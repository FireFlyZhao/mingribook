package chapter.nineteen;

import java.net.*;

public class MyHost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress ip = null;
		try {
			ip = InetAddress.getByName("localhost");
			System.out.println("��������" + ip.getHostName());
			System.out.println("����IP��ַ��" + ip.getHostAddress());
			System.out.println("����IP��ַ��" +
			InetAddress.getLocalHost().getHostAddress() );
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
