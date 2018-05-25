package com.mr.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mr.user.User;

public class UserDAO extends HibernateDaoSupport  {
    //保存用户的方法
    public void insert(User user){
        this.getHibernateTemplate().save(user);
    }
}
