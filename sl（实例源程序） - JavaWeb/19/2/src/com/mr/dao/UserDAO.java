package com.mr.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mr.user.User;

public class UserDAO implements UserDAOImpl {
    private DataSource dataSource;//注入DataSource
    public DataSource getDataSource() {
        return dataSource;
    }
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    //向数据表tb_user中添加数据
    public void inserUser(User user) {
        String name = user.getName();//获取姓名
        Integer age = user.getAge();//获取年龄
        String sex = user.getSex();//获取性别
        Connection conn = null;//定义Connection
        Statement stmt = null;//定义Statement   
         try {
             conn = dataSource.getConnection();//获取数据库连接
             stmt = conn.createStatement();
             stmt.execute("INSERT INTO tb_user (name,age,sex) " 
                  + "VALUES('"+name+"','" + age + "','" + sex + "')");//添加数据的SQL语句
         } catch (SQLException e) {
             e.printStackTrace();
         }
         finally {
             if(stmt != null) {
                 try {
                     stmt.close();//关闭Statement对象
                 }   
                 catch(SQLException e) {
                     e.printStackTrace();
                 }
             }
             if(conn != null) {
                 try {
                     conn.close();//关闭数据库连接
                 }
                 catch(SQLException e) {
                     e.printStackTrace();
                 }
             }
         }
    }
}
