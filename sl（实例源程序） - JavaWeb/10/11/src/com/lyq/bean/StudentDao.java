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
 * 学生信息数据库操作
 * @author Li YongQiang
 *
 */
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
	 * 批量删除
	 * @param ids
	 */
	public void delete(int[] ids){
		// 数据库连接
		Connection conn = getConnection();
		try {
			// 添加学生信息的SQL语句
			String sql = "delete from tb_student_del where id = ?";
			// 获取PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			// 通过循环添加批处理
			for(int id : ids){
				// 对SQL语句中的第1个参数赋值
				ps.setInt(1, id);
				// 添加批处理
				ps.addBatch();
			}
			// 执行批处理
			ps.executeBatch();
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
	}
	/**
	 * 查询所有学生信息
	 * @return List<Student>
	 */
	public List<Student> findStudent(){
		// 数据库连接
		Connection conn = getConnection();
		// 实例化List对象
		List<Student> list = new ArrayList<Student>();
		try {
			// 获取Statement
			Statement stmt = conn.createStatement();
			// 添加图书信息的SQL语句
			String sql = "select * from tb_student_del";
			// 执行查询
			ResultSet rs = stmt.executeQuery(sql);
			// 光标向后移动，并判断是否有效
			while(rs.next()){
				// 实例化Book对象
				Student student = new Student();
				// 对id属性赋值
				student.setId(rs.getInt("id"));
				// 对name属性赋值
				student.setName(rs.getString("name"));
				// 对sex属性赋值
				student.setSex(rs.getString("sex"));
				// 对age属性赋值
				student.setAge(rs.getInt("age"));
				// 对classes属性赋值
				student.setClasses(rs.getString("classes"));
				// 将图书对象添加到集合中
				list.add(student);
			}
			rs.close();		// 关闭ResultSet
			stmt.close();	// 关闭Statement
			conn.close();	// 关闭Connection
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
