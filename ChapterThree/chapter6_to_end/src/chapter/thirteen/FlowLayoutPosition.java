package chapter.thirteen;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class FlowLayoutPosition extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FlowLayoutPosition();
	}
	
	public FlowLayoutPosition() {
		setTitle("本窗体使用流布局管理器");
		Container c = getContentPane();
		setLayout(new FlowLayout(2, 10, 10));
		for (int i = 0; i < 10; i++) {
			c.add(new JButton("button"+i));
		}
		setSize(300, 200);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
