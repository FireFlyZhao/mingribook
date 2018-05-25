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
		request.setCharacterEncoding("UTF-8");//设置编码格式
		String username = request.getParameter("username");//获取用户名
		String password = request.getParameter("password");//获取密码
		String realname = request.getParameter("realname");//获取真名
		String age = request.getParameter("age");//获取年龄
		String tel =request.getParameter("tel");//获取电话
		//执行添加操作的SQL语句
		String sql="insert into tb_user2 (username,password,realname,age,tel) values('"+username+"','"+password+"','"+realname+"','"+age+"','"+tel+"')";
		System.out.println("...........................");
		myCheckClass.executeInsert(sql);//执行添加操作
		System.out.println("...........................");
		Map map = new HashMap();
		map.put("msg", "用户注册成功");
		return new ModelAndView("index", map);
	}
}
