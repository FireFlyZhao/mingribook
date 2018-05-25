package com.lzw;

import java.awt.*;

import javax.swing.*;

public class DrawIcon implements Icon { // ʵ��Icon�ӿ�
	private int width; // ����ͼ��Ŀ�
	private int height; // ����ͼ��ĳ�
	
	public int getIconHeight() { // ʵ��getIconHeight()����
		return this.height;
	}
	
	public int getIconWidth() { // ʵ��getIconWidth()����
		return this.width;
	}
	
	public DrawIcon(int width, int height) { // ���幹�췽��
		this.width = width;
		this.height = height;
	}
	
	// ʵ��paintIcon()����
	public void paintIcon(Component arg0, Graphics arg1, int x, int y) {
		arg1.fillOval(x, y, width, height); // ����һ��Բ��
	}
	
	public static void main(String[] args) {
		DrawIcon icon = new DrawIcon(15, 15);
		// ����һ����ǩ�������ñ�ǩ�ϵ������ڱ�ǩ���м�
		JLabel j = new JLabel("����", icon, SwingConstants.CENTER);
		JFrame jf = new JFrame(); // ����һ��JFrame����
		Container c = jf.getContentPane();
		c.add(j);
		jf.setSize(100,100);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
