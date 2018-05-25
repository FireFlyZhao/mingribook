package com.lzw;

import java.awt.*;

import javax.swing.*;

public class UseCase1 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final JProgressBar progressBar = new JProgressBar();
	
	public UseCase1() {
		
		getContentPane().add(progressBar, BorderLayout.NORTH);
		progressBar.setStringPainted(true);
		
		Thread threadA = new Thread(new Runnable() {
			int count = 0;
			
			public void run() {
				while (true) {
					progressBar.setValue(++count);
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		threadA.start();
	}
	
	public static void main(String[] args) {
		init(new UseCase1(), 100, 100);
		
	}
	
	public static void init(JFrame frame, int width, int height) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
}
