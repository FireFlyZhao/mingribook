package com.mr.mvc;

import com.mr.aop.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class CommitAction extends MultiActionController {
	
	private UserInterface myCheckClass;

	public UserInterface getMyCheckClass() {
		return myCheckClass;
	}

	public void setMyCheckClass(UserInterface myCheckClass) {
		this.myCheckClass = myCheckClass;
	}

	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//���ñ����ʽ
		String username = request.getParameter("username");//��ȡ�û���
		String password = request.getParameter("password");//��ȡ����
		String realname = request.getParameter("realname");//��ȡ����
		String age = request.getParameter("age");//��ȡ����
		String tel =request.getParameter("tel");//��ȡ�绰
		//ִ����Ӳ�����SQL���
		String sql="insert into tb_user2 (username,password,realname,age,tel) values('"+username+"','"+password+"','"+realname+"','"+age+"','"+tel+"')";
		System.out.println("...........................");
		myCheckClass.executeInsert(sql);//ִ����Ӳ���
		System.out.println("...........................");
		Map map = new HashMap();
		map.put("msg", "�û�ע��ɹ�");
		return new ModelAndView("index", map);
	}
}
