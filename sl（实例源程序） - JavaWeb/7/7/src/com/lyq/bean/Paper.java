package com.lyq.bean;

import java.io.Serializable;
/**
 * 调查问卷
 * @author Li YongQiang
 */
public class Paper implements Serializable {
	private static final long serialVersionUID = 1L;
	// 编程语言
	private String[] languages;
	// 掌握技术
	private String[] technics;
	// 部分
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
