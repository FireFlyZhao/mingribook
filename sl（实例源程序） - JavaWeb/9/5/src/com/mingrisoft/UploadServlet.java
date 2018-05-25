package com.mingrisoft;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.core.ApplicationPart;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig()
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String path = this.getServletContext().getRealPath("/");	//��ȡ��������ַ
		Part p = request.getPart("file1");							//��ȡ�û�ѡ����ϴ��ļ�	
		if (p.getContentType().contains("image")) {					// �������ϴ���ͼ���ļ�
			ApplicationPart ap = (ApplicationPart) p;
			String fname1 = ap.getFilename();						//��ȡ�ϴ��ļ���
			int path_idx = fname1.lastIndexOf("\\") + 1;			//���ϴ��ļ������н�ȡ
			String fname2 = fname1.substring(path_idx, fname1.length());	
			p.write(path + "/upload/" + fname2);					// д�� web ��Ŀ��·���µ�upload�ļ�����
			out.write("�ļ��ϴ��ɹ�");							
		}
		else{
			  out.write("��ѡ��ͼƬ�ļ�������");
		}
	}
}
