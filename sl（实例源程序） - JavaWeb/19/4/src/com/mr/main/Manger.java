package com.mr.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.mr.dao.AddDAO;
import com.mr.user.User;

public class Manger {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");            //װ�������ļ�
        BeanFactory factory = new XmlBeanFactory(resource);
        AddDAO addDAO = (AddDAO)factory.getBean("transactionProxy");//��ȡAddDAO
        User user = new User();//ʵ����Userʵ�����
        user.setName("����");//��������
        user.setAge(30);//��������
        user.setSex("��");//�����Ա�
        addDAO.addUser(user);//ִ�����ݿ���ӷ���
    }
}
