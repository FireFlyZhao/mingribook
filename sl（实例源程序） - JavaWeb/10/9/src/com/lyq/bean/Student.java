package com.lyq.bean;
/**
 * ѧ����Ϣ��
 * @author Li YongQiang
 *
 */
public class Student {
	// ѧ�� 
	private int id;
	// ����
	private String name;
	// ����
	private int age;
	// �Ա�
	private String sex;
	// �༶
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
