import java.net.*;

public class Address { // ������
	public static void main(String[] args) {
		InetAddress ip; // ����InetAddress����
		try { // try���鲶׽���ܳ��ֵ��쳣
			ip = InetAddress.getLocalHost(); // ʵ��������
			String localname = ip.getHostName(); // ��ȡ������
			String localip = ip.getHostAddress(); // ��ȡ��IP��ַ
			System.out.println("��������" + localname);// �����������
			System.out.println("����IP��ַ��" + localip); // ������IP���
		} catch (UnknownHostException e) {
			e.printStackTrace(); // ����쳣��Ϣ
		}
	}
}