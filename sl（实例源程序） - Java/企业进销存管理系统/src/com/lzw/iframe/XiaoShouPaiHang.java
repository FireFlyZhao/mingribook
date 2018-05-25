package com.lzw.iframe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.lzw.dao.Dao;
import com.lzw.dao.model.TbJsr;

public class XiaoShouPaiHang extends JInternalFrame {// 销售排行内部窗体
	
	private JButton okButton;// “确定”按钮
	private JComboBox month;// “月”下拉列表
	private JComboBox year;// “年”下拉列表
	private JTable table;// 表格模型
	private JComboBox operation;// “条件运算”下拉列表
	private JComboBox condition;// “条件内容”下拉列表
	private TbJsr user;// 经手人信息
	private DefaultTableModel dftm;// 表格模型的实例对象
	private Calendar date = Calendar.getInstance();// “日期”对象
	
	public XiaoShouPaiHang() {// 销售排行内部窗体的构造方法
		setIconifiable(true);// 可以图标化
		setClosable(true);// 可以关闭窗体
		setTitle("销售排行");// 设置销售排行内部窗体的标题
		getContentPane().setLayout(new GridBagLayout());// 设置销售排行内部窗体的布局为网格布局
		setBounds(100, 100, 700, 375);// 设置销售排行内部窗体的位置和宽高
		// “对”标签
		final JLabel label_1 = new JLabel();
		label_1.setText("对");
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.anchor = GridBagConstraints.EAST;
		gridBagConstraints_8.gridy = 0;
		gridBagConstraints_8.gridx = 0;
		getContentPane().add(label_1, gridBagConstraints_8);
		// “年”下拉列表
		year = new JComboBox();
		for (int i = 1981, j = 0; i <= date.get(Calendar.YEAR) + 1; i++, j++) {
			year.addItem(i);
			if (i == date.get(Calendar.YEAR))
				year.setSelectedIndex(j);
		}
		year.setPreferredSize(new Dimension(100, 21));
		setupComponet(year, 1, 0, 1, 90, true);
		// “年”标签
		setupComponet(new JLabel("年"), 2, 0, 1, 1, false);
		// “月”下拉列表
		month = new JComboBox();
		for (int i = 1; i <= 12; i++) {
			month.addItem(String.format("%02d", i));
			if (date.get(Calendar.MONTH) == i)
				month.setSelectedIndex(i - 1);
		}
		month.setPreferredSize(new Dimension(100, 21));
		setupComponet(month, 3, 0, 1, 30, true);
		// “月份的销售信息，按”标签
		setupComponet(new JLabel(" 月份的销售信息，按"), 4, 0, 1, 1, false);
		condition = new JComboBox();
		condition.setModel(new DefaultComboBoxModel(new String[]{"金额", "数量"}));
		setupComponet(condition, 5, 0, 1, 30, true);
		// “进行”标签
		setupComponet(new JLabel(" 进行"), 6, 0, 1, 1, false);
		// “条件运算”下拉列表
		operation = new JComboBox();
		operation.setModel(new DefaultComboBoxModel(
				new String[]{"升序排列", "降序排列"}));
		setupComponet(operation, 7, 0, 1, 30, true);
		// “确定”按钮
		okButton = new JButton();
		okButton.addActionListener(new OkAction());
		setupComponet(okButton, 8, 0, 1, 1, false);
		okButton.setText("确定");
		// 滚动面板
		final JScrollPane scrollPane = new JScrollPane();
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.weighty = 1.0;
		gridBagConstraints_6.anchor = GridBagConstraints.NORTH;
		gridBagConstraints_6.insets = new Insets(0, 10, 5, 10);
		gridBagConstraints_6.fill = GridBagConstraints.BOTH;
		gridBagConstraints_6.gridwidth = 9;
		gridBagConstraints_6.gridy = 1;
		gridBagConstraints_6.gridx = 0;
		getContentPane().add(scrollPane, gridBagConstraints_6);
		// 表格模型
		table = new JTable();
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度，使用滚动条
		dftm = (DefaultTableModel) table.getModel();
		String[] tableHeads = new String[]{"商品编号", "商品名称", "销售金额", "销售数量",
				"简称", "产地", "单位", "规格", "包装", "批号", "批准文号","简介","供应商"};
		dftm.setColumnIdentifiers(tableHeads);
		scrollPane.setViewportView(table);
	}
	// 更改表格数据
	private void updateTable(Iterator iterator) {
		int rowCount = dftm.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			dftm.removeRow(0);
		}
		while (iterator.hasNext()) {
			Vector vector = new Vector();
			List view = (List) iterator.next();
			Vector row=new Vector(view);
			int rowSize = row.size();
			for(int i=rowSize-2;i<rowSize;i++){
				Object colValue = row.get(i);
				row.remove(i);
				row.insertElementAt(colValue, 2);
			}
			vector.addAll(row);
			dftm.addRow(vector);
		}
	}
	// 设置组件位置并添加到容器中
	private void setupComponet(JComponent component, int gridx, int gridy,
			int gridwidth, int ipadx, boolean fill) {
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx = gridx;
		gridBagConstrains.gridy = gridy;
		if (gridwidth > 1)
			gridBagConstrains.gridwidth = gridwidth;
		if (ipadx > 0)
			gridBagConstrains.ipadx = ipadx;
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);
		if (fill)
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(component, gridBagConstrains);
	}
	// 点击“确定”按钮后，发生的事件
	private final class OkAction implements ActionListener {
		public void actionPerformed(final ActionEvent e) {
			List list = null;
			String strMonth = (String) month.getSelectedItem();
			String date = year.getSelectedItem() + strMonth;
			String con = condition.getSelectedIndex() == 0 ? "sumje " : "sl ";
			int oper = operation.getSelectedIndex();
			String sql1 = "select spid,sum(sl)as sl,sum(sl*dj) as sumje from"
					+ " v_sellView where substring(convert(varchar(30)"
					+ ",xsdate,112),0,7)='" + date + "' group by spid";
			String opstr = oper == 0 ? " asc" : " desc";
			String queryStr = "select * from tb_spinfo s inner join (" + sql1
					+ ") as sp on s.id=sp.spid order by " + con + opstr;
			list = Dao.findForList(queryStr);
			Iterator iterator = list.iterator();
			updateTable(iterator);
		}
	}
}