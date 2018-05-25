package chapter.twenty;

import java.sql.*;

public class Prep {
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
		Prep c = new Prep();
		con = c.getConnection(); 
		try {
			sql = con.prepareStatement("select * from tb_stu " + "where id = ?");
			sql.setInt(1, 4);
			res = sql.executeQuery();
			while (res.next()) {
				String id = res.getString("id");
				String name = res.getString("name");
				String sex = res.getString("sex");
				String birthday = res.getString("birthday");
				System.out.print("编号：" + id); 
				System.out.print(" 姓名:" + name);
				System.out.print(" 性别:" + sex);
				System.out.println(" 生日：" + birthday);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
