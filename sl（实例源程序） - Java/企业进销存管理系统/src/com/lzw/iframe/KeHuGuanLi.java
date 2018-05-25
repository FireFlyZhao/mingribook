package com.lzw.iframe;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.lzw.iframe.keHuGuanLi.*;

public class KeHuGuanLi extends JInternalFrame {// 客户管理内部窗体
	public KeHuGuanLi() {// 客户管理内部窗体的构造方法
		setIconifiable(true);// 可以图标化
		setClosable(true);// 可以关闭
		setTitle("客户信息管理");// 设置客户管理内部窗体的标题
		JTabbedPane tabPane = new JTabbedPane();// 创建选项卡面板
		final KeHuXiuGaiPanel khxgPanel = new KeHuXiuGaiPanel();// 客户修改面板
		final KeHuTianJiaPanel khtjPanel = new KeHuTianJiaPanel();// 客户添加面板
		tabPane.addTab("客户信息添加", null, khtjPanel, "客户添加");// 把客户添加面板添加到选项卡面板中
		tabPane.addTab("客户信息修改与删除", null, khxgPanel, "修改与删除");// 把客户修改面板添加到选项卡面板中
		getContentPane().add(tabPane);// 把选项卡面板添加到客户管理内部窗体的内容面板中
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				khxgPanel.initComboBox();// 初始化客户修改面板中的“选择客户”下拉列表
			}
		});
		pack();// 客户管理内部窗体中的组件按其首选大小进行布局
		setVisible(true);// 使客户管理内部窗体可见
	}
}
