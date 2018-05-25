import java.sql.*;

public class Gradation { // 创建类
	static Connection con; // 声明Connection对象
	static Statement sql; // 声明Statement对象
	static ResultSet res; // 声明ResultSet对象

	public Connection getConnection() { // 连接数据库方法

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:"
					+ "//127.0.0.1:3306/test", "root", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con; // 返回Connection对象
	}

	public static void main(String[] args) { // 主方法
		Gradation c = new Gradation(); // 创建本类对象
		con = c.getConnection(); // 与数据库建立连接
		try {
			sql = con.createStatement(); // 实例化Statement对象
			// 执行SQL语句，返回结果集
			res = sql.executeQuery("select * from tb_stu");
			while (res.next()) { // 如果当前语句不是最后一条则进入循环
				String id = res.getString("id"); // 获取列名是"id"的字段值
				// 获取列名是"name"的字段值
				String name = res.getString("name");
				// 获取列名是"sex"的字段值
				String sex = res.getString("sex");
				// 获取列名是"birthday"的字段值
				String birthday = res.getString("birthday");
				System.out.print("编号：" + id); // 将列值输出
				System.out.print(" 姓名:" + name);
				System.out.print(" 性别:" + sex);
				System.out.println(" 生日：" + birthday);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
