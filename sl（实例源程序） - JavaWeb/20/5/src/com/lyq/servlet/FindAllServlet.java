package com.lyq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.News;
import com.lyq.dao.NewsDao;

public class FindAllServlet extends HttpServlet {
	private static final long serialVersionUID = -4168051337619597253L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		NewsDao dao = new NewsDao();
		List<News> list = dao.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("news_list.jsp").forward(request, response);
	}

}
