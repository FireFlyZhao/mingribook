package com.lzw;
import java.awt.*;
import java.net.*;
import javax.swing.*;
public class DrawImage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image img;
	public DrawImage() {
		URL imgUrl = DrawImage.class.getResource("img.jpg");// ��ȡͼƬ��Դ��·��
		img = Toolkit.getDefaultToolkit().getImage(imgUrl); // ��ȡͼƬ��Դ
		this.setSize(440, 300); // ���ô����С
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô���ر�ģʽ
		add(new CanvasPanel()); // ���ô������Ϊ��ͼ������
		this.setTitle("����ͼƬ"); // ���ô������
	}
	public static void main(String[] args) {
		new DrawImage().setVisible(true);
	}
	class CanvasPanel extends Canvas {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(img, 0, 0, this); // ��ʾͼƬ
		}
	}
}