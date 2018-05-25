package com.mr.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.mr.employee.Employee;
import com.mr.hibernate.HibernateUtil;

/**
 * �޸�ʱ��ѯһ��Ա����Ϣ
 */
public class QueryOneEmployee extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer id = new Integer(request.getParameter("id"));//ȡ��id����
		Session session = null;
		try {
		session = HibernateUtil.getSession();
		Employee employeeVO = (Employee)session.get(Employee.class, id);//����id��ѯ��Ϣ
		request.setAttribute("employeeVO", employeeVO);
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();//�ر�session
		}
		//��ת���޸�ҳ��
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/update.jsp");
		rd.forward(request, response);
	}

}
