package com.mr.log;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggerExecute implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        before();//ִ��ǰ��֪ͨ
        invocation.proceed();
        return null;
    }
    //ǰ��֪ͨ
    private void before() {
        System.out.println("����ʼִ�У�");
    }
}
