package chapter.eighteen;

import java.awt.*;

import javax.swing.*;

public class UseCase1 extends JFrame {
	private static final long serialVersionUID = 1L;
	final JProgressBar progressBar = new JProgressBar();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init(new UseCase1(), 100, 100);
	}
	
	public UseCase1() {
		getContentPane().add(progressBar, BorderLayout.NORTH);
		progressBar.setStringPainted(true);
		
		Thread threadA = new Thread(new Runnable() {
			int count = 0;
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					progressBar.setValue(++count);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		threadA.start();
	}
	
	public static void init(JFrame frame, int width, int height) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
}
