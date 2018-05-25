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
        Session session = null;// ʵ����session����
        try {
            session = HibernateUtil.getSession();// ���session����
            String hql = "from Employee emp where emp.id= (select min(id) from Employee)";// ������ѯHQL���
            Query q = session.createQuery(hql);// ִ�в�ѯ����
            List<Employee> list = q.list();
            // ���IDֵ��С��Ա����Ϣ
            for (Employee emp : list) {
                System.out.println("IDֵ��С��Ա��Ϊ�� " + emp.getName());
                System.out.println("��IDֵΪ�� " + emp.getId());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();// �ر�session
        }
    }
}
