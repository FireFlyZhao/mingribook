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
    
    // ��ȡ��������
    public void getConn() {       
        String url = "jdbc:mysql://localhost:3306/db_database13";//�������ݵ�URL       
        try {
            Class.forName("com.mysql.jdbc.Driver");//���ݿ�����
            Con = DriverManager.getConnection(url, "root", "111");//�������ݿ�
            logger.info("Connection �Ѿ�����!");
            Stmt = Con.createStatement();//��������״̬
            logger.info("Statement �Ѿ�����!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // �ر����ݿ�
    public void close() {
        if (this.Con != null)
            if (this.Stmt != null) {
                try {
                    this.Con.close();
                    logger.info("Connection �ѹر�!");
                    this.Stmt.close();
                    logger.info("Statement �ѹر�!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }
}
