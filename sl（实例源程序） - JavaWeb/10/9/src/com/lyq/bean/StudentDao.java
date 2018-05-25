package com.lyq.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDao {
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
			String url = "jdbc:mysql://localhost:3306/db_database11";
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
	 * ���ѧ����Ϣ
	 * @param student
	 * @return ����Ӱ�������
	 */ 
	public int saveStudent(Student student){
		int row = 0;
		// ���ݿ�����
		Connection conn = getConnection();
		try {
			// ���ѧ����Ϣ��SQL���
			String sql = "insert into tb_student_add(name,age,sex,classes) values(?,?,?,?)";
			// ��ȡPreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			// ��SQL����еĵ�1��������ֵ
			ps.setString(1, student.getName());
			// ��SQL����еĵ�2��������ֵ
			ps.setInt(2, student.getAge());
			// ��SQL����еĵ�3��������ֵ
			ps.setString(3, student.getSex());
			// ��SQL����еĵ�4��������ֵ
			ps.setString(4, student.getClasses());
			// ִ�и��²���
			row = ps.executeUpdate();
			// �ر�PreparedStatement
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				// �ر�Connection
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
}
