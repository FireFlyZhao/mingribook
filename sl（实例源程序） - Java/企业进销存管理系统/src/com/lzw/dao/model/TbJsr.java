package com.lzw.dao.model;

public class TbJsr {// ��������Ϣ

	private String name;// ����������
	private String sex;// �������Ա�
	private String age;// ����������
	private String tel;// �����˵绰
	
	// ʹ��Getters and Setters��������������Ϣ���˽�����Է�װ����
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String username) {
		this.sex = username;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String pass) {
		this.age = pass;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String quan) {
		this.tel = quan;
	}

}