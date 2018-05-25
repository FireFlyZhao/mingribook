package com.mr.aop;

import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * 数据库管理
 * 
 * @author CHUNBIN
 */
public class ExecuteInsert extends ConnClass {
    // 定义日志
    private static Logger logger = Logger
            .getLogger(AfterAdvice.class.getName());
    private Statement state;
    
    public Statement getState() {
        return state;
    }
    
    public void setState(Statement state) {
        this.state = state;
    }
    
    // 执行添加方法
    public void executeInsert(String sql) {
        try {
            this.state.execute(sql);
            logger.info("注册成功！");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    // 关闭数据连接
    public void closeConn() {
        super.close();
        if (this.state != null) {
            try {
                this.state.close();
                logger.info("数据库关闭成功!");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
