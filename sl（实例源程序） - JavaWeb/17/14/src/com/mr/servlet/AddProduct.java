package com.mr.servlet;

import java.io.IOException;

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
 * ��Ӳ�Ʒ��Ϣ��Servlet
 */
public class AddProduct extends HttpServlet {
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");// ��Ʒ����
        Double price = new Double(request.getParameter("price"));// ��Ʒ�۸�
        Integer factoryID = new Integer(request.getParameter("factory"));// �����̵�ID
        Session session = null; // ����һ��Session����
        try {
            // Hibernate�ĳ־û�����
            session = HibernateInitialize.getSession();// ��ȡSession
            session.beginTransaction();// ������
            Factory factory = new Factory();// ʵ��������
            factory = (Factory)session.get(Factory.class, factoryID);//��ȡ�����̵�ʵ�����
            Product product = new Product();// ʵ��������
            product.setName(name);//���ò�Ʒ����
            product.setPrice(price);//���ò�Ʒ�۸�
            product.setFactory(factory);
            session.save(product);//�����Ʒ��Ϣ
            session.getTransaction().commit();// �����ύ
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();// ����ع�
        } finally {
            HibernateInitialize.closeSession();// �ر�Session
        }
        //��ת�����Ҳ�Ʒ��Ϣ�б��Servlet
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/QueryProduct");
        rd.forward(request, response);
    }
}
