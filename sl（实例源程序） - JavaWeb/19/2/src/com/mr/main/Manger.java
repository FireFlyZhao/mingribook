package com.mr.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.mr.dao.UserDAO;
import com.mr.user.User;

public class Manger {
    
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");            //装载配置文件
        BeanFactory factory = new XmlBeanFactory(resource);
        User user = new User();//实例化User对象
        user.setName("张三");//设置姓名
        user.setAge(new Integer(30));//设置年龄
        user.setSex("男");//设置性别
        UserDAO userDAO = (UserDAO) factory.getBean("userDAO");//获取UserDAO
        userDAO.inserUser(user);//执行添加方法
        System.out.println("数据添加成功!!!");          
    }
}
