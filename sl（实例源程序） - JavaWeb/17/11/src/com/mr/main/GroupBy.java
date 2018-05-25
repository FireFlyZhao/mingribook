package com.mr.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.mr.hibernate.HibernateUtil;
/**
 * HQL����������
 * @author CHUNBIN
 *
 */
public class GroupBy {
    
    public static void main(String[] args) {
        Session session = null;// ʵ����session����
        try {
            session = HibernateUtil.getSession();// ���session����
            String hql = "select emp.sex,count(*) from Employee emp group by emp.sex";// ������ѯHQL���
            Query q = session.createQuery(hql);// ִ�в�ѯ����
            List emplist = q.list();
            Iterator it = emplist.iterator();//ʹ�õ�����������صĶ�������
            while(it.hasNext()) {
                Object[] results = (Object[])it.next();
                System.out.print("Ա���Ա�: " + results[0] + "��������");
                System.out.println("����: " + results[1]);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();// �ر�session
        }
    }
    
}
