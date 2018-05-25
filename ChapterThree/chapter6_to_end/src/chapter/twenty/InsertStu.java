package chapter.twenty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertStu {
	static Connection con;
	static PreparedStatement sql;
	static ResultSet res;
	
	public Connection getConnection() { 

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:"
					+ "//127.0.0.1:3306/test", "root", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertStu c = new InsertStu();
		con = c.getConnection();
		try {
			sql = con.prepareStatement("insert into tb_stu(name,sex,birthday) values(?,?,?)");
			sql.setString(1, "李某");
			sql.setString(2, "女");
			sql.setString(3, "1999-10-20");
			sql.executeUpdate();
			System.out.println("数据插入成功。");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
