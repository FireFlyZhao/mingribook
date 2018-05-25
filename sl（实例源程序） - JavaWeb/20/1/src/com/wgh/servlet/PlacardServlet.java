package com.wgh.servlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class PlacardServlet extends HttpServlet {
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
		response.setContentType("text/html");
        String fileURL = request.getRealPath("/xml/placard.xml");		//XML�ļ���·��
		File file = new File(fileURL);
		String title=request.getParameter("title");						//��ȡ�������
		String content=request.getParameter("content");					//��ȡ��������
		Document document = null;
		Element placard = null;
		DateFormat df=new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��");	//�������ڸ�ʽ
		if (!file.exists()) { 					// �ж��ļ��Ƿ���ڣ���������ڣ��򴴽����ļ�
			document = DocumentHelper.createDocument();					//����XML�ĵ�����
			placard=DocumentHelper.createElement("placard");			//������ͨ�ڵ�
			document.setRootElement(placard); 							// ��placard����Ϊ���ڵ�
			placard.addAttribute("version", "2.0");						//Ϊ���ڵ��������version
			Element description = placard.addElement("description");	//���description�ӽڵ�
			description.setText("������");
			Element createTime = placard.addElement("createTime");		//���createTime�ӽڵ�
			createTime.setText("������"+df.format(new Date()));
		} else {
			SAXReader reader = new SAXReader(); // ʵ�ֻ�SAXReader����
			try {
				document = reader.read(new File(fileURL));//��ȡXML�ļ���Ӧ��XML�ĵ�����
				placard = document.getRootElement(); // ��ȡ���ڵ�
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
		/********************** ��ӹ�����Ϣ **************************/
		String id = String.valueOf(placard.elements("info").size() + 1); // ��ȡ��ǰ�����id��
		Element info = placard.addElement("info");		//���info�ڵ�
		info.addAttribute("id", id);					//Ϊinfo�ڵ�����ID����
		Element title_info = info.addElement("title");	//���title�ڵ�
		title_info.setText(title);							//����title�ڵ������
		Element content_item = info.addElement("content");	//���content�ڵ�
		// �˴�����ʹ��setText()���������ʹ�ø÷������������г���HTML����ʱ�����򽫳���
		content_item.addCDATA(content);						//����content�ڵ������ΪCDATA��
		Element pubDate_item = info.addElement("pubDate");	//���pubDate�ڵ�
		df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		//�������ڸ�ʽ
		pubDate_item.setText(df.format(new Date()));
		/***************************************************************/
		// �����ļ�
		
		// ����OutputFormat����
		OutputFormat format = OutputFormat.createPrettyPrint(); // ��ʽ��Ϊ������ʽ
		format.setEncoding("GBK"); 								// ����д��������
		try {
			XMLWriter writer = new XMLWriter(new FileWriter(fileURL), format);
			writer.write(document); 							// ����д������
			writer.close();										//�ر���
		} catch (IOException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("xml/placard.xml").forward(request,response);
	}
}
