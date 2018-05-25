import static javax.swing.SpringLayout.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.SpringLayout.Constraints;

public class ExampleFrame_06 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_06 frame = new ExampleFrame_06();
		frame.setVisible(true);
	}
	
	public ExampleFrame_06() {
		super();
		setTitle("���õ��ɿ��������С");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		Spring vST = Spring.constant(20);// ����һ��֧��
		Spring hSP = Spring.constant(20, 100, 500);// ����һ������
		JButton lButton = new JButton("��ťL");
		getContentPane().add(lButton);
		springLayout.putConstraint(NORTH, lButton, vST, NORTH,
				getContentPane());// ����ťL�����ࡪ��>��������
		springLayout.putConstraint(WEST, lButton, hSP, WEST,
				getContentPane());// ����ťL�����ࡪ��>��������
		JButton rButton = new JButton("��ťR");
		getContentPane().add(rButton);
		// ����ťR�����ࡪ��>����ťR������
		springLayout.putConstraint(NORTH, rButton, 0, NORTH, lButton);
		// ����ťR�����ࡪ��>����ťL������
		springLayout.putConstraint(WEST, rButton, Spring.scale(hSP, 2),
				EAST, lButton);
		springLayout.putConstraint(EAST, getContentPane(), hSP, EAST,
				rButton);// �������ࡪ��>����ťR������
		Spring widthSP = Spring.constant(60, 300, 600);// ����һ������
		Spring heightST = Spring.constant(60);// ����һ��֧��
		// ��á���ťL����Constraints����
		Constraints lButtonCons = springLayout.getConstraints(lButton);
		lButtonCons.setWidth(widthSP);// ���ÿ��������ȵĵ���
		lButtonCons.setHeight(heightST);// ���ÿ�������߶ȵ�֧��
		// ��á���ťR����Constraints����
		Constraints rButtonCons = springLayout.getConstraints(rButton);
		rButtonCons.setWidth(widthSP);// ���ÿ��������ȵĵ���
		rButtonCons.setHeight(heightST);// ���ÿ�������߶ȵ�֧��
	}
}
