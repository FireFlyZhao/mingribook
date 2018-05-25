package com.mr.dao;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mr.user.User;
/**
 * 执行信息批量添加
 */
public class DAOSupport extends HibernateDaoSupport {
	public void InsertPatchInfo(int count,HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name");//用户名称
		String business = request.getParameter("business");//职务
		HibernateTemplate template = this.getHibernateTemplate();//实例化Hibernate模板
		for(int i = 0; i < count ; i++){//批量执行添加方法
			User userVO = new User();//实例化对象 
			userVO.setName(name+i);//设置用户名
			userVO.setBusiness(business);//设置职务
			userVO.setAddTime(new Date());//设置添加时间
			template.save(userVO);//执行添加方法
		}	
	}
}
