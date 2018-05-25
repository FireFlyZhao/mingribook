package com.lyq;

import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Main {
	public static void main(String[] args) {
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
		
		try {
			// ����OutputFormat
			OutputFormat format = OutputFormat.createPrettyPrint();
			// ����XMLWriter
			XMLWriter xmlWriter = new XMLWriter(new OutputStreamWriter(System.out),format);
			// ���xml�ĵ�
			xmlWriter.write(document);
			xmlWriter.flush();
			xmlWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
