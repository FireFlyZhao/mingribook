package com.mr.user;

import java.util.Date;
/**
 * �û���ϢJavaBean
 */
public class User{
	
	private Integer id;//idֵ

	private String name;//�û�����
	
	private String business;//ְ��
	
	private Date addTime;//���ʱ��
	
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
