package com.mr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PringUserInfo {
    
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");//װ�������ļ�
        UserInfo ui = (UserInfo) context.getBean("user1");//��ȡbean
        ui.printInfo();//ִ��bean�Ĵ�ӡ����
    }    
}
