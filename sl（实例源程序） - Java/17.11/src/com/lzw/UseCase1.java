package com.lzw;

public class UseCase1 {
	enum Constants2 { // ������������ö��������
		Constants_A, Constants_B
	}
	 // ����һ������������Ĳ���Ϊö�����Ͷ���
	public static void doit2(Constants2 c) {
		switch (c) { // ����ö�����Ͷ�������ͬ����
			case Constants_A:
				System.out.println("doit2() Constants_A");
				break;
			case Constants_B:
				System.out.println("doit2() Constants_B");
				break;
		}
	}
	
	public static void main(String[] args) {
		UseCase1.doit2(Constants2.Constants_A);
		UseCase1.doit2(Constants2.Constants_B);
	}
}
