import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.*;

public class ExampleFrame_12 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_12 frame = new ExampleFrame_12();
		frame.setVisible(true);
		try {
			frame.addIconToTray();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public ExampleFrame_12() {
		super();
		setTitle("使用系统托盘");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JLabel label = new JLabel();
		label.setForeground(new Color(0, 128, 0));
		label.setFont(new Font("", Font.BOLD, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("请查看系统托盘中的变化！");
		getContentPane().add(label, BorderLayout.CENTER);
		//
	}
	
	public void addIconToTray() throws AWTException {
		if (SystemTray.isSupported()) {// 判断系统是否支持系统托盘功能
			URL resource = this.getClass().getResource("/img.JPG");// 获得图片路径
			ImageIcon icon = new ImageIcon(resource);// 创建图片对象
			PopupMenu popupMenu = new PopupMenu();// 创建弹出菜单对象
			MenuItem item = new MenuItem("退出");// 创建“退出”菜单项目对象
			// 为菜单项目添加动作监听器
			item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// 退出系统
				}
			});
			popupMenu.add(item);// 将“退出”菜单项目添加到弹出菜单中
			TrayIcon trayIcon = new TrayIcon(icon.getImage(), "使用系统托盘",
					popupMenu);// 创建托盘图片对象
			// 获得系统托盘对象
			SystemTray systemTray = SystemTray.getSystemTray();
			systemTray.add(trayIcon);// 将托盘图片添加到系统托盘中
		}
	}
	
}
