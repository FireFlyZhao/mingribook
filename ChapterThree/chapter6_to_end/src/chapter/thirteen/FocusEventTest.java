package chapter.thirteen;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FocusEventTest extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FocusEventTest();
	}
	
	public FocusEventTest() {
		setSize(250,100);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container cp=getContentPane();
		getContentPane().setLayout(new FlowLayout());
		
		final JLabel label = new JLabel();
		getContentPane().add(label);
		JTextField jt = new JTextField("�뵥�������ı���",10);
		JTextField jt2 = new JTextField("�뵥����",10);
		cp.add(jt);
		cp.add(jt2);
		jt.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "�ı���ʧȥ����");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		setVisible(true);
		
		
	}
}
