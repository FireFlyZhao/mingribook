package com.lyq.action;
import com.opensymphony.xwork2.ActionSupport;

public class GreetingAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// 用户名
	private String username;
	// 处理请求
	@Override
	public String execute() throws Exception{
		// 判断用户名是否有效
	if(username == null || "".equals(username)){
			// 返回到错误页面
			return ERROR;
		}else{
			// 返回到成功页面
			return SUCCESS;
		}
	}
	// username属性的getter方法
	public String getUsername() {
		return username;
	}
	// username属性的setter方法
	public void setUsername(String username) {
		this.username = username;
	}
}

