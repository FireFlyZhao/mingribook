import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ExampleFrame_01 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_01 frame = new ExampleFrame_01();
		frame.setVisible(true);
	}
	
	public ExampleFrame_01() {
		super();
		setTitle("ʹ����ʽ���ֹ�����");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Box topicBox = Box.createHorizontalBox();// ����һ��ˮƽ������
		getContentPane().add(topicBox, BorderLayout.NORTH);// ��ӵ�������
		topicBox.add(Box.createHorizontalStrut(5));// ���һ��5���ؿ��ˮƽ֧��
		JLabel topicLabel = new JLabel("���⣺");// ���������ǩ
		topicBox.add(topicLabel);// ��ӵ�ˮƽ��������
		topicBox.add(Box.createHorizontalStrut(5));// ���һ��5���ؿ��ˮƽ֧��
		JTextField topicTextField = new JTextField(30);// �����ı���
		topicBox.add(topicTextField);// ��ӵ�ˮƽ��������
		Box box = Box.createVerticalBox();// ����һ����ֱ������
		getContentPane().add(box, BorderLayout.CENTER);// ��ӵ�������
		box.add(Box.createVerticalStrut(5));// ���һ��5���ظߵĴ�ֱ֧��
		Box contentBox = Box.createHorizontalBox();// ����һ��ˮƽ������
		contentBox.setAlignmentX(1);// ���������ˮƽ����ֵ�����Ҳ����
		box.add(contentBox);// ��ӵ���ֱ��������
		contentBox.add(Box.createHorizontalStrut(5));// ���һ��5���ؿ��ˮƽ֧��
		JLabel contentLabel = new JLabel("���ݣ�");// ����һ����ǩ���
		contentLabel.setAlignmentY(0);// ��������Ĵ�ֱ����ֵ�����Ϸ�����
		contentBox.add(contentLabel);// ��ӵ�ˮƽ��������
		contentBox.add(Box.createHorizontalStrut(5));// ���һ��5���ؿ��ˮƽ֧��
		JScrollPane scrollPane = new JScrollPane();// ����һ���������
		scrollPane.setAlignmentY(0);// ��������Ĵ�ֱ����ֵ�����Ϸ�����
		contentBox.add(scrollPane);// ��ӵ�ˮƽ��������
		JTextArea contentTextArea = new JTextArea();// ����һ���ı�����
		contentTextArea.setLineWrap(true);
		scrollPane.setViewportView(contentTextArea);// ��ӵ����������
		box.add(Box.createVerticalStrut(5));// ���һ��5���ظߵĴ�ֱ֧��
		JButton submitButton = new JButton("ȷ��");// ����һ����ť
		submitButton.setAlignmentX(1);// ���������ˮƽ����ֵ�����Ҳ����
		box.add(submitButton);// ��ӵ���ֱ��������
		//
	}
	
}
