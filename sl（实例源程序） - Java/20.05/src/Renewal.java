import java.sql.*;

public class Renewal { // ������
	static Connection con; // ����Connection����
	static PreparedStatement sql; // ����PreparedStatement����
	static ResultSet res; // ����ResultSet����

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:"
					+ "//127.0.0.1:3306/test", "root", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) {
		Renewal c = new Renewal(); // �����������
		con = c.getConnection(); // �����������ݿⷽ��
		try {
			sql = con.prepareStatement("select * from tb_stu"); // ��ѯ���ݿ�
			res = sql.executeQuery(); // ִ��SQL���
			System.out.println("ִ�����ӡ��޸ġ�ɾ��ǰ����:");
			while (res.next()) {
				String id = res.getString(1);
				String name = res.getString("name");
				String sex = res.getString("sex");
				String birthday = res.getString("birthday"); // ������ѯ�����
				System.out.print("��ţ�" + id);
				System.out.print(" ������" + name);
				System.out.print(" �Ա�:" + sex);
				System.out.println(" ���գ�" + birthday);
			}
			sql = con.prepareStatement("insert into tb_stu(name,sex,birthday) values(?,?,?)");
			sql.setString(1, "��һ"); // Ԥ�����������
			sql.setString(2, "Ů");
			sql.setString(3, "2012-12-1");
			sql.executeUpdate();
			sql = con.prepareStatement("update tb_stu set birthday "
					+ "= ? where id = ? ");
			sql.setString(1, "2012-12-02"); // ��������
			sql.setInt(2, 1); // ��������
			sql.executeUpdate();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("delete from tb_stu where id = 1");
			// ��ѯ�޸����ݺ��tb_stu��������
			sql = con.prepareStatement("select * from tb_stu");
			res = sql.executeQuery(); // ִ��SQL���
			System.out.println("ִ�����ӡ��޸ġ�ɾ���������:");
			while (res.next()) {
				String id = res.getString(1);
				String name = res.getString("name");
				String sex = res.getString("sex");
				String birthday = res.getString("birthday");
				System.out.print("��ţ�" + id);
				System.out.print(" ������" + name);
				System.out.print(" �Ա�:" + sex);
				System.out.println(" ���գ�" + birthday);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
