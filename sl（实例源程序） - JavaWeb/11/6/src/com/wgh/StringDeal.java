package com.wgh;

public class StringDeal {
	public static String shiftEnter(String str) { // ���幫�õľ�̬����
		String newStr = str.replaceAll("\r\n", "<br>"); // �滻�س����з�
		newStr = newStr.replaceAll(" ", "&nbsp;");// �滻�ո��
		return newStr;
	}
}
