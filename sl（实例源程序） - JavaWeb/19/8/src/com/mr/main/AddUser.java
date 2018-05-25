package com.mr.main;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.mr.dao.DAOSupport;

/**
 *���������Ϣ�Ŀ�����
 */
public class AddUser extends AbstractController  {
	
	private DAOSupport dst;//ע��DAOSupport
	
	public DAOSupport getDst() {
		return dst;
	}

	public void setDst(DAOSupport dst) {
		this.dst = dst;
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//�����Ϣ������
		request.setCharacterEncoding("UTF-8");
		int count = Integer.parseInt(request.getParameter("count"));
		dst.InsertPatchInfo(count,request,response);//ִ�з�װ��������ӷ���
		Map map = new HashMap();//����ӳ��
		//������ӳɹ�ʱ����ʾ��Ϣ
		map.put("succ", "��Ϣ��ӳɹ��������"+count+"����Ϣ��");
		return new ModelAndView("index",map);
	}
}
