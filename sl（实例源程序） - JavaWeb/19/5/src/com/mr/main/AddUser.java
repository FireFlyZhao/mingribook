package com.mr.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

public class AddUser {
    //����JdbcTemplate�������
    public static void main(String[] args) {
        JdbcTemplate jtl = null;
        Resource resource = new ClassPathResource("applicationContext.xml");//��ȡ�����ļ�
        BeanFactory factory = new XmlBeanFactory(resource);
        jtl =(JdbcTemplate)factory.getBean("jdbcTemplate");//��ȡJdbcTemplate
        String sql = "insert into tb_user(name,age,sex) values ('С��','23','��')";//SQL���
        jtl.update(sql);//ִ����Ӳ���
        System.out.println("��Ӳ���ִ�гɹ�");//�����Ϣ
    }
}
