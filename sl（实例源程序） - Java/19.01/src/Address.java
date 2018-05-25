import java.net.*;

public class Address { // 创建类
	public static void main(String[] args) {
		InetAddress ip; // 创建InetAddress对象
		try { // try语句块捕捉可能出现的异常
			ip = InetAddress.getLocalHost(); // 实例化对象
			String localname = ip.getHostName(); // 获取本机名
			String localip = ip.getHostAddress(); // 获取本IP地址
			System.out.println("本机名：" + localname);// 将本机名输出
			System.out.println("本机IP地址：" + localip); // 将本机IP输出
		} catch (UnknownHostException e) {
			e.printStackTrace(); // 输出异常信息
		}
	}
}