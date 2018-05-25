import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class ExampleFrame_02 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_02 frame = new ExampleFrame_02();
		frame.setVisible(true);
	}
	
	public ExampleFrame_02() {
		super();
		setTitle("�������ɹ����ı��");
		setBounds(100, 100, 240, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Vector<String> columnNameV = new Vector<>();// ��������������
		columnNameV.add("A");// �������
		columnNameV.add("B");// �������
		Vector<Vector<String>> tableValueV = new Vector<>();// ��������������
		for (int row = 1; row < 6; row++) {
			Vector<String> rowV = new Vector<>();// ������������
			rowV.add("A" + row);// ��ӵ�Ԫ������
			rowV.add("B" + row);// ��ӵ�Ԫ������
			tableValueV.add(rowV);// �������������ӵ��������������
		}
		// ����ָ����������ͱ�����ݵı��
		JTable table = new JTable(tableValueV, columnNameV);
		// �������ӵ��߽粼�ֵ��м�
		getContentPane().add(table, BorderLayout.CENTER);
		JTableHeader tableHeader = table.getTableHeader();// ��ñ��ͷ����
		// �����ͷ��ӵ��߽粼�ֵ��Ϸ�
		getContentPane().add(tableHeader, BorderLayout.NORTH);
	}
}