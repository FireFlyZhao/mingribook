import java.sql.*;
public class Prep { // 创建类Perp
	static Connection con; // 声明Connection对象
	static PreparedStatement sql; // 声明预处理对象
	static ResultSet res; // 声明结果集对象
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
		Prep c = new Prep(); // 创建本类对象
		con = c.getConnection(); // 获取与数据库的连接
		try {
			// 实例化预处理对象
			sql = con.prepareStatement("select * from tb_stu"
					+ " where id = ?");
			sql.setInt(1, 4); // 设置参数
			res = sql.executeQuery(); // 执行预处理语句
			// 如果当前记录不是结果集中最后一行，则进入循环体
			while (res.next()) {
				String id = res.getString(1); // 获取结果集中第一列的值
				String name = res.getString("name"); // 获取name列的列值
				String sex = res.getString("sex"); // 获取sex列的列值
				// 获取birthday列的列值
				String birthday = res.getString("birthday");
				System.out.print("编号：" + id); // 输出信息
				System.out.print(" 姓名：" + name);
				System.out.print(" 性别:" + sex);
				System.out.println(" 生日：" + birthday);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
