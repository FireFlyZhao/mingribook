package com.lyq.dao;

import java.util.List;

import org.hibernate.Session;

import com.lyq.vo.Book;
/**
 * Dao�������������
 * @author lyq
 */
public class BookDao {
	/**
	 * ��������Book
	 * @param List
	 */
	public void saveAllBooks(List<Book> books){
		Session session = null;
		if(books != null && books.size() > 0){
			try {
				session = HibernateUtils.getSession();		//��ȡSession
				session.beginTransaction();					//��������
				Book book = null;							//����Book����
				for (int i = 0; i < books.size(); i++) {
					book = (Book)books.get(i);				//��ȡBook
					session.save(book);						//�������
				}
				session.getTransaction().commit();			//�ύ����
			} catch (Exception e) {
				e.printStackTrace();						//��ӡ������Ϣ
				session.getTransaction().rollback();		//�����ع�����
			}finally{
				HibernateUtils.closeSession(session);		//�ر�Session
			}
		}
	}
}
