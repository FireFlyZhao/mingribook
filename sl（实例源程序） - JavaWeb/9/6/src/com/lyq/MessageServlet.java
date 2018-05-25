package com.lyq;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ����Servlet
 * @author Li Yong Qiang
 */
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 6536812362207677194L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ����
		String title = request.getParameter("title");
		// ��ȡ����
		String content = request.getParameter("content");
		// ��������õ�request��
		request.setAttribute("title", title);
		// �����ݷ��õ�request��
		request.setAttribute("content", content);
		// ת����result.jspҳ��
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
