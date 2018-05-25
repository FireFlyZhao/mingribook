package com.lzw;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class DesktopPanel extends JDesktopPane {// �������

	private static final long serialVersionUID = 1L;
	private final Image backImage;// ����ͼƬ

	public DesktopPanel() {// �������Ĺ��췽��
		super();// ���ø���JDesktopPane�Ĺ�����
		URL url = DesktopPanel.class.getResource("/res/back.jpg");// ��ñ���ͼƬ��·��
		backImage = new ImageIcon(url).getImage();// ��ñ���ͼƬ
	}

	@Override
	protected void paintComponent(Graphics g) {// ��д��������ķ���
		int width = getWidth();// �����������Ŀ��
		int height = this.getHeight();// �����������ĸ߶�
		g.drawImage(backImage, 0, 0, width, height, this);// ���Ʊ���ͼƬ
	}
}
