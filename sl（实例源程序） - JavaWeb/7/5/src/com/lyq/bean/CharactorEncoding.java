package com.lyq.bean;

import java.io.UnsupportedEncodingException;

public class CharactorEncoding {
	/**
	 * ���췽��
	 */
	public CharactorEncoding(){
	}
	/**
	 * ���ַ�����ת�봦��
	 * @param str Ҫת����ַ���
	 * @return �������ַ���
	 */
	public String toString(String str){
		// ת���ַ�
		String text = "";
		// �ж�Ҫת����ַ����Ƿ���Ч
		if(str != null && !"".equals(str)){
			try {
				// ���ַ������б��봦��
				text = new String(str.getBytes("iso8859-1"),"GB18030");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		// ���غ���ַ���
		return text;
	}
}
