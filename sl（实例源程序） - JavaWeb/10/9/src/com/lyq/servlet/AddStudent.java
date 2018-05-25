package com.lyq.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.Student;
import com.lyq.bean.StudentDao;

/**
 * 添加学生信息的Servlet
 * @author Li YongQiang
 *
 */
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置response的编码
		response.setCharacterEncoding("GB18030");
		// 获取PrintWriter
		PrintWriter out = response.getWriter();
		// 设置request的编码
		request.setCharacterEncoding("GB18030");
		// 获取姓名
		String name = request.getParameter("name");
		// 获取性别
		String sex = request.getParameter("sex");
		// 获取年龄
		String age = request.getParameter("age");
		// 获取班级
		String classes = request.getParameter("classes");
		// 实例化student
		Student student = new Student(name,Integer.parseInt(age),sex,classes);	
		// 实例化StudentDao
		StudentDao dao = new StudentDao();
		// 添加学生信息
		int row = dao.saveStudent(student);
		if(row > 0){
			// 更新成输出信息
			out.print("成功添加了 " + row + "条数据！");
		}else{
			out.print("添加失败！");
		}
		out.flush();
		out.close();
	}

}
