package com.lzw.iframe;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import com.lzw.*;
import com.lzw.dao.Dao;
import com.lzw.dao.model.*;

public class JinHuoTuiHuo extends JInternalFrame {// 进货-退货内部窗体

	private final JTable table;// 表格模型
	private final JTextField thsj = new JTextField();// “退货时间”文本框
	private JComboBox jsr = null;// “经手人”下拉列表
	private final JComboBox jsfs = new JComboBox();// “结算方式”下拉列表
	private final JTextField lian = new JTextField();// “联系人”文本框
	private final JComboBox gys = new JComboBox();// “供应商”下拉列表
	private final JTextField piaoHao = new JTextField();// “退货票号”文本框
	private final JTextField pzs = new JTextField("0");// “品种数量”文本框
	private final JTextField hpzs = new JTextField("0");// “货品总数”文本框
	private final JTextField hjje = new JTextField("0");// “合计金额”文本框
	private final JTextField ysjl = new JTextField();// “验收结论”文本框
	private final JTextField czy = new JTextField();// “操作员”文本框
	private Date thsjDate;// “退货时间”
	private JComboBox sp;// “商品”下拉列表

	public JinHuoTuiHuo() {// 进货-退货内部窗体的构造方法
		super();// 调用父类JInternalFrame的构造器
		setMaximizable(true);// 可以最大化
		setIconifiable(true);// 可以图标化
		setClosable(true);// 进货-退货内部窗体可以关闭
		getContentPane().setLayout(new GridBagLayout());// 设置进货-退货内部窗体的布局为网格布局
		setTitle("进货-退货");// 设置进货-退货内部窗体的标题
		setBounds(50, 50, 700, 400);// 设置进货-退货内部窗体的位置和宽高
		// “退货票号”标签与“退货票号”文本框
		setupComponet(new JLabel("退货票号："), 0, 0, 1, 0, false);
		piaoHao.setFocusable(false);
		setupComponet(piaoHao, 1, 0, 1, 140, true);
		// “供应商”标签与“供应商”下拉列表
		setupComponet(new JLabel("供应商："), 2, 0, 1, 0, false);
		gys.setPreferredSize(new Dimension(160, 21));
		gys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doGysSelectAction();// “供应商”下拉列表的选择事件
			}
		});
		setupComponet(gys, 3, 0, 1, 1, true);
		// “联系人”标签与“联系人”文本框
		setupComponet(new JLabel("联系人："), 4, 0, 1, 0, false);
		lian.setFocusable(false);
		lian.setPreferredSize(new Dimension(80, 21));
		setupComponet(lian, 5, 0, 1, 0, true);
		// “结算方式”标签与“结算方式”下拉列表
		setupComponet(new JLabel("结算方式："), 0, 1, 1, 0, false);
		jsfs.addItem("现金");
		jsfs.addItem("支票");
		jsfs.setEditable(true);
		setupComponet(jsfs, 1, 1, 1, 1, true);
		// “退货时间”标签与“退货时间”文本框
		setupComponet(new JLabel("退货时间："), 2, 1, 1, 0, false);
		thsj.setFocusable(false);
		setupComponet(thsj, 3, 1, 1, 1, true);
		// “经手人”标签与“经手人”下拉列表
		setupComponet(new JLabel("经手人："), 4, 1, 1, 0, false);
		setupComponet(getJsrComboBox(), 5, 1, 1, 1, true);
		// “商品”下拉列表
		sp = new JComboBox();
		sp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TbKucun info = (TbKucun) sp.getSelectedItem();
				if (info != null && info.getId() != null) {// 如果选择有效就更新表格
					updateTable();
				}
			}
		});
		// 表格模型
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		initTable();
		table.addContainerListener(new computeInfo());// 添加事件完成品种数量、货品总数、合计金额的计算
		JScrollPane scrollPanel = new JScrollPane(table);
		scrollPanel.setPreferredSize(new Dimension(380, 200));
		setupComponet(scrollPanel, 0, 2, 6, 1, true);
		// “品种数量”标签与“品种数量”文本框
		setupComponet(new JLabel("品种数量："), 0, 3, 1, 0, false);
		pzs.setFocusable(false);
		setupComponet(pzs, 1, 3, 1, 1, true);
		// “货品总数”标签与“货品总数”文本框
		setupComponet(new JLabel("货品总数："), 2, 3, 1, 0, false);
		hpzs.setFocusable(false);
		setupComponet(hpzs, 3, 3, 1, 1, true);
		// “合计金额”标签与“合计金额”文本框
		setupComponet(new JLabel("合计金额："), 4, 3, 1, 0, false);
		hjje.setFocusable(false);
		setupComponet(hjje, 5, 3, 1, 1, true);
		// “验收结论”标签与“验收结论”文本框
		setupComponet(new JLabel("验收结论："), 0, 4, 1, 0, false);
		setupComponet(ysjl, 1, 4, 1, 1, true);
		// “操作人员”标签与“操作人员”文本框
		setupComponet(new JLabel("操作人员："), 2, 4, 1, 0, false);
		czy.setFocusable(false);
		czy.setText(MainFrame.getCzyStateLabel().getText());
		setupComponet(czy, 3, 4, 1, 1, true);

		JButton tjButton = new JButton("添加");// “添加”按钮
		tjButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 初始化退后票号
				initPiaoHao();
				// 结束表格中没有编写的单元
				stopTableCellEditing();
				// 如果表格中还包含空行，就不再添加新行
				for (int i = 0; i < table.getRowCount(); i++) {
					TbKucun info = (TbKucun) table.getValueAt(i, 0);
					if (info == null || info.getId().isEmpty())
						return;
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Vector());
				initSpBox();
			}
		});
		setupComponet(tjButton, 4, 4, 1, 1, false);

		JButton rkButton = new JButton("退货");// “退货”按钮
		rkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 结束表格中没有编写的单元
				stopTableCellEditing();
				// 清除空行
				clearEmptyRow();
				String hpzsStr = hpzs.getText();// 货品总数
				String pzsStr = pzs.getText();// 品种数
				String jeStr = hjje.getText();// 合计金额
				String jsfsStr = jsfs.getSelectedItem().toString();// 结算方式
				String jsrStr = jsr.getSelectedItem() + "";// 经手人
				String czyStr = czy.getText();// 操作员
				String rkDate = thsjDate.toLocaleString();// 入库时间
				String ysjlStr = ysjl.getText().trim();// 验收结论
				String id = piaoHao.getText();// 票号
				String gysName = gys.getSelectedItem().toString();// 供应商名字
				if (jsrStr == null || jsrStr.isEmpty()) {
					JOptionPane.showMessageDialog(JinHuoTuiHuo.this, "请填写经手人");
					return;
				}
				if (ysjlStr == null || ysjlStr.isEmpty()) {
					JOptionPane.showMessageDialog(JinHuoTuiHuo.this, "填写验收结论");
					return;
				}
				if (table.getRowCount() <= 0) {
					JOptionPane.showMessageDialog(JinHuoTuiHuo.this, "填加退货商品");
					return;
				}
				TbRkthMain rkthMain = new TbRkthMain(id, pzsStr, jeStr, ysjlStr, gysName, rkDate, czyStr, jsrStr, jsfsStr);
				Set<TbRkthDetail> set = rkthMain.getTbRkthDetails();
				int rows = table.getRowCount();
				for (int i = 0; i < rows; i++) {
					TbKucun kucun = (TbKucun) table.getValueAt(i, 0);
					String djStr = (String) table.getValueAt(i, 6);
					String slStr = (String) table.getValueAt(i, 7);
					Double dj = Double.valueOf(djStr);
					Integer sl = Integer.valueOf(slStr);
					TbRkthDetail detail = new TbRkthDetail();
					detail.setSpid(kucun.getId());
					detail.setTbRkthMain(rkthMain.getRkthId());
					detail.setDj(dj);
					detail.setSl(sl);
					set.add(detail);
				}
				boolean rs = Dao.insertRkthInfo(rkthMain);
				if (rs) {
					JOptionPane.showMessageDialog(JinHuoTuiHuo.this, "退货完成");
					DefaultTableModel dftm = new DefaultTableModel();
					table.setModel(dftm);
					initTable();
					pzs.setText("0");
					hpzs.setText("0");
					hjje.setText("0");
				}
			}
		});
		setupComponet(rkButton, 5, 4, 1, 1, false);
		addInternalFrameListener(new initTasks());// 添加窗体监听器，完成初始化
	}

	/**
	 * 获得“经手人”下拉列表的方法
	 * 
	 * @return “经手人”下拉列表
	 */
	private JComboBox getJsrComboBox() {
		if (jsr == null) {
			jsr = new JComboBox();
			List<List> czyList = Dao.getJsrs();
			for (List<String> list : czyList) {
				String id = list.get(0);
				String name = list.get(1);
				Item item = new Item(id, name);
				item.setId(id + "");
				item.setName(name);
				jsr.addItem(item);
			}
		}
		return jsr;
	}

	private void initTable() {// 初始化表格
		String[] columnNames = { "商品名称", "商品编号", "产地", "单位", "规格", "包装", "单价", "数量" };// 表头
		((DefaultTableModel) table.getModel()).setColumnIdentifiers(columnNames);// 创建表格模型对象并向其中添加表头
		TableColumn column = table.getColumnModel().getColumn(0);// 以表格模型中索引为0的列作参照
		final DefaultCellEditor editor = new DefaultCellEditor(sp);// 创建单元格编辑器
		editor.setClickCountToStart(2);// 开始编辑单元格所需的单击次数为2次
		column.setCellEditor(editor);// 编辑参照列中单元格时所用的编辑器
	}

	private void initSpBox() {// 初始化“商品”下拉列表
		List list = new ArrayList();
		ResultSet set = Dao.query("select * from tb_kucun where " + "id in(select id from tb_spinfo where gysName='"
				+ gys.getSelectedItem() + "')");
		sp.removeAllItems();
		sp.addItem(new TbKucun());
		for (int i = 0; table != null && i < table.getRowCount(); i++) {
			TbKucun tmpInfo = (TbKucun) table.getValueAt(i, 0);
			if (tmpInfo != null && tmpInfo.getId() != null)
				list.add(tmpInfo.getId());
		}
		try {
			while (set.next()) {
				TbKucun kucun = new TbKucun();
				kucun.setId(set.getString("id").trim());
				if (list.contains(kucun.getId()))// 如果表格中以存在同样商品，商品下拉框中就不再包含该商品
					continue;
				kucun.setSpname(set.getString("spname").trim());
				kucun.setCd(set.getString("cd").trim());
				kucun.setJc(set.getString("jc").trim());
				kucun.setDw(set.getString("dw").trim());
				kucun.setGg(set.getString("gg").trim());
				kucun.setBz(set.getString("bz").trim());
				kucun.setDj(Double.valueOf(set.getString("dj").trim()));
				kucun.setKcsl(Integer.valueOf(set.getString("kcsl").trim()));
				sp.addItem(kucun);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {// 设置组件位置并添加到容器中
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();// 创建网格限制对象
		gridBagConstrains.gridx = gridx;// 设置组件位于网格的横向索引为gridx
		gridBagConstrains.gridy = gridy;// 设置组件位于网格的纵向索引为gridy
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);// 组件彼此的间距
		if (gridwidth > 1)// 组件横跨网格数大于1
			gridBagConstrains.gridwidth = gridwidth;// 设置组件横跨网格数为gridwidth
		if (ipadx > 0)// 组件横向填充的大小大于0
			gridBagConstrains.ipadx = ipadx;// 设置组件横向填充的大小
		if (fill)// 组件占据空白区域
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
		getContentPane().add(component, gridBagConstrains);// 添加组件
	}

	private void doGysSelectAction() {// 选择供应商时更新联系人字段
		Item item = (Item) gys.getSelectedItem();
		TbGysinfo gysInfo = Dao.getGysInfo(item);
		lian.setText(gysInfo.getLian());
	}

	private final class computeInfo implements ContainerListener {// 在事件中计算品种数量、货品总数、合计金额
		public void componentRemoved(ContainerEvent e) {
			// 清除空行
			clearEmptyRow();
			// 计算代码
			int rows = table.getRowCount();
			int count = 0;
			double money = 0.0;
			// 计算品种数量
			TbKucun column = null;
			if (rows > 0)
				column = (TbKucun) table.getValueAt(rows - 1, 0);
			if (rows > 0 && (column == null || column.getId().isEmpty()))
				rows--;
			// 计算货品总数和金额
			for (int i = 0; i < rows; i++) {
				String column7 = (String) table.getValueAt(i, 7);
				String column6 = (String) table.getValueAt(i, 6);
				int c7 = (column7 == null || column7.isEmpty()) ? 0 : Integer.parseInt(column7);
				Double c6 = (column6 == null || column6.isEmpty()) ? 0 : Double.valueOf(column6);
				count += c7;
				money += c6 * c7;
			}
			pzs.setText(rows + "");
			hpzs.setText(count + "");
			hjje.setText(money + "");
		}

		public void componentAdded(ContainerEvent e) {
		}
	}

	private final class initTasks extends InternalFrameAdapter {// 窗体的初始化任务
		public void internalFrameActivated(InternalFrameEvent e) {
			super.internalFrameActivated(e);
			initTimeField();// 启动退货时间线程
			initGysField();// 初始化供应商字段
			initPiaoHao();// 初始化“退货票号”
			initSpBox();// 初始化“商品”下拉列表
		}

		private void initGysField() {// 初始化供应商字段
			List gysInfos = Dao.getGysInfos();
			for (Iterator iter = gysInfos.iterator(); iter.hasNext();) {
				List list = (List) iter.next();
				Item item = new Item();
				item.setId(list.get(0).toString().trim());
				item.setName(list.get(1).toString().trim());
				gys.addItem(item);
			}
			doGysSelectAction();
		}

		private void initTimeField() {// 启动退货时间线程
			new Thread(new Runnable() {
				public void run() {
					try {
						while (true) {
							thsjDate = new Date();
							thsj.setText(thsjDate.toLocaleString());
							Thread.sleep(1000);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

	private void initPiaoHao() {// 初始化“退货票号”
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		String maxId = Dao.getRkthMainMaxId(date);
		piaoHao.setText(maxId);
	}

	private synchronized void updateTable() {// 根据商品下拉框的选择，更新表格当前行的内容
		TbKucun kucun = (TbKucun) sp.getSelectedItem();
		int row = table.getSelectedRow();
		if (row >= 0 && kucun != null) {
			table.setValueAt(kucun.getId(), row, 1);
			table.setValueAt(kucun.getCd(), row, 2);
			table.setValueAt(kucun.getDw(), row, 3);
			table.setValueAt(kucun.getGg(), row, 4);
			table.setValueAt(kucun.getBz(), row, 5);
			table.setValueAt(kucun.getDj().toString(), row, 6);
			table.setValueAt(kucun.getKcsl().toString(), row, 7);
			table.editCellAt(row, 7);
		}
	}

	private synchronized void clearEmptyRow() {// 清除空行
		DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		for (int i = 0; i < table.getRowCount(); i++) {
			TbKucun kucun = (TbKucun) table.getValueAt(i, 0);
			if (kucun == null || kucun.getId() == null || kucun.getId().isEmpty()) {
				dftm.removeRow(i);
			}
		}
	}

	private void stopTableCellEditing() {// 停止表格单元的编辑
		TableCellEditor cellEditor = table.getCellEditor();
		if (cellEditor != null)
			cellEditor.stopCellEditing();
	}
}
