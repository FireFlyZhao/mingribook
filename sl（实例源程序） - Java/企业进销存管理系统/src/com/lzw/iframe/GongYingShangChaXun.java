package com.lzw.iframe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.lzw.Item;
import com.lzw.dao.Dao;
import com.lzw.dao.model.TbGysinfo;

public class GongYingShangChaXun extends JInternalFrame {// 供应商查询内部窗体

	private JTable table;// 表格模型
	private JTextField conditionContent;// “条件内容”文本框
	private JComboBox conditionOperation;// “条件运算”下拉列表
	private JComboBox conditionName;// “条件名称”下拉列表

	public GongYingShangChaXun() {// 供应商查询内部窗体的构造方法
		setMaximizable(true);// 可以最大化
		setIconifiable(true);// 可以图标化
		setClosable(true);// 可以关闭窗体
		setTitle("供应商信息查询");// 设置供应商查询内部窗体的标题
		getContentPane().setLayout(new GridBagLayout());// 设置供应商查询内部窗体的布局为网格布局
		setBounds(100, 100, 609, 375);// 设置供应商查询内部窗体的位置和宽高
		// 表格模型
		table = new JTable();
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
		final DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		String[] tableHeads = new String[] { "供应商ID", "供应商全称", "简称", "邮政编码", "地址", "电话", "传真", "联系人", "联系人电话", "开户银行",
				"电子信箱" };
		dftm.setColumnIdentifiers(tableHeads);
		// 滚动面板
		final JScrollPane scrollPane = new JScrollPane(table);
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.weighty = 1.0;
		gridBagConstraints_6.anchor = GridBagConstraints.NORTH;
		gridBagConstraints_6.insets = new Insets(0, 10, 0, 10);
		gridBagConstraints_6.fill = GridBagConstraints.BOTH;
		gridBagConstraints_6.gridwidth = 6;
		gridBagConstraints_6.gridy = 1;
		gridBagConstraints_6.gridx = 0;
		getContentPane().add(scrollPane, gridBagConstraints_6);
		// “选择查询条件”标签和“条件名称”下拉列表
		setupComponet(new JLabel(" 选择查询条件："), 0, 0, 1, 1, false);
		conditionName = new JComboBox();
		conditionName.setModel(new DefaultComboBoxModel(new String[] { "供应商全称", "简称" }));
		setupComponet(conditionName, 1, 0, 1, 30, true);
		// “条件运算”下拉列表
		conditionOperation = new JComboBox();
		conditionOperation.setModel(new DefaultComboBoxModel(new String[] { "等于", "包含" }));
		setupComponet(conditionOperation, 2, 0, 1, 30, true);
		// “条件内容”文本框
		conditionContent = new JTextField();
		setupComponet(conditionContent, 3, 0, 1, 140, true);
		// “查询”按钮
		final JButton queryButton = new JButton();
		queryButton.addActionListener(new queryAction(dftm));
		setupComponet(queryButton, 4, 0, 1, 1, false);
		queryButton.setText("查询");
		// “显示全部数据”按钮
		final JButton showAllButton = new JButton();
		showAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				conditionContent.setText("");
				List list = Dao.getGysInfos();
				updateTable(list, dftm);
			}
		});
		setupComponet(showAllButton, 5, 0, 1, 1, false);
		showAllButton.setText("显示全部数据");
	}
	// 点击“显示全部数据”按钮后，更新表格内容
	private void updateTable(List list, final DefaultTableModel dftm) {
		int num = dftm.getRowCount();
		for (int i = 0; i < num; i++)
			dftm.removeRow(0);
		Iterator iterator = list.iterator();
		TbGysinfo gysInfo;// 供应商信息
		while (iterator.hasNext()) {
			List info = (List) iterator.next();
			Item item = new Item();
			item.setId((String) info.get(0));
			item.setName((String) info.get(1));
			gysInfo = Dao.getGysInfo(item);
			Vector rowData = new Vector();
			rowData.add(gysInfo.getId());// 供应商编号
			rowData.add(gysInfo.getName());// 供应商名称
			rowData.add(gysInfo.getJc());// 供应商简称
			rowData.add(gysInfo.getBianma());// 邮政编码
			rowData.add(gysInfo.getAddress());// 供应商地址
			rowData.add(gysInfo.getTel());// 电话
			rowData.add(gysInfo.getFax());// 传真
			rowData.add(gysInfo.getLian());// 联系人
			rowData.add(gysInfo.getLtel());// 联系电话
			rowData.add(gysInfo.getYh());// 开户银行
			rowData.add(gysInfo.getMail());// 电子信箱
			dftm.addRow(rowData);// 向表格对象中添加行数据（供应商信息）
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
	private final class queryAction implements ActionListener {
		private final DefaultTableModel dftm;

		private queryAction(DefaultTableModel dftm) {
			this.dftm = dftm;
		}

		public void actionPerformed(final ActionEvent e) {
			String conName, conOperation, content;
			List list = null;
			conName = conditionName.getSelectedItem().toString().trim();
			conOperation = conditionOperation.getSelectedItem().toString().trim();
			content = conditionContent.getText().trim();
			String sql = "select * from tb_gysInfo where ";
			if (conName.equals("供应商全称")) {
				if (conOperation.equals("等于"))
					list = Dao.findForList(sql + "name='" + content + "'");
				else
					list = Dao.findForList(sql + "name like '%" + content + "%'");
			} else {
				if (conOperation.equals("等于"))
					list = Dao.findForList(sql + "jc='" + content + "'");
				else
					list = Dao.findForList(sql + "jc like '%" + content + "%'");
			}
			updateTable(list, dftm);
		}
	}
}
