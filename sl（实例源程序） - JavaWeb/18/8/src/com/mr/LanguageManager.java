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
 * 控制页面语言的切换
 */
public class LanguageManager extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String lang = request.getParameter("language");//获取参数
		Locale language = null;                       //定义Locale对象
		if(lang.equals("1")){
			language = Locale.CHINA;//中文
		}else{
			language = Locale.US;//英文
		}
		request.setAttribute("language", language);
		//跳转到添加页面上
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
}
