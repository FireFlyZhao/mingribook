package chapter.thirteen;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class JTextFieldTest extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JTextFieldTest();
	}
	
	public JTextFieldTest() {
		setSize(250,100);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Container cp=getContentPane();
		getContentPane().setLayout(new FlowLayout());
		final JTextField jt = new JTextField("aaa",20);
		final JButton jb = new JButton("清除");
		cp.add(jt);
		cp.add(jb);
		jt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jt.setText("触发事件");
				
			}
		});
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jt.setText("");
				jt.requestFocus();
			}
		});
		setVisible(true);
	}
}
