package com.mr.aop;

import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * ���ݿ����
 * 
 * @author CHUNBIN
 */
public class ExecuteInsert extends ConnClass {
    // ������־
    private static Logger logger = Logger
            .getLogger(AfterAdvice.class.getName());
    private Statement state;
    
    public Statement getState() {
        return state;
    }
    
    public void setState(Statement state) {
        this.state = state;
    }
    
    // ִ����ӷ���
    public void executeInsert(String sql) {
        try {
            this.state.execute(sql);
            logger.info("ע��ɹ���");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    // �ر���������
    public void closeConn() {
        super.close();
        if (this.state != null) {
            try {
                this.state.close();
                logger.info("���ݿ�رճɹ�!");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
