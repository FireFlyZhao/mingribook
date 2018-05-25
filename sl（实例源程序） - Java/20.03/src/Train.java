import java.sql.*;

public class Train { // 创建类Train
	static Connection con; // 声明Connection对象
	static Statement sql; // 声明Statement对象
	static ResultSet res; // 声明ResultSet对象
	
	public Connection getConnection() { // 与数据库连接方法
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
		Train c = new Train(); // 创建本类对象
		con = c.getConnection(); // 获取与数据库的连接
		try { // try语句捕捉异常
			sql = con.createStatement(); // 实例化Statement对象
			res = sql
					.executeQuery("select * from tb_stu where name like '张%'");// 执行SQL语句
			while (res.next()) { // 如果当前记录不是结果集中的最后一条，进入循环体
				String id = res.getString(1); // 获取id字段值
				String name = res.getString("name"); // 获取name字段值
				String sex = res.getString("sex"); // 获取sex字段值
				String birthday = res.getString("birthday"); // 获取birthday字段值
				System.out.print("编号：" + id); // 输出信息
				System.out.print(" 姓名：" + name);
				System.out.print(" 性别:" + sex);
				System.out.println(" 生日：" + birthday);
			}
		} catch (Exception e) { // 处理异常
			e.printStackTrace(); // 输出异常信息
		}
	}
}
