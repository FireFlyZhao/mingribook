package chapter.thirteen;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class UseCase2 extends JFrame{
	private static final long serialVersionUID = 1L;
	private String[] contents = {"�б�1","�б�2","�б�3","�б�4","�б�5"};
	private JComboBox<String> jc = new JComboBox<>();
	private JButton jb = new JButton("�ύ");
	int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UseCase2();
	}
	
	public UseCase2() {
		setSize(200, 100);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Container cp=getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(jc);
		cp.add(jb);
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(count < contents.length) {
					jc.addItem(contents[count++]);
				}
			}
		});
	}
}
