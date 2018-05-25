package com.mr.main;

import org.hibernate.Session;

import com.mr.hibernate.HibernateInitialize;
import com.mr.product.Product;

public class GetProduct {
	//����get()����װ�ض���
	public static void main(String[] args){
		Session session = null;			//����Session����
		try {
			//Hibernate�ĳ־û�����
			session = HibernateInitialize.getSession();//��ȡSession
			Product product = (Product) session.get(Product.class, new Integer("1"));//װ�ض���
			System.out.println("��һ��װ�ض���");
			Product product2 = (Product) session.get(Product.class, new Integer("1"));//װ�ض���
			System.out.println("�ڶ���װ�ض���");
		} catch (Exception e) {
			System.out.println("����װ��ʧ��");
			e.printStackTrace();
		} finally{
			HibernateInitialize.closeSession();//�ر�Session
		}
	}
}
