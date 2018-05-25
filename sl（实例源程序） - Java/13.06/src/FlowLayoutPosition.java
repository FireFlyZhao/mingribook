import java.awt.*;

import javax.swing.*;

public class FlowLayoutPosition extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlowLayoutPosition() {
		setTitle("������ʹ�������ֹ�����"); // ���ô������
		Container c = getContentPane();
		// ���ô���ʹ�������ֹ�������ʹ����Ҷ��룬�����������֮���ˮƽ����봹ֱ���
		setLayout(new FlowLayout(2, 10, 10));
		for (int i = 0; i < 10; i++) { // ��������ѭ�����10����ť
			c.add(new JButton("button" + i));
		}
		setSize(300, 200); // ���ô����С
		setVisible(true); // ���ô���ɼ�
		// ���ô���رշ�ʽ
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new FlowLayoutPosition();
	}
}
