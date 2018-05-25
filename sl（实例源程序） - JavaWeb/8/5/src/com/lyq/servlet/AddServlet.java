package com.lyq.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ¼����Ʒ��Ϣ��Servlet
 * @author Li YongQiang
 *
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ����response�ı���
		response.setCharacterEncoding("GB18030");
		// ��ȡPrintWriter
		PrintWriter out = response.getWriter();
		// ����request�ı���
		request.setCharacterEncoding("GB18030");
		// ��ȡ����
		String name = request.getParameter("name");
		// ��ȡ�۸�
		String price = request.getParameter("price");
		// ��ȡ����
		String count = request.getParameter("count");
		// ��ȡ��λ
		String unit = request.getParameter("unit");
		// ��ȡ����
		String add = request.getParameter("add");
		// �����Ʒ��Ϣ
		out.print("���ƣ�" + name + "<br>");
		out.print("�۸�" + price + "<br>");
		out.print("������" + count + "<br>");
		out.print("��λ��" + unit + "<br>");
		out.print("���أ�" + add + "<br>");
		
		out.flush();
		out.close();
	}

}
