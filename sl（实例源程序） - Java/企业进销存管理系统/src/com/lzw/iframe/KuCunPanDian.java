package com.lzw.iframe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.*;

import com.lzw.*;
import com.lzw.dao.Dao;
import com.lzw.dao.model.TbSpinfo;

public class KuCunPanDian extends JInternalFrame {// 库存盘点内部窗体

	private final JTable table;// 表格模型
	private final JTextField pdsj = new JTextField();// “盘点时间”文本框
	private final JTextField pzs = new JTextField("0");// “品种数”文本框
	private JTextField czy = new JTextField();// “操作员”文本框
	private Date pdDate = new Date();// 盘点日期

	public KuCunPanDian() {// 库存盘点内部窗体的构造方法
		super();// 调用父类JInternalFrame的构造器
		setMaximizable(true);// 可以最大化
		setIconifiable(true);// 可以图标化
		setClosable(true);// 可以关闭
		getContentPane().setLayout(new GridBagLayout());// 设置库存盘点内部窗体的布局为网格布局
		setTitle("库存盘点");// 设置库存盘点内部窗体的标题
		setBounds(50, 50, 750, 400);// 设置设置库存盘点内部窗体的位置和宽高
		// “操作员”标签与“操作员”文本框
		setupComponet(new JLabel("操 作 员："), 0, 0, 1, 0, false);
		czy.setFocusable(false);
		czy.setText(MainFrame.getCzyStateLabel().getText());
		czy.setPreferredSize(new Dimension(120, 21));
		setupComponet(czy, 1, 0, 1, 0, true);
		// “盘点时间”标签与“盘点时间”文本框
		setupComponet(new JLabel("盘点时间："), 2, 0, 1, 0, false);
		pdsj.setFocusable(false);
		pdsj.setText(pdDate.toLocaleString());
		pdsj.setPreferredSize(new Dimension(180, 21));
		setupComponet(pdsj, 3, 0, 1, 1, true);
		// “品种数”标签与“品种数”文本框
		setupComponet(new JLabel("品 种 数："), 4, 0, 1, 0, false);
		pzs.setFocusable(false);
		pzs.setPreferredSize(new Dimension(80, 21));
		setupComponet(pzs, 5, 0, 1, 20, true);
		// 表格模型
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		initTable();
		// 滚动面板
		JScrollPane scrollPanel = new JScrollPane(table);
		scrollPanel.setPreferredSize(new Dimension(700, 300));
		setupComponet(scrollPanel, 0, 2, 6, 1, true);
	}

	private void initTable() {// 初始化表格
		String[] columnNames = { "商品名称", "商品编号", "供应商", "产地", "单位", "规格", "单价", "数量", "包装", "盘点数量", "损益数量" };
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setColumnIdentifiers(columnNames);
		// 设置盘点字段只接收数字输入
		final JTextField pdField = new JTextField(0);
		pdField.setEditable(false);
		pdField.addKeyListener(new PanDianKeyAdapter(pdField));
		JTextField readOnlyField = new JTextField(0);
		readOnlyField.setEditable(false);

		DefaultCellEditor pdEditor = new DefaultCellEditor(pdField);
		DefaultCellEditor readOnlyEditor = new DefaultCellEditor(readOnlyField);
		// 设置表格单元为只读格式
		for (int i = 0; i < columnNames.length; i++) {
			TableColumn column = table.getColumnModel().getColumn(i);
			column.setCellEditor(readOnlyEditor);
		}
		// 获得表格中的列属性与编辑此列中单元格时所用的编辑器
		TableColumn pdColumn = table.getColumnModel().getColumn(9);
		TableColumn syColumn = table.getColumnModel().getColumn(10);
		pdColumn.setCellEditor(pdEditor);
		syColumn.setCellEditor(readOnlyEditor);
		// 初始化表格内容
		List kcInfos = Dao.getKucunInfos();
		for (int i = 0; i < kcInfos.size(); i++) {
			List info = (List) kcInfos.get(i);
			Item item = new Item();
			item.setId((String) info.get(0));
			item.setName((String) info.get(1));
			TbSpinfo spinfo = Dao.getSpInfo(item);
			Object[] row = new Object[columnNames.length];
			if (spinfo.getId() != null && !spinfo.getId().isEmpty()) {
				row[0] = spinfo.getSpname();
				row[1] = spinfo.getId();
				row[2] = spinfo.getGysname();
				row[3] = spinfo.getCd();
				row[4] = spinfo.getDw();
				row[5] = spinfo.getGg();
				row[6] = info.get(2).toString();
				row[7] = info.get(3).toString();
				row[8] = spinfo.getBz();
				row[9] = 0;
				row[10] = 0;
				tableModel.addRow(row);
				String pzsStr = pzs.getText();
				int pzsInt = Integer.parseInt(pzsStr);
				pzsInt++;
				pzs.setText(pzsInt + "");
			}
		}
	}

	// 盘点字段的按键监听器
	private class PanDianKeyAdapter extends KeyAdapter {
		private final JTextField field;

		private PanDianKeyAdapter(JTextField field) {
			this.field = field;
		}

		public void keyTyped(KeyEvent e) {// 键入某个键时
			if (("0123456789" + (char) 8).indexOf(e.getKeyChar() + "") < 0) {
				e.consume();
			}
			field.setEditable(true);
		}

		public void keyReleased(KeyEvent e) {// 释放某个键时
			String pdStr = field.getText();//获取盘点数量
			String kcStr = "0";
			int row = table.getSelectedRow();//获取当前选中行
			if (row >= 0) {
				kcStr = (String) table.getValueAt(row, 7);//获取第七列单元格，库存数量
			}
			try {
				int pdNum = Integer.parseInt(pdStr);
				int kcNum = Integer.parseInt(kcStr);
				if (row >= 0) {
					table.setValueAt(kcNum - pdNum, row, 10);//计算并更新损益单元格的内容
				}
				if (e.getKeyChar() != 8)
					field.setEditable(false);
			} catch (NumberFormatException e1) {
				field.setText("0");
			}
		}
	}

	// 设置组件位置并添加到容器中
	private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();// 创建网格限制对象
		gridBagConstrains.gridx = gridx;// 设置组件位于网格的横向索引为gridx
		gridBagConstrains.gridy = gridy;// 设置组件位于网格的纵向索引为gridy
		gridBagConstrains.insets = new Insets(5, 1, 3, 5);// 组件彼此的间距
		if (gridwidth > 1)// 组件横跨网格数大于1
			gridBagConstrains.gridwidth = gridwidth;// 设置组件横跨网格数为gridwidth
		if (ipadx > 0)// 组件横向填充的大小大于0
			gridBagConstrains.ipadx = ipadx;// 设置组件横向填充的大小
		if (fill)// 组件占据空白区域
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
		getContentPane().add(component, gridBagConstrains);// 添加组件
	}
}
