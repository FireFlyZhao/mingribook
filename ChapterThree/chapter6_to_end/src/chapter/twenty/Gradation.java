package chapter.twenty;

import java.sql.*;

public class Gradation {
	static Connection con;
	static Statement sql;
	static ResultSet res;
	
	public Connection getConnection() { // �������ݿⷽ��

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:"
					+ "//127.0.0.1:3306/test", "root", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con; // ����Connection����
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
				System.out.print("��ţ�" + id); 
				System.out.print(" ����:" + name);
				System.out.print(" �Ա�:" + sex);
				System.out.println(" ���գ�" + birthday);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
