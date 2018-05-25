package com.mr.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.mr.employee.Employee;
import com.mr.hibernate.HibernateUtil;

public class QueryMinID {
    public static void main(String[] args) {
        Session session = null;// 实例化session对象
        try {
            session = HibernateUtil.getSession();// 获得session对象
            String hql = "from Employee emp where emp.id= (select min(id) from Employee)";// 条件查询HQL语句
            Query q = session.createQuery(hql);// 执行查询操作
            List<Employee> list = q.list();
            // 输出ID值最小的员工信息
            for (Employee emp : list) {
                System.out.println("ID值最小的员工为： " + emp.getName());
                System.out.println("其ID值为： " + emp.getId());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();// 关闭session
        }
    }
}
