package com.mr.dao;


import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.mr.user.User;

public class AddDAO extends JdbcDaoSupport {
    //添加用户的方法
    public void addUser(User user){
        //执行添加方法的sql语句
        String sql="insert into tb_user (name,age,sex) values('" + 
                    user.getName() + "','" + user.getAge()+ "','" + user.getSex()+ "')";
        //执行两次添加方法
        getJdbcTemplate().execute(sql);
        int a=0;//制造异常测试事务是否配置成功
        a=9/a;
        getJdbcTemplate().execute(sql);
    }
}
