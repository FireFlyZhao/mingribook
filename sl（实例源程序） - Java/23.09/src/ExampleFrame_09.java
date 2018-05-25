import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class ExampleFrame_09 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	
	public static void main(String args[]) {
		ExampleFrame_09 frame = new ExampleFrame_09();
		frame.setVisible(true);
	}
	
	public ExampleFrame_09() {
		super();
		setTitle("文件选择对话框");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		final JLabel label = new JLabel();
		label.setText("文件：");
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(20);
		panel.add(textField);
		
		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();// 创建文件选择对话框
				// 显示文件选择对话框
				int i = fileChooser.showOpenDialog(getContentPane());
				// 判断用户单击的是否为“打开”按钮
				if (i == JFileChooser.APPROVE_OPTION) {
					// 获得选中的文件对象
					File selectedFile = fileChooser.getSelectedFile();
					// 显示选中文件的名称
					textField.setText(selectedFile.getName());
				}
			}
		});
		button.setText("上传");
		panel.add(button);
		//
	}
}
