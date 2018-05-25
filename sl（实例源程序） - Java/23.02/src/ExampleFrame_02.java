import java.awt.*;
import java.net.*;

import javax.swing.*;
import javax.swing.event.*;

public class ExampleFrame_02 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_02 frame = new ExampleFrame_02();
		frame.setVisible(true);
	}
	
	public ExampleFrame_02() {
		super();
		getContentPane().setFocusCycleRoot(true);
		setTitle("ѡ����");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JTabbedPane tabbedPane = new JTabbedPane();
		// ����ѡ���ǩ�Ĳ��ַ�ʽ
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				// ��ñ�ѡ��ѡ�������
				int selectedIndex = tabbedPane.getSelectedIndex();
				// ���ָ��������ѡ���ǩ
				String title = tabbedPane.getTitleAt(selectedIndex);
				System.out.println(title);
			}
		});
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		URL resource = ExampleFrame_02.class.getResource("/tab.JPG");
		ImageIcon imageIcon = new ImageIcon(resource);
		final JLabel tabLabelA = new JLabel();
		tabLabelA.setText("ѡ�A");
		// ����ǩ�����ӵ�ѡ���
		tabbedPane.addTab("ѡ�A", imageIcon, tabLabelA, "����鿴ѡ�A");
		final JLabel tabLabelB = new JLabel();
		tabLabelB.setText("ѡ�B");
		tabbedPane.addTab("ѡ�B", imageIcon, tabLabelB, "����鿴ѡ�B");
		final JLabel tabLabelC = new JLabel();
		tabLabelC.setText("ѡ�C");
		tabbedPane.addTab("ѡ�C", imageIcon, tabLabelC, "����鿴ѡ�C");
		tabbedPane.setSelectedIndex(2); // ��������Ϊ2��ѡ���ѡ��
		tabbedPane.setEnabledAt(0, false); // ��������Ϊ0��ѡ�������
	}
}
