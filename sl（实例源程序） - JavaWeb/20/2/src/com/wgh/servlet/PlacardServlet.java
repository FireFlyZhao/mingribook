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
		String action = request.getParameter("action"); // 获取action参数值
		if ("query".equals(action)) { // 查询全部公告
			this.query(request, response);
		} else if ("modify_query".equals(action)) { // 修改公告时应用的查询
			this.modify_query(request, response);
		} else if ("del".equals(action)) { // 删除公告
			this.del(request, response);
		} else if ("clearAll".equals(action)) { // 删除全部公告信息
			this.clearAll(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action"); // 获取action参数值
		if ("modify".equals(action)) { // 修改公告
			this.modify(request, response);
		}
	}

	/**
	 *查询全部公告信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK"); // 设置响应的编码
		String fileURL = request.getRealPath("/xml/placard.xml"); // 获取XML文件的路径
		File file = new File(fileURL);
		Document document = null; // 声明Document对象
		Element placard = null; // 声明Element对象
		List list = null; // 声明List对象
		String description = ""; // 定义保存描述信息的变量
		String createTime = ""; // 定义保存创建日期的变量
		if (file.exists()) { // 判断文件是否存在，如果存在，则获取该文件
			SAXReader reader = new SAXReader(); // 实例化SAXReader对象
			try {
				document = reader.read(new File(fileURL));// 获取XML文件对应的XML文档对象
				placard = document.getRootElement(); // 获取根节点
				List list_item = placard.elements("info");
				description = placard.element("description").getText(); // 获取描述信息
				createTime = placard.element("createTime").getText(); // 获取创建日期
				int id = 0;
				String title = ""; // 标题
				String content = ""; // 内容
				String pubDate = ""; // 发布日期
				if (list_item.size() > 0) {
					list = new ArrayList();
				}
				for (int i = list_item.size(); i > 0; i--) {
					PlacardForm f = new PlacardForm();
					Element item = (Element) list_item.get(i - 1);
					id = Integer.parseInt(item.attribute("id").getValue()); // 获取ID属性
					f.setId(id);
					if (null != item.element("title").getText()) {
						title = item.element("title").getText(); // 获取标题
					} else {
						title = "暂无标题";
					}
					f.setTitle(title);
					if (null != item.element("content").getText()) {
						content = item.element("content").getText(); // 获取标题
					} else {
						content = "暂无内容";
					}
					f.setContent(content);
					// 获取发布日期
					if (null != item.element("pubDate").getText()) {
						pubDate = item.element("pubDate").getText(); // 获取发布日期
					}
					f.setPubDate(pubDate);
					list.add(f);
				}
				document.clearContent(); // 释放资源
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("createTime", createTime); // 保存创建日期
		request.setAttribute("description", description); // 保存描述信息
		request.setAttribute("rssContent", list); // 保存公告列表
		request.getRequestDispatcher("placardList.jsp").forward(request,
				response);

	}

	/**
	 * 进行修改前查询数据的方法
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void modify_query(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK"); // 指定响应的编码
		String fileURL = request.getRealPath("/xml/placard.xml"); // 获取XML文件的路径
		File file = new File(fileURL);
		Document document = null; // 声明Document对象
		Element placard = null; // 声明表示根节点的Element对象
		int id = Integer.parseInt(request.getParameter("id")); // 获取公告ID
		PlacardForm f = new PlacardForm();
		if (file.exists()) { // 判断文件是否存在，如果存在，则获取该文件
			SAXReader reader = new SAXReader(); // 实例化SAXReader对象
			try {
				document = reader.read(new File(fileURL));// 获取XML文件对应的XML文档对象
				placard = document.getRootElement(); // 获取根节点
				Element item = (Element) placard
						.selectSingleNode("/placard/info[@id='" + id + "']"); // 获取要修改的节点
				if (null != item) {
					String title = ""; // 标题
					String content = ""; // 内容
					String pubDate = ""; // 发布日期

					id = Integer.parseInt(item.attributeValue("id")); // 获取ID属性
					f.setId(id);
					if (null != item.element("title").getText()) {
						title = item.element("title").getText(); // 获取标题
					} else {
						title = "暂无标题";
					}
					f.setTitle(title);
					if (null != item.element("content").getText()) {
						content = item.element("content").getText(); // 获取标题
					} else {
						content = "暂无内容";
					}
					f.setContent(content);
					// 获取发布日期
					if (null != item.element("pubDate").getText()) {
						pubDate = item.element("pubDate").getText(); // 获取发布日期
					}
					f.setPubDate(pubDate);

					document.clearContent(); // 释放资源
				}
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("placardContent", f); // 保存公告信息
		request.getRequestDispatcher("modify.jsp").forward(request, response);
	}

	/**
	 * 修改公告信息
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
		String title = request.getParameter("title"); // 标题
		String content = request.getParameter("content"); // 内容
		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
		String pubDate = df.format(new java.util.Date()); // 发布日期
		int id = Integer.parseInt(request.getParameter("id")); // 获取要删除的公告ID
		File file = new File(fileURL);
		Document document = null;
		Element placard = null;
		if (file.exists()) { // 判断文件是否存在，如果存在，则获取该文件
			SAXReader reader = new SAXReader(); // 实例化SAXReader对象
			try {
				document = reader.read(new File(fileURL));// 获取XML文件对应的XML文档对象
				placard = document.getRootElement(); // 获取根节点
				Element item = (Element) placard
						.selectSingleNode("/placard/info[@id='" + id + "']"); // 获取要修改的节点
				if (null != item) {
					item.element("title").setText(title);
					item.element("content").setText(content);
					item.element("pubDate").setText(pubDate);
				}
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
		// 创建OutputFormat对象
		OutputFormat format = OutputFormat.createPrettyPrint(); // 格式化为缩进方式
		format.setEncoding("GBK"); // 设置写入流编码
		try {
			XMLWriter writer = new XMLWriter(new FileWriter(fileURL), format);
			writer.write(document); // 向流写入数据
			writer.close();
			document.clearContent(); // 释放资源
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out
				.println("<script>alert('修改成功！');window.location.href='PlacardServlet?action=query';</script>");
	}

	/**
	 * 删除公告信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK"); // 指定响应的编码
		String fileURL = request.getRealPath("/xml/placard.xml"); // 获取XML文件的路径
		File file = new File(fileURL);
		Document document = null; // 声明Document对象
		Element placard = null; // 声明表示根节点的Element对象
		int id = Integer.parseInt(request.getParameter("id")); // 获取公告ID
		if (file.exists()) { // 判断文件是否存在，如果存在，则获取该文件
			SAXReader reader = new SAXReader(); // 实例化SAXReader对象
			try {
				document = reader.read(new File(fileURL));// 获取XML文件对应的XML文档对象
				placard = document.getRootElement(); // 获取根节点
				Element item = (Element) placard
						.selectSingleNode("/placard/info[@id='" + id + "']"); // 获取要删除的节点
				if (null != item) {
					placard.remove(item); // 删除指定节点
				}
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
		// 创建OutputFormat对象
		OutputFormat format = OutputFormat.createPrettyPrint(); // 格式化为缩进方式
		format.setEncoding("GBK"); // 设置写入流编码
		try {
			XMLWriter writer = new XMLWriter(new FileWriter(fileURL), format);
			writer.write(document); // 向流写入数据
			writer.close();
			document.clearContent(); // 释放资源
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.println("<script>alert('删除成功！');window.location.href='PlacardServlet?action=query';</script>");
	}

	/**
	 * 删除全部公告信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void clearAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK"); // 指定响应的编码
		String fileURL = request.getRealPath("/xml/placard.xml"); // 获取XML文件的路径
		File file = new File(fileURL);
		Document document = null;
		if (file.exists()) { // 判断文件是否存在，如果存在，则获取该文件
			SAXReader reader = new SAXReader(); // 实例化SAXReader对象
			try {
				document = reader.read(new File(fileURL));// 获取XML文件对应的XML文档对象
				document.getRootElement().elements("info").clear(); // 删除全部info节点
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
		// 创建OutputFormat对象
		OutputFormat format = OutputFormat.createPrettyPrint(); // 格式化为缩进方式
		format.setEncoding("GBK"); // 设置写入流编码
		try {
			XMLWriter writer = new XMLWriter(new FileWriter(fileURL), format);
			writer.write(document); // 向流写入数据
			writer.close();
			document.clearContent(); // 释放资源
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out
				.println("<script>alert('删除全部公告成功！');window.location.href='PlacardServlet?action=query';</script>");
	}
}
