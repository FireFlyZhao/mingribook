package com.mr.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.mr.hibernate.HibernateInitialize;

/**
 * HQL�����Ӳ�ѯ
 */
public class QueryPeople extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Session session = null;// ʵ����session����
        List<Object[]> list = new ArrayList<Object[]>();
        try {
            session = HibernateInitialize.getSession();// ���session����
            // ��������
            session.beginTransaction();
            String hql = "select peo.id,peo.name,peo.age,peo.sex,c.idcard_code from People peo left join peo.idcard c";// ������ѯHQL���
            Query q = session.createQuery(hql);// ִ�в�ѯ����
            list = q.list();
            // �ύ����
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            // �����ع�����
            session.getTransaction().rollback();
        } finally {
            HibernateInitialize.closeSession();// �ر�session
        }
        request.setAttribute("list", list);
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher(
                "/index.jsp");
        rd.forward(request, response);
	}

}
