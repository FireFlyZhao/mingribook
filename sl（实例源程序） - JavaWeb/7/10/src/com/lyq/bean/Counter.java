package com.lyq.bean;
/**
 * ������
 * @author Li YongQiang
 */
public class Counter {
	// ����
	private static int count = 0;
	// ��ȡ������ֵ
	public int getCount(){
		return ++count;
	}
}
