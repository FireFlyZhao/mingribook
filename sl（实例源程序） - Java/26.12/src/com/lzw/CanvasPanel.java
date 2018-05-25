package com.lzw;
import java.awt.*;
import javax.swing.*;
public class CanvasPanel extends JPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image back;
	private Image cloud;
	int time;
	private Thread thread;
	private boolean play = true;
	int width = 458;
	int height = 357;
	int x = width;
	public CanvasPanel() {
		super();
		back = new ImageIcon(getClass().getResource("back.jpg")).getImage();
		cloud = new ImageIcon(getClass().getResource("cloud.png")).getImage();
		time = 100;
		play = true;
		if (thread == null || !thread.isAlive())
			thread = new Thread(this);
		thread.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(back, 0, 0, width, height, this);
		g.drawImage(cloud, x, 10, this);

		x -= 2;
		if (x <= -cloud.getWidth(this))
			x = width;

	}
	public void run() {
		while (play) {
			try {
				Thread.sleep(time);
			} catch (Exception e) {
				e.printStackTrace();
			}
			repaint();
		}
	}
}
