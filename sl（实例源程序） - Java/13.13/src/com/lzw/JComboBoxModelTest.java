package com.lzw;

import java.awt.*;

import javax.swing.*;

public class JComboBoxModelTest extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox<String> jc = new JComboBox<>(new MyComboBox());
	JLabel jl = new JLabel("��ѡ��֤��:");
	
	public JComboBoxModelTest() {
		setSize(new Dimension(160, 180));
		setVisible(true);
		setTitle("�ڴ��������������б��");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(jl);
		cp.add(jc);
	}
	
	public static void main(String[] args) {
		new JComboBoxModelTest();
	}
}

class MyComboBox extends AbstractListModel<String> implements ComboBoxModel<String> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String selecteditem = null;
	String[] test = { "���֤", "����֤", "ѧ��֤", "����֤" };
	
	public String getElementAt(int index) {
		return test[index];
	}
	
	public int getSize() {
		return test.length;
	}
	
	public void setSelectedItem(Object item) {
		selecteditem = (String) item;
	}
	
	public Object getSelectedItem() {
		return selecteditem;
	}
	
	public int getIndex() {
		for (int i = 0; i < test.length; i++) {
			if (test[i].equals(getSelectedItem()))
				return i;
		}
		return 0;
	}
}
