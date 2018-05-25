package com.lzw;
import java.awt.*;
import java.net.*;
import javax.swing.*;
public class ImageZoom extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image img;
	private JPanel contentPanel = null;
	private JSlider jSlider = null;
	private int imgWidth, imgHeight;
	private Canvas canvas = null;
	public ImageZoom() {
		initialize(); // ���ó�ʼ������
	}
	// �����ʼ������
	private void initialize() {
		URL imgUrl = ImageZoom.class.getResource("img.jpg");// ��ȡͼƬ��Դ��·��
		img = Toolkit.getDefaultToolkit().getImage(imgUrl);// ��ȡͼƬ��Դ
		canvas = new MyCanvas();
		this.setBounds(100, 100, 800, 600); // ���ô����С��λ��
		this.setContentPane(getContentPanel()); // �����������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô���ر�ģʽ
		this.setTitle("����ͼƬ"); // ���ô������
	}
	// �������Ĳ���
	private JPanel getContentPanel() {
		if (contentPanel == null) {
			contentPanel = new JPanel();
			contentPanel.setLayout(new BorderLayout());
			contentPanel.add(getJSlider(), BorderLayout.SOUTH);
			contentPanel.add(canvas, BorderLayout.CENTER);
		}
		return contentPanel;
	}
	// ��ȡ�������
	private JSlider getJSlider() {
		if (jSlider == null) {
			jSlider = new JSlider();
			jSlider.setMaximum(1000);
			jSlider.setValue(100);
			jSlider.setMinimum(1);
			jSlider.addChangeListener(new javax.swing.event.ChangeListener() {
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					canvas.repaint();
				}
			});
		}
		return jSlider;
	}
	// ������
	public static void main(String[] args) {
		new ImageZoom().setVisible(true);
	}
	// ������
	class MyCanvas extends Canvas {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			int newW = 0, newH = 0;
			imgWidth = img.getWidth(this); // ��ȡͼƬ���
			imgHeight = img.getHeight(this); // ��ȡͼƬ�߶�
			float value = jSlider.getValue();// ���������ȡֵ
			newW = (int) (imgWidth * value / 100);// ����ͼƬ�Ŵ��Ŀ��
			newH = (int) (imgHeight * value / 100);// ����ͼƬ�Ŵ��ĸ߶�
			g.drawImage(img, 0, 0, newW, newH, this);// ����ָ����С��ͼƬ
		}
	}
}