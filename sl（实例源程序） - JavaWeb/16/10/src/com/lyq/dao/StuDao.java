package com.lyq.dao;

import java.util.List;

import org.hibernate.Session;

import com.lyq.vo.Student;

public class StuDao {
	/**
	 * 批量删除
	 * @param ids String 数组
	 */
	public void deleteStudent(String[] ids){
		Session session = null;
		try {
			session = HibernateUtils.getSession();			//获取Session
			session.beginTransaction();						//开启事物
			for (String s : ids) {							//通过循环获取主键id
				Integer id = Integer.valueOf(s);			//转换为Integer型
				//通过load方法加载数据
				Student stu = (Student)session.load(Student.class, id);
				session.delete(stu);						//删除数据
			}
			session.getTransaction().commit();				//提交事物
		} catch (Exception e) {
			e.printStackTrace();							//打印异常信息
			session.getTransaction().rollback();			//回滚事物
		}finally{
			HibernateUtils.closeSession(session);			//关闭Session
		}
	}
	/**
	 * 查询所有学生
	 * @return List
	 */
	public List<Student> findAllStudent(){
		List<Student> list = null;
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			list = session.createQuery("from Student").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		return list;
	}
}
