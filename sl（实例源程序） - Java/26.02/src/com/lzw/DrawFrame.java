package com.lzw;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
public class DrawFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DrawFrame() {
		super();
		initialize();// 调用初始化方法
	}
	// 初始化方法
	private void initialize() {
		this.setSize(300, 200); // 设置窗体大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭模式
		add(new CanvasPanel()); // 设置窗体面板为绘图面板对象
		this.setTitle("绘图实例2"); // 设置窗体标题
	}
	public static void main(String[] args) {
		new DrawFrame().setVisible(true);
	}
	class CanvasPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;
			Shape[] shapes = new Shape[4]; // 声明图形数组
			shapes[0] = new Ellipse2D.Double(5, 5, 100, 100); // 创建圆形对象
			// 创建矩形对象
			shapes[1] = new Rectangle2D.Double(110, 5, 100, 100); 
			shapes[2] = new Rectangle2D.Double(15, 15, 80, 80); // 创建矩形对象
			shapes[3] = new Ellipse2D.Double(120, 15, 80, 80); // 创建圆形对象
			for (Shape shape : shapes) { // 遍历图形数组
				Rectangle2D bounds = shape.getBounds2D();
				if (bounds.getWidth() == 80)
					g2.fill(shape); // 填充图形
				else
					g2.draw(shape); // 绘制图形
			}
		}
	}
}
