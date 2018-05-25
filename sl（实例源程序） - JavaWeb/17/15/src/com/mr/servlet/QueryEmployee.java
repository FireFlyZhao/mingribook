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
 * ģ����ѯԱ����Ϣ
 */
public class QueryEmployee extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
        List emplist = new ArrayList();//ʵ����List��Ϣ����
        String name = request.getParameter("name");
        Session session = null;// ʵ����session����
        try {
            session = HibernateUtil.getSession();// ���session����
            String hql = "from Employee emp where emp.name like ?";// ��ѯHQL���
            Query q = session.createQuery(hql);// ִ�в�ѯ����
            q.setParameter(0, "%"+name+"%");//Ϊģ����ѯ�Ĳ�����ֵ
            emplist = q.list();//�����صĶ���ת��ΪList����
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();// �ر�session
        }
        request.setAttribute("emplist", emplist);
        //��ת��Ա����Ϣ���б�ҳ��
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/employee.jsp");
        rd.forward(request, response);
	}

}
