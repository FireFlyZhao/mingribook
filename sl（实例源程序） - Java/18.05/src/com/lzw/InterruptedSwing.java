package com.lzw;

import java.awt.*;

import javax.swing.*;

public class InterruptedSwing extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Thread thread;
	
	public static void main(String[] args) {
		init(new InterruptedSwing(), 100, 100);
	}
	
	public InterruptedSwing() {
		super();
		final JProgressBar progressBar = new JProgressBar(); // 创建进度条
		// 将进度条放置在窗体合适位置
		getContentPane().add(progressBar, BorderLayout.NORTH);
		progressBar.setStringPainted(true); // 设置进度条上显示数字
		thread = new Thread(new Runnable() {
			int count = 0;
			
			public void run() {
				while (true) {
					progressBar.setValue(++count); // 设置进度条的当前值
					try {
						Thread.sleep(1000); // 使线程休眠1000豪秒
						// 捕捉InterruptedException异常
					} catch (InterruptedException e) {
						System.out.println("当前线程序被中断");
						break;
					}
				}
			}
		});
		thread.start(); // 启动线程
		thread.interrupt(); // 中断线程
	}
	
	public static void init(JFrame frame, int width, int height) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
	
}
