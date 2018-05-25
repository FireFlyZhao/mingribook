import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;

public class ExampleFrame_10 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_10 frame = new ExampleFrame_10();
		frame.setVisible(true);
	}
	
	public ExampleFrame_10() {
		super();
		setTitle("选择照片对话框");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JLabel label = new JLabel("<双击选择照片>", SwingConstants.CENTER);
		label.addMouseListener(new MouseAdapter() {
			JFileChooser fileChooser;
			{
				// 创建文件选择对话框
				fileChooser = new JFileChooser();
				// 设置文件过滤器，只列出JPG或GIF格式的图片
				FileFilter filter = new FileNameExtensionFilter(
						"图像文件（JPG/GIF）", "JPG", "JPEG", "GIF");
				fileChooser.setFileFilter(filter);
			}
			
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					// 显示文件选择对话框
					int i = fileChooser.showOpenDialog(getContentPane());
					// 判断用户单击的是否为“打开”按钮
					if (i == JFileChooser.APPROVE_OPTION) {
						// 获得选中的图片对象
						File selectedFile = fileChooser.getSelectedFile();
						label.setIcon(new ImageIcon(selectedFile
								.getAbsolutePath()));// 将图片显示到标签上
						label.setText(null);
					}
				}
			}
		});
		getContentPane().add(label, BorderLayout.CENTER);
	}
}
