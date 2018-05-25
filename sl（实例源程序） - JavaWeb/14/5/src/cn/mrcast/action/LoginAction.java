package cn.mrcast.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
@Results({
	@Result(name="success",location="/success.jsp"),
	@Result(name="error" ,location="/error.jsp"),
	@Result(name="exit" ,location="/index.jsp")
}) 
public class LoginAction extends ActionSupport{
       private String username;
       private String password; 
	   public String getUsername() {
		return username;
	   }
	   public void setUsername(String username) {
		this.username = username;
	   } 
	   public String getPassword() {
		return password; 
	   }
	   public void setPassword(String password) {
		this.password = password;
	   }
       @Action("login")
	   public String execute()
	   {
		  if(username.equals("mr")&&password.equals("mrsoft"))
		  {
			  return "success";
		  }
		  else
		  { 
			  return "error"; 
		  }
	   }
       @Action("ex")
       public String exit()
	   {
	      return "exit";   
	   }  
}
