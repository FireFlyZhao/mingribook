package com.lzw;
import java.awt.*;
import java.net.URL;
import javax.swing.*;
public class RotateImage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image img;
	private MyCanvas canvasPanel = null;
	public RotateImage() {
		initialize(); // 调用初始化方法
	}
	// 界面初始化方法
	private void initialize() {
		// 获取图片资源的路径
		URL imgUrl = RotateImage.class.getResource("cow.jpg");
		img = Toolkit.getDefaultToolkit().getImage(imgUrl); // 获取图片资源
		canvasPanel = new MyCanvas();
		this.setBounds(100, 100, 400, 350); // 设置窗体大小和位置
		add(canvasPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭模式
		this.setTitle("图片旋转"); // 设置窗体标题
	}
	// 主方法
	public static void main(String[] args) {
		new RotateImage().setVisible(true);
	}
	// 画板
	class MyCanvas extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.rotate(Math.toRadians(5));
			g2.drawImage(img, 70, 10, 300, 200, this);// 绘制指定大小的图片
			g2.rotate(Math.toRadians(5));
			g2.drawImage(img, 70, 10, 300, 200, this);// 绘制指定大小的图片
			g2.rotate(Math.toRadians(5));
			g2.drawImage(img, 70, 10, 300, 200, this);// 绘制指定大小的图片
		}
	}
}