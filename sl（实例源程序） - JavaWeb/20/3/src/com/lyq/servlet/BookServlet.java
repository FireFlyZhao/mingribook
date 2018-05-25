package com.lyq.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = -5565840336525362453L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/xml");
		
		// 创建Document对象
		Document document = DocumentHelper.createDocument();
		// 创建根节点
		Element root = DocumentHelper.createElement("Book-info");
		document.setRootElement(root);
		// 创建图书节点
		Element book1 = root.addElement("book");
		book1.addAttribute("名称", "Java开发典型模块大全");
		// 创建图书节点的子节点
		Element book1_price = book1.addElement("价格");
		book1_price.setText("79");
		// 创建图书节点的子节点
		Element book1_author = book1.addElement("作者");
		book1_author.setText("明日科技");
		// 创建图书节点
		Element book2 = root.addElement("book");
		book2.addAttribute("名称", "JAVA从入门到精通");
		// 创建图书节点的子节点
		Element book2_price = book2.addElement("价格");
		book2_price.setText("59.8");
		// 创建图书节点的子节点
		Element book2_author = book2.addElement("作者");
		book2_author.setText("明日科技");
		// 获取输出流
		OutputStream out = response.getOutputStream();
		// 创建XMLWriter
		XMLWriter xmlWriter = new XMLWriter(out);
		// 写出xml文档
		xmlWriter.write(document);
		xmlWriter.flush();
		xmlWriter.close();
	}
}
