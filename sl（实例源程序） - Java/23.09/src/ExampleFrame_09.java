import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class ExampleFrame_09 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	
	public static void main(String args[]) {
		ExampleFrame_09 frame = new ExampleFrame_09();
		frame.setVisible(true);
	}
	
	public ExampleFrame_09() {
		super();
		setTitle("�ļ�ѡ��Ի���");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		final JLabel label = new JLabel();
		label.setText("�ļ���");
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(20);
		panel.add(textField);
		
		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();// �����ļ�ѡ��Ի���
				// ��ʾ�ļ�ѡ��Ի���
				int i = fileChooser.showOpenDialog(getContentPane());
				// �ж��û��������Ƿ�Ϊ���򿪡���ť
				if (i == JFileChooser.APPROVE_OPTION) {
					// ���ѡ�е��ļ�����
					File selectedFile = fileChooser.getSelectedFile();
					// ��ʾѡ���ļ�������
					textField.setText(selectedFile.getName());
				}
			}
		});
		button.setText("�ϴ�");
		panel.add(button);
		//
	}
}
