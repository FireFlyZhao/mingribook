package com.lzw;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FocusEventTest extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FocusEventTest() {
		setSize(250,100);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container cp=getContentPane();
		getContentPane().setLayout(new FlowLayout());

		final JLabel label = new JLabel();
		getContentPane().add(label);
		JTextField jt=new JTextField("�뵥�������ı���",10);
		JTextField jt2=new JTextField("�뵥����",10);
		cp.add(jt);
		cp.add(jt2);
		jt.addFocusListener(new FocusListener(){
			//���ʧȥ����ʱ���õķ��� 
			public void focusLost(FocusEvent arg0) {
				JOptionPane.showMessageDialog(null, "�ı���ʧȥ����");
			}
			//�����ȡ���̽���ʱ���õķ���
			public void focusGained(FocusEvent arg0) {
			}
		});
		setVisible(true);
	}
	public static void main(String[] args) {
		new FocusEventTest();
	}

}
