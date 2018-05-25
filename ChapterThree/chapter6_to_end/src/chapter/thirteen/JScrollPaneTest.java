package chapter.thirteen;

import java.awt.Container;

import java.awt.*;

import javax.swing.*;

public class JScrollPaneTest extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JScrollPaneTest();
	}
	
	public JScrollPaneTest() {
		Container c = getContentPane();
		JTextArea ta = new JTextArea(20, 50);
		JScrollPane sp = new JScrollPane(ta);
		c.add(sp);
		setTitle("带滚动条的文字编译器");
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
