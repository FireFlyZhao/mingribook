package com.mr.aop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public abstract class ConnClass implements UserInterface {
    private static Logger logger = Logger
            .getLogger(AfterAdvice.class.getName());
    
    private Connection Con = null;
    
    private Statement Stmt = null;
    
    public Connection getCon() {
        return Con;
    }
    
    public void setCon(Connection con) {
        Con = con;
    }
    
    public Statement getStmt() {
        return this.Stmt;
    }
    
    public void setStmt(Statement stmt) {
        Stmt = stmt;
    }
    
    // 获取数据连接
    public void getConn() {       
        String url = "jdbc:mysql://localhost:3306/db_database13";//连接数据的URL       
        try {
            Class.forName("com.mysql.jdbc.Driver");//数据库驱动
            Con = DriverManager.getConnection(url, "root", "111");//连接数据库
            logger.info("Connection 已经创建!");
            Stmt = Con.createStatement();//创建连接状态
            logger.info("Statement 已经创建!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // 关闭数据库
    public void close() {
        if (this.Con != null)
            if (this.Stmt != null) {
                try {
                    this.Con.close();
                    logger.info("Connection 已关闭!");
                    this.Stmt.close();
                    logger.info("Statement 已关闭!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }
}
