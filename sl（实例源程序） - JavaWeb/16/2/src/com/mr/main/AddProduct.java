package com.mr.main;

import org.hibernate.Session;

import com.mr.hibernate.HibernateInitialize;
import com.mr.product.Product;

public class AddProduct {

	/**
	 * �����Ʒ
	 */
	public static void main(String[] args) {
		Session session = null;			//����Session����
		Product product = new Product();//ʵ�����־û���
		//Ϊ�־û������Ը�ֵ
		product.setName("Java Web��̱���");//���ò�Ʒ����
		product.setPrice(79.00);//���ò�Ʒ�۸�
		product.setFactory("���տƼ�");//����������
		product.setRemark("��");//��
		//Hibernate�ĳ־û�����
		try {
			session = HibernateInitialize.getSession();//��ȡSession
			session.beginTransaction();//��������
			session.save(product);//ִ�����ݿ���Ӳ���
			session.getTransaction().commit();//�����ύ
		} catch (Exception e) {
			session.getTransaction().rollback();//����ع�
			System.out.println("�������ʧ��");
			e.printStackTrace();
		}finally{
			HibernateInitialize.closeSession();//�ر�Session����
		}
	}
}
