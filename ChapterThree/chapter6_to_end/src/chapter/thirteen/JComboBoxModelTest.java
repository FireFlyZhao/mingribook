package chapter.thirteen;

import java.awt.*;

import javax.swing.*;

public class JComboBoxModelTest extends JFrame {
	private static final long serialVersionUID = 1L;
	JComboBox<String> jc = new JComboBox<>(new MyComboBox());
	JLabel jl = new JLabel("��ѡ��֤��:");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JComboBoxModelTest();
	}
	
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
}

class MyComboBox extends AbstractListModel<String> implements ComboBoxModel<String>{
	private static final long serialVersionUID = 1L;
	String selecteditem = null;
	String[] test = {"���֤", "����֤", "ѧ��֤", "����֤"};
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return test.length;
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return test[index];
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		selecteditem = (String) anItem;
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
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