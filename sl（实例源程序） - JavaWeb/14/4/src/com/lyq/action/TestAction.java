package com.lyq.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author Li Yongqiang
 * Map类型的request、session、application
 */
public class TestAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	// Map类型的request
	private Map<String, Object> request;
	// Map类型的session
	private Map<String, Object> session;
	// Map类型的application
	private Map<String, Object> application;
	// 构造方法
	@SuppressWarnings("unchecked")
	public TestAction(){
		// 获取ActionContext对象
		ActionContext context = ActionContext.getContext();
		// 获取Map类型的request
		request = (Map<String, Object>) context.get("request");
		// 获取Map类型的session
		session = context.getSession();
		// 获取Map类型的application
		application = context.getApplication();
	}
	/**
	 * 请求处理方法
	 * @return String
	 */
	public String execute() throws Exception{
		// 字符串信息
		String info = "明日科技";
		// 向request添加信息
		request.put("info", info);
		// 向session添加信息
		session.put("info", info);
		// 向application添加信息
		application.put("info", info);
		// 成功返回
		return SUCCESS;
	}
}
