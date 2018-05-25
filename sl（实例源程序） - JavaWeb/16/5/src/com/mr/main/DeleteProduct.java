package com.mr.main;

import org.hibernate.Session;

import com.mr.hibernate.HibernateInitialize;
import com.mr.product.Product;

public class DeleteProduct {

	//删除指定产品信息
	public static void main(String[] args) {
		Session session = null;			//声明Session对象
		try {
			//Hibernate的持久化操作
			session = HibernateInitialize.getSession();//获取Session
			Product product = (Product) session.get(Product.class, new Integer("1"));//装载对象
			session.delete(product);//删除持久化信息
			session.flush();//强制刷新提交
		} catch (Exception e) {
			System.out.println("对象删除失败");
			e.printStackTrace();
		} finally{
			HibernateInitialize.closeSession();//关闭Session
		}
	}

}
