package com.lyq.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * �û�Action
 * @author Li Yongqiang
 */
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// ��ʾ��Ϣ
	private String info;
	// ����û���Ϣ
	public String add() throws Exception{
		info = "����û���Ϣ";
		return "add";
	}
	// �����û���Ϣ
	public String update() throws Exception{
		info = "�����û���Ϣ";
		return "update";
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}
