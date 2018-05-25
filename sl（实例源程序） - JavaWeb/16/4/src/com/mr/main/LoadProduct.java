package com.mr.main;

import org.hibernate.Session;

import com.mr.hibernate.HibernateInitialize;
import com.mr.product.Product;

public class LoadProduct {
	//利用load方法加载对象
	public static void main(String[] args) {
		Session session = null;			//声明Session对象
		try {
			//Hibernate的持久化操作
			session = HibernateInitialize.getSession();//获取Session
			Product product = new Product();//实例化对象
			session.load(product, new Integer("1"));//装载对象
			//Product product = (Product) session.load(Product.class, new Integer("1"));//装载对象
			System.out.println("产品ID："+product.getId());
			System.out.println("产品名称："+product.getName());
			System.out.println("产品价格："+product.getPrice()+"元");
			System.out.println("生产厂商："+product.getFactory());
			System.out.println("产品备注："+product.getRemark());
		} catch (Exception e) {
			System.out.println("对象装载失败");
			e.printStackTrace();
		} finally{
			HibernateInitialize.closeSession();//关闭Session
		}
	}

}
