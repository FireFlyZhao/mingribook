package com.lzw;

import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DrawPanel() {
		super();
		//
	}

	@Override
	protected void paintComponent(Graphics g) {
		// ����
		super.paintComponent(g);
		g.drawRect(10, 10, 100, 50);
		// ����
		int[] xs = {10, 50, 30};
		int[] ys = {80, 80, 110};
		g.drawPolygon(xs, ys, 3);
		// Բ��
		g.drawOval(130,10,80,80);
		// ��Բ
		g.drawOval(60,80,80,50);
	}

}
