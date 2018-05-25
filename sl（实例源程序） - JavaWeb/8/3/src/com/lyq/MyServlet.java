package com.lyq;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 3563565034243126713L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("GBK");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>ServletÊµÀý</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    ServletÊµÀý£º ");
		out.print(this.getClass());
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}
