package chapter.thirteen;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GridLayoutPosition extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GridLayoutPosition();
	}
	
	public GridLayoutPosition() {
		setTitle("这是一个使用网格布局管理器的窗体");
		Container c = getContentPane();
		setLayout(new GridLayout(7, 3, 5, 5));
		for (int i = 0; i < 20; i++) {
			c.add(new JButton("button" + i));
		}
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
