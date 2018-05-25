package chapter.nineteen;

import java.net.*;

public class MyHost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress ip = null;
		try {
			ip = InetAddress.getByName("localhost");
			System.out.println("主机名：" + ip.getHostName());
			System.out.println("主机IP地址：" + ip.getHostAddress());
			System.out.println("本机IP地址：" +
			InetAddress.getLocalHost().getHostAddress() );
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
