package com.mr.aop;
public interface UserInterface {	 
	public abstract void getConn();//��ȡ���ݿ����ӵķ���
	public abstract void executeInsert(String sql);//ִ����Ӳ���
	public abstract void closeConn();//�ر����ݿ�����	
}
