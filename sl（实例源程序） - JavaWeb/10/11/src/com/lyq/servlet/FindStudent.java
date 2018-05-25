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
 * 查看学生信息
 * @author Li YongQiang
 *
 */
public class FindStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 实例化StudentDao
		StudentDao dao = new StudentDao();
		List<Student> list = dao.findStudent();
		// 将图书集合放置到request之中
		request.setAttribute("list", list);
		// 请求转发到book_list.jsp
		request.getRequestDispatcher("student_list.jsp").forward(request, response);
	}

}
