import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

public class WindowStateListener_Example extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String args[]) {
		WindowStateListener_Example frame = new WindowStateListener_Example();
		frame.setVisible(true);
	}
	public WindowStateListener_Example() {
		super();
		// 为窗体添加状态事件监听器
		addWindowStateListener(new MyWindowStateListener());
		setTitle("捕获窗体状态事件");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private class MyWindowStateListener implements WindowStateListener {
		public void windowStateChanged(WindowEvent e) {
			int oldState = e.getOldState();// 获得窗体以前的状态
			int newState = e.getNewState();// 获得窗体现在的状态
			String from = "";// 标识窗体以前状态的中文字符串
			String to = "";// 标识窗体现在状态的中文字符串
			switch (oldState) {// 判断窗台以前的状态
				case Frame.NORMAL:// 窗体处于正常化
					from = "正常化";
					break;
				case Frame.MAXIMIZED_BOTH:// 窗体处于最大化
					from = "最大化";
					break;
				default:// 窗体处于最小化
					from = "最小化";
			}
			switch (newState) {// 判断窗台现在的状态
				case Frame.NORMAL:// 窗体处于正常化
					to = "正常化";
					break;
				case Frame.MAXIMIZED_BOTH:// 窗体处于最大化
					to = "最大化";
					break;
				default:// 窗体处于最小化
					to = "最小化";
			}
			System.out.println(from + "——>" + to);
		}
	}
}
