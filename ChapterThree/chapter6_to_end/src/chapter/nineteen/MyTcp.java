package chapter.nineteen;

import java.io.*;
import java.net.*;

public class MyTcp {
	private BufferedReader reader;
	private ServerSocket server;
	private Socket socket;

	void getserver() {
		try {
			server = new ServerSocket(8998);
			System.out.println("�������׽����Ѿ������ɹ�");
			while (true) {
				System.out.println("�ȴ��ͻ���������");
				socket = server.accept();
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getClientMessage();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getClientMessage() {
		try {
			while (true) {
				if (reader.ready()) {
					System.out.println("�ͻ���:" + reader.readLine());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			if (reader != null) {
				reader.close();
			}
			if (socket != null) {
				socket.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTcp tcp = new MyTcp();
		tcp.getserver();
	}

}
