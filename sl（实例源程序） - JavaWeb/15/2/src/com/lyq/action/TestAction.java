package com.lyq.action;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	/**
	 * 请求执行
	 * @return
	 */
	public String execute() throws Exception{
		// 线程睡眠1秒
		Thread.sleep(1000);
		return SUCCESS;
	}
}
