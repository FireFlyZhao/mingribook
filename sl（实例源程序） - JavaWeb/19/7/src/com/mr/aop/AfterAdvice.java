package com.mr.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.apache.log4j.Logger;

public class AfterAdvice implements AfterReturningAdvice {

	private  static Logger logger = Logger.getLogger(AfterAdvice.class.getName());
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		logger.info("After֪ͨ��ʼ������������");//����log4j�����Ϣ
		if (method.getName().equals("executeInsert")){
			if ( target instanceof  UserInterface ){//����ִ֪ͨ�к�ر����ݿ�����
				UserInterface di=(UserInterface) target;
				di.closeConn();//�ر����ݿ�����
			}
		}
	}
}
