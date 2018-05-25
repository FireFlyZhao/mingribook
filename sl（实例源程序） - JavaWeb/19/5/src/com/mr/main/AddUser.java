package com.mr.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

public class AddUser {
    //利用JdbcTemplate添加数据
    public static void main(String[] args) {
        JdbcTemplate jtl = null;
        Resource resource = new ClassPathResource("applicationContext.xml");//获取配置文件
        BeanFactory factory = new XmlBeanFactory(resource);
        jtl =(JdbcTemplate)factory.getBean("jdbcTemplate");//获取JdbcTemplate
        String sql = "insert into tb_user(name,age,sex) values ('小明','23','男')";//SQL语句
        jtl.update(sql);//执行添加操作
        System.out.println("添加操作执行成功");//输出信息
    }
}
