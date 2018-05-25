import static javax.swing.SpringLayout.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class ExampleFrame_05 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_05 frame = new ExampleFrame_05();
		frame.setVisible(true);
	}
	
	public ExampleFrame_05() {
		super();
		setTitle("ʹ�õ��ɺ�֧��");
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
		springLayout.putConstraint(WEST, rButton, Spring.scale(hSP, 2),
				EAST, lButton);// ����ťR�����ࡪ��>����ťL������
		// �������ࡪ��>����ťR������
		springLayout.putConstraint(EAST, getContentPane(), hSP, EAST,
				rButton);
	}
	
}
