package com.mr.log;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggerExecute implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        before();//执行前置通知
        invocation.proceed();
        return null;
    }
    //前置通知
    private void before() {
        System.out.println("程序开始执行！");
    }
}
