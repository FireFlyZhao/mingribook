package com.mr.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.mr.hibernate.HibernateUtil;
/**
 * HQL语句分组排列
 * @author CHUNBIN
 *
 */
public class GroupBy {
    
    public static void main(String[] args) {
        Session session = null;// 实例化session对象
        try {
            session = HibernateUtil.getSession();// 获得session对象
            String hql = "select emp.sex,count(*) from Employee emp group by emp.sex";// 条件查询HQL语句
            Query q = session.createQuery(hql);// 执行查询操作
            List emplist = q.list();
            Iterator it = emplist.iterator();//使用迭代器输出返回的对象数组
            while(it.hasNext()) {
                Object[] results = (Object[])it.next();
                System.out.print("员工性别: " + results[0] + "————");
                System.out.println("人数: " + results[1]);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();// 关闭session
        }
    }
    
}
