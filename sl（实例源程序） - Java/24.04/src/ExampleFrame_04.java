import static javax.swing.SpringLayout.*;

import java.awt.*;

import javax.swing.*;

public class ExampleFrame_04 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_04 frame = new ExampleFrame_04();
		frame.setVisible(true);
	}
	
	public ExampleFrame_04() {
		super();
		setBounds(100, 100, 500, 375);
		setTitle("使用弹簧布局管理器");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 创建弹簧布局管理器对象
		SpringLayout springLayout = new SpringLayout();
		Container contentPane = getContentPane();// 获得窗体容器对象
		// 将窗体容器修改为采用弹簧布局管理器
		contentPane.setLayout(springLayout);
		JLabel topicLabel = new JLabel("主题：");
		contentPane.add(topicLabel);
		// 主题标签北侧——>容器北侧
		springLayout
				.putConstraint(NORTH, topicLabel, 5, NORTH, contentPane);
		// 主题标签西侧——>容器西侧
		springLayout.putConstraint(WEST, topicLabel, 5, WEST, contentPane);
		JTextField topicTextField = new JTextField();
		contentPane.add(topicTextField);
		// 主题文本框北侧——>容器北侧
		springLayout.putConstraint(NORTH, topicTextField, 5, NORTH,
				contentPane);
		// 主题文本框西侧——>主题标签东侧
		springLayout.putConstraint(WEST, topicTextField, 5, EAST,
				topicLabel);
		// 主题文本框东侧——>容器东侧
		springLayout.putConstraint(EAST, topicTextField, -5, EAST,
				contentPane);
		JLabel contentLabel = new JLabel("内容：");
		contentPane.add(contentLabel);
		springLayout.putConstraint(NORTH, contentLabel, 5, SOUTH,
				topicTextField);// 内容标签北侧——>主题文本框南侧
		// 内容标签西侧——>容器西侧
		springLayout
				.putConstraint(WEST, contentLabel, 5, WEST, contentPane);
		JScrollPane contentScrollPane = new JScrollPane();
		contentScrollPane.setViewportView(new JTextArea());
		contentPane.add(contentScrollPane);
		springLayout.putConstraint(NORTH, contentScrollPane, 5, SOUTH,
				topicTextField);// 滚动面板北侧——>主题文本框南侧
		springLayout.putConstraint(WEST, contentScrollPane, 5, EAST,
				contentLabel);// 滚动面板西侧——>内容标签东侧
		springLayout.putConstraint(EAST, contentScrollPane, -5, EAST,
				contentPane);// 滚动面板东侧——>容器东侧
		JButton resetButton = new JButton("清空");
		contentPane.add(resetButton);
		// “清空”按钮南侧——>容器南侧
		springLayout.putConstraint(SOUTH, resetButton, -5, SOUTH,
				contentPane);
		JButton submitButton = new JButton("确定");
		contentPane.add(submitButton);
		// “确定”按钮南侧——>容器南侧
		springLayout.putConstraint(SOUTH, submitButton, -5, SOUTH,
				contentPane);
		// “确定”按钮东侧——>容器东侧
		springLayout.putConstraint(EAST, submitButton, -5, EAST,
				contentPane);
		springLayout.putConstraint(SOUTH, contentScrollPane, -5, NORTH,
				submitButton);// 滚动面板南侧——>“确定”按钮北侧
		// “清空”按钮东侧——>“确定”按钮西侧
		springLayout.putConstraint(EAST, resetButton, -5, WEST,
				submitButton);
	}
}