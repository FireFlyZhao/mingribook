package com.lzw.iframe.czyGl;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.lzw.dao.Dao;
import com.lzw.dao.model.TbJsr;

public class TJJingShouRen extends JPanel {// 添加经手人面板

	private JTextField jsrName;// “姓名”文本框
	private JTextField tel;// “电话”文本框
	private JTextField age;// “年龄”文本框
	private JComboBox sex;// “性别”下拉列表

	private void clear() {// 清除文本框内容的方法
		// 设置文本框的内容为空
		jsrName.setText(null);
		tel.setText(null);
		age.setText(null);
	}

	public TJJingShouRen() {// 添加经手人面板
		super();// 调用父类JPanel的构造器
		setLayout(new GridBagLayout());// 设置添加经手人面板的布局为网格布局
		setBounds(0, 0, 280, 236);// 设置添加经手人面板的位置和宽高
		
		final JLabel label_4 = new JLabel();// “姓名”标签
		label_4.setFont(new Font("", Font.PLAIN, 14));// 设置“姓名”标签内字体的样式和大小
		label_4.setText("姓名：");// 设置“姓名”标签内的文本内容
		final GridBagConstraints gridBagConstraints_10 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_10.gridx = 0;// 组件位于网格的横向索引为0
		gridBagConstraints_10.gridy = 0;// 组件位于网格的纵向索引为0
		add(label_4, gridBagConstraints_10);// 向添加经手人面板中添加“姓名”标签
		
		jsrName = new JTextField();// “姓名”文本框
		final GridBagConstraints gridBagConstraints_11 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_11.weighty = 1.0;// 组件纵向扩大的权重是1.0
		gridBagConstraints_11.insets = new Insets(0, 0, 0, 10);// 组件彼此的间距
		gridBagConstraints_11.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
		gridBagConstraints_11.gridwidth = 2;// 组件横向跨越2个网格
		gridBagConstraints_11.gridy = 0;// 组件位于网格的纵向索引为0
		gridBagConstraints_11.gridx = 1;// 组件位于网格的横向索引为1
		add(jsrName, gridBagConstraints_11);// 向添加经手人面板中添加“姓名”文本框
		
		final JLabel label = new JLabel();// “性别”标签
		label.setFont(new Font("", Font.PLAIN, 14));// 设置“性别”标签内字体的样式和大小
		label.setText("性别：");// 设置“性别”标签内的文本内容
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints.gridy = 1;// 组件位于网格的纵向索引为1
		gridBagConstraints.gridx = 0;// 组件位于网格的横向索引为0
		add(label, gridBagConstraints);// 向添加经手人面板中添加“性别”标签
		
		sex = new JComboBox();// “性别”下拉列表
		sex.addItem("男");// 设置“性别”下拉列表中的选项内容
		sex.addItem("女");// 设置“性别”下拉列表中的选项内容
		final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_1.weightx = 1.0;// 组件横向扩大的权重是1.0
		gridBagConstraints_1.weighty = 1.0;// 组件纵向扩大的权重是1.0
		gridBagConstraints_1.ipadx = -250;// 组件横向减少250像素
		gridBagConstraints_1.insets = new Insets(0, 0, 0, 10);// 组件彼此的间距
		gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
		gridBagConstraints_1.gridwidth = 2;// 组件横向跨越2个网格
		gridBagConstraints_1.gridy = 1;// 组件位于网格的纵向索引为1
		gridBagConstraints_1.gridx = 1;// 组件位于网格的横向索引为1
		add(sex, gridBagConstraints_1);// 向添加经手人面板中添加“性别”下拉列表
		
		final JLabel label_2 = new JLabel();// “年龄”标签
		label_2.setFont(new Font("", Font.PLAIN, 14));// 设置“年龄”标签内字体的样式和大小
		label_2.setText("年龄：");// 设置“年龄”标签内的文本内容
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_4.gridy = 2;// 组件位于网格的纵向索引为2
		gridBagConstraints_4.gridx = 0;// 组件位于网格的横向索引为0
		add(label_2, gridBagConstraints_4);// 向添加经手人面板中添加“年龄”标签
		
		age = new JTextField();// “年龄”文本框
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_5.weighty = 1.0;// 组件纵向扩大的权重是1.0
		gridBagConstraints_5.insets = new Insets(0, 0, 0, 10);// 组件彼此的间距
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
		gridBagConstraints_5.gridwidth = 2;// 组件横向跨越2个网格
		gridBagConstraints_5.gridy = 2;// 组件位于网格的纵向索引为2
		gridBagConstraints_5.gridx = 1;// 组件位于网格的横向索引为1
		add(age, gridBagConstraints_5);// 向添加经手人面板中添加“年龄”文本框
		
		final JLabel label_3 = new JLabel();// “电话”标签
		label_3.setFont(new Font("", Font.PLAIN, 14));// 设置“电话”标签内字体的样式和大小
		label_3.setText("电话：");// 设置“电话”标签内的文本内容
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_6.gridy = 3;// 组件位于网格的纵向索引为3
		gridBagConstraints_6.gridx = 0;// 组件位于网格的横向索引为0
		add(label_3, gridBagConstraints_6);// 向添加经手人面板中添加“电话”标签
		
		tel = new JTextField();// “电话”文本框
		final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_7.weighty = 1.0;// 组件纵向扩大的权重是1.0
		gridBagConstraints_7.insets = new Insets(0, 0, 0, 10);// 组件彼此的间距
		gridBagConstraints_7.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
		gridBagConstraints_7.gridwidth = 2;// 组件横向跨越2个网格
		gridBagConstraints_7.gridy = 3;// 组件位于网格的纵向索引为3
		gridBagConstraints_7.gridx = 1;// 组件位于网格的横向索引为1
		add(tel, gridBagConstraints_7);// 向添加经手人面板中添加“电话”文本框
		
		final JButton button = new JButton("添加");// “添加”按钮
		button.addActionListener(new ActionListener() {// “添加”按钮动作事件的监听
			public void actionPerformed(final ActionEvent e) {
				String nameStr = jsrName.getText();// 获得“姓名”文本框中的文本内容
				if (nameStr == null || nameStr.isEmpty())// “姓名”文本框为空或“姓名”文本框中的文本内容为空
					return;// 退出应用程序
				String ageStr = new String(age.getText());// 获得“年龄”文本框中的文本内容
				TbJsr user = Dao.getJsr(nameStr, ageStr);// 经手人信息
				if (user.getSex() != null && !user.getSex().isEmpty()) {// 经手人的性别不为空且经手人表示性别的字符串的长度不为0
					JOptionPane.showMessageDialog(TJJingShouRen.this, "经手人(" + user.getName() + ")已经存在");// 弹出对话框
					sex.setFocusable(true);// // “性别”下拉列表获得焦点
					return;// 退出应用程序
				}
				String sexStr = sex.getSelectedItem() + "";// 获得经手人的性别
				TbJsr jsr = new TbJsr();// 经手人信息
				jsr.setTel(tel.getText());// 设置经手人电话
				jsr.setAge(age.getText());// 设置经手人年龄
				jsr.setName(nameStr);// 设置经手人姓名
				jsr.setSex(sexStr);// 设置经手人性别
				int i = Dao.addJsr(jsr);// 添加经手人
				if (i > 0)// 添加经手人的数目大于1
					JOptionPane.showMessageDialog(TJJingShouRen.this, "添加成功");// 弹出提示框
				clear();// 清除文本框的内容
			}
		});
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_8.weighty = 1.0;// 组件纵向扩大的权重是1.0
		gridBagConstraints_8.anchor = GridBagConstraints.EAST;// 设置组件在该组件显示区域的右中
		gridBagConstraints_8.gridy = 5;// 组件位于网格的纵向索引为5
		gridBagConstraints_8.gridx = 1;// 组件位于网格的横向索引为1
		add(button, gridBagConstraints_8);// 向添加经手人面板中添加“添加”按钮

		final JButton button_1 = new JButton();// “重置”按钮
		button_1.addActionListener(new ActionListener() {// 为“重置”按钮添加动作事件的监听
			public void actionPerformed(final ActionEvent e) {
				clear();// 清除文本框的内容
			}
		});
		button_1.setText("重置");// 设置“重置”按钮中的字体内容
		final GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_9.weighty = 1.0;// 组件纵向扩大的权重是1.0
		gridBagConstraints_9.gridy = 5;// 组件位于网格的纵向索引为5
		gridBagConstraints_9.gridx = 2;// 组件位于网格的横向索引为2
		add(button_1, gridBagConstraints_9);// 向添加经手人面板中添加“重置”按钮
	}
}
