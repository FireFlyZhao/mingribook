import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseEvent_Example extends JFrame { // �̳д�����JFrame
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		MouseEvent_Example frame = new MouseEvent_Example();
		frame.setVisible(true); // ���ô���ɼ���Ĭ��Ϊ���ɼ�
	}
	
	public MouseEvent_Example() {
		super(); // �̳и���Ĺ��췽��
		setTitle("����¼�ʾ��"); // ���ô���ı���
		setBounds(100, 100, 500, 375); // ���ô������ʾλ�ü���С
		// ���ô���رհ�ť�Ķ���Ϊ�˳�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JLabel label = new JLabel();
		label.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {// ����������ʱ������
				System.out.println("����������");
			}
			
			public void mousePressed(MouseEvent e) {// ��갴��������ʱ������
				System.out.print("��갴�������£�");
				int i = e.getButton(); // ͨ����ֵ�����жϰ��µ����ĸ���
				if (i == MouseEvent.BUTTON1)
					System.out.println("���µ���������");
				if (i == MouseEvent.BUTTON2)
					System.out.println("���µ���������");
				if (i == MouseEvent.BUTTON3)
					System.out.println("���µ�������Ҽ�");
			}
			
			public void mouseReleased(MouseEvent e) {// ��갴�����ͷ�ʱ������
				System.out.print("��갴�����ͷţ�");
				int i = e.getButton(); // ͨ����ֵ�����ж��ͷŵ����ĸ���
				if (i == MouseEvent.BUTTON1)
					System.out.println("�ͷŵ���������");
				if (i == MouseEvent.BUTTON2)
					System.out.println("�ͷŵ���������");
				if (i == MouseEvent.BUTTON3)
					System.out.println("�ͷŵ�������Ҽ�");
			}
			
			public void mouseClicked(MouseEvent e) {// ���������¼�ʱ������
				System.out.print("��������갴����");
				int i = e.getButton(); // ͨ����ֵ�����жϵ��������ĸ���
				if (i == MouseEvent.BUTTON1)
					System.out.print("����������������");
				if (i == MouseEvent.BUTTON2)
					System.out.print("�������������֣�");
				if (i == MouseEvent.BUTTON3)
					System.out.print("������������Ҽ���");
				int clickCount = e.getClickCount();
				System.out.println("��������Ϊ" + clickCount + "��");
			}
			
			public void mouseExited(MouseEvent e) {// ����Ƴ����ʱ������
				System.out.println("����Ƴ����");
			}
		});
		getContentPane().add(label, BorderLayout.CENTER);
		//
	}
	
}
