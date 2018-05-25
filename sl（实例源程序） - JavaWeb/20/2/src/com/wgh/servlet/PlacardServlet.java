package com.wgh.servlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.wgh.model.PlacardForm;

public class PlacardServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action"); // ��ȡaction����ֵ
		if ("query".equals(action)) { // ��ѯȫ������
			this.query(request, response);
		} else if ("modify_query".equals(action)) { // �޸Ĺ���ʱӦ�õĲ�ѯ
			this.modify_query(request, response);
		} else if ("del".equals(action)) { // ɾ������
			this.del(request, response);
		} else if ("clearAll".equals(action)) { // ɾ��ȫ��������Ϣ
			this.clearAll(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action"); // ��ȡaction����ֵ
		if ("modify".equals(action)) { // �޸Ĺ���
			this.modify(request, response);
		}
	}

	/**
	 *��ѯȫ��������Ϣ
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK"); // ������Ӧ�ı���
		String fileURL = request.getRealPath("/xml/placard.xml"); // ��ȡXML�ļ���·��
		File file = new File(fileURL);
		Document document = null; // ����Document����
		Element placard = null; // ����Element����
		List list = null; // ����List����
		String description = ""; // ���屣��������Ϣ�ı���
		String createTime = ""; // ���屣�洴�����ڵı���
		if (file.exists()) { // �ж��ļ��Ƿ���ڣ�������ڣ����ȡ���ļ�
			SAXReader reader = new SAXReader(); // ʵ����SAXReader����
			try {
				document = reader.read(new File(fileURL));// ��ȡXML�ļ���Ӧ��XML�ĵ�����
				placard = document.getRootElement(); // ��ȡ���ڵ�
				List list_item = placard.elements("info");
				description = placard.element("description").getText(); // ��ȡ������Ϣ
				createTime = placard.element("createTime").getText(); // ��ȡ��������
				int id = 0;
				String title = ""; // ����
				String content = ""; // ����
				String pubDate = ""; // ��������
				if (list_item.size() > 0) {
					list = new ArrayList();
				}
				for (int i = list_item.size(); i > 0; i--) {
					PlacardForm f = new PlacardForm();
					Element item = (Element) list_item.get(i - 1);
					id = Integer.parseInt(item.attribute("id").getValue()); // ��ȡID����
					f.setId(id);
					if (null != item.element("title").getText()) {
						title = item.element("title").getText(); // ��ȡ����
					} else {
						title = "���ޱ���";
					}
					f.setTitle(title);
					if (null != item.element("content").getText()) {
						content = item.element("content").getText(); // ��ȡ����
					} else {
						content = "��������";
					}
					f.setContent(content);
					// ��ȡ��������
					if (null != item.element("pubDate").getText()) {
						pubDate = item.element("pubDate").getText(); // ��ȡ��������
					}
					f.setPubDate(pubDate);
					list.add(f);
				}
				document.clearContent(); // �ͷ���Դ
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("createTime", createTime); // ���洴������
		request.setAttribute("description", description); // ����������Ϣ
		request.setAttribute("rssContent", list); // ���湫���б�
		request.getRequestDispatcher("placardList.jsp").forward(request,
				response);

	}

	/**
	 * �����޸�ǰ��ѯ���ݵķ���
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void modify_query(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK"); // ָ����Ӧ�ı���
		String fileURL = request.getRealPath("/xml/placard.xml"); // ��ȡXML�ļ���·��
		File file = new File(fileURL);
		Document document = null; // ����Document����
		Element placard = null; // ������ʾ���ڵ��Element����
		int id = Integer.parseInt(request.getParameter("id")); // ��ȡ����ID
		PlacardForm f = new PlacardForm();
		if (file.exists()) { // �ж��ļ��Ƿ���ڣ�������ڣ����ȡ���ļ�
			SAXReader reader = new SAXReader(); // ʵ����SAXReader����
			try {
				document = reader.read(new File(fileURL));// ��ȡXML�ļ���Ӧ��XML�ĵ�����
				placard = document.getRootElement(); // ��ȡ���ڵ�
				Element item = (Element) placard
						.selectSingleNode("/placard/info[@id='" + id + "']"); // ��ȡҪ�޸ĵĽڵ�
				if (null != item) {
					String title = ""; // ����
					String content = ""; // ����
					String pubDate = ""; // ��������

					id = Integer.parseInt(item.attributeValue("id")); // ��ȡID����
					f.setId(id);
					if (null != item.element("title").getText()) {
						title = item.element("title").getText(); // ��ȡ����
					} else {
						title = "���ޱ���";
					}
					f.setTitle(title);
					if (null != item.element("content").getText()) {
						content = item.element("content").getText(); // ��ȡ����
					} else {
						content = "��������";
					}
					f.setContent(content);
					// ��ȡ��������
					if (null != item.element("pubDate").getText()) {
						pubDate = item.element("pubDate").getText(); // ��ȡ��������
					}
					f.setPubDate(pubDate);

					document.clearContent(); // �ͷ���Դ
				}
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("placardContent", f); // ���湫����Ϣ
		request.getRequestDispatcher("modify.jsp").forward(request, response);
	}

	/**
	 * �޸Ĺ�����Ϣ
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void modify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		String fileURL = request.getRealPath("/xml/placard.xml");
		String title = request.getParameter("title"); // ����
		String content = request.getParameter("content"); // ����
		DateFormat df = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��");
		String pubDate = df.format(new java.util.Date()); // ��������
		int id = Integer.parseInt(request.getParameter("id")); // ��ȡҪɾ���Ĺ���ID
		File file = new File(fileURL);
		Document document = null;
		Element placard = null;
		if (file.exists()) { // �ж��ļ��Ƿ���ڣ�������ڣ����ȡ���ļ�
			SAXReader reader = new SAXReader(); // ʵ����SAXReader����
			try {
				document = reader.read(new File(fileURL));// ��ȡXML�ļ���Ӧ��XML�ĵ�����
				placard = document.getRootElement(); // ��ȡ���ڵ�
				Element item = (Element) placard
						.selectSingleNode("/placard/info[@id='" + id + "']"); // ��ȡҪ�޸ĵĽڵ�
				if (null != item) {
					item.element("title").setText(title);
					item.element("content").setText(content);
					item.element("pubDate").setText(pubDate);
				}
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
		// ����OutputFormat����
		OutputFormat format = OutputFormat.createPrettyPrint(); // ��ʽ��Ϊ������ʽ
		format.setEncoding("GBK"); // ����д��������
		try {
			XMLWriter writer = new XMLWriter(new FileWriter(fileURL), format);
			writer.write(document); // ����д������
			writer.close();
			document.clearContent(); // �ͷ���Դ
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out
				.println("<script>alert('�޸ĳɹ���');window.location.href='PlacardServlet?action=query';</script>");
	}

	/**
	 * ɾ��������Ϣ
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK"); // ָ����Ӧ�ı���
		String fileURL = request.getRealPath("/xml/placard.xml"); // ��ȡXML�ļ���·��
		File file = new File(fileURL);
		Document document = null; // ����Document����
		Element placard = null; // ������ʾ���ڵ��Element����
		int id = Integer.parseInt(request.getParameter("id")); // ��ȡ����ID
		if (file.exists()) { // �ж��ļ��Ƿ���ڣ�������ڣ����ȡ���ļ�
			SAXReader reader = new SAXReader(); // ʵ����SAXReader����
			try {
				document = reader.read(new File(fileURL));// ��ȡXML�ļ���Ӧ��XML�ĵ�����
				placard = document.getRootElement(); // ��ȡ���ڵ�
				Element item = (Element) placard
						.selectSingleNode("/placard/info[@id='" + id + "']"); // ��ȡҪɾ���Ľڵ�
				if (null != item) {
					placard.remove(item); // ɾ��ָ���ڵ�
				}
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
		// ����OutputFormat����
		OutputFormat format = OutputFormat.createPrettyPrint(); // ��ʽ��Ϊ������ʽ
		format.setEncoding("GBK"); // ����д��������
		try {
			XMLWriter writer = new XMLWriter(new FileWriter(fileURL), format);
			writer.write(document); // ����д������
			writer.close();
			document.clearContent(); // �ͷ���Դ
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.println("<script>alert('ɾ���ɹ���');window.location.href='PlacardServlet?action=query';</script>");
	}

	/**
	 * ɾ��ȫ��������Ϣ
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void clearAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK"); // ָ����Ӧ�ı���
		String fileURL = request.getRealPath("/xml/placard.xml"); // ��ȡXML�ļ���·��
		File file = new File(fileURL);
		Document document = null;
		if (file.exists()) { // �ж��ļ��Ƿ���ڣ�������ڣ����ȡ���ļ�
			SAXReader reader = new SAXReader(); // ʵ����SAXReader����
			try {
				document = reader.read(new File(fileURL));// ��ȡXML�ļ���Ӧ��XML�ĵ�����
				document.getRootElement().elements("info").clear(); // ɾ��ȫ��info�ڵ�
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
		// ����OutputFormat����
		OutputFormat format = OutputFormat.createPrettyPrint(); // ��ʽ��Ϊ������ʽ
		format.setEncoding("GBK"); // ����д��������
		try {
			XMLWriter writer = new XMLWriter(new FileWriter(fileURL), format);
			writer.write(document); // ����д������
			writer.close();
			document.clearContent(); // �ͷ���Դ
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out
				.println("<script>alert('ɾ��ȫ������ɹ���');window.location.href='PlacardServlet?action=query';</script>");
	}
}
