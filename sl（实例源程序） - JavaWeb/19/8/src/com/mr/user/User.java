package com.mr.user;

import java.util.Date;
/**
 * 用户信息JavaBean
 */
public class User{
	
	private Integer id;//id值

	private String name;//用户名称
	
	private String business;//职务
	
	private Date addTime;//添加时间
	
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

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
}
