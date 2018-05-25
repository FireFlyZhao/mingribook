package com.mr.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateInitialize {
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();//ThreadLocal����
    private static SessionFactory sessionFactory = null;//SessionFactory����
    //��̬��
	static {
    	try {
    		// ����Hibernate�����ļ�
			Configuration cfg = new Configuration().configure();
			sessionFactory = cfg.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("�����Ự����ʧ��");
			e.printStackTrace();
		}
    }
	/**
     *	��ȡSession
     *  @return Session
     *  @throws HibernateException
     */
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession(): null;
			threadLocal.set(session);
		}

        return session;
    }
	/**
     * �ؽ��Ự����
     */
	public static void rebuildSessionFactory() {
		try {
			// ����Hibernate�����ļ�
			Configuration cfg = new Configuration().configure();
			sessionFactory = cfg.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("�����Ự����ʧ��");
			e.printStackTrace();
		}
	}
	/**
	 * ��ȡSessionFactory����
	 * @return SessionFactory����
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	/** 
     *	�ر�Session
     *  @throws HibernateException
     */
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);//
        if (session != null) {
            session.close();//�ر�Session
        }
    }
}
