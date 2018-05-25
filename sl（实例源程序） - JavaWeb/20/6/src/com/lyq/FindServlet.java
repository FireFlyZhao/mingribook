package com.lyq;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 2497221668021907912L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SAXReader reader = new SAXReader();
		try {
			String file = getServletContext().getRealPath("/Student.xml");
			Document document = reader.read(new File(file));// 获取XML文件对应的XML文档对象

			Element root = document.getRootElement();
			List<Element> list = root.elements("student");
			List<Student> students = new ArrayList<Student>();
			for (Element element : list) {
				Student s = new Student();
				s.setId(Integer.valueOf(element.attributeValue("id")));
				s.setName(element.elementText("name"));
				s.setSex(element.elementText("sex"));
				s.setAge(Integer.valueOf(element.elementText("age")));
				students.add(s);
			}
			request.setAttribute("list", students);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

}
