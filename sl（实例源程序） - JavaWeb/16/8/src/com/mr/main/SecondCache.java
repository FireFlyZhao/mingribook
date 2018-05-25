package com.mr.main;

import org.hibernate.Session;

import com.mr.hibernate.HibernateInitialize;
import com.mr.product.Product;

public class SecondCache {

	//ʹ�ö��������ѯ����
	public static void main(String[] args) {
		Session session = null;			//������һ��Session����
		Session session2 = null;		//�����ڶ���Session����
		try {
			//Hibernate�ĳ־û�����
			session = HibernateInitialize.getSession();//��ȡ��һ��Session
			session2 = HibernateInitialize.getSession();//��ȡ�ڶ���Session
			Product product = (Product) session.get(Product.class, new Integer("1"));//װ�ض���
			System.out.println("��һ��Sessionװ�ض���");
			Product product2 = (Product) session2.get(Product.class, new Integer("1"));//װ�ض���
			System.out.println("�ڶ���Sessionװ�ض���");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			HibernateInitialize.closeSession();//�ر�Session
		}
	}
}
