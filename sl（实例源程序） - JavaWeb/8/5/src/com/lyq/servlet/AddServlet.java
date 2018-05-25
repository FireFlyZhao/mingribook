package com.lyq.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 录入商品信息的Servlet
 * @author Li YongQiang
 *
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置response的编码
		response.setCharacterEncoding("GB18030");
		// 获取PrintWriter
		PrintWriter out = response.getWriter();
		// 设置request的编码
		request.setCharacterEncoding("GB18030");
		// 获取名称
		String name = request.getParameter("name");
		// 获取价格
		String price = request.getParameter("price");
		// 获取数量
		String count = request.getParameter("count");
		// 获取单位
		String unit = request.getParameter("unit");
		// 获取产地
		String add = request.getParameter("add");
		// 输出商品信息
		out.print("名称：" + name + "<br>");
		out.print("价格：" + price + "<br>");
		out.print("数量：" + count + "<br>");
		out.print("单位：" + unit + "<br>");
		out.print("产地：" + add + "<br>");
		
		out.flush();
		out.close();
	}

}
