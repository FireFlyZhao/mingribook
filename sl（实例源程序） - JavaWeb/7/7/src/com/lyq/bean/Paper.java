package com.lyq.bean;

import java.io.Serializable;
/**
 * �����ʾ�
 * @author Li YongQiang
 */
public class Paper implements Serializable {
	private static final long serialVersionUID = 1L;
	// �������
	private String[] languages;
	// ���ռ���
	private String[] technics;
	// ����
	private String[] parts;
	
	public Paper(){
	}
	public String[] getLanguages() {
		return languages;
	}
	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
	public String[] getTechnics() {
		return technics;
	}
	public void setTechnics(String[] technics) {
		this.technics = technics;
	}
	public String[] getParts() {
		return parts;
	}
	public void setParts(String[] parts) {
		this.parts = parts;
	}
}
