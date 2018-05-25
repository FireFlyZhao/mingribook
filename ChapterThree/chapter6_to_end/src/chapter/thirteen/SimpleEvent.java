package chapter.thirteen;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SimpleEvent extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton jb = new JButton("我是按钮，单击我");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SimpleEvent();
	}
	
	public SimpleEvent() {
		setLayout(null);
		setSize(200,100);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Container cp=getContentPane();
		cp.add(jb);
		jb.setBounds(10, 10, 100, 30);
		jb.addActionListener(new jbAction());
		setVisible(true);
	}
	
	class jbAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			jb.setText("我被单击了");
		}
		
	}
}

