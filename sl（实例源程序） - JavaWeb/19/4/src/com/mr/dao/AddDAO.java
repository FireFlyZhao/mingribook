package com.mr.dao;


import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.mr.user.User;

public class AddDAO extends JdbcDaoSupport {
    //����û��ķ���
    public void addUser(User user){
        //ִ����ӷ�����sql���
        String sql="insert into tb_user (name,age,sex) values('" + 
                    user.getName() + "','" + user.getAge()+ "','" + user.getSex()+ "')";
        //ִ��������ӷ���
        getJdbcTemplate().execute(sql);
        int a=0;//�����쳣���������Ƿ����óɹ�
        a=9/a;
        getJdbcTemplate().execute(sql);
    }
}
