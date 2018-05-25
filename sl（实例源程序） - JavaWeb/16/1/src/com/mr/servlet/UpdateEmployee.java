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
 * �޸�Ա����Ϣ
 */
public class UpdateEmployee extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//���ñ��뷽ʽ
		//��ҳ��ȡֵ
		Integer id = new Integer(request.getParameter("id"));//��ȡΨһ�Ա�ʶ
		String name = request.getParameter("name");//��ȡԱ������
		String sex = request.getParameter("sex");
		String business = request.getParameter("business");
		String address = request.getParameter("address");
		String remark = request.getParameter("remark");
		//�޸Ĳ���
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();//��������
			Employee employee = (Employee)session.load(Employee.class, id);//�޸Ĳ���
			employee.setName(name);//�޸�Ա���ĸ�������
			employee.setBusiness(business);
			employee.setSex(sex);
			employee.setBusiness(business);
			employee.setAddress(address);
			employee.setRemark(remark);
			session.getTransaction().commit();//�ύ����
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();//����ع�
		}finally{
			HibernateUtil.closeSession();//�ر�session
		}
		//�޸ĳɹ�����ת�����ҵ�Servlet
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/QueryEmployee");
		rd.forward(request, response);
	}
}
