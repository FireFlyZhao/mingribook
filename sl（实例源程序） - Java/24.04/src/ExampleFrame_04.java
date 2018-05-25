import static javax.swing.SpringLayout.*;

import java.awt.*;

import javax.swing.*;

public class ExampleFrame_04 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_04 frame = new ExampleFrame_04();
		frame.setVisible(true);
	}
	
	public ExampleFrame_04() {
		super();
		setBounds(100, 100, 500, 375);
		setTitle("ʹ�õ��ɲ��ֹ�����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �������ɲ��ֹ���������
		SpringLayout springLayout = new SpringLayout();
		Container contentPane = getContentPane();// ��ô�����������
		// �����������޸�Ϊ���õ��ɲ��ֹ�����
		contentPane.setLayout(springLayout);
		JLabel topicLabel = new JLabel("���⣺");
		contentPane.add(topicLabel);
		// �����ǩ���ࡪ��>��������
		springLayout
				.putConstraint(NORTH, topicLabel, 5, NORTH, contentPane);
		// �����ǩ���ࡪ��>��������
		springLayout.putConstraint(WEST, topicLabel, 5, WEST, contentPane);
		JTextField topicTextField = new JTextField();
		contentPane.add(topicTextField);
		// �����ı��򱱲ࡪ��>��������
		springLayout.putConstraint(NORTH, topicTextField, 5, NORTH,
				contentPane);
		// �����ı������ࡪ��>�����ǩ����
		springLayout.putConstraint(WEST, topicTextField, 5, EAST,
				topicLabel);
		// �����ı��򶫲ࡪ��>��������
		springLayout.putConstraint(EAST, topicTextField, -5, EAST,
				contentPane);
		JLabel contentLabel = new JLabel("���ݣ�");
		contentPane.add(contentLabel);
		springLayout.putConstraint(NORTH, contentLabel, 5, SOUTH,
				topicTextField);// ���ݱ�ǩ���ࡪ��>�����ı����ϲ�
		// ���ݱ�ǩ���ࡪ��>��������
		springLayout
				.putConstraint(WEST, contentLabel, 5, WEST, contentPane);
		JScrollPane contentScrollPane = new JScrollPane();
		contentScrollPane.setViewportView(new JTextArea());
		contentPane.add(contentScrollPane);
		springLayout.putConstraint(NORTH, contentScrollPane, 5, SOUTH,
				topicTextField);// ������山�ࡪ��>�����ı����ϲ�
		springLayout.putConstraint(WEST, contentScrollPane, 5, EAST,
				contentLabel);// ����������ࡪ��>���ݱ�ǩ����
		springLayout.putConstraint(EAST, contentScrollPane, -5, EAST,
				contentPane);// ������嶫�ࡪ��>��������
		JButton resetButton = new JButton("���");
		contentPane.add(resetButton);
		// ����ա���ť�ϲࡪ��>�����ϲ�
		springLayout.putConstraint(SOUTH, resetButton, -5, SOUTH,
				contentPane);
		JButton submitButton = new JButton("ȷ��");
		contentPane.add(submitButton);
		// ��ȷ������ť�ϲࡪ��>�����ϲ�
		springLayout.putConstraint(SOUTH, submitButton, -5, SOUTH,
				contentPane);
		// ��ȷ������ť���ࡪ��>��������
		springLayout.putConstraint(EAST, submitButton, -5, EAST,
				contentPane);
		springLayout.putConstraint(SOUTH, contentScrollPane, -5, NORTH,
				submitButton);// ��������ϲࡪ��>��ȷ������ť����
		// ����ա���ť���ࡪ��>��ȷ������ť����
		springLayout.putConstraint(EAST, resetButton, -5, WEST,
				submitButton);
	}
}