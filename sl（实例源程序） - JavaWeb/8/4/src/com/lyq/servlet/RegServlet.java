package com.lyq.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * �û�ע��Servlet
 * @author Li YongQiang
 *
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ����response�ı���
		response.setCharacterEncoding("GB18030");
		// ��ȡPrintWriter
		PrintWriter out = response.getWriter();
		// ����request�ı���
		request.setCharacterEncoding("GB18030");
		// ��ȡ�û���
		String name = request.getParameter("name");
		// ��ȡ����
		String password = request.getParameter("password");
		// ��ȡ�Ա�
		String sex = request.getParameter("sex");
		// ��ȡqq����
		String qq = request.getParameter("qq");
		// ��ȡ�����ַ
		String mail = request.getParameter("mail");
		// ����û���
		out.println("�û���:" + name + "<br>");
		// �������
		out.println("����:" + password + "<br>");
		// ����Ա�
		out.println("�Ա�:" + sex + "<br>");
		// ���qq����
		out.println("qq����:" + qq + "<br>");
		// ���E-Mail��ַ
		out.println("E-Mail��ַ:" + mail + "<br>");
		out.flush();
		out.close();
	}

}
