import java.awt.*;
import java.net.*;

import javax.swing.*;

public class ExampleFrame_03 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_03 frame = new ExampleFrame_03();
		frame.setVisible(true);
	}
	
	public ExampleFrame_03() {
		super();
		setTitle("Ϊ���������ӱ���ͼƬ");
		setBounds(100, 100, 570, 430);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ����һ������������
		final JDesktopPane desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		final JLabel backLabel = new JLabel(); // ����һ����ǩ�������
		// ��ñ���ͼƬ��·��
		URL resource = this.getClass().getResource("/back.JPG");
		ImageIcon icon = new ImageIcon(resource); // ��������ͼƬ����
		backLabel.setIcon(icon); // ���ǩ�����ʾ����ͼƬ
		// �����������ʾλ�ü���С
		backLabel.setBounds(0, 0, icon.getIconWidth(), icon
				.getIconHeight());
		// ����ǩ�����ӵ�ָ������λ��
		desktopPane.add(backLabel, new Integer(Integer.MIN_VALUE));
	}
}
