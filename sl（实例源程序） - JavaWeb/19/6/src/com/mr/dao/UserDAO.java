package com.mr.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mr.user.User;

public class UserDAO extends HibernateDaoSupport  {
    //�����û��ķ���
    public void insert(User user){
        this.getHibernateTemplate().save(user);
    }
}
