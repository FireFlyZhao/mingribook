package com.lyq.action;
import com.opensymphony.xwork2.ActionSupport;

public class GreetingAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// �û���
	private String username;
	// ��������
	@Override
	public String execute() throws Exception{
		// �ж��û����Ƿ���Ч
	if(username == null || "".equals(username)){
			// ���ص�����ҳ��
			return ERROR;
		}else{
			// ���ص��ɹ�ҳ��
			return SUCCESS;
		}
	}
	// username���Ե�getter����
	public String getUsername() {
		return username;
	}
	// username���Ե�setter����
	public void setUsername(String username) {
		this.username = username;
	}
}

