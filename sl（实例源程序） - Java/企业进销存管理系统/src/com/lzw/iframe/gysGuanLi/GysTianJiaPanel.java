package com.lzw.iframe.gysGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import keyListener.InputKeyListener;

import com.lzw.dao.Dao;
import com.lzw.dao.model.TbGysinfo;

public class GysTianJiaPanel extends JPanel {// 供应商添加面板

	private JTextField EMailF;// “电子信箱”文本框
	private JTextField yinHangF;// “开户银行”文本框
	private JTextField lianXiRenDianHuaF;// “联系人电话”文本框
	private JTextField lianXiRenF;// “联系人”文本框
	private JTextField chuanZhenF;// “传真”文本框
	private JTextField dianHuaF;// “电话”文本框
	private JTextField diZhiF;// “地址”文本框
	private JTextField bianMaF;// “邮政编码”文本框
	private JTextField jianChengF;// “简称”文本框
	private JTextField quanChengF;// “供应商全称”文本框
	private JButton resetButton;// “重置”文本框

	public GysTianJiaPanel() {// 供应商添加面板
		setLayout(new GridBagLayout());// 设置供应商添加面板的布局为网格布局
		setBounds(10, 10, 510, 302);// 设置供应商添加面板的位置与宽高

		setupComponet(new JLabel("供应商全称："), 0, 0, 1, 1, false);// 设置“供应商全称”标签的位置并添加到容器中
		quanChengF = new JTextField();// “供应商全称”文本框
		setupComponet(quanChengF, 1, 0, 3, 400, true);// 设置“供应商全称”文本框的位置并添加到容器中

		setupComponet(new JLabel("简称："), 0, 1, 1, 1, false);// 设置“简称”标签的位置并添加到容器中
		jianChengF = new JTextField();// “简称”文本框
		setupComponet(jianChengF, 1, 1, 1, 160, true);// 设置“简称”文本框的位置并添加到容器中

		setupComponet(new JLabel("邮政编码："), 2, 1, 1, 1, false);// 设置“邮政编码”标签的位置并添加到容器中
		bianMaF = new JTextField();// “邮政编码”文本框
		bianMaF.addKeyListener(new InputKeyListener());// 为“邮政编码”文本框添加键盘输入事件的监听
		setupComponet(bianMaF, 3, 1, 1, 0, true);// 设置“邮政编码”文本框的位置并添加到容器中

		setupComponet(new JLabel("地址："), 0, 2, 1, 1, false);// 设置“地址”标签的位置并添加到容器中
		diZhiF = new JTextField();// “地址”文本框
		setupComponet(diZhiF, 1, 2, 3, 0, true);// 设置“地址”文本框的位置并添加到容器中

		setupComponet(new JLabel("电话："), 0, 3, 1, 1, false);// 设置“电话”标签的位置并添加到容器中
		dianHuaF = new JTextField();// “电话”文本框
		dianHuaF.addKeyListener(new InputKeyListener());// 为“电话”文本框添加键盘输入事件的监听
		setupComponet(dianHuaF, 1, 3, 1, 0, true);// 设置“电话”文本框的位置并添加到容器中

		setupComponet(new JLabel("传真："), 2, 3, 1, 1, false);// 设置“传真”标签的位置并添加到容器中
		chuanZhenF = new JTextField();// “传真”文本框
		chuanZhenF.addKeyListener(new InputKeyListener());// 为“传真”文本框添加键盘输入事件的监听
		setupComponet(chuanZhenF, 3, 3, 1, 0, true);// 设置“传真”文本框的位置并添加到容器中

		setupComponet(new JLabel("联系人："), 0, 4, 1, 1, false);// 设置“联系人”标签的位置并添加到容器中
		lianXiRenF = new JTextField();// “联系人”文本框
		setupComponet(lianXiRenF, 1, 4, 1, 0, true);// 设置“联系人”文本框的位置并添加到容器中

		setupComponet(new JLabel("联系人电话："), 2, 4, 1, 1, false);// 设置“联系人电话”标签的位置并添加到容器中
		lianXiRenDianHuaF = new JTextField();// “联系人电话”文本框
		lianXiRenDianHuaF.addKeyListener(new InputKeyListener());// 为“联系人电话”文本框添加键盘输入事件的监听
		setupComponet(lianXiRenDianHuaF, 3, 4, 1, 0, true);// 设置“联系人电话”文本框的位置并添加到容器中

		setupComponet(new JLabel("开户银行："), 0, 5, 1, 1, false);// 设置“开户银行”标签的位置并添加到容器中
		yinHangF = new JTextField();// “开户银行”文本框
		setupComponet(yinHangF, 1, 5, 1, 0, true);// 设置“开户银行”文本框的位置并添加到容器中

		setupComponet(new JLabel("电子信箱："), 2, 5, 1, 1, false);// 设置“电子信箱”标签的位置并添加到容器中
		EMailF = new JTextField();// “电子信箱”文本框
		setupComponet(EMailF, 3, 5, 1, 0, true);// 设置“电子信箱”文本框的位置并添加到容器中

		final JButton tjButton = new JButton();// “添加”按钮
		tjButton.addActionListener(new ActionListener() {// “添加”按钮动作事件的监听
			public void actionPerformed(final ActionEvent e) {
				// 文本框为空时，弹出提示框
				if (diZhiF.getText().equals("") || quanChengF.getText().equals("") || chuanZhenF.getText().equals("")
						|| jianChengF.getText().equals("") || yinHangF.getText().equals("")
						|| bianMaF.getText().equals("") || diZhiF.getText().equals("")
						|| lianXiRenF.getText().equals("") || lianXiRenDianHuaF.getText().equals("")
						|| EMailF.getText().equals("") || dianHuaF.getText().equals("")) {
					JOptionPane.showMessageDialog(GysTianJiaPanel.this, "请填写全部信息");
					return;
				}
				// 执行SQL查询语句获得的结果集
				ResultSet haveUser = Dao.query("select * from tb_gysinfo where name='" + quanChengF.getText().trim() + "'");
				try {
					if (haveUser.next()) {// 结果集haveUser中有超过一条的记录
						System.out.println("error");// 控制台输出error
						JOptionPane.showMessageDialog(GysTianJiaPanel.this, "供应商信息添加失败，存在同名供应商", "供应商添加信息",
								JOptionPane.INFORMATION_MESSAGE);// 弹出提示框
						return;
					}
				} catch (Exception er) {
					er.printStackTrace();
				}
				ResultSet set = Dao.query("select max(id) from tb_gysinfo");// 执行SQL查询语句获得的结果集
				String id = null;// 声明供应商编号
				try {
					if (set != null && set.next()) {// 结果集set不为空且结果集set中有超过一条的记录
						String sid = set.getString(1).trim();// 获得结果集set中的第一列数据值
						if (sid == null)// 第一列数据值为空
							id = "gys1001";// 为产品编号赋值
						else {
							String str = sid.substring(3);// 从索引为3处开始截取字符串
							id = "gys" + (Integer.parseInt(str) + 1);// 重新拼接字符串获得产品编号
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				TbGysinfo gysInfo = new TbGysinfo();// 供应商信息
				gysInfo.setId(id);// 设置供应商编号
				gysInfo.setAddress(diZhiF.getText().trim());// 设置供应商地址
				gysInfo.setBianma(bianMaF.getText().trim());// 设置邮政编码
				gysInfo.setFax(chuanZhenF.getText().trim());// 设置传真
				gysInfo.setYh(yinHangF.getText().trim());// 设置开户银行
				gysInfo.setJc(jianChengF.getText().trim());// 设置供应商简称
				gysInfo.setName(quanChengF.getText().trim());// 设置供应商名称
				gysInfo.setLian(lianXiRenF.getText().trim());// 设置联系人
				gysInfo.setLtel(lianXiRenDianHuaF.getText().trim());// 设置联系电话
				gysInfo.setMail(EMailF.getText().trim());// 设置电子信箱
				gysInfo.setTel(dianHuaF.getText().trim());// 设置电话
				Dao.addGys(gysInfo);// 添加供应商信息
				JOptionPane.showMessageDialog(GysTianJiaPanel.this, "已成功添加客户", "客户添加信息",
						JOptionPane.INFORMATION_MESSAGE);// 弹出提示框
				resetButton.doClick();// “重置”按钮执行点击事件
			}
		});
		tjButton.setText("添加");// “添加”按钮
		setupComponet(tjButton, 2, 6, 1, 0, false);// 设置“添加”按钮的位置并添加到容器中

		resetButton = new JButton();// “重置”按钮
		setupComponet(resetButton, 3, 6, 1, 0, false);// 设置“重置”按钮的位置并添加到容器中
		resetButton.addActionListener(new ActionListener() {// “重置”按钮动作事件的监听
			public void actionPerformed(final ActionEvent e) {
				// 设置文本框的内容为空
				diZhiF.setText("");
				bianMaF.setText("");
				chuanZhenF.setText("");
				jianChengF.setText("");
				lianXiRenF.setText("");
				lianXiRenDianHuaF.setText("");
				EMailF.setText("");
				quanChengF.setText("");
				dianHuaF.setText("");
				yinHangF.setText("");
			}
		});
		resetButton.setText("重置");// 设置“重置”按钮中的文本内容
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
		add(component, gridBagConstrains);// 添加组件
	}
}