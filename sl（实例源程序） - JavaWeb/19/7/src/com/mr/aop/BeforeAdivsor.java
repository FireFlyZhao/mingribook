package com.mr.aop;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;
import javax.servlet.http.HttpServletRequest;

public class BeforeAdivsor implements MethodBeforeAdvice {
    
    private static Logger logger = Logger
            .getLogger(AfterAdvice.class.getName());
    
    public void before(Method arg0, Object[] arg1, Object arg2)
            throws Throwable {
        logger.info("Before通知开始。。。。。。。");
        if (arg2 instanceof UserInterface) {
            UserInterface di = (UserInterface) arg2;// arg2为目标对象
            di.getConn();//调用getConn()创建连接
        }      
        //以下是将getConn()创建的连接状态，传递给ExecuteInsert实现类
        ConnClass ci = (ConnClass) arg2;//转换为抽象类对象
        ExecuteInsert bi = (ExecuteInsert) arg2;//转换为实现类对象
        //将连接状态设置给实现类。目的是让execute方法执行前获先得连接
        bi.setState(ci.getStmt());
    }
    
}