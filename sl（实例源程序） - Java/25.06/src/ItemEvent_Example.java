import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ItemEvent_Example extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ItemEvent_Example frame = new ItemEvent_Example();
		frame.setVisible(true);
	}

	public ItemEvent_Example() {
		super();
		getContentPane().setLayout(new FlowLayout());
		setTitle("ѡ���¼�ʾ��");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComboBox<String> comboBox = new JComboBox<>();// ����һ�������˵�
		for (int i = 1; i < 6; i++) {// ͨ��ѭ�����ѡ��
			comboBox.addItem("ѡ��" + i);
		}
		comboBox.addItemListener(new ItemListener() {// ���ѡ���¼�������
			public void itemStateChanged(ItemEvent e) {
				int stateChange = e.getStateChange();// ����¼�����
				String item = e.getItem().toString();// ��ô����˴��¼���ѡ��
				if (stateChange == ItemEvent.SELECTED) {// �鿴�Ƿ���ѡ��ѡ���
					System.out.println("�˴��¼���      ѡ��  ѡ�" + item + "��������");
					// �鿴�Ƿ���ȡ��ѡ��ѡ���
				} else if (stateChange == ItemEvent.DESELECTED) {
					System.out.println("�˴��¼���  ȡ��ѡ��  ѡ�" + item + "��������");
				} else {// ������ԭ�򴥷�
					System.out.println("�˴��¼�������ԭ�򴥷���");
				}
			}
		});
		getContentPane().add(comboBox);
	}

}
