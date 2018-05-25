import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class KeyEvent_Example extends JFrame { // �̳д�����JFrame
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		KeyEvent_Example frame = new KeyEvent_Example();
		frame.setVisible(true); // ���ô���ɼ���Ĭ��Ϊ���ɼ�
	}
	
	public KeyEvent_Example() {
		super(); // �̳и���Ĺ��췽��
		setTitle("�����¼�ʾ��"); // ���ô���ı���
		setBounds(100, 100, 500, 375); // ���ô������ʾλ�ü���С
		// ���ô���رհ�ť�Ķ���Ϊ�˳�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JLabel label = new JLabel();
		label.setText("��ע��");
		getContentPane().add(label, BorderLayout.WEST);
		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		JTextArea textArea = new JTextArea();
		textArea.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) { // ����������ʱ������
				// �������keyCode�ı�ǩ
				String keyText = KeyEvent.getKeyText(e.getKeyCode());
				if (e.isActionKey()) { // �жϰ��µ��Ƿ�Ϊ������
					System.out.println("�����µ��Ƕ�������" + keyText + "��");
				} else {
					System.out.print("�����µ��ǷǶ�������" + keyText + "��");
					// �������¼��еļ���������ַ�
					int keyCode = e.getKeyCode();
					switch (keyCode) {
						case KeyEvent.VK_CONTROL: // �жϰ��µ��Ƿ�ΪCtrl��
							System.out.print("��Ctrl��������");
							break;
						case KeyEvent.VK_ALT: // �жϰ��µ��Ƿ�ΪAlt��
							System.out.print("��Alt��������");
							break;
						case KeyEvent.VK_SHIFT: // �жϰ��µ��Ƿ�ΪShift��
							System.out.print("��Shift��������");
							break;
					}
					System.out.println();
				}
			}
			public void keyTyped(KeyEvent e) { // ���������¼�ʱ������
				// ���������ַ�
				System.out.println("�˴�������ǡ�" + e.getKeyChar() + "��");
			}
			public void keyReleased(KeyEvent e) { // �������ͷ�ʱ������
				// �������keyCode�ı�ǩ
				String keyText = KeyEvent.getKeyText(e.getKeyCode());
				System.out.println("���ͷŵ��ǡ�" + keyText + "����");
				System.out.println();
			}
		});
		textArea.setLineWrap(true);
		textArea.setRows(3);
		textArea.setColumns(15);
		scrollPane.setViewportView(textArea);
	}
}
