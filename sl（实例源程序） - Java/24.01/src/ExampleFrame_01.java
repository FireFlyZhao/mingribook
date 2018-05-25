import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
		setTitle("使用箱式布局管理器");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Box topicBox = Box.createHorizontalBox();// 创建一个水平箱容器
		getContentPane().add(topicBox, BorderLayout.NORTH);// 添加到窗体中
		topicBox.add(Box.createHorizontalStrut(5));// 添加一个5像素宽的水平支柱
		JLabel topicLabel = new JLabel("主题：");// 创建主题标签
		topicBox.add(topicLabel);// 添加到水平箱容器中
		topicBox.add(Box.createHorizontalStrut(5));// 添加一个5像素宽的水平支柱
		JTextField topicTextField = new JTextField(30);// 创建文本框
		topicBox.add(topicTextField);// 添加到水平箱容器中
		Box box = Box.createVerticalBox();// 创建一个垂直箱容器
		getContentPane().add(box, BorderLayout.CENTER);// 添加到窗体中
		box.add(Box.createVerticalStrut(5));// 添加一个5像素高的垂直支柱
		Box contentBox = Box.createHorizontalBox();// 创建一个水平箱容器
		contentBox.setAlignmentX(1);// 设置组件的水平调整值，靠右侧对齐
		box.add(contentBox);// 添加到垂直箱容器中
		contentBox.add(Box.createHorizontalStrut(5));// 添加一个5像素宽的水平支柱
		JLabel contentLabel = new JLabel("内容：");// 创建一个标签组件
		contentLabel.setAlignmentY(0);// 设置组件的垂直调整值，靠上方对齐
		contentBox.add(contentLabel);// 添加到水平箱容器中
		contentBox.add(Box.createHorizontalStrut(5));// 添加一个5像素宽的水平支柱
		JScrollPane scrollPane = new JScrollPane();// 创建一个滚动面板
		scrollPane.setAlignmentY(0);// 设置组件的垂直调整值，靠上方对齐
		contentBox.add(scrollPane);// 添加到水平箱容器中
		JTextArea contentTextArea = new JTextArea();// 创建一个文本区域
		contentTextArea.setLineWrap(true);
		scrollPane.setViewportView(contentTextArea);// 添加到滚动面板中
		box.add(Box.createVerticalStrut(5));// 添加一个5像素高的垂直支柱
		JButton submitButton = new JButton("确定");// 创建一个按钮
		submitButton.setAlignmentX(1);// 设置组件的水平调整值，靠右侧对齐
		box.add(submitButton);// 添加到垂直箱容器中
		//
	}
	
}
