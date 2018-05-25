package com.mr.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.mr.user.User;

public class Manger extends AbstractController {
    
    private User user;//注入User对象

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //登录验证
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String name=request.getParameter("name");//用户名
        String password = request.getParameter("password");//密码
        //验证用户输入的用户名和密码
        if(name.equals(user.getName())&&password.equals(user.getPassword())){
            return new ModelAndView("succ");//跳转到登录成功页面
        }else{
            return new ModelAndView("error");//跳转到登录失败页面
        }
    }
    
}
