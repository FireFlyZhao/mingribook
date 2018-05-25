package com.mr.dao;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mr.user.User;
/**
 * ִ����Ϣ�������
 */
public class DAOSupport extends HibernateDaoSupport {
	public void InsertPatchInfo(int count,HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name");//�û�����
		String business = request.getParameter("business");//ְ��
		HibernateTemplate template = this.getHibernateTemplate();//ʵ����Hibernateģ��
		for(int i = 0; i < count ; i++){//����ִ����ӷ���
			User userVO = new User();//ʵ�������� 
			userVO.setName(name+i);//�����û���
			userVO.setBusiness(business);//����ְ��
			userVO.setAddTime(new Date());//�������ʱ��
			template.save(userVO);//ִ����ӷ���
		}	
	}
}
