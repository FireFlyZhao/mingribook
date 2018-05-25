package com.lzw;

import java.awt.*;

import javax.swing.*;

public class JScrollPaneTest extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JScrollPaneTest() {
		Container c = getContentPane(); // 创建容器
		JTextArea ta = new JTextArea(20, 50); // 创建文本区域组件
		JScrollPane sp = new JScrollPane(ta); // 创建JScrollPane面板对象
		c.add(sp); // 将该面板添加到该容器中
		
		setTitle("带滚动条的文字编译器");
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JScrollPaneTest();
		
	}
	
}
