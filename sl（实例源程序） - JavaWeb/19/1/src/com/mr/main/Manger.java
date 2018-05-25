package com.mr.main;

import org.springframework.aop.framework.ProxyFactory;

import com.mr.log.LoggerExecute;
import com.mr.target.Target;

public class Manger {
    //��������
    public static void main(String[] args) {
        Target target = new Target();                 //����Ŀ�����
        ProxyFactory di=new ProxyFactory();
        di.addAdvice(new LoggerExecute());
        di.setTarget(target);
        Target proxy=(Target)di.getProxy();
        proxy.execute("AOP�ļ�ʵ��");               //����ִ��execute()����
    } 
}
