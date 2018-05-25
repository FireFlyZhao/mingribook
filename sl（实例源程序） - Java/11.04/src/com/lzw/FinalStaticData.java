package com.lzw;

import static java.lang.System.*;

import java.util.*;

public class FinalStaticData {
	private static Random rand = new Random(); // ʵ����һ��Random�����
	// �������0~10֮�����������趨��Ϊfinal��a1
	private final int a1 = rand.nextInt(10);
	// �������0~10֮�����������趨��Ϊstatic final��a2
	private static final int a2 = rand.nextInt(10);
	
	public static void main(String[] args) {
		FinalStaticData fdata = new FinalStaticData(); // ʵ����һ������
		// ���ö���Ϊfinal��a1
		out.println("����ʵ�����������a1��ֵ��" + fdata.a1);
		// ���ö���Ϊstatic final��a2
		out.println("����ʵ�����������a1��ֵ��" + fdata.a2);
		// ʵ��������һ������
		FinalStaticData fdata2 = new FinalStaticData();
		out.println("����ʵ�����������a1��ֵ��" + fdata2.a1);
		out.println("����ʵ�����������a2��ֵ��" + fdata2.a2);
	}
}
