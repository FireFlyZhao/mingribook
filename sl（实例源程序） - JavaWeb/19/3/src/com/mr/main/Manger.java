package com.mr.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.mr.transaction.TransactionExample;


public class Manger {

    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");            //װ�������ļ�
        BeanFactory factory = new XmlBeanFactory(resource);
        TransactionExample transactionExample = (TransactionExample) factory.getBean("transactionExample");//��ȡUserDAO
        transactionExample.transactionOperation();//ִ����ӷ���
    }
}
