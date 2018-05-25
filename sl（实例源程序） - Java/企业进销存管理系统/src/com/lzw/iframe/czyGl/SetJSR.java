package com.lzw.iframe.czyGl;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.lzw.dao.Dao;
import com.lzw.iframe.JsrGL;

public class SetJSR extends JPanel {// 设置经手人面板

	private JTextField sexField;// “性别”文本框
	private JTextField ageField;// “年龄”文本框
	private JTextField nameField;// “姓名”文本框
	private JTable table;// 表格模型
	private DefaultTableModel dftm;// 创建表格对象
	private String[] columnNames;// 存储列标题的数组

	public SetJSR() {// 设置经手人面板
		super();// 调用父类JPanel的构造器
		setBounds(0, 0, 491, 200);// 设置“设置经手人面板”的位置和宽高
		setLayout(new GridBagLayout());// 设置“设置经手人面板”的布局为网格布局

		final JScrollPane scrollPane = new JScrollPane();// 滚动面板
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints.weightx = 1.0;// 组件横向扩大的权重是1.0
		gridBagConstraints.insets = new Insets(0, 0, 20, 0);// 组件彼此的间距
		gridBagConstraints.gridwidth = 12;// 组件横向跨越12个网格
		gridBagConstraints.fill = GridBagConstraints.BOTH;// 组件水平、数值同时扩大以占据空白区域
		gridBagConstraints.weighty = 1.0;// 组件纵向扩大的权重是1.0
		gridBagConstraints.gridx = 0;// 组件位于网格的横向索引为0
		gridBagConstraints.gridy = 0;// 组件位于网格的纵向索引为0
		gridBagConstraints.ipadx = 35;// 组件横向增加35像素
		gridBagConstraints.ipady = -195;// 组件纵向减少195像素
		add(scrollPane, gridBagConstraints);// 向设置经手人面板中添加滚动面板

		table = new JTable();// 表格模型
		dftm = (DefaultTableModel) table.getModel();// 创建表格对象
		columnNames = new String[] { "编号", "姓名", "性别", "年龄", "联系电话", "禁用" };// 存储列标题的数组
		dftm.setColumnIdentifiers(columnNames);// 用列标题数组中的元素替换表格对象中的列标识符
		table.addMouseListener(new MouseAdapter() {// 为表格模型添加鼠标点击事件
			public void mouseClicked(final MouseEvent e) {
				String nameStr, ageStr, sexStr;// 声明“姓名”、“性别”、“年龄”
				int selRow = table.getSelectedRow();// 选定行的索引
				nameStr = table.getValueAt(selRow, 1).toString().trim();// 获得“姓名”
				ageStr = table.getValueAt(selRow, 3).toString().trim();// 获得“年龄”
				sexStr = table.getValueAt(selRow, 2).toString().trim();// 获得“性别”
				nameField.setText(nameStr);// 设置“姓名”文本框中的内容
				ageField.setText(ageStr);// 设置“年龄”文本框中的内容
				sexField.setText(sexStr);// 设置“性别”文本框中的内容
			}
		});
		scrollPane.setViewportView(table);// 把表格模型置于滚动面板中

		final JLabel label = new JLabel();// “姓名”标签
		final GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_3.gridy = 2;// 组件位于网格的纵向索引为2
		gridBagConstraints_3.gridx = 0;// 组件位于网格的横向索引为0
		add(label, gridBagConstraints_3);// 向设置经手人面板中添加“姓名”标签
		label.setText("姓名：");// 设置“姓名”标签中的文本内容

		nameField = new JTextField();// “姓名”文本框
		nameField.setEditable(false);// 设置“姓名”文本框不可编辑
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_4.insets = new Insets(0, 0, 0, 10);// 组件彼此的间距
		gridBagConstraints_4.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
		gridBagConstraints_4.weightx = 1.0;// 组件横向扩大的权重是1.0
		gridBagConstraints_4.gridy = 2;// 组件位于网格的纵向索引为2
		gridBagConstraints_4.gridx = 3;// 组件位于网格的横向索引为3
		add(nameField, gridBagConstraints_4);// 向设置经手人面板中添加“姓名”文本框

		final JLabel label_2 = new JLabel();// “性别”标签
		label_2.setText("性别：");// 设置“性别”标签中的文本内容
		final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_7.gridy = 2;// 组件位于网格的纵向索引为2
		gridBagConstraints_7.gridx = 4;// 组件位于网格的横向索引为4
		add(label_2, gridBagConstraints_7);// 向设置经手人面板中添加“性别”标签

		sexField = new JTextField();// “性别”文本框
		sexField.setEditable(false);// 设置“性别”文本框不可编辑
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_8.weightx = 1.0;// 组件横向扩大的权重是1.0
		gridBagConstraints_8.insets = new Insets(0, 0, 0, 10);// 组件彼此的间距
		gridBagConstraints_8.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
		gridBagConstraints_8.gridy = 2;// 组件位于网格的纵向索引为2
		gridBagConstraints_8.gridx = 5;// 组件位于网格的横向索引为5
		add(sexField, gridBagConstraints_8);// 向设置经手人面板中添加“性别”文本框

		final JLabel label_1 = new JLabel();// “年龄”标签
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_6.gridy = 2;// 组件位于网格的纵向索引为2
		gridBagConstraints_6.gridx = 6;// 组件位于网格的横向索引为6
		add(label_1, gridBagConstraints_6);// 向设置经手人面板中添加“性别”文本框
		label_1.setText("年龄：");// 设置“年龄”标签中的文本内容

		ageField = new JTextField();// “年龄”文本框
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_5.insets = new Insets(0, 0, 0, 10);// 组件彼此的间距
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
		gridBagConstraints_5.weightx = 1.0;// 组件横向扩大的权重是1.0
		gridBagConstraints_5.gridy = 2;// 组件位于网格的纵向索引为2
		gridBagConstraints_5.gridx = 7;// 组件位于网格的横向索引为7
		add(ageField, gridBagConstraints_5);// 向设置经手人面板中添加“年龄”文本框
		ageField.setEditable(false);

		final JButton button = new JButton("删除");// “删除”按钮
		final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_1.insets = new Insets(5, 0, 5, 0);// 组件彼此的间距
		gridBagConstraints_1.gridy = 7;// 组件位于网格的纵向索引为7
		gridBagConstraints_1.gridx = 4;// 组件位于网格的横向索引为4
		add(button, gridBagConstraints_1);// 向设置经手人面板中添加“删除”按钮
		button.addActionListener(new ActionListener() {// “删除”按钮动作事件的监听
			public void actionPerformed(final ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(SetJSR.this, "确认要删除该操作员？");// 弹出“确认要删除该操作员？”的提示框
				if (op == JOptionPane.OK_OPTION) {// 点击“确认”
					int selRow = table.getSelectedRow();// 选定行的索引
					if (selRow < 0)// 选定行的索引小于0
						return;// 退出应用程序
					String id = table.getValueAt(selRow, 0).toString().trim();// 获得经手人编号
					Dao.delete("delete tb_jsr where id='" + id + "'");// 执行SQL删除语句
					sexField.setText("");// 设置“性别”文本框中的内容为空
					ageField.setText("");// 设置“年龄”文本框中的内容为空
					nameField.setText("");// 设置“姓名”文本框中的内容为空
					initTable();// 初始化表格模型
				}
			}
		});

		final JButton enableButton = new JButton("禁用/启用");// “禁用/启用”按钮
		final GridBagConstraints gridBagConstraints4 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints4.insets = new Insets(5, 0, 5, 0);// 组件彼此的间距
		gridBagConstraints4.gridy = 7;// 组件位于网格的纵向索引为7
		gridBagConstraints4.gridx = 3;// 组件位于网格的横向索引为3
		add(enableButton, gridBagConstraints4);// 向设置经手人面板中添加“禁用/启用”按钮
		enableButton.addActionListener(new ActionListener() {// “禁用/启用”按钮动作事件的监听
			public void actionPerformed(final ActionEvent e) {
				int selRow = table.getSelectedRow();// 选定行的索引
				if (selRow < 0)// 选定行的索引小于0
					return;// 退出应用程序
				int op = JOptionPane.showConfirmDialog(SetJSR.this, "确认要修改该操作员状态？");// 弹出“确认要修改该操作员状态？”的提示框
				if (op == JOptionPane.OK_OPTION) {// 点击“确认”
					if (selRow < 0)// 选定行的索引小于0
						return;// 退出应用程序
					String id = table.getValueAt(selRow, 0).toString().trim();// 获得经手人编号
					Dao.update("update tb_jsr set enable=enable-1 where id='" + id + "'");// 执行SQL修改语句
					initTable();// 初始化表格模型
				}
			}
		});

		final JButton button_1 = new JButton("关闭");// “关闭”按钮
		final GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_2.insets = new Insets(5, 0, 5, 0);// 组件彼此的间距
		gridBagConstraints_2.gridy = 7;// 组件位于网格的纵向索引为7
		gridBagConstraints_2.gridx = 6;// 组件位于网格的横向索引为6
		add(button_1, gridBagConstraints_2);// 向设置经手人面板中添加“关闭”按钮
		button_1.addActionListener(new ActionListener() {// “关闭”按钮动作事件的监听
			public void actionPerformed(final ActionEvent e) {
				JsrGL parent = (JsrGL) SetJSR.this.getRootPane().getParent();// 获得经手人设置窗体
				parent.doDefaultCloseAction();// 关闭经手人设置窗体
			}
		});
	}

	public void initTable() {// 初始化表格模型
		List ul = Dao.getJsrs();// 获得被启用的经手人集合
		Iterator it = ul.iterator();// 获取经手人集合的迭代器
		String[] data = new String[6];// 创建长度为6的字符串数组
		dftm.setDataVector(null, columnNames);// 设置表格模型对象的列名
		while (it.hasNext()) {// 经手人的集合中的元素是否被遍历完
			List userlist = (List) it.next();// 获得经手人的集合中的下一个元素
			// 把集合中元素存放在字符串数组中
			data[0] = (String) userlist.get(0);
			data[1] = (String) userlist.get(1);
			data[2] = (String) userlist.get(2);
			data[3] = (String) userlist.get(3);
			data[4] = (String) userlist.get(4);
			data[5] = ((String) userlist.get(5)).equals("1") ? "启用" : "禁用";
			dftm.addRow(data);// 向表格对象中添加行数据
		}
		setVisible(true);// 使表格模型可见
	}
}
