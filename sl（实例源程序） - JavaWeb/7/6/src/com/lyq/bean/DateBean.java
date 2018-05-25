package com.lyq.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * ��ȡ��ǰʱ���JavaBean
 * @author Li YongQiang
 * 
 */
public class DateBean {
	// ���ڼ�ʱ��
	private String dateTime;
	// ����
	private String week;
	// Calendar����
	private Calendar calendar = Calendar.getInstance();
	/**
	 * ��ȡ��ǰ���ڼ�ʱ��
	 * @return ���ڼ�ʱ����ַ���
	 */
	public String getDateTime() {
		// ��ȡ��ǰʱ��
		Date currDate = Calendar.getInstance().getTime();
		// ʵ����SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�ա�HH��mm��ss��");
		// ��ʽ������ʱ��
		dateTime = sdf.format(currDate);
		// �������ڼ�ʱ����ַ���
		return dateTime;
	}
	/**
	 * ��ȡ���ڼ�
	 * @return ���������ַ���
	 */
	public String getWeek() {
		// ��������
		String[] weeks = { "������", "����һ", "���ڶ�", "������", "������", "������", "������" };
		// ��ȡһ���ڵ�ĳ��
		int index = calendar.get(Calendar.DAY_OF_WEEK);
		// ��ȡ���ڼ�
		week = weeks[index - 1];
		// ���������ַ���
		return week;
	}
}
