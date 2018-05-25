package com.mr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PringUserInfo {
    
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");//装载配置文件
        UserInfo ui = (UserInfo) context.getBean("user1");//获取bean
        ui.printInfo();//执行bean的打印方法
    }    
}
