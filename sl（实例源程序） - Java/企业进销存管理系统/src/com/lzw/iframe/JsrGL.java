package com.lzw.iframe;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.lzw.iframe.czyGl.*;

public class JsrGL extends JInternalFrame {// 经手人管理内部窗体
	public JsrGL() {// 经手人管理内部窗体的构造方法
		setIconifiable(true);// 可以图标化
		setClosable(true);// 可以关闭
		setBounds(100, 100, 491, 200);// 设置经手人管理内部窗体的位置和宽高
		setTitle("经手人管理");// 设置经手人管理内部窗体的标题
		JTabbedPane tabPane = new JTabbedPane();// 创建选项卡面板
		final TJJingShouRen tjPanel = new TJJingShouRen();// 添加经手人面板
		final SetJSR setPanel = new SetJSR();// 设置经手人面板
		tabPane.addTab("添加经手人", null, tjPanel, "添加经手人");// 把添加经手人面板添加到选项卡面板中
		tabPane.addTab("设置经手人", null, setPanel, "设置经手人");// 把设置经手人面板添加到选项卡面板中
		getContentPane().add(tabPane);// 把选项卡面板添加到经手人管理内部窗体的内容面板中
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				setPanel.initTable();// 初始化设置经手人面板中的表格模型
			}
		});
		pack();// 经手人管理内部窗体中的组件按其首选大小进行布局
		setVisible(true);// 使经手人管理内部窗体可见
	}
}
