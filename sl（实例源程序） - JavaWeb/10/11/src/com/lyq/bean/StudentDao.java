package com.lyq.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * ѧ����Ϣ���ݿ����
 * @author Li YongQiang
 *
 */
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
	 * ����ɾ��
	 * @param ids
	 */
	public void delete(int[] ids){
		// ���ݿ�����
		Connection conn = getConnection();
		try {
			// ���ѧ����Ϣ��SQL���
			String sql = "delete from tb_student_del where id = ?";
			// ��ȡPreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			// ͨ��ѭ�����������
			for(int id : ids){
				// ��SQL����еĵ�1��������ֵ
				ps.setInt(1, id);
				// ���������
				ps.addBatch();
			}
			// ִ��������
			ps.executeBatch();
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
	}
	/**
	 * ��ѯ����ѧ����Ϣ
	 * @return List<Student>
	 */
	public List<Student> findStudent(){
		// ���ݿ�����
		Connection conn = getConnection();
		// ʵ����List����
		List<Student> list = new ArrayList<Student>();
		try {
			// ��ȡStatement
			Statement stmt = conn.createStatement();
			// ���ͼ����Ϣ��SQL���
			String sql = "select * from tb_student_del";
			// ִ�в�ѯ
			ResultSet rs = stmt.executeQuery(sql);
			// �������ƶ������ж��Ƿ���Ч
			while(rs.next()){
				// ʵ����Book����
				Student student = new Student();
				// ��id���Ը�ֵ
				student.setId(rs.getInt("id"));
				// ��name���Ը�ֵ
				student.setName(rs.getString("name"));
				// ��sex���Ը�ֵ
				student.setSex(rs.getString("sex"));
				// ��age���Ը�ֵ
				student.setAge(rs.getInt("age"));
				// ��classes���Ը�ֵ
				student.setClasses(rs.getString("classes"));
				// ��ͼ�������ӵ�������
				list.add(student);
			}
			rs.close();		// �ر�ResultSet
			stmt.close();	// �ر�Statement
			conn.close();	// �ر�Connection
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
