package com.lzw.iframe;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.lzw.dao.Dao;
import com.lzw.dao.model.TbJsr;

public class GengGaiMiMa extends JInternalFrame {// 更改密码内部窗体

	// private JLabel name;
	private JPasswordField oldPass;// “旧密码”密码框
	private JPasswordField newPass2;// “确认新密码”密码框
	private JPasswordField newPass1;// “新密码”密码框

	public GengGaiMiMa() {// 更改密码窗体的构造方法
		super();// 调用父类JInternalFrame的构造器
		setIconifiable(true);// 设置更改密码窗体可以图标化
		setTitle("更改密码");// 设置更改密码窗体的标题
		setClosable(true);// 设置可以关闭更改密码窗体
		getContentPane().setLayout(new GridBagLayout());// 设置更改密码窗体中内容面板的布局是网格布局
		setBounds(100, 100, 300, 228);// 设置更改密码窗体的位置与宽高

		/*name = new JLabel();
		final GridBagConstraints gridBagConstraints_12 = new GridBagConstraints();
		gridBagConstraints_12.gridy = 2;
		gridBagConstraints_12.gridx = 1;
		gridBagConstraints_12.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(name, gridBagConstraints_12);*/

		final JLabel label_1 = new JLabel();// “旧密码：”标签
		label_1.setFont(new Font("", Font.PLAIN, 14));// 设置“旧密码：”标签中的字体样式和大小
		label_1.setText("旧  密  码：");// 设置“旧密码：”标签中的文本内容
		final GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_2.gridy = 3;// 组件位于网格的纵向索引为3
		gridBagConstraints_2.gridx = 0;// 组件位于网格的横向索引为0
		getContentPane().add(label_1, gridBagConstraints_2);// 向更改密码窗体中的内容面板添加“旧密码：”标签

		oldPass = new JPasswordField();// “旧密码”密码框
		final GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_3.weighty = 1.0;// 组件纵向扩大的权重是1.0
		gridBagConstraints_3.insets = new Insets(0, 0, 0, 10);// 组件彼此的间距
		gridBagConstraints_3.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
		gridBagConstraints_3.gridwidth = 3;// 组件横跨3个网格
		gridBagConstraints_3.gridy = 3;// 组件位于网格的纵向索引为3
		gridBagConstraints_3.gridx = 1;// 组件位于网格的横向索引为1
		getContentPane().add(oldPass, gridBagConstraints_3);// 向更改密码窗体中的内容面板添加“旧密码”密码框

		final JLabel label_2 = new JLabel();// “新密码：”标签
		label_2.setFont(new Font("", Font.PLAIN, 14));// 设置“新密码：”标签中的字体样式和大小
		label_2.setText("新  密  码：");// 设置“新密码：”标签中的文本内容
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_4.gridy = 4;// 组件位于网格的纵向索引为4
		gridBagConstraints_4.gridx = 0;// 组件位于网格的横向索引为0
		getContentPane().add(label_2, gridBagConstraints_4);// 向更改密码窗体中的内容面板添加“新密码：”标签

		newPass1 = new JPasswordField();// “新密码”密码框
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_5.weighty = 1.0;// 组件纵向扩大的权重是1.0
		gridBagConstraints_5.ipadx = 30;// 组件横向增加30像素
		gridBagConstraints_5.insets = new Insets(0, 0, 0, 10);// 组件彼此的间距
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
		gridBagConstraints_5.gridwidth = 3;// 组件横跨3个网格
		gridBagConstraints_5.gridy = 4;// 组件位于网格的纵向索引为4
		gridBagConstraints_5.gridx = 1;// 组件位于网格的横向索引为1
		getContentPane().add(newPass1, gridBagConstraints_5);// 向更改密码窗体中的内容面板添加“新密码”密码框

		final JLabel label_3 = new JLabel();// “确认新密码：”标签
		label_3.setFont(new Font("", Font.PLAIN, 14));// 设置“确认新密码：”标签中的字体样式和大小
		label_3.setText("确认新密码：");// 设置“确认新密码：”标签中的文本内容
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_6.gridy = 5;// 组件位于网格的纵向索引为5
		gridBagConstraints_6.gridx = 0;// 组件位于网格的横向索引为0
		getContentPane().add(label_3, gridBagConstraints_6);// 向更改密码窗体中的内容面板添加“确认新密码：”标签

		newPass2 = new JPasswordField();// “确认新密码”密码框
		final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_7.weighty = 1.0;// 组件纵向扩大的权重是1.0
		gridBagConstraints_7.ipadx = 30;// 组件横向增加30像素
		gridBagConstraints_7.insets = new Insets(0, 0, 0, 10);// 组件彼此的间距
		gridBagConstraints_7.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
		gridBagConstraints_7.weightx = 1.0;// 组件横向扩大的权重是1.0
		gridBagConstraints_7.gridwidth = 3;// 组件横跨3个网格
		gridBagConstraints_7.gridy = 5;// 组件位于网格的纵向索引为5
		gridBagConstraints_7.gridx = 1;// 组件位于网格的横向索引为1
		getContentPane().add(newPass2, gridBagConstraints_7);// 向更改密码窗体中的内容面板添加“确认新密码”密码框

		final JButton button = new JButton("确认");// “确认”按钮
		button.addActionListener(new ActionListener() {// 为“确认”按钮添加动作事件的监听
			public void actionPerformed(final ActionEvent e) {
				String newPass1Str = newPass1.getText();// 获取“新密码”密码框中的文本内容
				String newPass2Str = newPass2.getText();// 获取“确认新密码”密码框中的文本内容
				if (newPass1Str.equals(newPass2Str)) {// “新密码”密码框中的文本内容与“确认新密码”密码框中的文本内容相同
					String oldPassStr = oldPass.getText();// 获取“旧密码”密码框中的文本内容
					int res = Dao.modifyPassword(oldPassStr, newPass1Str);// 获得更改密码的记录条数
					if (res <= 0) {// 更改密码的记录条数不大于0
						String failed = "密码修改失败，请检测旧密码是否正确。";// 初始化密码修改失败的字符串
						JOptionPane.showMessageDialog(getContentPane(), failed);// 弹出密码修改失败的提示框
						return;// 退出应用程序
					}
					JOptionPane.showMessageDialog(getContentPane(), "密码修改成功。");// 弹出密码修改成功的提示框
				} else {// “新密码”密码框中的文本内容与“确认新密码”密码框中的文本内容不相同
					JOptionPane.showMessageDialog(getContentPane(), "两次输入的密码不一致，请重新输入。");// 弹出两次输入的密码不一致的提示框
				}
			}
		});
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_8.weighty = 1.0;// 组件纵向扩大的权重是1.0
		gridBagConstraints_8.anchor = GridBagConstraints.EAST;// 组件在其显示区域的右中
		gridBagConstraints_8.gridy = 6;// 组件位于网格的纵向索引为6
		gridBagConstraints_8.gridx = 1;// 组件位于网格的横向索引为1
		getContentPane().add(button, gridBagConstraints_8);// 向更改密码窗体中的内容面板添加“确认”按钮

		final JButton button_1 = new JButton();// “重置”按钮
		button_1.addActionListener(new ActionListener() {// 为“重置”按钮添加动作事件的监听
			public void actionPerformed(final ActionEvent e) {
				oldPass.setText(null);// 设置“旧密码”密码框的文本内容为空
				newPass1.setText(null);// 设置“新密码”密码框的文本内容为空
				newPass2.setText(null);// 设置“确认新密码”密码框的文本内容为空
			}
		});
		button_1.setText("重置");// 设置“重置”按钮中的文本内容为“重置”
		final GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_9.gridwidth = 2;// 组件横跨2个网格
		gridBagConstraints_9.weighty = 1.0;// 组件纵向扩大的权重是1.0
		gridBagConstraints_9.gridy = 6;// 组件位于网格的纵向索引为6
		gridBagConstraints_9.gridx = 2;// 组件位于网格的横向索引为2
		getContentPane().add(button_1, gridBagConstraints_9);// 向更改密码窗体中的内容面板添加“重置”按钮
	}
}
