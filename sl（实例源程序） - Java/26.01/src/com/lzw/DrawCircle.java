package com.lzw;
import java.awt.*;
import javax.swing.*;
public class DrawCircle extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int OVAL_WIDTH = 80;// Բ�εĿ�
	private final int OVAL_HEIGHT = 80;// Բ�εĸ�
	public DrawCircle() {
		super();
		initialize();// ���ó�ʼ������
	}
	// ��ʼ������
	private void initialize() {
		this.setSize(300, 200);// ���ô����С
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ô���ر�ģʽ
		setContentPane(new DrawPanel());// ���ô������Ϊ��ͼ������
		this.setTitle("��ͼʵ��1");// ���ô������
	}
	public static void main(String[] args) {
		new DrawCircle().setVisible(true);
	}
	// ������ͼ���
	class DrawPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			super.paint(g);
			g.drawOval(10, 10, OVAL_WIDTH, OVAL_HEIGHT); // ���Ƶ�1��Բ��
			g.drawOval(80, 10, OVAL_WIDTH, OVAL_HEIGHT); // ���Ƶ�2��Բ��
			g.drawOval(150, 10, OVAL_WIDTH, OVAL_HEIGHT); // ���Ƶ�3��Բ��
			g.drawOval(50, 70, OVAL_WIDTH, OVAL_HEIGHT); // ���Ƶ�4��Բ��
			g.drawOval(120, 70, OVAL_WIDTH, OVAL_HEIGHT); // ���Ƶ�5��Բ��
		}
	}
}
