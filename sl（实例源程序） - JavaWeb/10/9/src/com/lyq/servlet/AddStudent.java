package com.lyq.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.Student;
import com.lyq.bean.StudentDao;

/**
 * ���ѧ����Ϣ��Servlet
 * @author Li YongQiang
 *
 */
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ����response�ı���
		response.setCharacterEncoding("GB18030");
		// ��ȡPrintWriter
		PrintWriter out = response.getWriter();
		// ����request�ı���
		request.setCharacterEncoding("GB18030");
		// ��ȡ����
		String name = request.getParameter("name");
		// ��ȡ�Ա�
		String sex = request.getParameter("sex");
		// ��ȡ����
		String age = request.getParameter("age");
		// ��ȡ�༶
		String classes = request.getParameter("classes");
		// ʵ����student
		Student student = new Student(name,Integer.parseInt(age),sex,classes);	
		// ʵ����StudentDao
		StudentDao dao = new StudentDao();
		// ���ѧ����Ϣ
		int row = dao.saveStudent(student);
		if(row > 0){
			// ���³������Ϣ
			out.print("�ɹ������ " + row + "�����ݣ�");
		}else{
			out.print("���ʧ�ܣ�");
		}
		out.flush();
		out.close();
	}

}
