import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;

public class ExampleFrame_10 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_10 frame = new ExampleFrame_10();
		frame.setVisible(true);
	}
	
	public ExampleFrame_10() {
		super();
		setTitle("ѡ����Ƭ�Ի���");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JLabel label = new JLabel("<˫��ѡ����Ƭ>", SwingConstants.CENTER);
		label.addMouseListener(new MouseAdapter() {
			JFileChooser fileChooser;
			{
				// �����ļ�ѡ��Ի���
				fileChooser = new JFileChooser();
				// �����ļ���������ֻ�г�JPG��GIF��ʽ��ͼƬ
				FileFilter filter = new FileNameExtensionFilter(
						"ͼ���ļ���JPG/GIF��", "JPG", "JPEG", "GIF");
				fileChooser.setFileFilter(filter);
			}
			
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					// ��ʾ�ļ�ѡ��Ի���
					int i = fileChooser.showOpenDialog(getContentPane());
					// �ж��û��������Ƿ�Ϊ���򿪡���ť
					if (i == JFileChooser.APPROVE_OPTION) {
						// ���ѡ�е�ͼƬ����
						File selectedFile = fileChooser.getSelectedFile();
						label.setIcon(new ImageIcon(selectedFile
								.getAbsolutePath()));// ��ͼƬ��ʾ����ǩ��
						label.setText(null);
					}
				}
			}
		});
		getContentPane().add(label, BorderLayout.CENTER);
	}
}
