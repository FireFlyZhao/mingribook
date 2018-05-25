package com.wgh.tools;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ZoneServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");		//��ȡaction������ֵ
		if("getProvince".equals(action)){	//��ȡʡ�ݺ�ֱϽ����Ϣ
			this.getProvince(request,response);
		}else if("getCity".equals(action)){	//��ȡ������Ϣ
			this.getCity(request, response);
		}
	}
	/**
	 * ��ȡʡ�ݺ�ֱϽ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getProvince(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");		//������Ӧ�ı��뷽ʽ
		String result="";
		CityMap cityMap=new CityMap();//ʵ��������ʡ����Ϣ��CityMap���ʵ��
		Map<String,String[]> map=cityMap.model;//��ȡʡ����Ϣ���浽Map��
		Set<String> set=map.keySet();		//��ȡMap�����еļ�������Set���Ϸ���
		Iterator it=set.iterator();
		while(it.hasNext()){		//����ȡ��ʡ������Ϊһ���Զ��ŷָ����ַ���
			result=result+it.next()+",";
		}
		result=result.substring(0, result.length()-1);	//ȥ�����һ������
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(result);		//�����ȡ��ʡ���ַ���
		out.flush();
		out.close();
	}
	/**
	 * ��ȡ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getCity(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");	//������Ӧ�ı��뷽ʽ
		String result="";
		String selProvince=request.getParameter("parProvince");	//��ȡѡ���ʡ��
		selProvince=new String(selProvince.getBytes("ISO-8859-1"),"GBK");
		CityMap cityMap=new CityMap();	//ʵ��������ʡ����Ϣ��CityMap���ʵ��
		Map<String,String[]> map=cityMap.model;	//��ȡʡ����Ϣ���浽Map��
		String[]arrCity= map.get(selProvince);	//��ȡָ������ֵ
		for(int i=0;i<arrCity.length;i++){		//����ȡ����������Ϊһ���Զ��ŷָ����ַ���
			result=result+arrCity[i]+",";
		}
		result=result.substring(0, result.length()-1);	//ȥ�����һ������
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(result);								//�����ȡ�������ַ���
		out.flush();
		out.close();
	}
}
