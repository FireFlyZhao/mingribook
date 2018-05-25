package com.mr.main;

import org.hibernate.Session;

import com.mr.hibernate.HibernateInitialize;
import com.mr.product.Product;

public class LoadProduct {
	//����load�������ض���
	public static void main(String[] args) {
		Session session = null;			//����Session����
		try {
			//Hibernate�ĳ־û�����
			session = HibernateInitialize.getSession();//��ȡSession
			Product product = new Product();//ʵ��������
			session.load(product, new Integer("1"));//װ�ض���
			//Product product = (Product) session.load(Product.class, new Integer("1"));//װ�ض���
			System.out.println("��ƷID��"+product.getId());
			System.out.println("��Ʒ���ƣ�"+product.getName());
			System.out.println("��Ʒ�۸�"+product.getPrice()+"Ԫ");
			System.out.println("�������̣�"+product.getFactory());
			System.out.println("��Ʒ��ע��"+product.getRemark());
		} catch (Exception e) {
			System.out.println("����װ��ʧ��");
			e.printStackTrace();
		} finally{
			HibernateInitialize.closeSession();//�ر�Session
		}
	}

}
