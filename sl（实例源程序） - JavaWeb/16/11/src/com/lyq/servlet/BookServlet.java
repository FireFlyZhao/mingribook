package com.lyq.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lyq.dao.BookDao;
import com.lyq.vo.Book;

public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = -5565840336525362453L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		//��ȡsession
		HttpSession session = request.getSession();
		//��session�л�ȡ�ѱ����ͼ��
		List<Book> list = (List)session.getAttribute("books");
		if("add".equals(command)){//��Session�����ͼ��
			//�ռ�ͼ����Ϣ
			String bookName = request.getParameter("bookName");
			String price = request.getParameter("price");
			String bookCount = request.getParameter("bookCount");
			String category = request.getParameter("category");
			String desc = request.getParameter("description");
			//����Book����
			Book book = new Book();
			book.setBookName(bookName);
			book.setBookCount(Integer.valueOf(bookCount));
			book.setPrice(Double.valueOf(price));
			book.setCategory(category);
			book.setDescription(desc);
			if(list == null){
				list = new ArrayList<Book>();
			}
			list.add(book);
			//�����ݱ��浽Session֮��
			session.setAttribute("books", list);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if("save".equals(command)){//�����ݿ�����������ͼ��
			String info = "û��ͼ��Ҫ���棡";		//�����Ϣ
			if(list != null && list.size() > 0){
				BookDao dao = new BookDao();		//����BookDao����
				dao.saveAllBooks(list);				//������������
				session.removeAttribute("books");	//�����ݴ�Session���Ƴ�
				info = "����ͼ�鱣��ɹ���";
			}
			request.setAttribute("info", info);
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}
}
