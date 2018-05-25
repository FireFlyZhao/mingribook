package com.mr.main;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;

import com.mr.factory.Factory;
import com.mr.hibernate.HibernateInitialize;
import com.mr.product.Product;

public class SelectProduct {
	public static void main(String[] args) {
		Session session = null;			//����һ��Session����
		try {
			//Hibernate�ĳ־û�����
			session = HibernateInitialize.getSession();//��ȡSession
			session.beginTransaction();//������
			Factory factoty = (Factory) session.get(Factory.class, new Integer("1"));//װ�ض���
			System.out.println("�����̣�"+factoty.getFactoryName());//��ӡ����������
			Set<Product> products = factoty.getProducts();//��ȡ���϶���
			//ͨ�����������Ʒ��Ϣ
			for (Iterator<Product> it = products.iterator(); it.hasNext();) {
				Product product = (Product) it.next();
				System.out.println("��Ʒ���ƣ�" + product.getName()+"||��Ʒ�۸�"+product.getPrice());
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
