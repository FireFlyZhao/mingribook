package com.mr.main;

import org.hibernate.Session;

import com.mr.hibernate.HibernateInitialize;
import com.mr.product.Product;

public class DeleteProduct {

	//ɾ��ָ����Ʒ��Ϣ
	public static void main(String[] args) {
		Session session = null;			//����Session����
		try {
			//Hibernate�ĳ־û�����
			session = HibernateInitialize.getSession();//��ȡSession
			Product product = (Product) session.get(Product.class, new Integer("1"));//װ�ض���
			session.delete(product);//ɾ���־û���Ϣ
			session.flush();//ǿ��ˢ���ύ
		} catch (Exception e) {
			System.out.println("����ɾ��ʧ��");
			e.printStackTrace();
		} finally{
			HibernateInitialize.closeSession();//�ر�Session
		}
	}

}
