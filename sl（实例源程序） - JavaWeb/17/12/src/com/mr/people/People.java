package com.mr.people;

import com.mr.idcard.IDcard;


public class People {

	private Integer id;//唯一性标识
	
	private String name;//公民姓名
	
	private String sex;//公民性别
	
	private Integer age;//公民年龄
	
	private IDcard idcard;//引用的身份证对象实体

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

	public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public IDcard getIdcard() {
        return idcard;
    }

    public void setIdcard(IDcard idcard) {
        this.idcard = idcard;
    }
}
