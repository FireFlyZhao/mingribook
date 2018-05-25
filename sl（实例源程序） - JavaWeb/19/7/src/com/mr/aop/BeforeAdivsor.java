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
        logger.info("Before֪ͨ��ʼ��������������");
        if (arg2 instanceof UserInterface) {
            UserInterface di = (UserInterface) arg2;// arg2ΪĿ�����
            di.getConn();//����getConn()��������
        }      
        //�����ǽ�getConn()����������״̬�����ݸ�ExecuteInsertʵ����
        ConnClass ci = (ConnClass) arg2;//ת��Ϊ���������
        ExecuteInsert bi = (ExecuteInsert) arg2;//ת��Ϊʵ�������
        //������״̬���ø�ʵ���ࡣĿ������execute����ִ��ǰ���ȵ�����
        bi.setState(ci.getStmt());
    }
    
}