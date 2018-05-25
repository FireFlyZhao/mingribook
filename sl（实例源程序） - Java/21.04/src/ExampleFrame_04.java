import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class ExampleFrame_04 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	
	public static void main(String args[]) {
		ExampleFrame_04 frame = new ExampleFrame_04();
		frame.setVisible(true);
	}
	
	public ExampleFrame_04() {
		super();
		setTitle("���ݱ��");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		String[] columnNames = { "A", "B", "C", "D", "E", "F", "G" };
		Vector<String> columnNameV = new Vector<>();
		for (int column = 0; column < columnNames.length; column++) {
			columnNameV.add(columnNames[column]);
		}
		Vector<Vector<String>> tableValueV = new Vector<>();
		for (int row = 1; row < 21; row++) {
			Vector<String> rowV = new Vector<>();
			for (int column = 0; column < columnNames.length; column++) {
				rowV.add(columnNames[column] + row);
			}
			tableValueV.add(rowV);
		}
		
		table = new JTable(tableValueV, columnNameV);
		table.setRowSelectionInterval(1, 3);// ����ѡ����
		table.addRowSelectionInterval(5, 5);// ���ѡ����
		scrollPane.setViewportView(table);
		
		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		JButton selectAllButton = new JButton("ȫ��ѡ��");
		selectAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.selectAll();// ѡ��������
			}
		});
		buttonPanel.add(selectAllButton);
		
		JButton clearSelectionButton = new JButton("ȡ��ѡ��");
		clearSelectionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.clearSelection();// ȡ������ѡ���е�ѡ��״̬
			}
		});
		buttonPanel.add(clearSelectionButton);
		//
		System.out.println("�����" + table.getRowCount() + "��"
				+ table.getColumnCount() + "��");
		System.out.println("����" + table.getSelectedRowCount() + "�б�ѡ��");
		System.out.println("��3�е�ѡ��״̬Ϊ��" + table.isRowSelected(2));
		System.out.println("��5�е�ѡ��״̬Ϊ��" + table.isRowSelected(4));
		System.out.println("��ѡ�еĵ�һ�е������ǣ�" + table.getSelectedRow());
		int[] selectedRows = table.getSelectedRows();// ������б�ѡ���е�����
		System.out.print("���б�ѡ���е������ǣ�");
		for (int row = 0; row < selectedRows.length; row++) {
			System.out.print(selectedRows[row] + "  ");
		}
		System.out.println();
		System.out.println("���ƶ�ǰ��2�е������ǣ�" + table.getColumnName(1));
		System.out.println("���ƶ�ǰ��2�е�2�е�ֵ�ǣ�" + table.getValueAt(1, 1));
		table.moveColumn(1, 5);// ��λ������1�����ƶ�������5��
		System.out.println("���ƶ����2�е������ǣ�" + table.getColumnName(1));
		System.out.println("���ƶ����2�е�2�е�ֵ�ǣ�" + table.getValueAt(1, 1));
	}
}
