package com.mr.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.mr.dao.UserDAO;
import com.mr.user.User;

public class AddUser {
    //����û���Ϣ
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");//��ȡ�����ļ�
        BeanFactory factory = new XmlBeanFactory(resource);
        UserDAO userDAO = (UserDAO)factory.getBean("userDAO");//��ȡUserDAO
        User user = new User();
        user.setName("Spring��Hibernate����");//��������
        user.setAge(20);//��������
        user.setSex("��");//�����Ա�
        userDAO.insert(user);//ִ���û���ӵķ���
        System.out.println("��ӳɹ���");
    }
}
