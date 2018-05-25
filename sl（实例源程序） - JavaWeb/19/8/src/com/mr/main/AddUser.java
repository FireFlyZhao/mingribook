package com.mr.main;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.mr.dao.DAOSupport;

/**
 *批量添加信息的控制器
 */
public class AddUser extends AbstractController  {
	
	private DAOSupport dst;//注入DAOSupport
	
	public DAOSupport getDst() {
		return dst;
	}

	public void setDst(DAOSupport dst) {
		this.dst = dst;
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//添加信息的条数
		request.setCharacterEncoding("UTF-8");
		int count = Integer.parseInt(request.getParameter("count"));
		dst.InsertPatchInfo(count,request,response);//执行封装的批量添加方法
		Map map = new HashMap();//定义映射
		//设置添加成功时的提示信息
		map.put("succ", "信息添加成功，共添加"+count+"条信息！");
		return new ModelAndView("index",map);
	}
}
