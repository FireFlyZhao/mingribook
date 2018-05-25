package com.lyq.bean;

import java.io.Serializable;
/**
 * 邮件对象JavaBean
 * @author Li YongQiang
 */
public class Email implements Serializable {
	//  serialVersionUID 值
	private static final long serialVersionUID = 1L;
	// Email地址
	private String mailAdd;
	// 是否是一个标准的Email地址
	private boolean eamil;
	/**
	 * 默认无参的构造方法
	 */
	public Email() {
	}
	/**
	 * 构造方法
	 * @param mailAdd Email地址
	 */
	public Email(String mailAdd) {
		this.mailAdd = mailAdd;
	}
	/**
	 * 是否是一个标准的Email地址
	 * @return 布尔值
	 */
	public boolean isEamil() {
		// 正则表达式，定义邮箱格式
		String regex = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"; 
		// matches()方法可判断字符串是否与正则表达式匹配
		if (mailAdd.matches(regex)) { 
			// eamil为真
			eamil = true;
		}
		// 返回eamil
		return eamil;
	}
	public String getMailAdd() {
		return mailAdd;
	}
	public void setMailAdd(String mailAdd) {
		this.mailAdd = mailAdd;
	}
}
