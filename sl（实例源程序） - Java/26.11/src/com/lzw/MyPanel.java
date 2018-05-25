package com.lzw;

import java.awt.*;
import java.util.Date;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int OVAL_WIDTH = 150;
	private static final int OVAL_HEIGHT = 150;

	public MyPanel() {
		super();
		//
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(4.0F));
		g2.setColor(Color.BLUE);
		g2.drawOval(10, 10, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第1个圆形
		g2.setStroke(new BasicStroke(8.0F));
		g2.setColor(Color.CYAN);
		g2.drawOval(130, 10, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第2个圆形
		g2.setStroke(new BasicStroke(2.0F));
		g2.setColor(Color.GREEN);
		g2.drawOval(250, 10, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第3个圆形
		g2.setStroke(new BasicStroke(5.0F));
		g2.setColor(Color.MAGENTA);
		g2.drawOval(70, 120, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第4个圆形
		g2.setStroke(new BasicStroke(9.0F));
		g2.setColor(Color.ORANGE);
		g2.drawOval(190, 120, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第5个圆形
		Date now=new Date();
		String nowStr = String.format("%tY年%tm月%td日", new Date[]{now, now, now});
		Font font = new Font("宋体",Font.BOLD,14);
		g2.setFont(font);
		g2.drawString(nowStr, 80, 300);
	}

}
