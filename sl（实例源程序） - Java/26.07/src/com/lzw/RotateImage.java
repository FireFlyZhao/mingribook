package com.lzw;
import java.awt.*;
import java.net.URL;
import javax.swing.*;
public class RotateImage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image img;
	private MyCanvas canvasPanel = null;
	public RotateImage() {
		initialize(); // ���ó�ʼ������
	}
	// �����ʼ������
	private void initialize() {
		// ��ȡͼƬ��Դ��·��
		URL imgUrl = RotateImage.class.getResource("cow.jpg");
		img = Toolkit.getDefaultToolkit().getImage(imgUrl); // ��ȡͼƬ��Դ
		canvasPanel = new MyCanvas();
		this.setBounds(100, 100, 400, 350); // ���ô����С��λ��
		add(canvasPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô���ر�ģʽ
		this.setTitle("ͼƬ��ת"); // ���ô������
	}
	// ������
	public static void main(String[] args) {
		new RotateImage().setVisible(true);
	}
	// ����
	class MyCanvas extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.rotate(Math.toRadians(5));
			g2.drawImage(img, 70, 10, 300, 200, this);// ����ָ����С��ͼƬ
			g2.rotate(Math.toRadians(5));
			g2.drawImage(img, 70, 10, 300, 200, this);// ����ָ����С��ͼƬ
			g2.rotate(Math.toRadians(5));
			g2.drawImage(img, 70, 10, 300, 200, this);// ����ָ����С��ͼƬ
		}
	}
}