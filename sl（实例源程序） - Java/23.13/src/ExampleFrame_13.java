import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

public class ExampleFrame_13 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_13 frame = new ExampleFrame_13();
		frame.setVisible(true);
	}
	
	public ExampleFrame_13() {
		super();
		setTitle("使用桌面集成控件");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		final JButton dickButton = new JButton();
		dickButton.setText("打开编程词典网");
		dickButton.addActionListener(new ButtonListener(1));
		panel.add(dickButton);
		
		final JButton noteButton = new JButton();
		noteButton.setText("打开记事本");
		noteButton.addActionListener(new ButtonListener(2));
		panel.add(noteButton);
		
		final JButton wordButton = new JButton();
		wordButton.setText("打开Word");
		wordButton.addActionListener(new ButtonListener(0));
		panel.add(wordButton);
		//
	}
	
	private class ButtonListener implements ActionListener {
		
		int index;
		
		public ButtonListener(int index) {
			this.index = index;
		}
		
		public void actionPerformed(ActionEvent e) {
			try {
if (Desktop.isDesktopSupported()) { // 判断系统是否提供了对该类的支持
	Desktop desktop = Desktop.getDesktop();// 获得该类的对象
	switch (index) {
		case 1:
			// 判断是否支持“浏览”动作
			if (desktop.isSupported(Desktop.Action.BROWSE))
				desktop.browse(new URI(
						"http://www.mrbccd.com"));// 浏览网站
			break;
		case 2:
			// 判断是否支持“编辑”动作
			if (desktop.isSupported(Desktop.Action.EDIT))
				desktop.edit(new File("src/new.txt"));// 编辑记事本
			break;
		default:
			// 判断是否支持“打开”动作
			if (desktop.isSupported(Desktop.Action.OPEN))
				desktop.open(new File("src/new.doc"));// 打开Word
	}
}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
}
