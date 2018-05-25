package com.mr.main;

import org.hibernate.Session;

import com.mr.hibernate.HibernateInitialize;
import com.mr.product.Product;

public class SecondCache {

	//使用二级缓存查询数据
	public static void main(String[] args) {
		Session session = null;			//声明第一个Session对象
		Session session2 = null;		//声明第二个Session对象
		try {
			//Hibernate的持久化操作
			session = HibernateInitialize.getSession();//获取第一个Session
			session2 = HibernateInitialize.getSession();//获取第二个Session
			Product product = (Product) session.get(Product.class, new Integer("1"));//装载对象
			System.out.println("第一个Session装载对象");
			Product product2 = (Product) session2.get(Product.class, new Integer("1"));//装载对象
			System.out.println("第二个Session装载对象");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			HibernateInitialize.closeSession();//关闭Session
		}
	}
}
