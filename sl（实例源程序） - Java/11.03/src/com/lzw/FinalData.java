package com.lzw;

import static java.lang.System.*;

import java.util.*;
class Test {
	int i = 0;
}

public class FinalData {
	static Random rand = new Random();
	private final int VALUE_1 = 9; // ����һ��final����
	private static final int VALUE_2 = 10; // ����һ��final��static����
	private final Test test = new Test(); // ����һ��final����
	private Test test2 = new Test(); // ����һ������final������
	private final int[] a = { 1, 2, 3, 4, 5, 6 }; // ����һ������Ϊfinal������
	private final int i4 = rand.nextInt(20);
	private static final int i5 = rand.nextInt(20);
	
	public String toString() {
		return i4 + " " + i5 + " ";
	}
	
	public static void main(String[] args) {
		FinalData data = new FinalData();
		// data.test=new Test();
		//���Զ�ָ��Ϊfinal�������еĳ�Ա������ֵ
		//�����ܽ�����Ϊfinal������ָ����������
		// data.value2++;
		//���ܸı䶨��Ϊfinal�ĳ���ֵ
		data.test2 = new Test(); // ���Խ�û�ж���Ϊfinal������ָ����������
		for (int i = 0; i < data.a.length; i++) {
			// a[i]=9;
			// //���ܶԶ���Ϊfinal�����鸳ֵ
		}
		out.println(data);
		out.println("data2");
		out.println(new FinalData());
		// out.println(data);
	}
}
