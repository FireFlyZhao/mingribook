package com.mr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ����ҳ�����Ե��л�
 */
public class LanguageManager extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String lang = request.getParameter("language");//��ȡ����
		Locale language = null;                       //����Locale����
		if(lang.equals("1")){
			language = Locale.CHINA;//����
		}else{
			language = Locale.US;//Ӣ��
		}
		request.setAttribute("language", language);
		//��ת�����ҳ����
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
}
