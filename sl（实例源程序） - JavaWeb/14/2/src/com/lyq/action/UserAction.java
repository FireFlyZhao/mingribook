package com.lyq.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 用户Action
 * @author Li Yongqiang
 */
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// 提示信息
	private String info;
	// 添加用户信息
	public String add() throws Exception{
		info = "添加用户信息";
		return "add";
	}
	// 更新用户信息
	public String update() throws Exception{
		info = "更新用户信息";
		return "update";
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}
