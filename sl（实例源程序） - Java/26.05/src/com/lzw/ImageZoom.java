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
		initialize(); // 调用初始化方法
	}
	// 界面初始化方法
	private void initialize() {
		URL imgUrl = ImageZoom.class.getResource("img.jpg");// 获取图片资源的路径
		img = Toolkit.getDefaultToolkit().getImage(imgUrl);// 获取图片资源
		canvas = new MyCanvas();
		this.setBounds(100, 100, 800, 600); // 设置窗体大小和位置
		this.setContentPane(getContentPanel()); // 设置内容面板
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭模式
		this.setTitle("绘制图片"); // 设置窗体标题
	}
	// 内容面板的布局
	private JPanel getContentPanel() {
		if (contentPanel == null) {
			contentPanel = new JPanel();
			contentPanel.setLayout(new BorderLayout());
			contentPanel.add(getJSlider(), BorderLayout.SOUTH);
			contentPanel.add(canvas, BorderLayout.CENTER);
		}
		return contentPanel;
	}
	// 获取滑块组件
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
	// 主方法
	public static void main(String[] args) {
		new ImageZoom().setVisible(true);
	}
	// 画板类
	class MyCanvas extends Canvas {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			int newW = 0, newH = 0;
			imgWidth = img.getWidth(this); // 获取图片宽度
			imgHeight = img.getHeight(this); // 获取图片高度
			float value = jSlider.getValue();// 滑块组件的取值
			newW = (int) (imgWidth * value / 100);// 计算图片放大后的宽度
			newH = (int) (imgHeight * value / 100);// 计算图片放大后的高度
			g.drawImage(img, 0, 0, newW, newH, this);// 绘制指定大小的图片
		}
	}
}