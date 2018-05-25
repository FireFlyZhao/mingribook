package com.lyq.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author Li Yongqiang
 * Map���͵�request��session��application
 */
public class TestAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	// Map���͵�request
	private Map<String, Object> request;
	// Map���͵�session
	private Map<String, Object> session;
	// Map���͵�application
	private Map<String, Object> application;
	// ���췽��
	@SuppressWarnings("unchecked")
	public TestAction(){
		// ��ȡActionContext����
		ActionContext context = ActionContext.getContext();
		// ��ȡMap���͵�request
		request = (Map<String, Object>) context.get("request");
		// ��ȡMap���͵�session
		session = context.getSession();
		// ��ȡMap���͵�application
		application = context.getApplication();
	}
	/**
	 * ��������
	 * @return String
	 */
	public String execute() throws Exception{
		// �ַ�����Ϣ
		String info = "���տƼ�";
		// ��request�����Ϣ
		request.put("info", info);
		// ��session�����Ϣ
		session.put("info", info);
		// ��application�����Ϣ
		application.put("info", info);
		// �ɹ�����
		return SUCCESS;
	}
}
