package com.lyq.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 计算器Servlet
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
		// 获取第一个数字
		double firstNum = Double.valueOf(request.getParameter("firstNum"));
		// 获取第一个数字
		double secondNum = Double.valueOf(request.getParameter("secendNum"));
		// 获取运算符
		String operator = request.getParameter("operator");
		// 计算结果
		double result = 0;
		// 判断运算符
		if("+".equals(operator)){
			result = firstNum + secondNum;
		}else if("-".equals(operator)){
			result = firstNum - secondNum;
		}else if("*".equals(operator)){
			result = firstNum * secondNum;
		}else if("/".equals(operator)){
			result = firstNum / secondNum;
		}
		// 输出计算结果
		out.print(firstNum + " " + operator +  " " + secondNum + " = " + result);
		out.print("<br><a href='index.jsp'>返回</a>");
		out.flush();
		out.close();
	}

}
