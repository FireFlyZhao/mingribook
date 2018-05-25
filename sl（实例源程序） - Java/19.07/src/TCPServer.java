// 服务器端程序
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

public class TCPServer extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServerSocket ss = null;
	private boolean bStart = false;
	
	private JTextArea taContent = new JTextArea();
	
	private int index = 0;
	
	List<Client> clients = new ArrayList<Client>();
	
	public void launchFrame() {
//		Container con = this.getContentPane();
		taContent.setEditable(false);
		
		taContent.setBackground(Color.DARK_GRAY);
		taContent.setForeground(Color.YELLOW);
		this.add(taContent);
		this.setSize(300, 350);
		this.setLocation(400, 200);
		this.setTitle("TCP Server");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tcpMonitor();
	}
	
	public void tcpMonitor() {
		try {
			ss = new ServerSocket(8888);
			bStart = true;
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try {
			while (bStart) {
				index++;
				Socket s = ss.accept();
				Client c = new Client(s);
				clients.add(c);
				
				taContent.append(s.getInetAddress().getHostAddress()
						+ " connected " + index + " clients\n");
				new Thread(c).start();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ss.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String args[]) {
		TCPServer ts = new TCPServer();
		ts.launchFrame();
	}
	
	private class Client implements Runnable {
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		Socket s = null;
		boolean bStart = false;
		
		Client(Socket s) {
			this.s = s;
			try {
				dis = new DataInputStream(s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			bStart = true;
		}
		
		public void sendToEveryClient(String str) {
			try {
				dos.writeUTF(str);
				dos.flush();
				
			} catch (IOException e) {
				index--;
				clients.remove(this);
				taContent.append(s.getInetAddress().getHostAddress()
						+ " exited " + index + " clients\n");
				System.out.println("对方退出了！我从List里面去掉了！");
			}
		}
		
		public void run() {
			try {
				while (bStart) {
					String str = dis.readUTF();
					System.out.println(str);
					for (int i = 0; i < clients.size(); i++) {
						Client c = clients.get(i);
						c.sendToEveryClient(str);
					}
				}
			} catch (EOFException e) {
				clients.remove(this);
				taContent.append(s.getInetAddress().getHostAddress()
						+ " exited " + clients.size() + " clients\n");
				System.out.println("client closed");
			} catch (SocketException e) {
				System.out.println("client closed");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (s != null)
						s.close();
					if (dis != null)
						dis.close();
					if (dos != null)
						dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
