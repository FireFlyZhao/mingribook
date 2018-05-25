package com.mr.main;

import org.hibernate.Session;

import com.mr.hibernate.HibernateInitialize;
import com.mr.product.Product;

public class GetProduct {
	//利用get()方法装载对象
	public static void main(String[] args){
		Session session = null;			//声明Session对象
		try {
			//Hibernate的持久化操作
			session = HibernateInitialize.getSession();//获取Session
			Product product = (Product) session.get(Product.class, new Integer("1"));//装载对象
			System.out.println("第一次装载对象");
			Product product2 = (Product) session.get(Product.class, new Integer("1"));//装载对象
			System.out.println("第二次装载对象");
		} catch (Exception e) {
			System.out.println("对象装载失败");
			e.printStackTrace();
		} finally{
			HibernateInitialize.closeSession();//关闭Session
		}
	}
}
