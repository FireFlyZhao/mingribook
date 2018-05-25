package com.mr.main;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;

import com.mr.factory.Factory;
import com.mr.hibernate.HibernateInitialize;
import com.mr.product.Product;

public class SelectProduct {
	public static void main(String[] args) {
		Session session = null;			//声明一个Session对象
		try {
			//Hibernate的持久化操作
			session = HibernateInitialize.getSession();//获取Session
			session.beginTransaction();//事务开启
			Factory factoty = (Factory) session.get(Factory.class, new Integer("1"));//装载对象
			System.out.println("生产商："+factoty.getFactoryName());//打印生产商名称
			Set<Product> products = factoty.getProducts();//获取集合对象
			//通过迭代输出产品信息
			for (Iterator<Product> it = products.iterator(); it.hasNext();) {
				Product product = (Product) it.next();
				System.out.println("产品名称：" + product.getName()+"||产品价格："+product.getPrice());
			}
			session.getTransaction().commit();//事务提交
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();//事务回滚
		} finally{
			HibernateInitialize.closeSession();//关闭Session
		}
	}
}
