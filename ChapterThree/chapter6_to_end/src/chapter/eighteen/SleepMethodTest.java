package chapter.eighteen;

import java.awt.*;
import java.util.*;

import javax.swing.*;

public class SleepMethodTest extends JFrame {
	private static final long serialVersionUID = 1L;
	private Thread t;
	private static Color[] color = { Color.BLACK, Color.BLUE, Color.CYAN,
			Color.GREEN, Color.ORANGE, Color.YELLOW, Color.RED,
			Color.PINK, Color.LIGHT_GRAY };
	private static final Random rand = new Random();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init(new SleepMethodTest(), 100, 100);
	}
	
	public static Color getC() {
		return color[rand.nextInt(color.length)];
	}
	
	public SleepMethodTest() {
		t = new Thread(new Runnable() {
			int x = 30;
			int y = 50;
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Graphics graphics = getGraphics();
					graphics.setColor(getC());
					graphics.drawLine(x, y, 100, y++);
					if (y >= 80) {
						y = 50;
					}
				}
			}
		});
		t.start();
	}
	
	public static void init(JFrame frame, int width, int height) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
}
