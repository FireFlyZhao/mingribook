package com.lyq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.Student;
import com.lyq.bean.StudentDao;
/**
 * �鿴ѧ����Ϣ
 * @author Li YongQiang
 *
 */
public class FindStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ʵ����StudentDao
		StudentDao dao = new StudentDao();
		List<Student> list = dao.findStudent();
		// ��ͼ�鼯�Ϸ��õ�request֮��
		request.setAttribute("list", list);
		// ����ת����book_list.jsp
		request.getRequestDispatcher("student_list.jsp").forward(request, response);
	}

}
