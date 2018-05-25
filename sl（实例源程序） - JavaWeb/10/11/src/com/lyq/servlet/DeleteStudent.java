package com.lyq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.StudentDao;

/**
 * 批量删除学生
 * @author Li YongQiang
 *
 */
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取要删除的id
		String[] allId = request.getParameterValues("id");
		// 判断allId是否有效
		if(allId != null && allId.length > 0){
			// 创建ids数组
			int[] ids = new int[allId.length];
			// 遍历allId
			for(int i=0; i<allId.length; i++){
				// 对ds数组赋值
				ids[i] = Integer.parseInt(allId[i]);
			}
			// 实例化StudentDao
			StudentDao dao = new StudentDao();
			// 批量删除
			dao.delete(ids);
		}
		// 重定向到FindStudent
		response.sendRedirect("FindStudent");
	}

}
