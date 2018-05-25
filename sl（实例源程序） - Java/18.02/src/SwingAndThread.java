import java.awt.*;
import java.net.*;

import javax.swing.*;

public class SwingAndThread extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jl = new JLabel(); // ����JLabel����
	private static Thread t; // �����̶߳���
	private int count = 0; // ������������
	private Container container = getContentPane(); // ��������
	
	public SwingAndThread() {
		setBounds(300, 200, 250, 100); // ���Զ�λ�����С��λ��
		container.setLayout(null); // ʹ���岻ʹ���κβ��ֹ�����
		URL url = SwingAndThread.class.getResource("/1.gif"); // ��ȡͼƬ��URL
		Icon icon = new ImageIcon(url); // ʵ����һ��Icon
		jl.setIcon(icon); // ��ͼ������ڱ�ǩ��
		 // ����ͼƬ�ڱ�ǩ������
		jl.setHorizontalAlignment(SwingConstants.LEFT);
		jl.setBounds(10, 10, 200, 50); // ���ñ�ǩ��λ�����С
		jl.setOpaque(true);
		t = new Thread(new Runnable() { // ���������ڲ��࣬����ʵ��Runnable�ӿ�
					public void run() { // ��дrun()����
						while (count <= 200) { // ����ѭ������
							 // ����ǩ�ĺ������ñ�����ʾ
							jl.setBounds(count, 10, 200, 50);
							try {
								Thread.sleep(1000); // ʹ�߳�����1000����
							} catch (Exception e) {
								e.printStackTrace();
							}
							count += 4; // ʹ������ÿ������4
							if (count == 200) {
								// ��ͼ�굽���ǩ�����ұߣ�ʹ��ص���ǩ�����
								count = 10;
							}
						}
					}
				});
		t.start(); // �����߳�
		container.add(jl); // ����ǩ��ӵ�������
		setVisible(true); // ʹ�������
		// ���ô���Ĺرշ�ʽ
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new SwingAndThread(); // ʵ����һ��SwingAndThread����
	}
}
