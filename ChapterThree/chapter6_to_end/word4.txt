package chapter.fifteen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FTest extends JFrame {
	private JScrollPane scrollPane;
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextArea jTextArea = null;
	private JPanel controlPanel = null;
	private JButton openButton = null;
	private JButton closeButton = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FTest thisClass = new FTest();
		thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thisClass.setVisible(true);
	}

	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getjTextArea());
		}
		return scrollPane;
	}

	public JPanel getjContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getScrollPane(), BorderLayout.CENTER);
			jContentPane.add(getControlPanel(),BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	public JTextArea getjTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
		}
		return jTextArea;
	}

	public JPanel getControlPanel() {
		if (controlPanel == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setVgap(1);
			controlPanel = new JPanel();
			controlPanel.setLayout(flowLayout);
			controlPanel.add(getOpenButton(),null);
			controlPanel.add(getCloseButton(), null);
		}
		return controlPanel;
	}

	public JButton getOpenButton() {
		if (openButton == null) {
			openButton = new JButton();
			openButton.setText("写入文件");
			openButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					File file = new File("word4.txt");
					try {
						FileWriter out = new FileWriter(file);
						String s = jTextArea.getText();
						out.write(s);
						out.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
		}
		return openButton;
	}

	public JButton getCloseButton() {
		if (closeButton == null) {
			closeButton = new JButton();
			closeButton.setText("读取文件");
			closeButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					File file = new File("word4.txt");
					try {
						FileReader in = new FileReader(file);
						char byt[] = new char[1024];
						int len = in.read(byt);
						jTextArea.setText(new String(byt, 0 ,len));
						in.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return closeButton;
	}
	
	public FTest() {
		super();
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		this.setSize(300, 200);
		this.setContentPane(getjContentPane());
		this.setTitle("JFrame");
	}
	
}
