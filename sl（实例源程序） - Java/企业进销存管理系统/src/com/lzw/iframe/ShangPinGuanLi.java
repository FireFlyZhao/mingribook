package com.lzw.iframe;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import com.lzw.iframe.shangPinGuanLi.*;

public class ShangPinGuanLi extends JInternalFrame {// 商品管理内部窗体
	public ShangPinGuanLi() {// 商品管理内部窗体的构造方法
		setIconifiable(true);// 可以图标化
		setClosable(true);// 可以关闭
		setTitle("商品管理");// 设置商品管理内部窗体的标题
		JTabbedPane tabPane = new JTabbedPane();// 创建选项卡面板
		final ShangPinXiuGaiPanel spxgPanel = new ShangPinXiuGaiPanel();// 商品修改面板
		final ShangPinTianJiaPanel sptjPanel = new ShangPinTianJiaPanel();// 商品添加面板
		tabPane.addTab("商品信息添加", null, sptjPanel, "商品添加");// 把商品添加面板添加到选项卡面板中
		tabPane.addTab("商品信息修改与删除", null, spxgPanel, "修改与删除");// 把商品修改面板添加到选项卡面板中
		getContentPane().add(tabPane);// 把选项卡面板添加到商品管理内部窗体的内容面板中
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spxgPanel.initComboBox();// 初始化商品修改面板中的商品下拉选择框
				spxgPanel.initGysBox();// 初始化商品修改面板中的供应商下拉列表
			}
		});
		addInternalFrameListener(new InternalFrameAdapter(){
			public void internalFrameActivated(InternalFrameEvent e) {
				super.internalFrameActivated(e);
				sptjPanel.initGysBox();//初始化商品添加面板中的供应商下拉选择框
			}
		});
		pack();// 商品管理内部窗体中的组件按其首选大小进行布局
		setVisible(true);// 使商品管理内部窗体可见
	}
}
