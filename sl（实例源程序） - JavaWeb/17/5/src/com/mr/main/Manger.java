package com.mr.main;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;

import com.mr.hibernate.HibernateInitialize;
import com.mr.role.Role;
import com.mr.user.User;

public class Manger {
	public static void main(String[] args) {
		Session session = null;			//����һ��Session����
		try {
			//Hibernate�ĳ־û�����
			session = HibernateInitialize.getSession();//��ȡSession
			session.beginTransaction();//������
			User user = (User)session.get(User.class, new Integer("1"));//װ���û�����
			Set<Role> roles= user.getRoles();//��ȡȨ�����Ƽ���
			System.out.println(user.getName()+"�û���ӵ�е�Ȩ��Ϊ��");
			//ͨ���������Ȩ����Ϣ
			for (Iterator<Role> it = roles.iterator(); it.hasNext();) {
				Role roles2 = (Role) it.next();
				System.out.print(roles2.getRoleName()+"||");
			}
			System.out.println();//����
			Role rol = (Role)session.get(Role.class, new Integer("2"));
			Set<User> users = rol.getUsers();//��ȡ�û����Ƽ���
			System.out.println(rol.getRoleName()+"Ȩ�ޱ������û���");
			//ͨ����������û���Ϣ
			for (Iterator<User> it = users.iterator(); it.hasNext();) {
				User users2 = (User) it.next();
				System.out.print(users2.getName()+"||");
			}
			session.getTransaction().commit();//�����ύ
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();//����ع�
		} finally{
			HibernateInitialize.closeSession();//�ر�Session
		}
	}
}
