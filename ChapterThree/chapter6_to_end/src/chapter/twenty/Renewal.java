package chapter.twenty;

import java.sql.*;

public class Renewal {
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
		Renewal c = new Renewal();
		con = c.getConnection();
		try {
			sql = con.prepareStatement("select * from tb_stu");
			res = sql.executeQuery();
			System.out.println("执行增加、修改、删除前数据:");
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
			sql = con.prepareStatement("insert into tb_stu(name,sex,birthday) values(?,?,?)");
			sql.setString(1,"张一");
			sql.setString(2,"女");
			sql.setString(3,"2018-05-25");
			sql.executeUpdate();
			sql = con.prepareStatement("update tb_stu set birthday"
					+ " = ? where id = ?");
			sql.setString(1, "2012-12-02");
			sql.setInt(2, 16);
			sql.executeUpdate();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("delete from tb_stu where id = 1");
			sql = con.prepareStatement("select * from tb_stu");
			res = sql.executeQuery();
			System.out.println("执行增加、修改、删除后的数据:");
			while (res.next()) {
				String id = res.getString(1);
				String name = res.getString("name");
				String sex = res.getString("sex");
				String birthday = res.getString("birthday");
				System.out.print("编号：" + id);
				System.out.print(" 姓名：" + name);
				System.out.print(" 性别:" + sex);
				System.out.println(" 生日：" + birthday);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
