package com.mr.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.mr.user.User;

public class Manger extends AbstractController {
    
    private User user;//ע��User����

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //��¼��֤
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String name=request.getParameter("name");//�û���
        String password = request.getParameter("password");//����
        //��֤�û�������û���������
        if(name.equals(user.getName())&&password.equals(user.getPassword())){
            return new ModelAndView("succ");//��ת����¼�ɹ�ҳ��
        }else{
            return new ModelAndView("error");//��ת����¼ʧ��ҳ��
        }
    }
    
}
