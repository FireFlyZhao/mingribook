package com.lyq.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * ���ݿ����ӹ�����
 * @author Li Yong Qiang
 */
public class DataBaseUtil {
	/**
	 * ��ȡ���ݿ�����
	 * @return Connection����
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			// ��������
			Class.forName("com.mysql.jdbc.Driver");
			// ���ݿ�����url
			String url = "jdbc:mysql://localhost:3306/db_database09";
			// ��ȡ���ݿ�����
			conn = DriverManager.getConnection(url, "root", "111");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * �ر����ݿ�����
	 * @param conn Connection����
	 */
	public static void closeConnection(Connection conn){
		// �ж�conn�Ƿ�Ϊ��
		if(conn != null){
			try {
				conn.close();	// �ر����ݿ�����
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
