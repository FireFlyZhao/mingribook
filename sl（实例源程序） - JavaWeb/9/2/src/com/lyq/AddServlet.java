package com.lyq;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ���ͼ����Ϣ��Servlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// ����GET����
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	// ����POST����
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ PrintWriter
		PrintWriter out = response.getWriter();
		// ��ȡͼ����
		String id = request.getParameter("id");
		// ��ȡ����
		String name = request.getParameter("name");
		// ��ȡ����
		String author = request.getParameter("author");
		// ��ȡ�۸�
		String price = request.getParameter("price");
		// ���ͼ����Ϣ
		out.print("<h2>ͼ����Ϣ��ӳɹ�</h2><hr>");
		out.print("ͼ���ţ�" + id + "<br>");
		out.print("ͼ�����ƣ�" + name + "<br>");
		out.print("���ߣ�" + author + "<br>");
		out.print("�۸�" + price + "<br>");
		// ˢ����
		out.flush();
		// �ر���
		out.close();
	}
}
