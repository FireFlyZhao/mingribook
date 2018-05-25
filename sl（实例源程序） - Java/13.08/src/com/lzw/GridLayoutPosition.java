package com.lzw;

import java.awt.*;

import javax.swing.*;

public class GridLayoutPosition extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GridLayoutPosition() {
		Container c = getContentPane();
		// ��������ʹ�����񲼾ֹ�����������7��3�е�����
		setLayout(new GridLayout(7, 3, 5, 5));
		for (int i = 0; i < 20; i++) {
			c.add(new JButton("button" + i)); // ѭ����Ӱ�ť
		}
		setSize(300, 300);
		setTitle("����һ��ʹ�����񲼾ֹ������Ĵ���");
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new GridLayoutPosition();
	}
}
