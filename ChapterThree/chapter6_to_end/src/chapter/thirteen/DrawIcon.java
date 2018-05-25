package chapter.thirteen;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class DrawIcon implements Icon {
	private int width;
	private int height;
	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		g.fillOval(x, y, width, height);
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrawIcon icon = new DrawIcon(15, 15);
		JLabel j = new JLabel("≤‚ ‘", icon, SwingConstants.CENTER);
		JFrame jf = new JFrame();
		Container c = jf.getContentPane();
		c.add(j);
		jf.setSize(100, 100);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	public DrawIcon(int width, int height) {
		this.width = width;
		this.height = height;
	}
}
