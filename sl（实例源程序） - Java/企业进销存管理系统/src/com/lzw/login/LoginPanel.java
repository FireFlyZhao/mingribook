package com.lzw.login;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

import java.awt.Dimension;

public class LoginPanel extends JPanel {// ��¼���

	public int width, height;// ���Ŀ��
	private Image img;// ��¼���ı���ͼƬ

	public LoginPanel() {// ��¼���Ĺ��췽��
		super();// ���ø���JPanel�Ĺ�����
		URL url = getClass().getResource("/res/login.jpg");// ��õ�¼��屳��ͼƬ��·��
		img = new ImageIcon(url).getImage();// ��õ�¼���ı���ͼƬ
	}

	protected void paintComponent(Graphics g) {// ��д�����������
		super.paintComponent(g);// �������
		g.drawImage(img, 0, 0, this);// ����ͼƬ
	}

}