package lee;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author  yeeku.H.lee kongyeeku@163.com
 * @version  1.0
 * <br>Copyright (C), 2005-2008, yeeku.H.Lee
 * <br>This program is protected by copyright laws.
 * <br>Program Name:
 * <br>Date: 
 */
public class LoginAction extends ActionSupport
{
	public User user;
	public String name;
	public String password;
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String execute() throws Exception 
	{
	   return SUCCESS;
	}

}