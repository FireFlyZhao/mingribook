package com.lzw;
import java.awt.*;
import java.net.URL;
import javax.swing.*;
public class TiltImage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image img;
	private MyCanvas canvasPanel = null;
	public TiltImage() {
		initialize(); // ���ó�ʼ������
	}
	// �����ʼ������
	private void initialize() {
		// ��ȡͼƬ��Դ��·��
		URL imgUrl = TiltImage.class.getResource("cow.jpg");
		img = Toolkit.getDefaultToolkit().getImage(imgUrl); // ��ȡͼƬ��Դ
		canvasPanel = new MyCanvas();
		this.setBounds(100, 100, 400, 300); // ���ô����С��λ��
		add(canvasPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô���ر�ģʽ
		this.setTitle("ͼƬ��б"); // ���ô������
	}
	// ������
	public static void main(String[] args) {
		new TiltImage().setVisible(true);
	}
	// ����
	class MyCanvas extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.shear(0.3, 0);
			g2.drawImage(img, 0, 0, 300, 200, this);// ����ָ����С��ͼƬ
		}
	}
}