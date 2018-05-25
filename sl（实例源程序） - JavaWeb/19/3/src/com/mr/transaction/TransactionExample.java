package com.mr.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class TransactionExample {
    DataSource dataSource;//ע������Դ
    PlatformTransactionManager transactionManager;//ע�����������
    TransactionTemplate transactionTemplate;//ע��TransactionTemplateģ��
    public DataSource getDataSource() {
        return dataSource;
    }
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }
    public void transactionOperation() {
        transactionTemplate.execute(new TransactionCallback() {
            public Object doInTransaction(TransactionStatus status) {
                Connection conn = DataSourceUtils.getConnection(dataSource);//������ݿ�����
                try {
                    Statement stmt = conn.createStatement();
                    //ִ��������ӷ���
                    stmt.execute("insert into tb_user(name,age,sex) values('Сǿ','26','��')");
                    int a=0;//�����쳣���������Ƿ����óɹ�
                    a=9/a;
                    stmt.execute("insert into tb_user(name,age,sex) values('С��','22','Ů')");
                    System.out.println("����ִ�гɹ���");
                } catch (Exception e) {
                    transactionManager.rollback(status);//����ع�
                    System.out.println("����ִ��ʧ�ܣ�����ع���");
                    System.out.println("ԭ��"+e.getMessage());
                }
                return null;
            }
        });
    }
}
