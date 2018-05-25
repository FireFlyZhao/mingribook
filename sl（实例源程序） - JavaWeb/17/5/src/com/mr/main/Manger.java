package com.mr.main;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;

import com.mr.hibernate.HibernateInitialize;
import com.mr.role.Role;
import com.mr.user.User;

public class Manger {
	public static void main(String[] args) {
		Session session = null;			//声明一个Session对象
		try {
			//Hibernate的持久化操作
			session = HibernateInitialize.getSession();//获取Session
			session.beginTransaction();//事务开启
			User user = (User)session.get(User.class, new Integer("1"));//装载用户对象
			Set<Role> roles= user.getRoles();//获取权限名称集合
			System.out.println(user.getName()+"用户所拥有的权限为：");
			//通过迭代输出权限信息
			for (Iterator<Role> it = roles.iterator(); it.hasNext();) {
				Role roles2 = (Role) it.next();
				System.out.print(roles2.getRoleName()+"||");
			}
			System.out.println();//换行
			Role rol = (Role)session.get(Role.class, new Integer("2"));
			Set<User> users = rol.getUsers();//获取用户名称集合
			System.out.println(rol.getRoleName()+"权限被赋予用户：");
			//通过迭代输出用户信息
			for (Iterator<User> it = users.iterator(); it.hasNext();) {
				User users2 = (User) it.next();
				System.out.print(users2.getName()+"||");
			}
			session.getTransaction().commit();//事务提交
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();//事务回滚
		} finally{
			HibernateInitialize.closeSession();//关闭Session
		}
	}
}
