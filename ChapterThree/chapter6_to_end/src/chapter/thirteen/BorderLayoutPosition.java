package chapter.thirteen;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class BorderLayoutPosition extends JFrame {
	String[] border = {BorderLayout.CENTER, BorderLayout.NORTH,
			BorderLayout.SOUTH, BorderLayout.WEST, BorderLayout.EAST};
	String[] buttonName = {"center button", "north button",
			"south button", "west button", "east button"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BorderLayoutPosition();
	}
	
	public BorderLayoutPosition() {
		setTitle("这个窗体使用边界布局管理器");
		Container c = getContentPane();
		setLayout(new BorderLayout());
		for (int  i = 0; i < border.length; i++) {
			c.add(border[i], new JButton(buttonName[i]));
		}
		setSize(350, 200);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
