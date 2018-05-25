package com.lzw;
import java.awt.*;
import javax.swing.*;
public class DrawCircle extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int OVAL_WIDTH = 80;// 圆形的宽
	private final int OVAL_HEIGHT = 80;// 圆形的高
	public DrawCircle() {
		super();
		initialize();// 调用初始化方法
	}
	// 初始化方法
	private void initialize() {
		this.setSize(300, 200);// 设置窗体大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗体关闭模式
		setContentPane(new DrawPanel());// 设置窗体面板为绘图面板对象
		this.setTitle("绘图实例1");// 设置窗体标题
	}
	public static void main(String[] args) {
		new DrawCircle().setVisible(true);
	}
	// 创建绘图面板
	class DrawPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			super.paint(g);
			g.drawOval(10, 10, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第1个圆形
			g.drawOval(80, 10, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第2个圆形
			g.drawOval(150, 10, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第3个圆形
			g.drawOval(50, 70, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第4个圆形
			g.drawOval(120, 70, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第5个圆形
		}
	}
}
