package com.lzw;

import java.awt.*;

import javax.swing.*;

public class JScrollPaneTest extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JScrollPaneTest() {
		Container c = getContentPane(); // ��������
		JTextArea ta = new JTextArea(20, 50); // �����ı��������
		JScrollPane sp = new JScrollPane(ta); // ����JScrollPane������
		c.add(sp); // ���������ӵ���������
		
		setTitle("�������������ֱ�����");
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JScrollPaneTest();
		
	}
	
}
