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
		setTitle("在这个窗体中使用了列表框");
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
	private String[] contents = { "列表1", "列表2", "列表3", "列表4", "列表5", "列表6" };
	
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
