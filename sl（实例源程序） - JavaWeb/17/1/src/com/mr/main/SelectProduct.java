package com.mr.main;

import org.hibernate.Session;

import com.mr.factory.Factory;
import com.mr.hibernate.HibernateInitialize;
import com.mr.product.Product;

public class SelectProduct {
	public static void main(String[] args) {
		Session session = null;			//������һ��Session����
		try {
			//Hibernate�ĳ־û�����
			session = HibernateInitialize.getSession();//��ȡSession
			session.beginTransaction();//������
			Product product = (Product) session.get(Product.class, new Integer("1"));//װ�ض���
			System.out.println("��Ʒ���ƣ�"+product.getName());
			System.out.println("��Ʒ�۸�"+product.getPrice()+"Ԫ");
			System.out.println("�����̣�"+product.getFactory().getFactoryName());
			session.getTransaction().commit();//�����ύ
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();//����ع�
		} finally{
			HibernateInitialize.closeSession();//�ر�Session
		}
	}
}
