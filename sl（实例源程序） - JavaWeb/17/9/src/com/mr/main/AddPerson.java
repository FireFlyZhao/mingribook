package com.mr.main;

import org.hibernate.Session;

import com.mr.hibernate.HibernateInitialize;
import com.mr.person.Staffer;
import com.mr.person.Student;

public class AddPerson {
	public static void main(String[] args) {
		Session session = null;// ����һ��Session����
		try {
			// Hibernate�ĳ־û�����
			session = HibernateInitialize.getSession();// ��ȡSession
			session.beginTransaction();// ������
			Student student = new Student();//����ѧ����ʵ�����
			student.setId(1);//�趨ѧ����ID����ֵ
			student.setName("С��");
			student.setAge(12);
			student.setSex("��");
			student.setSchool("����ϣ��Сѧ");
			session.save(student);//����ѧ����Ϣ
			Staffer staffer = new Staffer();
			staffer.setId(2);
			staffer.setName("С��");
			staffer.setAge(25);
			staffer.setSex("Ů");
			staffer.setCompany("���տƼ�");
			session.save(staffer);//����ְԱ��Ϣ
			session.getTransaction().commit();// �����ύ
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();// ����ع�
		} finally {
			HibernateInitialize.closeSession();// �ر�Session
		}
	}
}
