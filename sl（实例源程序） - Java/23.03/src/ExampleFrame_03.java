import java.awt.*;
import java.net.*;

import javax.swing.*;

public class ExampleFrame_03 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_03 frame = new ExampleFrame_03();
		frame.setVisible(true);
	}
	
	public ExampleFrame_03() {
		super();
		setTitle("为桌面面板添加背景图片");
		setBounds(100, 100, 570, 430);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 创建一个桌面面板对象
		final JDesktopPane desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		final JLabel backLabel = new JLabel(); // 创建一个标签组件对象
		// 获得背景图片的路径
		URL resource = this.getClass().getResource("/back.JPG");
		ImageIcon icon = new ImageIcon(resource); // 创建背景图片对象
		backLabel.setIcon(icon); // 令标签组件显示背景图片
		// 设置组件的显示位置及大小
		backLabel.setBounds(0, 0, icon.getIconWidth(), icon
				.getIconHeight());
		// 将标签组件添加到指定索引位置
		desktopPane.add(backLabel, new Integer(Integer.MIN_VALUE));
	}
}
