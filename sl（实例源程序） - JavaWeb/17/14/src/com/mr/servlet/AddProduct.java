package com.mr.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.mr.factory.Factory;
import com.mr.hibernate.HibernateInitialize;
import com.mr.product.Product;

/**
 * 添加产品信息的Servlet
 */
public class AddProduct extends HttpServlet {
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");// 产品名称
        Double price = new Double(request.getParameter("price"));// 产品价格
        Integer factoryID = new Integer(request.getParameter("factory"));// 生产商的ID
        Session session = null; // 声明一个Session对象
        try {
            // Hibernate的持久化操作
            session = HibernateInitialize.getSession();// 获取Session
            session.beginTransaction();// 事务开启
            Factory factory = new Factory();// 实例化对象
            factory = (Factory)session.get(Factory.class, factoryID);//获取生产商的实体对象
            Product product = new Product();// 实例化对象
            product.setName(name);//设置产品名称
            product.setPrice(price);//设置产品价格
            product.setFactory(factory);
            session.save(product);//保存产品信息
            session.getTransaction().commit();// 事务提交
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();// 事务回滚
        } finally {
            HibernateInitialize.closeSession();// 关闭Session
        }
        //跳转到查找产品信息列表的Servlet
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/QueryProduct");
        rd.forward(request, response);
    }
}
