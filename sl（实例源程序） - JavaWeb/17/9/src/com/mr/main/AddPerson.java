package com.mr.main;

import org.hibernate.Session;

import com.mr.hibernate.HibernateInitialize;
import com.mr.person.Staffer;
import com.mr.person.Student;

public class AddPerson {
	public static void main(String[] args) {
		Session session = null;// 声明一个Session对象
		try {
			// Hibernate的持久化操作
			session = HibernateInitialize.getSession();// 获取Session
			session.beginTransaction();// 事务开启
			Student student = new Student();//声明学生的实体对象
			student.setId(1);//设定学生的ID属性值
			student.setName("小明");
			student.setAge(12);
			student.setSex("男");
			student.setSchool("明日希望小学");
			session.save(student);//保存学生信息
			Staffer staffer = new Staffer();
			staffer.setId(2);
			staffer.setName("小红");
			staffer.setAge(25);
			staffer.setSex("女");
			staffer.setCompany("明日科技");
			session.save(staffer);//保存职员信息
			session.getTransaction().commit();// 事务提交
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();// 事务回滚
		} finally {
			HibernateInitialize.closeSession();// 关闭Session
		}
	}
}
