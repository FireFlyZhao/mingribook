package com.lyq.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDao {
	/**
	 * 获取数据库连接
	 * @return Connection对象
	 */
	public Connection getConnection(){
		// 数据库连接
		Connection conn = null;
		try {
			// 加载数据库驱动，注册到驱动管理器
			Class.forName("com.mysql.jdbc.Driver");
			// 数据库连接字符串
			String url = "jdbc:mysql://localhost:3306/db_database11";
			// 数据库用户名
			String username = "root";
			// 数据库密码
			String password = "111";
			// 创建Connection连接
			conn = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 返回数据库连接
		return conn;
	}
	/**
	 * 添加学生信息
	 * @param student
	 * @return 更新影响的行数
	 */ 
	public int saveStudent(Student student){
		int row = 0;
		// 数据库连接
		Connection conn = getConnection();
		try {
			// 添加学生信息的SQL语句
			String sql = "insert into tb_student_add(name,age,sex,classes) values(?,?,?,?)";
			// 获取PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			// 对SQL语句中的第1个参数赋值
			ps.setString(1, student.getName());
			// 对SQL语句中的第2个参数赋值
			ps.setInt(2, student.getAge());
			// 对SQL语句中的第3个参数赋值
			ps.setString(3, student.getSex());
			// 对SQL语句中的第4个参数赋值
			ps.setString(4, student.getClasses());
			// 执行更新操作
			row = ps.executeUpdate();
			// 关闭PreparedStatement
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				// 关闭Connection
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
}
