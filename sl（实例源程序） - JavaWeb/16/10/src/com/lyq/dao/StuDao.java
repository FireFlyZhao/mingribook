package com.lyq.dao;

import java.util.List;

import org.hibernate.Session;

import com.lyq.vo.Student;

public class StuDao {
	/**
	 * ����ɾ��
	 * @param ids String ����
	 */
	public void deleteStudent(String[] ids){
		Session session = null;
		try {
			session = HibernateUtils.getSession();			//��ȡSession
			session.beginTransaction();						//��������
			for (String s : ids) {							//ͨ��ѭ����ȡ����id
				Integer id = Integer.valueOf(s);			//ת��ΪInteger��
				//ͨ��load������������
				Student stu = (Student)session.load(Student.class, id);
				session.delete(stu);						//ɾ������
			}
			session.getTransaction().commit();				//�ύ����
		} catch (Exception e) {
			e.printStackTrace();							//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();			//�ع�����
		}finally{
			HibernateUtils.closeSession(session);			//�ر�Session
		}
	}
	/**
	 * ��ѯ����ѧ��
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
