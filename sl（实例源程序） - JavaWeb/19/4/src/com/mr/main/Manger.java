package com.mr.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.mr.dao.AddDAO;
import com.mr.user.User;

public class Manger {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");            //装载配置文件
        BeanFactory factory = new XmlBeanFactory(resource);
        AddDAO addDAO = (AddDAO)factory.getBean("transactionProxy");//获取AddDAO
        User user = new User();//实例化User实体对象
        user.setName("张三");//设置姓名
        user.setAge(30);//设置年龄
        user.setSex("男");//设置性别
        addDAO.addUser(user);//执行数据库添加方法
    }
}
