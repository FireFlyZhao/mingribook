package com.lzw;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class PartImage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image img;
	private int dx1, dy1, dx2, dy2;
	private int sx1, sy1, sx2, sy2;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private MyCanvas canvasPanel = null;
	
	public PartImage() {
		dx2 = sx2 = 300; // ��ʼ��ͼ���С
		dy2 = sy2 = 200;
		initialize(); // ���ó�ʼ������
	}
	
	// �����ʼ������
	private void initialize() {
		URL imgUrl = PartImage.class.getResource("cow.jpg");// ��ȡͼƬ��Դ��·��
		img = Toolkit.getDefaultToolkit().getImage(imgUrl); // ��ȡͼƬ��Դ
		this.setBounds(100, 100, 300, 260); // ���ô����С��λ��
		this.setContentPane(getJPanel());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô���ر�ģʽ
		this.setTitle("ͼƬ��ת"); // ���ô������
	}
	
	// ��ȡ�������ķ���
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(new BorderLayout());
			jPanel.add(getControlPanel(), BorderLayout.SOUTH);
			jPanel.add(getMyCanvas1(), BorderLayout.CENTER);
		}
		return jPanel;
	}
	
	// ��ȡ��ť�������ķ���
	private JPanel getControlPanel() {
		if (jPanel1 == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.gridy = 0;
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1.add(getJButton(), new GridBagConstraints());
			jPanel1.add(getJButton1(), gridBagConstraints);
		}
		return jPanel1;
	}
	
	// ��ȡˮƽ��ת��ť
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("ˮƽ��ת");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					sx1 = Math.abs(sx1 - 300);
					sx2 = Math.abs(sx2 - 300);
					canvasPanel.repaint();
				}
			});
		}
		return jButton;
	}
	
	// ��ȡ��ֱ��ת��ť
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("��ֱ��ת");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					sy1 = Math.abs(sy1 - 200);
					sy2 = Math.abs(sy2 - 200);
					canvasPanel.repaint();
				}
			});
		}
		return jButton1;
	}
	
	// ��ȡ�������
	private MyCanvas getMyCanvas1() {
		if (canvasPanel == null) {
			canvasPanel = new MyCanvas();
		}
		return canvasPanel;
	}
	
	// ������
	public static void main(String[] args) {
		new PartImage().setVisible(true);
	}
	
	// ����
	class MyCanvas extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, this);// ����ָ����С��ͼƬ
		}
	}
} // @jve:decl-index=0:visual-constraint="10,10"