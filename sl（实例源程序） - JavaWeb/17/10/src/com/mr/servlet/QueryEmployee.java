package com.mr.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.mr.hibernate.HibernateUtil;

/**
 * 查找员工信息列表
 */
public class QueryEmployee extends HttpServlet {
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Session session = null;// 实例化session对象
        List emplist = new ArrayList();
        try {
            session = HibernateUtil.getSession();// 获得session对象
            //String hql = "from Employee emp";// 查询HQL语句
            String hql = "from Employee emp where emp.sex='男'";// 条件查询HQL语句
            Query q = session.createQuery(hql);// 执行查询操作
            emplist = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("查询失败");
        } finally {
            HibernateUtil.closeSession();// 关闭session
        }
        request.setAttribute("emplist", emplist);
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher(
                "/index.jsp");
        rd.forward(request, response);
    }
}
