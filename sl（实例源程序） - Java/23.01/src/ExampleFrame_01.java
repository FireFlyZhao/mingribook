import java.awt.*;

import javax.swing.*;
public class ExampleFrame_01 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String args[]) {
		ExampleFrame_01 frame = new ExampleFrame_01();
		frame.setVisible(true);
	}
	public ExampleFrame_01() {
		super();
		setTitle("分割面板");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 创建一个水平方向的分割面板
		final JSplitPane hSplitPane = new JSplitPane();
		// 分隔条左侧的宽度为40像素
		hSplitPane.setDividerLocation(40);
		// 添加到指定区域
		getContentPane().add(hSplitPane, BorderLayout.CENTER);
		// 在水平面板左侧添加一个标签组件
		hSplitPane.setLeftComponent(new JLabel("      1"));
		// 创建一个垂直方向的分割面板
		final JSplitPane vSplitPane = new JSplitPane(
				JSplitPane.VERTICAL_SPLIT);
		// 分隔条上方的高度为30像素
		vSplitPane.setDividerLocation(30);
		vSplitPane.setDividerSize(8);// 分隔条的宽度为8像素
		vSplitPane.setOneTouchExpandable(true);// 提供UI小部件
		// 在调整分隔条位置时面板的重绘方式为连续绘制
		vSplitPane.setContinuousLayout(true);
		hSplitPane.setRightComponent(vSplitPane);// 添加到水平面板的右侧
		// 在垂直面板上方添加一个标签组件
		vSplitPane.setLeftComponent(new JLabel("      2"));
		// 在垂直面板下方添加一个标签组件
		vSplitPane.setRightComponent(new JLabel("      3"));
	}
}
