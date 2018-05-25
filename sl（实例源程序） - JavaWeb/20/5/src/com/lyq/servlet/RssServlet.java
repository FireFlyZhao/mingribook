package com.lyq.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.lyq.News;
import com.lyq.dao.NewsDao;

public class RssServlet extends HttpServlet {

	private static final long serialVersionUID = 2895903933116452743L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/xml");
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("rss");
		document.setRootElement(root);
		root.addAttribute("version", "2.0");
		
		Element channel = root.addElement("channel");
		Element title = channel.addElement("title");
		title.setText("新闻网_社会新闻");
		Element link = channel.addElement("link");
		link.setText("http://localhost:8080/FindAllServlet");
		Element desc = channel.addElement("description");
		desc.setText("新闻网");
		
		NewsDao dao = new NewsDao();
		List<News> list = dao.findAll();
		for (News news : list) {
			Element item = channel.addElement("item");
			item.addAttribute("id", String.valueOf(news.getId()));
			Element itemTitle = item.addElement("title");
			itemTitle.setText(news.getTitle());
			Element itemLink = item.addElement("link");
			itemLink.setText("http://localhost:8080/FindByIdServlet?id=" + news.getId());
			Element pubDate = item.addElement("pubDate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pubDate.setText(sdf.format(news.getCreateTime()));
		}
		
		OutputStream out = response.getOutputStream();
		OutputFormat fomart = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(out,fomart);
		xmlWriter.write(document);
		xmlWriter.flush();
		xmlWriter.close();
	}

}
