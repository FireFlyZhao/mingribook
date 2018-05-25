package com.wgh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wgh.HibernateUtil;
import com.wgh.model.TbMessage;

public class MessageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MessageServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("list".equals(action)) {
			listMessage(request, response);
		}else if("update".equals(action)){
			updateMessage(request,response);
		}else if("getMessage".equals(action)){
			getMessage(request,response);
		}

	}
	//��ȡȫ��������Ϣ
	public void listMessage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		HibernateUtil hibernateUtil = new HibernateUtil();
		List<TbMessage> listMessage = hibernateUtil.listMessage();// ��ȡȫ��������Ϣ
		request.setAttribute("listMessage",listMessage);	//����������Ϣ��request��
		request.getRequestDispatcher("listMessage.jsp").forward(request, response);
	}
	
	//��ȡָ��������Ϣ
	public void getMessage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		int id=Integer.parseInt(request.getParameter("id"));//��ȡҪ��ѯ������ID
		HibernateUtil hibernateUtil = new HibernateUtil();
		TbMessage message = hibernateUtil.getMessage(id);// ��ȡָ��������Ϣ
		request.setAttribute("tbMessage",message);	//����������Ϣ��request��
		request.getRequestDispatcher("showMessage.jsp").forward(request, response);
	}
		
	public void updateMessage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		int id=Integer.parseInt(request.getParameter("id"));//��ȡ����ID
		String writer = new String(request.getParameter("writer").getBytes("ISO-8859-1"),"GBK");// ��ȡ������
		String content = new String(request.getParameter("content").getBytes("ISO-8859-1"),"GBK");// ��ȡ��������
		HibernateUtil hibernateUtil = new HibernateUtil();
		TbMessage message = new TbMessage(); // ʵ��������
		message.setId(id);	//��������ID
		message.setWriter(writer); // �������������Ե�ֵ
		message.setContent(content);// ���������������Ե�ֵ
		String returnStr = hibernateUtil.updateMessage(message);// ����������Ϣ
		// ������ʾ��Ϣ���ض���ҳ��
		PrintWriter out = response.getWriter();
		out.print("<script>alert('" + returnStr
				+ "');window.location.href='forward.jsp';</script>");
		out.flush();
		out.close();
	}
	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
