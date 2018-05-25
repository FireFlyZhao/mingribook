package com.lzw.iframe;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.lzw.iframe.gysGuanLi.*;

public class GysGuanLi extends JInternalFrame {// 供应商管理内部窗体

	public GysGuanLi() {// 供应商管理窗体的构造方法
		setIconifiable(true);// 设置供应商管理窗体可以图标化
		setClosable(true);// 设置可以关闭供应商管理窗体
		setTitle("供应商管理");// 设置供应商管理窗体的标题
		JTabbedPane tabPane = new JTabbedPane();// 创建选项卡面板
		final GysXiuGaiPanel spxgPanel = new GysXiuGaiPanel();// 供应商修改面板
		final GysTianJiaPanel sptjPanel = new GysTianJiaPanel();// 供应商添加面板
		tabPane.addTab("供应商信息添加", null, sptjPanel, "供应商添加");// 把供应商添加面板添加到选项卡面板中
		tabPane.addTab("供应商信息修改与删除", null, spxgPanel, "修改与删除");// 把供应商修改面板添加到选项卡面板中
		getContentPane().add(tabPane);// 把选项卡面板添加到供应商管理窗体的内容面板中
		tabPane.addChangeListener(new ChangeListener() {// 选项卡面板添加捕获被选中选项卡发生改变的事件监听
			public void stateChanged(ChangeEvent e) {
				spxgPanel.initComboBox();// 初始化供应商修改面板中的“选择供应商”下拉列表
			}
		});
		pack();// 供应商管理窗体中的组件按其首选大小进行布局
		setVisible(true);// 使供应商管理窗体可见
	}

}