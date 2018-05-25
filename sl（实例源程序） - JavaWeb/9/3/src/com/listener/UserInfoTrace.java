package com.listener;
import javax.servlet.http.HttpSessionBindingEvent;

public class UserInfoTrace implements javax.servlet.http.HttpSessionBindingListener {
  private String user;
  private UserInfoList container = UserInfoList.getInstance();


  public UserInfoTrace() {
    user = "";
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getUser() {
    return this.user;
  }

  public void valueBound(HttpSessionBindingEvent arg0) {
    System.out.println("����" + this.user);

  }

  public void valueUnbound(HttpSessionBindingEvent arg0) {
    System.out.println("����" + this.user);
    if (user != "") {
  container.removeUserInfo(user);
    }
  }

}
