package com.lyq;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 添加图书信息的Servlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 处理GET请求
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	// 处理POST请求
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取 PrintWriter
		PrintWriter out = response.getWriter();
		// 获取图书编号
		String id = request.getParameter("id");
		// 获取名称
		String name = request.getParameter("name");
		// 获取作者
		String author = request.getParameter("author");
		// 获取价格
		String price = request.getParameter("price");
		// 输出图书信息
		out.print("<h2>图书信息添加成功</h2><hr>");
		out.print("图书编号：" + id + "<br>");
		out.print("图书名称：" + name + "<br>");
		out.print("作者：" + author + "<br>");
		out.print("价格：" + price + "<br>");
		// 刷新流
		out.flush();
		// 关闭流
		out.close();
	}
}
