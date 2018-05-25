package chapter.nineteen;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

public class TCPClient extends JFrame {
	private static final long serialVersionUID = 1L;
	TextArea taContent = new TextArea();
	JTextField tfTxt = new JTextField(20);
	
	JButton send = new JButton("发送");
	JButton connect = new JButton("连接");
	JButton clear = new JButton("清空");
	
	boolean live = false;
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	Socket s = null;
	DataOutputStream dos = null;
	DataInputStream dis = null;
	
	boolean bConnected = false;
	
	Thread t = new Thread(new RecToServer());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TCPClient tc = new TCPClient();
		tc.launchFrame();
	}
	
	private class RecToServer implements Runnable{
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while (bConnected) {
					String str = dis.readUTF();
					taContent.append(str + "\n");
				}
			}catch(SocketException e){
				System.out.println("服务器已关闭");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void launchFrame() {
		taContent.setEditable(false);
		
		p2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		p2.add(send);
		p2.add(connect);
		p2.add(clear);
		
		Container con = this.getContentPane();
		
		con.add(taContent, "North");
		con.add(tfTxt, "Center");
		con.add(p2, "South");
		
		this.setSize(300, 350);
		this.setLocation(400, 200);
		this.setTitle("Chat Client");
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		connect.addActionListener(new Connect());
		send.addActionListener(new SendMsg());
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				taContent.setText("");
			}
		});
		
		
	}
	
	private class Connect implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand() == "连接") {
				connectToServer();
				try {
					t.start();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				connect.setText("断开连接");
			}else if (e.getActionCommand() == "断开连接") {
				disConnect();
				connect.setText("连接");
			}
		}
		
		
	}
	
	public void disConnect() {
		try {
			if (s != null) {
				s.close();
			}
			
			if (dos != null) {
				dos.close();
			}
			if (dis != null) {
				dis.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void connectToServer() {
		try {
			s = new Socket("127.0.0.1", 8888);
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			
			bConnected = true;
			
		} catch (BindException e) {
			// TODO: handle exception
			System.out.println("找不到指定的服务器");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private class SendMsg implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (connect.getActionCommand() == "连接") {
				JOptionPane.showMessageDialog(TCPClient.this, "没有找到指定的服务器", "错误提示", 1);
			}else {
				String str = tfTxt.getText();
				tfTxt.setText("");
				try {
					dos.writeUTF(str);
					dos.flush();
				} catch (SocketException ex) {	
					System.out.println("没有找到指定的服务器");
					JOptionPane.showMessageDialog(TCPClient.this,
							"没有找到指定的服务器", "错误提示", 1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		}
		
	}
	
}
