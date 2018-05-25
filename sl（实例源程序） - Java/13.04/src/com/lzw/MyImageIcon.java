package com.lzw;
import java.awt.*;
import java.net.*;

import javax.swing.*;

public class MyImageIcon extends JFrame {

	private static final long serialVersionUID = 1L;

	public MyImageIcon() {
		Container container = getContentPane();
		// ����һ����ǩ
		JLabel jl = new JLabel("����һ��JFrame����", JLabel.CENTER);
		// ��ȡͼƬ���ڵ�URL
		URL url = MyImageIcon.class.getResource("imageButton.jpg");
		Icon icon = new ImageIcon(url); // ʵ����Icon����
		jl.setIcon(icon); // Ϊ��ǩ����ͼƬ
		// �������ַ����ڱ�ǩ�м�
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		jl.setOpaque(true); // ���ñ�ǩΪ��͸��״̬
		container.add(jl); // ����ǩ��ӵ�������
		setSize(250, 100); // ���ô����С
		setVisible(true); // ʹ����ɼ�
		// ���ô���ر�ģʽ
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[]) {
		new MyImageIcon(); // ʵ����MyImageIcon����
	}
}
