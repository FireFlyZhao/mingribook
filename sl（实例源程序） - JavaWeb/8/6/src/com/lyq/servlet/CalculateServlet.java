package com.lyq.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ������Servlet
 * @author Li Yong Qiang
 */
public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 7223778025721767631L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("GBK");
		PrintWriter out = response.getWriter();
		// ��ȡ��һ������
		double firstNum = Double.valueOf(request.getParameter("firstNum"));
		// ��ȡ��һ������
		double secondNum = Double.valueOf(request.getParameter("secendNum"));
		// ��ȡ�����
		String operator = request.getParameter("operator");
		// ������
		double result = 0;
		// �ж������
		if("+".equals(operator)){
			result = firstNum + secondNum;
		}else if("-".equals(operator)){
			result = firstNum - secondNum;
		}else if("*".equals(operator)){
			result = firstNum * secondNum;
		}else if("/".equals(operator)){
			result = firstNum / secondNum;
		}
		// ���������
		out.print(firstNum + " " + operator +  " " + secondNum + " = " + result);
		out.print("<br><a href='index.jsp'>����</a>");
		out.flush();
		out.close();
	}

}
