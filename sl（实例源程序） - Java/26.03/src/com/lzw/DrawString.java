package com.lzw;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
public class DrawString extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Shape rect; // ���ζ���
	private Font font; // �������
	private Date date; // ��ǰ���ڶ���
	public DrawString() {
		rect = new Rectangle2D.Double(10, 10, 200, 80);
		font = new Font("����", Font.BOLD, 16);
		date = new Date();
		this.setSize(230, 140); // ���ô����С
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô���ر�ģʽ
		add(new CanvasPanel()); // ���ô������Ϊ��ͼ������
		this.setTitle("��ͼ�ı�"); // ���ô������
	}
	public static void main(String[] args) {
		new DrawString().setVisible(true);
	}
	class CanvasPanel extends Canvas {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.CYAN); // ���õ�ǰ��ͼ��ɫ
			g2.fill(rect); // ������
			g2.setColor(Color.BLUE); // ���õ�ǰ��ͼ��ɫ
			g2.setFont(font); // ��������
			g2.drawString("����ʱ����", 20, 30); // �����ı�
			g2.drawString(String.format("%tr", date), 50, 60); // ����ʱ���ı�
		}
	}
}