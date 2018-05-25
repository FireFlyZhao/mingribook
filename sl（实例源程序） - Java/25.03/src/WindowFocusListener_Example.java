import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class WindowFocusListener_Example extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String args[]) {
		WindowFocusListener_Example frame = new WindowFocusListener_Example();
		frame.setVisible(true);
	}
	public WindowFocusListener_Example() {
		super();
		// 为窗体添加焦点事件监听器
		addWindowFocusListener(new MyWindowFocusListener());
		setTitle("捕获窗体焦点事件");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private class MyWindowFocusListener implements WindowFocusListener {
		public void windowGainedFocus(WindowEvent e) {// 窗口获得焦点时被触发
			System.out.println("窗口获得了焦点！");
		}
		public void windowLostFocus(WindowEvent e) {// 窗口失去焦点时被触发
			System.out.println("窗口失去了焦点！");
		}
	}
}
