package chapter.thirteen;

import java.awt.*;

import javax.swing.*;

public class JTextAreaTest extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JTextAreaTest();
	}
	
	public JTextAreaTest() {
		setSize(200,100);
		setTitle("�����Զ����е��ı���");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Container cp=getContentPane();
		JTextArea jt = new JTextArea("text",6,6);
		jt.setLineWrap(true);
		cp.add(jt);
		setVisible(true);
	}
}
