package com.lyq.bean;
/**
 * �û�JavaBean
 * @author Li YongQiang
 */
public class User {
	// �û���
	private String name;
	// ����
	private String password;
	// qq���� 
	private String qq;
	// E-Mail��ַ
	private String mail;
	// �Ա�
	private String sex;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
