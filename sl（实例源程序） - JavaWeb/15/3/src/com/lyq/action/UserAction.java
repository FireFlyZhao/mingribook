package com.lyq.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	// �û���
	private String name;
	// ����
	private String password;
	// ����
	private String description;
	// �Ա�
	private int sex = 0;
	// ʡ��
	private String province;
	// ����
	private String[] hobby;

	// �û�ע��
	public String execute() throws Exception {
		return SUCCESS;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
}
