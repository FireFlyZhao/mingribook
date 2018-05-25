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
		// Ϊ������ӽ����¼�������
		addWindowFocusListener(new MyWindowFocusListener());
		setTitle("�����役���¼�");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private class MyWindowFocusListener implements WindowFocusListener {
		public void windowGainedFocus(WindowEvent e) {// ���ڻ�ý���ʱ������
			System.out.println("���ڻ���˽��㣡");
		}
		public void windowLostFocus(WindowEvent e) {// ����ʧȥ����ʱ������
			System.out.println("����ʧȥ�˽��㣡");
		}
	}
}
