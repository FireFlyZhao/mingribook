package com.lzw;

import java.awt.*;

import javax.swing.*;

public class JListTest extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JListTest() {
		Container cp = getContentPane();
		
		cp.setLayout(null);
		JList<String> jl = new JList<>(new MyListModel());
		JScrollPane js = new JScrollPane(jl);
		js.setBounds(10, 10, 100, 100);
		cp.add(js);
		setTitle("�����������ʹ�����б��");
		setSize(200, 150);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String args[]) {
		new JListTest();
	}
}

class MyListModel extends AbstractListModel<String> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] contents = { "�б�1", "�б�2", "�б�3", "�б�4", "�б�5", "�б�6" };
	
	public String getElementAt(int x) {
		if (x < contents.length)
			return contents[x++];
		else
			return null;
	}
	
	public int getSize() {
		return contents.length;
	}
}
