package com.lzw.iframe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import com.lzw.dao.Dao;
import com.lzw.dao.model.TbJsr;

public class XiaoShouChaXun extends JInternalFrame{// 销售查询内部窗体
	
	private JButton queryButton;// “查询”按钮
	private JTextField endDate;// “终止日期”文本框
	private JTextField startDate;// “起始日期”文本框
	private JTable table;// 表格模型
	private JTextField content;// “条件内容”文本框
	private JComboBox operation;// “条件运算”下拉列表
	private JComboBox condition;// “条件名称”下拉列表
	private TbJsr user;// 经手人信息
	private DefaultTableModel dftm;// 表格模型的实例化对象
	private JCheckBox selectDate;// “指定查询日期”复选框
	
	public XiaoShouChaXun() {// 销售查询内部窗体的构造方法
		// 打开销售查询内部窗体时，设置“起始日期”和“终止日期”
		addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameActivated(final InternalFrameEvent e) {
				java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
				endDate.setText(date.toString());
				date.setMonth(0);
				date.setDate(1);
				startDate.setText(date.toString());
			}
		});
		setIconifiable(true);// 可以图标化
		setClosable(true);// 可以关闭
		setTitle("销售信息查询");// 设置销售查询内部窗体的标题
		getContentPane().setLayout(new GridBagLayout());// 设置销售查询内部窗体的布局是网格布局
		setBounds(100, 100, 680, 375);// 设置销售查询内部窗体的位置和宽高
		// “选择查询条件”标签和“条件名称”下拉列表
		setupComponet(new JLabel(" 选择查询条件："), 0, 0, 1, 1, false);
		condition = new JComboBox();
		condition.setModel(new DefaultComboBoxModel(new String[] {"客户全称", "销售票号"}));
		setupComponet(condition, 1, 0, 1, 30, true);
		// “条件运算”下拉列表
		operation = new JComboBox();
		operation.setModel(new DefaultComboBoxModel(new String[]{"等于", "包含"}));
		setupComponet(operation, 4, 0, 1, 30, true);
		// “条件内容”文本框
		content = new JTextField();
		content.addKeyListener(new KeyAdapter() {
			public void keyReleased(final KeyEvent e) {
				if(e.getKeyCode()==10) {
					queryButton.doClick();
				}
			}
		});
		setupComponet(content, 5, 0, 2, 240, true);
		// “查询”按钮
		queryButton = new JButton();
		queryButton.addActionListener(new QueryAction());
		setupComponet(queryButton, 7, 0, 1, 1, false);
		queryButton.setText("查询");
		// “指定查询日期”复选框
		selectDate = new JCheckBox();
		final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
		gridBagConstraints_7.anchor = GridBagConstraints.EAST;
		gridBagConstraints_7.insets = new Insets(0, 10, 0, 0);
		gridBagConstraints_7.gridy = 1;
		gridBagConstraints_7.gridx = 0;
		getContentPane().add(selectDate, gridBagConstraints_7);
		// “指定查询日期    从”标签
		final JLabel label_1 = new JLabel();
		label_1.setText("指定查询日期    从");
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.anchor = GridBagConstraints.EAST;
		gridBagConstraints_8.gridy = 1;
		gridBagConstraints_8.gridx = 1;
		getContentPane().add(label_1, gridBagConstraints_8);
		// “起始日期”文本框
		startDate = new JTextField();
		startDate.setPreferredSize(new Dimension(100,21));
		setupComponet(startDate, 2, 1, 3, 1, true);
		// “到”文本框
		setupComponet(new JLabel("到"), 5, 1, 1, 1, false);
		// “终止日期”文本框
		endDate = new JTextField();
		endDate.addKeyListener(content.getKeyListeners()[0]);
		endDate.setPreferredSize(new Dimension(100,21));
		final GridBagConstraints gridBagConstraints_11 = new GridBagConstraints();
		gridBagConstraints_11.ipadx = 90;
		gridBagConstraints_11.anchor = GridBagConstraints.WEST;
		gridBagConstraints_11.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints_11.gridy = 1;
		gridBagConstraints_11.gridx = 6;
		getContentPane().add(endDate, gridBagConstraints_11);
		// “显示全部数据”按钮
		final JButton showAllButton = new JButton();
		showAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				content.setText("");
				List list=Dao.findForList("select * from v_sellView");
				Iterator iterator=list.iterator();
				updateTable(iterator);
			}
		});
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.insets = new Insets(0, 0, 0, 10);
		gridBagConstraints_5.gridy = 1;
		gridBagConstraints_5.gridx = 7;
		getContentPane().add(showAllButton, gridBagConstraints_5);
		showAllButton.setFont(new Font("", Font.PLAIN, 12));
		showAllButton.setText("显示全部数据");
		// 滚动面板
		final JScrollPane scrollPane = new JScrollPane();
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.weighty = 1.0;
		gridBagConstraints_6.anchor = GridBagConstraints.NORTH;
		gridBagConstraints_6.insets = new Insets(0, 10, 5, 10);
		gridBagConstraints_6.fill = GridBagConstraints.BOTH;
		gridBagConstraints_6.gridwidth = 9;
		gridBagConstraints_6.gridy = 2;
		gridBagConstraints_6.gridx = 0;
		getContentPane().add(scrollPane, gridBagConstraints_6);
		// 表格模型
		table = new JTable();
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		dftm = (DefaultTableModel)table.getModel();
		String[] tableHeads = new String[]{"销售票号", "商品名称", "商品编号", "规格", "单价",
				"数量", "金额", "客户全称", "销售日期", "操作员", "经手人", "结算方式"};
		dftm.setColumnIdentifiers(tableHeads);
		scrollPane.setViewportView(table);
	}
	// 更新表格数据
	private void updateTable(Iterator iterator) {
		int rowCount=dftm.getRowCount();
		for(int i=0;i<rowCount;i++) {
			dftm.removeRow(0);
		}
		while(iterator.hasNext()) {
			Vector vector=new Vector();
			List view=(List) iterator.next();
			vector.addAll(view);
			dftm.addRow(vector);
		}
	}
	// 设置组件位置并添加到容器中
	private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {
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
	// 条件查询
	private final class QueryAction implements ActionListener {
		public void actionPerformed(final ActionEvent e) {
			boolean selDate = selectDate.isSelected();
			if(content.getText().equals("")) {
				JOptionPane.showMessageDialog(getContentPane(), "请输入查询内容！");
				return;
			}
			if(selDate) {
				if(startDate.getText()==null||startDate.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "请输入查询的开始日期！");
					return;
				}
				if(endDate.getText()==null||endDate.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "请输入查询的结束日期！");
					return;
				}
			}
			List list=null;// 结果集
			String con = condition.getSelectedIndex() == 0 ? "khname " : "sellId ";
			int oper = operation.getSelectedIndex();
			String opstr = oper == 0 ? "= " : "like ";
			String cont = content.getText();
			list = Dao.findForList("select * from v_sellView where "
					+ con
					+ opstr
					+ (oper == 0 ? "'"+cont+"'" : "'%" + cont + "%'")
					+ (selDate ? " and xsdate>'" + startDate.getText()
							+ "' and xsdate<='" + endDate.getText()+" 23:59:59'" : ""));// 执行拼接的SQL语句后获得的结果集
			Iterator iterator = list.iterator();// 与结果集list相应的迭代器
			updateTable(iterator);
		}
	}
}