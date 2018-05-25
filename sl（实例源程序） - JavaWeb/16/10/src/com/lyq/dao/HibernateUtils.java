package com.lyq.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Hibernate工具类，用于获取SessionFactory和Session
 * @author lyq
 */
public class HibernateUtils {
	private static SessionFactory factory;	//定义Session工厂
	//静态块用于实例化Session工厂
	static{
		Configuration cfg = new Configuration().configure();
		factory = cfg.buildSessionFactory();
	}
	/**
	 * 获取Session工厂
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory(){
		return factory;
	}
	/**
	 * 获取Session
	 * @return Session
	 */
	public static Session getSession(){
		return factory.openSession();
	}
	/**
	 * 关闭Session释放资源
	 * @param session
	 */
	public static void closeSession(Session session){
		if(session != null){
			if(session.isOpen()){
				session.close();
			}
		}
	}
}
