package com.lzw;
import java.io.*;
import java.net.*;

public class MyTcp { // 创建类MyTcp
	private BufferedReader reader; // 创建BufferedReader对象
	private ServerSocket server; // 创建ServerSocket对象
	private Socket socket; // 创建Socket对象socket
	
	void getserver() {
		try {
			server = new ServerSocket(8998); // 实例化Socket对象
			System.out.println("服务器套接字已经创建成功"); // 输出信息
			while (true) { // 如果套接字是连接状态
				System.out.println("等待客户机的连接"); // 输出信息
				socket = server.accept(); // 实例化Socket对象
				reader = new BufferedReader(new InputStreamReader(socket
						.getInputStream())); // 实例化BufferedReader对象
				getClientMessage(); // 调用getClientMessage()方法
			}
		} catch (Exception e) {
			e.printStackTrace(); // 输出异常信息
		}
	}
	
	private void getClientMessage() {
		try {
			while (true) { // 如果套接字是连接状态
				if (reader.ready()) {
					// 获得客户端信息
					System.out.println("客户机:" + reader.readLine());
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); // 输出异常信息
		}
		try {
			if (reader != null) {
				reader.close(); // 关闭流
			}
			if (socket != null) {
				socket.close(); // 关闭套接字
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) { // 主方法
		MyTcp tcp = new MyTcp(); // 创建本类对象
		tcp.getserver(); // 调用方法
	}
}
