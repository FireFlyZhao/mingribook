import java.awt.*;

import javax.swing.*;

public class BorderLayoutPosition extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 定义组件摆放位置的数组
	String[] border = { BorderLayout.CENTER, BorderLayout.NORTH,
			BorderLayout.SOUTH, BorderLayout.WEST, BorderLayout.EAST };
	String[] buttonName = { "center button", "north button",
			"south button", "west button", "east button" };
	
	public BorderLayoutPosition() {
		setTitle("这个窗体使用边界布局管理器");
		Container c = getContentPane(); // 定义一个容器
		setLayout(new BorderLayout()); // 设置容器为边界布局管理器
		for (int i = 0; i < border.length; i++) {
			// 在容器中添加按钮，并设置按钮布局
			c.add(border[i], new JButton(buttonName[i]));
		}
		setSize(350, 200); // 设置窗体大小
		setVisible(true); // 使窗体可视
		// 设置窗体关闭方式
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BorderLayoutPosition();
	}
}
