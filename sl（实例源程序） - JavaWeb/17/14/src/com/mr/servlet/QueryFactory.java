package com.mr.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.mr.factory.Factory;
import com.mr.hibernate.HibernateInitialize;
import com.mr.product.Product;

/**
 * ����������
 */
public class QueryFactory extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Session session = null; // ����һ��Session����
		List list = new ArrayList();//List����
        try {
            // Hibernate�ĳ־û�����
            session = HibernateInitialize.getSession();// ��ȡSession
            String hql = "from Factory";//����HQL���
            session.beginTransaction();// ������
            list = session.createQuery(hql).list();
            session.getTransaction().commit();// �����ύ
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();// ����ع�
        } finally {
            HibernateInitialize.closeSession();// �ر�Session
        }
        request.setAttribute("list", list);//�����ѯ���صļ���
        //��ת����Ʒ���ҳ��
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/AddProduct.jsp");
        rd.forward(request, response);
	}

}
