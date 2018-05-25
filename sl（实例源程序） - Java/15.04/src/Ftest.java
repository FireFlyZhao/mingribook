import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class Ftest extends JFrame { // 创建类，继承Jframe类
	private JScrollPane scrollPane;
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null; // 创建面板对象
	private JTextArea jTextArea = null; // 创建文本域对象
	private JPanel controlPanel = null; // 创建面板对象
	private JButton openButton = null; // 创建按钮对象
	private JButton closeButton = null; // 创建按钮对象
	
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
		}
		return jTextArea;
	}
	
	private JPanel getControlPanel() {
		if (controlPanel == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setVgap(1);
			controlPanel = new JPanel();
			controlPanel.setLayout(flowLayout);
			controlPanel.add(getOpenButton(), null);
			controlPanel.add(getCloseButton(), null);
		}
		return controlPanel;
	}
	
	private JButton getOpenButton() {
		if (openButton == null) {
			openButton = new JButton();
			openButton.setText("写入文件"); // 修改按钮的提示信息
			openButton
					.addActionListener(new java.awt.event.ActionListener() {
						// 按钮的单击事件
						public void actionPerformed(ActionEvent e) {
							// 创建文件对象
							File file = new File("word.txt");
							try {
								// 创建FileWriter对象
								FileWriter out = new FileWriter(file);
								// 获取文本域中文本
								String s = jTextArea.getText();
								out.write(s); // 将信息写入磁盘文件
								out.close(); // 将流关闭
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					});
		}
		return openButton;
	}
	
	private JButton getCloseButton() {
		if (closeButton == null) {
			closeButton = new JButton();
			closeButton.setText("读取文件"); // 修改按钮的提示信息
			closeButton
					.addActionListener(new java.awt.event.ActionListener() {
						// 按钮的单击事件
						public void actionPerformed(ActionEvent e) {
							File file = new File("word.txt"); // 创建文件对象
							try {
								// 创建FileReader对象
								FileReader in = new FileReader(file);
								char byt[] = new char[1024]; // 创建char型数组
								int len = in.read(byt); // 将字节读入数组
								// 设置文本域的显示信息
								jTextArea.setText(new String(byt, 0, len));
								in.close(); // 关闭流
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					});
		}
		return closeButton;
	}
	
	public Ftest() {
		super();
		initialize();
	}
	
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}
	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getScrollPane(), BorderLayout.CENTER);
			jContentPane.add(getControlPanel(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}
	
	public static void main(String[] args) { // 主方法
		Ftest thisClass = new Ftest(); // 创建本类对象
		thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thisClass.setVisible(true); // 设置该窗体为显示状态
	}
	/**
	 * @return
	 */
	protected JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getJTextArea());
		}
		return scrollPane;
	}
}
