package com.lzw;

public class Usecase3 extends Thread {
	int index=0;
	String[] str={"Hello","Java","world","study","��ҪѧϰJava����","Java��̴ʵ��ܰ���ѧϰ�������Լ������з�"};
	public void run() {
		while (true) {
			System.out.println(str[index++%6]);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Usecase3().start();
	}
}
