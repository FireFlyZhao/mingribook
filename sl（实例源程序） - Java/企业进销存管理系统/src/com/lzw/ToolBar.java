package com.lzw;

import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import com.lzw.dao.*;

public class ToolBar extends JToolBar {// 工具条
	
	private MenuBar menuBar;// 菜单栏

	/**
	 * 缺省构造函数
	 */
	private ToolBar() {
	}

	/**
	 * 完整构造函数
	 */
	public ToolBar(MenuBar frameMenuBar) {
		super();// 调用父类JToolBar的构造器
		this.menuBar = frameMenuBar;
		initialize();// 界面初始化方法
	}

	/**
	 * 界面初始化方法
	 */
	private void initialize() {
		setSize(new Dimension(600, 24));// 设置工具条的宽高
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));// 设置工具条的边框
		add(createToolButton(menuBar.getJinhuoItem()));// 向工具条中添加进货单
		add(createToolButton(menuBar.getXiaoshou_danItem()));// 向工具条中添加销售单
		add(createToolButton(menuBar.getKucun_pandianItem()));// 向工具条中添加库存盘点
		add(createToolButton(menuBar.getJiage_tiaozhengItem()));// 向工具条中添加价格调整
		add(createToolButton(menuBar.getShangpin_chaxunItem()));// 向工具条中添加商品查询
		add(createToolButton(menuBar.getShangpin_guanliItem()));// 向工具条中添加商品资料管理
		add(createToolButton(menuBar.getKehu_guanliItem()));// 向工具条中添加客户资料管理
		add(createToolButton(menuBar.getGys_guanliItem()));// 向工具条中添加供应商资料管理
		add(createToolButton(menuBar.getExitItem()));// 向工具条中添加退出系统
	}

	/**
	 * 创建工具栏按钮的方法
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton createToolButton(final JMenuItem item) {
		JButton button = new JButton();// 工具栏按钮
		button.setText(item.getText());// 设置工具栏按钮的文本内容
		button.setToolTipText(item.getText());// 设置工具栏按钮的悬浮效果
		button.setIcon(item.getIcon());// 设置工具栏按钮的图标
		button.setFocusable(false);// 让工具栏按钮失去焦点
		button.addActionListener(new java.awt.event.ActionListener() {// 为工具栏按钮添加动作事件的监听
			public void actionPerformed(java.awt.event.ActionEvent e) {
				item.doClick();// 菜单项的点击事件
			}
		});
		return button;
	}

	public void setMenuBar(MenuBar menuBar) {// 设置菜单栏
		this.menuBar = menuBar;
	}
}
