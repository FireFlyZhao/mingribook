package com.mr.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.mr.transaction.TransactionExample;


public class Manger {

    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");            //装载配置文件
        BeanFactory factory = new XmlBeanFactory(resource);
        TransactionExample transactionExample = (TransactionExample) factory.getBean("transactionExample");//获取UserDAO
        transactionExample.transactionOperation();//执行添加方法
    }
}
