package com.lzw;

import java.awt.*;

import javax.swing.*;

public class JTextAreaTest extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextAreaTest(){
		setSize(200,100);
		setTitle("定义自动换行的文本域");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Container cp=getContentPane();
		JTextArea jt=new JTextArea("文本域",6,6);
		jt.setLineWrap(true);//可以自动换行
		cp.add(jt);
		setVisible(true);
	}
	public static void main(String[] args) {
		new JTextAreaTest();
	}
}
