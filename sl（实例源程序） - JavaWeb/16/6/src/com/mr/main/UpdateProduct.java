package com.mr.main;

import org.hibernate.Session;

import com.mr.hibernate.HibernateInitialize;
import com.mr.product.Product;

public class UpdateProduct {
	
	//�޸�ָ����Ʒ��Ϣ
	public static void main(String[] args) {
		Session session = null;			//����Session����
		try {
			//Hibernate�ĳ־û�����
			session = HibernateInitialize.getSession();//��ȡSession
			Product product = (Product) session.load(Product.class, new Integer("1"));//װ�ض���
			product.setName("Java Web��̴ʵ�");//�޸���Ʒ����
			product.setRemark("��");//�޸ı�ע��Ϣ
			session.update(product );
			session.flush();
		} catch (Exception e) {
			System.out.println("�����޸�ʧ��");
			e.printStackTrace();
		} finally{
			HibernateInitialize.closeSession();//�ر�Session
		}
	}

}
