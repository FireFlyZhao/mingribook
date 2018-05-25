package com.lyq.bean;
/**
 * 学生信息类
 * @author Li YongQiang
 *
 */
public class Student {
	// 学号 
	private int id;
	// 姓名
	private String name;
	// 年龄
	private int age;
	// 性别
	private String sex;
	// 班级
	private String classes;
	public Student(){
	}
	public Student(String name, int age, String sex, String classes) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.classes = classes;
	}
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
}
