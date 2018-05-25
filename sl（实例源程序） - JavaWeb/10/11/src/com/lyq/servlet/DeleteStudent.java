package com.lyq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.StudentDao;

/**
 * ����ɾ��ѧ��
 * @author Li YongQiang
 *
 */
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡҪɾ����id
		String[] allId = request.getParameterValues("id");
		// �ж�allId�Ƿ���Ч
		if(allId != null && allId.length > 0){
			// ����ids����
			int[] ids = new int[allId.length];
			// ����allId
			for(int i=0; i<allId.length; i++){
				// ��ds���鸳ֵ
				ids[i] = Integer.parseInt(allId[i]);
			}
			// ʵ����StudentDao
			StudentDao dao = new StudentDao();
			// ����ɾ��
			dao.delete(ids);
		}
		// �ض���FindStudent
		response.sendRedirect("FindStudent");
	}

}
