package com.lyq;

import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Main {
	public static void main(String[] args) {
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
		
		try {
			// 创建OutputFormat
			OutputFormat format = OutputFormat.createPrettyPrint();
			// 创建XMLWriter
			XMLWriter xmlWriter = new XMLWriter(new OutputStreamWriter(System.out),format);
			// 输出xml文档
			xmlWriter.write(document);
			xmlWriter.flush();
			xmlWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
