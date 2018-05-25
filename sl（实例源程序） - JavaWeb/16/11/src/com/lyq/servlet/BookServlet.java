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
		//获取session
		HttpSession session = request.getSession();
		//从session中获取已保存的图书
		List<Book> list = (List)session.getAttribute("books");
		if("add".equals(command)){//向Session中添加图书
			//收集图书信息
			String bookName = request.getParameter("bookName");
			String price = request.getParameter("price");
			String bookCount = request.getParameter("bookCount");
			String category = request.getParameter("category");
			String desc = request.getParameter("description");
			//创建Book对象
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
			//将数据保存到Session之中
			session.setAttribute("books", list);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if("save".equals(command)){//向数据库中批量保存图书
			String info = "没有图书要保存！";		//结果信息
			if(list != null && list.size() > 0){
				BookDao dao = new BookDao();		//创建BookDao对象
				dao.saveAllBooks(list);				//批量保存数据
				session.removeAttribute("books");	//将数据从Session中移除
				info = "所有图书保存成功！";
			}
			request.setAttribute("info", info);
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}
}
