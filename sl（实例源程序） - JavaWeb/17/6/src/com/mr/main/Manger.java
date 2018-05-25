package com.mr.main;

import org.hibernate.Session;

import com.mr.hibernate.HibernateInitialize;
import com.mr.people.People;

public class Manger {
	public static void main(String[] args) {
		Session session = null;// 声明一个Session对象
		try {
			// Hibernate的持久化操作
			session = HibernateInitialize.getSession();// 获取Session
			session.beginTransaction();// 事务开启
			People people = (People)session.load(People.class, new Integer("1"));//装载公民对象
			session.delete(people);//删除装载的公民对象
			session.getTransaction().commit();// 事务提交
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();// 事务回滚
		} finally {
			HibernateInitialize.closeSession();// 关闭Session
		}
	}
}