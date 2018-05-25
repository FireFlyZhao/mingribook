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

import com.mr.hibernate.HibernateUtil;

/**
 * ����Ա����Ϣ�б�
 */
public class QueryEmployee extends HttpServlet {
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Session session = null;// ʵ����session����
        List emplist = new ArrayList();
        try {
            session = HibernateUtil.getSession();// ���session����
            //String hql = "from Employee emp";// ��ѯHQL���
            String hql = "from Employee emp where emp.sex='��'";// ������ѯHQL���
            Query q = session.createQuery(hql);// ִ�в�ѯ����
            emplist = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("��ѯʧ��");
        } finally {
            HibernateUtil.closeSession();// �ر�session
        }
        request.setAttribute("emplist", emplist);
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher(
                "/index.jsp");
        rd.forward(request, response);
    }
}
