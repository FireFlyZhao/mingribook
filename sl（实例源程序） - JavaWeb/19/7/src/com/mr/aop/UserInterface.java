package com.mr.aop;
public interface UserInterface {	 
	public abstract void getConn();//获取数据库连接的方法
	public abstract void executeInsert(String sql);//执行添加操作
	public abstract void closeConn();//关闭数据库连接	
}
