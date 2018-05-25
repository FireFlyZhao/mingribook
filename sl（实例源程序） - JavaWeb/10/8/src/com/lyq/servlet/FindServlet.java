package com.lyq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.Product;
import com.lyq.bean.BookDao;

/**
 * Servlet implementation class FindServlet
 */
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 当前页码
		int currPage = 1;
		// 判断传递页码是否有效
		if(request.getParameter("page") != null){
			// 对当前页码赋值
			currPage = Integer.parseInt(request.getParameter("page"));
		}
		// 实例化ProductDao
		BookDao dao = new BookDao();
		// 查询所有商品信息
		List<Product> list = dao.find(currPage);
		// 将list放置到request之中
		request.setAttribute("list", list);
		// 总页数
		int pages ;
		// 查询总记录数
		int count = dao.findCount();
		// 计算总页数
		if(count % Product.PAGE_SIZE == 0){
			// 对总页数赋值
			pages = count / Product.PAGE_SIZE;
		}else{
			// 对总页数赋值
			pages = count / Product.PAGE_SIZE + 1;
		}
		// 实例化StringBuffer
		StringBuffer sb = new StringBuffer();
		// 通过循环构建分页条
		for(int i=1; i <= pages; i++){
			// 判断是否为当前页
			if(i == currPage){
				// 构建分页条
				sb.append("『" + i + "』");
			}else{
				// 构建分页条
				sb.append("<a href='FindServlet?page=" + i + "'>" + i + "</a>");
			}
			// 构建分页条
			sb.append("　");
		}
		// 将分页条的字符串放置到request之中
		request.setAttribute("bar", sb.toString());
		// 转发到product_list.jsp页面
		request.getRequestDispatcher("product_list.jsp").forward(request, response);
	}

}
