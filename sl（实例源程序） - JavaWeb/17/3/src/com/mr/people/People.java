package com.mr.people;

import com.mr.idcard.IDcard;

public class People {

	private Integer id;//唯一性标识
	
	private String name;//公民姓名
	
	private String sex;//公民性别
	
	private String age;//公民年龄
	
	private IDcard idcard;//身份证实体对象

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public IDcard getIdcard() {
		return idcard;
	}

	public void setIdcard(IDcard idcard) {
		this.idcard = idcard;
	}
}
