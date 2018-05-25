package chapter.thirteen;

import java.awt.*;

import javax.swing.*;

public class JListTest extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JListTest();
	}
	
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
}

class MyListModel extends AbstractListModel<String>{
	private static final long serialVersionUID = 1L;
	private String[] contents = { "�б�1", "�б�2", "�б�3", "�б�4", "�б�5", "�б�6" };
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return contents.length;
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		if (index < contents.length)
			return contents[index++];
		else
			return null;
	}
	
}