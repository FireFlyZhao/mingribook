package com.lzw;

import java.awt.*;

import javax.swing.*;

public class PriorityTest extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Thread threadA;
	private Thread threadB;
	private Thread threadC;
	private Thread threadD;
	
	public PriorityTest() {
		getContentPane().setLayout(new GridLayout(4, 1));
		// �ֱ�ʵ����4���߳�
		final JProgressBar progressBar = new JProgressBar();
		final JProgressBar progressBar2 = new JProgressBar();
		final JProgressBar progressBar3 = new JProgressBar();
		final JProgressBar progressBar4 = new JProgressBar();
		getContentPane().add(progressBar);
		getContentPane().add(progressBar2);
		getContentPane().add(progressBar3);
		getContentPane().add(progressBar4);
		progressBar.setStringPainted(true);
		progressBar2.setStringPainted(true);
		progressBar3.setStringPainted(true);
		progressBar4.setStringPainted(true);
		threadA = new Thread(new MyThread(progressBar));
		threadB = new Thread(new MyThread(progressBar2));
		threadC = new Thread(new MyThread(progressBar3));
		threadD = new Thread(new MyThread(progressBar4));
		setPriority("threadA", 5, threadA);
		setPriority("threadB", 5, threadB);
		setPriority("threadC", 4, threadC);
		setPriority("threadD", 3, threadD);
	}
	
	// ���������̵߳����ơ����ȼ��ķ���
	public static void setPriority(String threadName, int priority,
			Thread t) {
		t.setPriority(priority); // �����̵߳����ȼ�
		t.setName(threadName); // �����̵߳�����
		t.start(); // �����߳�
	}
	
	public static void main(String[] args) {
		init(new PriorityTest(), 100, 100);
	}
	
	public static void init(JFrame frame, int width, int height) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
	
	private final class MyThread implements Runnable { // ����һ��ʵ��Runnable�ӿڵ���
		private final JProgressBar bar;
		int count = 0;
		
		private MyThread(JProgressBar bar) {
			this.bar = bar;
		}
		
		public void run() { // ��дrun()����
			while (true) {
				bar.setValue(count += 10); // ���ù�������ֵÿ������10
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("��ǰ�߳����ж�");
				}
			}
		}
	}
	
}
