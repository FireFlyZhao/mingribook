package com.mr.main;

import org.hibernate.Session;

import com.mr.hibernate.HibernateInitialize;
import com.mr.people.People;

public class Manger {
	public static void main(String[] args) {
		Session session = null;// ����һ��Session����
		try {
			// Hibernate�ĳ־û�����
			session = HibernateInitialize.getSession();// ��ȡSession
			session.beginTransaction();// ������
			People people = (People)session.load(People.class, new Integer("1"));//װ�ع������
			session.delete(people);//ɾ��װ�صĹ������
			session.getTransaction().commit();// �����ύ
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();// ����ع�
		} finally {
			HibernateInitialize.closeSession();// �ر�Session
		}
	}
}