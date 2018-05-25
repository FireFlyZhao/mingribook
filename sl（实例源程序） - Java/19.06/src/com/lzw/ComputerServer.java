package com.lzw;

import java.io.*;
import java.net.*;

/**
 * @author Administrator
 */
public class ComputerServer {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8001);
			while (!ss.isClosed()) {
				Socket s = ss.accept();
				InputStream ips = s.getInputStream();
				OutputStream ops = s.getOutputStream();
				String str = "欢迎进入程序\n2．编写TCP服务器程序，"
						+ "实现创建一个在8001端口上等待的ServerSocket"
						+ "对象，当接收到一个客户机的连接请求后，"
						+ "程序从与客户机建立了连接的Socket对象中获得输入输出"
						+ "流。通过输出流向客户机发送信息。";
				ops.write(str.getBytes());
				byte[] buf = new byte[1024];
				int len = 0;
				if (ips.available() > 0)
					len = ips.read(buf);
				System.out.println(new String(buf, 0, len));
				ips.close();
				ops.close();
				s.close();
			}
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
