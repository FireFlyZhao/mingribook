package com.lyq.bean;
/**
 * 学生对象
 * @author Li Yongqiang
 */
public class Student {
	// 学号 
	private int id;
	// 姓名
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String say(){
		return "我是一个学生";
	}
}
