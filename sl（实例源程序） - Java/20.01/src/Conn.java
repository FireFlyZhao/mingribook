import java.sql.*; //����java.sql��

public class Conn { // ������Conn
	Connection con; // ����Connection����

	public Connection getConnection() { // ��������ֵΪConnection�ķ���
		try { // �������ݿ�������
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���ݿ��������سɹ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try { // ͨ���������ݿ��URL��ȡ���ݿ����Ӷ���
			con = DriverManager.getConnection("jdbc:mysql:"
					+ "//127.0.0.1:3306/test", "root", "123456");
			System.out.println("���ݿ����ӳɹ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con; // ������Ҫ�󷵻�һ��Connection����
	}

	public static void main(String[] args) { // ������
		Conn c = new Conn(); // �����������
		c.getConnection(); // �����������ݿ�ķ���
	}
}
