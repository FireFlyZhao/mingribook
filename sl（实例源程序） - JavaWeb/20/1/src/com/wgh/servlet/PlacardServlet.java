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
        String fileURL = request.getRealPath("/xml/placard.xml");		//XML文件的路径
		File file = new File(fileURL);
		String title=request.getParameter("title");						//获取公告标题
		String content=request.getParameter("content");					//获取公告内容
		Document document = null;
		Element placard = null;
		DateFormat df=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");	//设置日期格式
		if (!file.exists()) { 					// 判断文件是否存在，如果不存在，则创建该文件
			document = DocumentHelper.createDocument();					//创建XML文档对象
			placard=DocumentHelper.createElement("placard");			//创建普通节点
			document.setRootElement(placard); 							// 将placard设置为根节点
			placard.addAttribute("version", "2.0");						//为根节点添加属性version
			Element description = placard.addElement("description");	//添加description子节点
			description.setText("公告栏");
			Element createTime = placard.addElement("createTime");		//添加createTime子节点
			createTime.setText("创建于"+df.format(new Date()));
		} else {
			SAXReader reader = new SAXReader(); // 实现化SAXReader对象
			try {
				document = reader.read(new File(fileURL));//获取XML文件对应的XML文档对象
				placard = document.getRootElement(); // 获取根节点
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
		/********************** 添加公告信息 **************************/
		String id = String.valueOf(placard.elements("info").size() + 1); // 获取当前公告的id号
		Element info = placard.addElement("info");		//添加info节点
		info.addAttribute("id", id);					//为info节点设置ID属性
		Element title_info = info.addElement("title");	//添加title节点
		title_info.setText(title);							//设置title节点的内容
		Element content_item = info.addElement("content");	//添加content节点
		// 此处不能使用setText()方法，如果使用该方法，当内容中出现HTML代码时，程序将出错
		content_item.addCDATA(content);						//设置content节点的内容为CDATA段
		Element pubDate_item = info.addElement("pubDate");	//添加pubDate节点
		df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		//设置日期格式
		pubDate_item.setText(df.format(new Date()));
		/***************************************************************/
		// 保存文件
		
		// 创建OutputFormat对象
		OutputFormat format = OutputFormat.createPrettyPrint(); // 格式化为缩进方式
		format.setEncoding("GBK"); 								// 设置写入流编码
		try {
			XMLWriter writer = new XMLWriter(new FileWriter(fileURL), format);
			writer.write(document); 							// 向流写入数据
			writer.close();										//关闭流
		} catch (IOException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("xml/placard.xml").forward(request,response);
	}
}
