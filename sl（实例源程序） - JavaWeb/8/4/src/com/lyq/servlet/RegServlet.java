package com.lyq.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 用户注册Servlet
 * @author Li YongQiang
 *
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置response的编码
		response.setCharacterEncoding("GB18030");
		// 获取PrintWriter
		PrintWriter out = response.getWriter();
		// 设置request的编码
		request.setCharacterEncoding("GB18030");
		// 获取用户名
		String name = request.getParameter("name");
		// 获取密码
		String password = request.getParameter("password");
		// 获取性别
		String sex = request.getParameter("sex");
		// 获取qq号码
		String qq = request.getParameter("qq");
		// 获取邮箱地址
		String mail = request.getParameter("mail");
		// 输出用户名
		out.println("用户名:" + name + "<br>");
		// 输出密码
		out.println("密码:" + password + "<br>");
		// 输出性别
		out.println("性别:" + sex + "<br>");
		// 输出qq号码
		out.println("qq号码:" + qq + "<br>");
		// 输出E-Mail地址
		out.println("E-Mail地址:" + mail + "<br>");
		out.flush();
		out.close();
	}

}
