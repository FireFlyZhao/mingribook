package com.mr.main;

import org.hibernate.Session;

import com.mr.hibernate.HibernateInitialize;
import com.mr.product.Product;

public class AddProduct {

	/**
	 * 添加商品
	 */
	public static void main(String[] args) {
		Session session = null;			//声明Session对象
		Product product = new Product();//实例化持久化类
		//为持久化类属性赋值
		product.setName("Java Web编程宝典");//设置产品名称
		product.setPrice(79.00);//设置产品价格
		product.setFactory("明日科技");//设置生产商
		product.setRemark("无");//无
		//Hibernate的持久化操作
		try {
			session = HibernateInitialize.getSession();//获取Session
			session.beginTransaction();//开启事务
			session.save(product);//执行数据库添加操作
			session.getTransaction().commit();//事务提交
		} catch (Exception e) {
			session.getTransaction().rollback();//事务回滚
			System.out.println("数据添加失败");
			e.printStackTrace();
		}finally{
			HibernateInitialize.closeSession();//关闭Session对象
		}
	}
}
