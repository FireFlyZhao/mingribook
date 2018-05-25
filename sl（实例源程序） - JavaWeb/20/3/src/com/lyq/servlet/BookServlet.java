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
		
		// ����Document����
		Document document = DocumentHelper.createDocument();
		// �������ڵ�
		Element root = DocumentHelper.createElement("Book-info");
		document.setRootElement(root);
		// ����ͼ��ڵ�
		Element book1 = root.addElement("book");
		book1.addAttribute("����", "Java��������ģ���ȫ");
		// ����ͼ��ڵ���ӽڵ�
		Element book1_price = book1.addElement("�۸�");
		book1_price.setText("79");
		// ����ͼ��ڵ���ӽڵ�
		Element book1_author = book1.addElement("����");
		book1_author.setText("���տƼ�");
		// ����ͼ��ڵ�
		Element book2 = root.addElement("book");
		book2.addAttribute("����", "JAVA�����ŵ���ͨ");
		// ����ͼ��ڵ���ӽڵ�
		Element book2_price = book2.addElement("�۸�");
		book2_price.setText("59.8");
		// ����ͼ��ڵ���ӽڵ�
		Element book2_author = book2.addElement("����");
		book2_author.setText("���տƼ�");
		// ��ȡ�����
		OutputStream out = response.getOutputStream();
		// ����XMLWriter
		XMLWriter xmlWriter = new XMLWriter(out);
		// д��xml�ĵ�
		xmlWriter.write(document);
		xmlWriter.flush();
		xmlWriter.close();
	}
}
