package com.lyq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
/**
 * 批处理
 * @author Li YongQiang
 */
public class Batch {
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
			String url = "jdbc:mysql://localhost:3306/db_database10";
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
	 * 批量添加数据
	 * @return 所影响的行数
	 */
	public int saveBatch(){
		// 行数
		int row = 0 ;
		// 获取数据库连接
		Connection conn = getConnection();
		try {
			// 插入数据的SQL语句
			String sql = "insert into tb_student_batch(id,name,sex,age) values(?,?,?,?)";
			// 创建PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			// 实例化Random
			Random random = new Random();
			// 循环添加数据
			for (int i = 0; i < 10; i++) {
				// 对SQL语句中的第1个参数赋值
				ps.setInt(1, i+1);
				// 对SQL语句中的第2个参数赋值
				ps.setString(2, "学生" + i);
				// 对SQL语句中的第3个参数赋值
				ps.setBoolean(3, i % 2 == 0 ? true : false);
				// 对SQL语句中的第4个参数赋值
				ps.setInt(4, random.nextInt(5) + 10);
				// 添加批处理命令
				ps.addBatch();
			}
			// 执行批处理操作并返回计数组成的数组
			int[] rows = ps.executeBatch();
			// 对行数赋值
			row = rows.length;
			// 关闭PreparedStatement
			ps.close();
			// 关闭Connection
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回添加的行数
		return row;
	}
}
