package com.lyq.dao;

import java.util.List;

import org.hibernate.Session;

import com.lyq.vo.Book;
/**
 * Dao类用于添加数据
 * @author lyq
 */
public class BookDao {
	/**
	 * 批量保存Book
	 * @param List
	 */
	public void saveAllBooks(List<Book> books){
		Session session = null;
		if(books != null && books.size() > 0){
			try {
				session = HibernateUtils.getSession();		//获取Session
				session.beginTransaction();					//开启事物
				Book book = null;							//创建Book对象
				for (int i = 0; i < books.size(); i++) {
					book = (Book)books.get(i);				//获取Book
					session.save(book);						//保存对象
				}
				session.getTransaction().commit();			//提交事物
			} catch (Exception e) {
				e.printStackTrace();						//打印错误信息
				session.getTransaction().rollback();		//出错将回滚事物
			}finally{
				HibernateUtils.closeSession(session);		//关闭Session
			}
		}
	}
}
