package chapter.twenty;

import java.sql.*;

public class Gradation {
	static Connection con;
	static Statement sql;
	static ResultSet res;
	
	public Connection getConnection() { // 连接数据库方法

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:"
					+ "//127.0.0.1:3306/test", "root", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con; // 返回Connection对象
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gradation c = new Gradation();
		con = c.getConnection(); 
		try {
			sql = con.createStatement();
			res = sql.executeQuery("select * from tb_stu");
			while(res.next()) {
				String id = res.getString(1);
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
