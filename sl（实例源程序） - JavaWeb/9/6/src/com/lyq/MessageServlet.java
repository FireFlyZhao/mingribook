package com.lyq;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 留言Servlet
 * @author Li Yong Qiang
 */
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 6536812362207677194L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取标题
		String title = request.getParameter("title");
		// 获取内容
		String content = request.getParameter("content");
		// 将标题放置到request中
		request.setAttribute("title", title);
		// 将内容放置到request中
		request.setAttribute("content", content);
		// 转发到result.jsp页面
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
