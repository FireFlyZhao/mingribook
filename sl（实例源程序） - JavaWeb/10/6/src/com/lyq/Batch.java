package com.lyq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
/**
 * ������
 * @author Li YongQiang
 */
public class Batch {
	/**
	 * ��ȡ���ݿ�����
	 * @return Connection����
	 */
	public Connection getConnection(){
		// ���ݿ�����
		Connection conn = null;
		try {
			// �������ݿ�������ע�ᵽ����������
			Class.forName("com.mysql.jdbc.Driver");
			// ���ݿ������ַ���
			String url = "jdbc:mysql://localhost:3306/db_database10";
			// ���ݿ��û���
			String username = "root";
			// ���ݿ�����
			String password = "111";
			// ����Connection����
			conn = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// �������ݿ�����
		return conn;
	}
	/**
	 * �����������
	 * @return ��Ӱ�������
	 */
	public int saveBatch(){
		// ����
		int row = 0 ;
		// ��ȡ���ݿ�����
		Connection conn = getConnection();
		try {
			// �������ݵ�SQL���
			String sql = "insert into tb_student_batch(id,name,sex,age) values(?,?,?,?)";
			// ����PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			// ʵ����Random
			Random random = new Random();
			// ѭ���������
			for (int i = 0; i < 10; i++) {
				// ��SQL����еĵ�1��������ֵ
				ps.setInt(1, i+1);
				// ��SQL����еĵ�2��������ֵ
				ps.setString(2, "ѧ��" + i);
				// ��SQL����еĵ�3��������ֵ
				ps.setBoolean(3, i % 2 == 0 ? true : false);
				// ��SQL����еĵ�4��������ֵ
				ps.setInt(4, random.nextInt(5) + 10);
				// �������������
				ps.addBatch();
			}
			// ִ����������������ؼ�����ɵ�����
			int[] rows = ps.executeBatch();
			// ��������ֵ
			row = rows.length;
			// �ر�PreparedStatement
			ps.close();
			// �ر�Connection
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ������ӵ�����
		return row;
	}
}
