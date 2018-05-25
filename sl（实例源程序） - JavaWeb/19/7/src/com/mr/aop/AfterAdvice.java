package com.mr.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.apache.log4j.Logger;

public class AfterAdvice implements AfterReturningAdvice {

	private  static Logger logger = Logger.getLogger(AfterAdvice.class.getName());
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		logger.info("After通知开始。。。。。。");//利用log4j输出信息
		if (method.getName().equals("executeInsert")){
			if ( target instanceof  UserInterface ){//后置通知执行后关闭数据库连接
				UserInterface di=(UserInterface) target;
				di.closeConn();//关闭数据库连接
			}
		}
	}
}
