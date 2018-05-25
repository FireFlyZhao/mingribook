package chapter.nineteen;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

public class TestClient extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private JTextField portField;
	private JTextField hostField;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					TestClient frame = new TestClient();
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}
	
	public TestClient() {
		super();
		setBounds(100, 100, 500, 212);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		final JLabel label = new JLabel();
		label.setText("连接主机：");
		panel.add(label);
		
		hostField = new JTextField();
		hostField.setText("localhost");
		panel.add(hostField);
		
		final JLabel label_1 = new JLabel();
		label_1.setText("端口：");
		panel.add(label_1);
		
		portField = new JTextField();
		portField.setText("8001");
		panel.add(portField);
		
		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				final String hostName = hostField.getText();
				String portNum = portField.getText();
				final int port = Integer.parseInt(portNum);
				new Thread() {
					public void run() {
						try {
							final InetAddress host = InetAddress.getByName(hostName);
							Socket socket = new Socket(host, port);
							final InputStream is = socket.getInputStream();
							InputStreamReader reader = new InputStreamReader(is);
							int data = 0;
							while ((data=reader.read()) != -1) {
								textArea.append((char)data + " ");
								textArea.revalidate();
								Thread.sleep(100);
							}
						} catch (Exception e2) {
							// TODO: handle exception
							textArea.append(e2.toString());
							e2.printStackTrace();
						}
					}
				}.start();
				
				
				
			}
		});
		button.setText("连接");
		panel.add(button);
		
		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
	}
}
