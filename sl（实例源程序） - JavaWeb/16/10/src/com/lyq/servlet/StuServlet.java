package com.lyq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.dao.StuDao;
import com.lyq.vo.Student;

public class StuServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		StuDao dao = new StuDao();
		if ("find".equals(command)) {			//��ѯ����ѧ����Ϣ
			//��ѯ����ѧ����Ϣ
			List<Student> list = dao.findAllStudent();
			request.setAttribute("list", list);
			request.getRequestDispatcher("stu_list.jsp").forward(request,response);
		} else if ("delete".equals(command)) {	//����ɾ��ѧ����Ϣ
			//��ȡѧ��id
			String[] ids = request.getParameterValues("id");
			if(ids != null && ids.length > 0){
				dao.deleteStudent(ids);			//����ɾ��ѧ����Ϣ
			}
			request.getRequestDispatcher("StuServlet?command=find").forward(request,response);
		}
	}
}
