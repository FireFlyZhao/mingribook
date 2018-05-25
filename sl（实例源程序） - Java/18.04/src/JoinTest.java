import java.awt.*;

import javax.swing.*;

public class JoinTest extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Thread threadA; // ���������߳�
	private Thread threadB;
	final JProgressBar progressBar = new JProgressBar(); // �����������������
	final JProgressBar progressBar2 = new JProgressBar();
	int count = 0;
	
	public static void main(String[] args) {
		init(new JoinTest(), 100, 100);
	}
	
	public JoinTest() {
		super();
		// �������������ڴ������
		getContentPane().add(progressBar, BorderLayout.NORTH);
		// �������������ڴ���������
		getContentPane().add(progressBar2, BorderLayout.SOUTH);
		progressBar.setStringPainted(true); // ���ý�������ʾ�����ַ�
		progressBar2.setStringPainted(true);
		// ʹ�������ڲ�����ʽ��ʼ��Threadʵ����
		threadA = new Thread(new Runnable() {
			int count = 0;
			
			public void run() { // ��дrun()����
				while (true) {
					progressBar.setValue(++count); // ���ý������ĵ�ǰֵ
					try {
						Thread.sleep(100); // ʹ�߳�A����100����
						threadB.join(); // ʹ�߳�B����join()����
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		threadA.start(); // �����߳�A
		threadB = new Thread(new Runnable() {
			int count = 0;
			
			public void run() {
				while (true) {
					progressBar2.setValue(++count); // ���ý������ĵ�ǰֵ
					try {
						Thread.sleep(100); // ʹ�߳�B����100����
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (count == 100) // ��count��������Ϊ100ʱ
						break; // ����ѭ��
				}
			}
		});
		threadB.start(); // �����߳�B
	}
	
	// ���ô���������Է���
	public static void init(JFrame frame, int width, int height) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
}
