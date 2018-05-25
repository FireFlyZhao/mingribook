package com.lzw.iframe.keHuGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import keyListener.InputKeyListener;

import com.lzw.dao.Dao;
import com.lzw.dao.model.TbKhinfo;

public class KeHuTianJiaPanel extends JPanel {// 客户添加面板

	private JTextField keHuQuanCheng;// “客户全称”文本框
	private JTextField yinHangZhangHao;// “银行账号”文本框
	private JTextField kaiHuYinHang;// “开户银行”文本框
	private JTextField EMail;// “E-Mail”文本框
	private JTextField lianXiDianHua;// “联系电话”文本框
	private JTextField lianXiRen;// “联系人”文本框
	private JTextField chuanZhen;// “传真”文本框
	private JTextField dianHua;// “电话”文本框
	private JTextField youZhengBianMa;// “邮政编码”文本框
	private JTextField diZhi;// “客户地址”文本框
	private JTextField keHuJianCheng;// “客户简称”文本框
	private JButton resetButton;// “重置”按钮文本框

	public KeHuTianJiaPanel() {// 客户添加面板
		super();// 调用父类JPanel的构造器
		setBounds(10, 10, 460, 300);// 设置客户添加面板的位置与宽高
		setLayout(new GridBagLayout());// 设置客户添加面板的布局为网格布局
		setVisible(true);// 使客户添加面板可见
		
		final JLabel khName = new JLabel();// “客户全称”标签
		khName.setText("客户全称：");// 设置“客户全称”标签的文本内容
		setupComponet(khName, 0, 0, 1, 0, false);// 设置“客户全称”标签的位置并添加到容器中
		keHuQuanCheng = new JTextField();// “客户全称”文本框
		setupComponet(keHuQuanCheng, 1, 0, 3, 350, true);// 设置“客户全称”文本框的位置并添加到容器中
		
		final JLabel addressLabel = new JLabel("客户地址：");// “客户地址”标签
		setupComponet(addressLabel, 0, 1, 1, 0, false);// 设置“客户地址”标签的位置并添加到容器中
		diZhi = new JTextField();// “客户地址”文本框
		setupComponet(diZhi, 1, 1, 3, 0, true);// 设置“客户地址”文本框的位置并添加到容器中
		
		final JLabel jc = new JLabel();// “客户简称”标签
		jc.setText("客户简称：");// 设置“客户简称”标签的文本内容
		setupComponet(jc, 0, 2, 1, 0, false);// 设置“客户简称”标签的位置并添加到容器中
		keHuJianCheng = new JTextField();// “客户简称”文本框
		setupComponet(keHuJianCheng, 1, 2, 1, 100, true);// 设置“客户简称”文本框的位置并添加到容器中
		
		setupComponet(new JLabel("邮政编码："), 2, 2, 1, 0, false);// 设置“邮政编码”标签的位置并添加到容器中
		youZhengBianMa = new JTextField();// “邮政编码”文本框
		setupComponet(youZhengBianMa, 3, 2, 1, 100, true);// 设置“邮政编码”文本框的位置并添加到容器中
		youZhengBianMa.addKeyListener(new InputKeyListener());// 为“邮政编码”文本框添加键盘输入事件的监听
		
		setupComponet(new JLabel("电话："), 0, 3, 1, 0, false);// 设置“电话”标签的位置并添加到容器中
		dianHua = new JTextField();// “电话”文本框
		setupComponet(dianHua, 1, 3, 1, 100, true);// 设置“电话”文本框的位置并添加到容器中
		dianHua.addKeyListener(new InputKeyListener());// 为“电话”文本框添加键盘输入事件的监听
		
		setupComponet(new JLabel("传真："), 2, 3, 1, 0, false);// 设置“传真”标签的位置并添加到容器中
		chuanZhen = new JTextField();// “传真”文本框
		chuanZhen.addKeyListener(new InputKeyListener());// 为“传真”文本框添加键盘输入事件的监听
		setupComponet(chuanZhen, 3, 3, 1, 100, true);// 设置“传真”文本框的位置并添加到容器中
		
		setupComponet(new JLabel("联系人："), 0, 4, 1, 0, false);// 设置“联系人”标签的位置并添加到容器中
		lianXiRen = new JTextField();// “联系人”文本框
		setupComponet(lianXiRen, 1, 4, 1, 100, true);// 设置“联系人”文本框的位置并添加到容器中
		
		setupComponet(new JLabel("联系电话："), 2, 4, 1, 0, false);// 设置“联系电话”标签的位置并添加到容器中
		lianXiDianHua = new JTextField();// “联系电话”文本框
		setupComponet(lianXiDianHua, 3, 4, 1, 100, true);// 设置“联系电话”文本框的位置并添加到容器中
		lianXiDianHua.addKeyListener(new InputKeyListener());// 为“联系电话”文本框添加键盘输入事件的监听
		
		setupComponet(new JLabel("E-Mail："), 0, 5, 1, 0, false);// 设置“E-Mail”标签的位置并添加到容器中
		EMail = new JTextField();// “E-Mail”文本框
		setupComponet(EMail, 1, 5, 3, 350, true);// 设置“E-Mail”文本框的位置并添加到容器中
		
		setupComponet(new JLabel("开户银行："), 0, 6, 1, 0, false);// 设置“开户银行”标签的位置并添加到容器中
		kaiHuYinHang = new JTextField();// “开户银行”文本框
		setupComponet(kaiHuYinHang, 1, 6, 1, 100, true);// 设置“开户银行”文本框的位置并添加到容器中
		
		setupComponet(new JLabel("银行账号："), 2, 6, 1, 0, false);// 设置“银行账号”标签的位置并添加到容器中
		yinHangZhangHao = new JTextField();// “银行账号”文本框
		setupComponet(yinHangZhangHao, 3, 6, 1, 100, true);// 设置“银行账号”文本框的位置并添加到容器中
		
		final JButton saveButton = new JButton("保存");// “保存”按钮
		setupComponet(saveButton, 1, 7, 1, 0, false);// 设置“保存”按钮的位置并添加到容器中
		saveButton.addActionListener(new SaveButtonActionListener());// 为“保存”按钮添加动作事件的监听
		
		resetButton = new JButton("重置");// “重置”按钮
		setupComponet(resetButton, 3, 7, 1, 0, false);// 设置“重置”按钮的位置并添加到容器中
		resetButton.addActionListener(new ChongZheButtonActionListener());// 为“重置”按钮添加动作事件的监听
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

	private final class SaveButtonActionListener implements ActionListener {// “保存”按钮动作事件的监听
		public void actionPerformed(final ActionEvent e) {
			// 文本框为空时，弹出提示框
			if (diZhi.getText().equals("") || youZhengBianMa.getText().equals("") || chuanZhen.getText().equals("")
					|| yinHangZhangHao.getText().equals("") || keHuJianCheng.getText().equals("")
					|| keHuQuanCheng.getText().equals("") || lianXiRen.getText().equals("")
					|| lianXiDianHua.getText().equals("") || EMail.getText().equals("") || dianHua.getText().equals("")
					|| kaiHuYinHang.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "请填写全部信息");
				return;// 退出应用程序
			}
			// 执行SQL查询语句获得的结果集
			ResultSet haveUser = Dao.query("select * from tb_khinfo where khname='" + keHuQuanCheng.getText().trim() + "'");
			try {
				if (haveUser.next()) {// 结果集haveUser中有超过一条的记录
					System.out.println("error");// 控制台输出error
					JOptionPane.showMessageDialog(KeHuTianJiaPanel.this, "客户信息添加失败，存在同名客户", "客户添加信息",
							JOptionPane.INFORMATION_MESSAGE);// 弹出提示框
					return;
				}
			} catch (Exception er) {
				er.printStackTrace();
			}
			ResultSet set = Dao.query("select max(id) from tb_khinfo");// 执行SQL查询语句获得的结果集
			String id = null;// 声明客户编号
			try {
				if (set != null && set.next()) {// 结果集set不为空且结果集set中有超过一条的记录
					String sid = set.getString(1);// 获得结果集set中的第一列数据值
					if (sid == null)// 第一列数据值为空
						id = "kh1001";// 为产品编号赋值
					else {
						String str = sid.substring(2);// 从索引为2处开始截取字符串
						id = "kh" + (Integer.parseInt(str) + 1);// 重新拼接字符串获得产品编号
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			TbKhinfo khinfo = new TbKhinfo();// 客户信息
			khinfo.setId(id);// 设置商品编号
			khinfo.setAddress(diZhi.getText().trim());// 设置客户地址
			khinfo.setBianma(youZhengBianMa.getText().trim());// 设置邮编
			khinfo.setFax(chuanZhen.getText().trim());// 设置传真
			khinfo.setHao(yinHangZhangHao.getText().trim());// 设置银行账号
			khinfo.setJian(keHuJianCheng.getText().trim());// 设置客户简称
			khinfo.setKhname(keHuQuanCheng.getText().trim());// 设置客户名称
			khinfo.setLian(lianXiRen.getText().trim());// 设置联系人
			khinfo.setLtel(lianXiDianHua.getText().trim());// 设置联系电话
			khinfo.setMail(EMail.getText().trim());// 设置电子邮箱
			khinfo.setTel(dianHua.getText().trim());// 设置电话
			khinfo.setXinhang(kaiHuYinHang.getText());// 设置开户银行
			Dao.addKeHu(khinfo);// 添加客户信息
			JOptionPane.showMessageDialog(KeHuTianJiaPanel.this, "已成功添加客户", "客户添加信息", JOptionPane.INFORMATION_MESSAGE);// 弹出提示框
			resetButton.doClick();// “重置”按钮执行点击事件
		}
	}

	private class ChongZheButtonActionListener implements ActionListener {// “重置”按钮动作事件的监听
		public void actionPerformed(final ActionEvent e) {
			// 设置文本框的内容为空
			keHuQuanCheng.setText("");
			yinHangZhangHao.setText("");
			kaiHuYinHang.setText("");
			EMail.setText("");
			lianXiDianHua.setText("");
			lianXiRen.setText("");
			chuanZhen.setText("");
			dianHua.setText("");
			youZhengBianMa.setText("");
			diZhi.setText("");
			keHuJianCheng.setText("");
		}
	}
}