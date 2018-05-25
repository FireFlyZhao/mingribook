package com.lzw.dao.model;

public class TbJsr {// 经手人信息

	private String name;// 经手人姓名
	private String sex;// 经手人性别
	private String age;// 经手人年龄
	private String tel;// 经手人电话
	
	// 使用Getters and Setters方法将经手人信息类的私有属性封装起来
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