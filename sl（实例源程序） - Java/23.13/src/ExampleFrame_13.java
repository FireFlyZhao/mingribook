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
		setTitle("ʹ�����漯�ɿؼ�");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		final JButton dickButton = new JButton();
		dickButton.setText("�򿪱�̴ʵ���");
		dickButton.addActionListener(new ButtonListener(1));
		panel.add(dickButton);
		
		final JButton noteButton = new JButton();
		noteButton.setText("�򿪼��±�");
		noteButton.addActionListener(new ButtonListener(2));
		panel.add(noteButton);
		
		final JButton wordButton = new JButton();
		wordButton.setText("��Word");
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
if (Desktop.isDesktopSupported()) { // �ж�ϵͳ�Ƿ��ṩ�˶Ը����֧��
	Desktop desktop = Desktop.getDesktop();// ��ø���Ķ���
	switch (index) {
		case 1:
			// �ж��Ƿ�֧�֡����������
			if (desktop.isSupported(Desktop.Action.BROWSE))
				desktop.browse(new URI(
						"http://www.mrbccd.com"));// �����վ
			break;
		case 2:
			// �ж��Ƿ�֧�֡��༭������
			if (desktop.isSupported(Desktop.Action.EDIT))
				desktop.edit(new File("src/new.txt"));// �༭���±�
			break;
		default:
			// �ж��Ƿ�֧�֡��򿪡�����
			if (desktop.isSupported(Desktop.Action.OPEN))
				desktop.open(new File("src/new.doc"));// ��Word
	}
}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
}
