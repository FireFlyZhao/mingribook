import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class ExampleFrame_03 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_03 frame = new ExampleFrame_03();
		frame.setVisible(true);
	}
	
	public ExampleFrame_03() {
		super();
		setTitle("������");
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
			Vector<String> rowV = new Vector<String>();
			for (int column = 0; column < columnNames.length; column++) {
				rowV.add(columnNames[column] + row);
			}
			tableValueV.add(rowV);
		}
		JTable table = new MTable(tableValueV, columnNameV);
		// �رձ���е��Զ���������
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// ѡ��ģʽΪ��ѡ
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// ��ѡ���еı���ɫΪ��ɫ
		table.setSelectionBackground(Color.YELLOW);
		// ��ѡ���е�ǰ��ɫ��������ɫ��Ϊ��ɫ
		table.setSelectionForeground(Color.RED);
		table.setRowHeight(30); // �����и�Ϊ30����
		scrollPane.setViewportView(table);
	}
	
	private class MTable extends JTable { // ʵ���Լ��ı����
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MTable(Vector<Vector<String>> rowData, Vector<String> columnNames) {
			super(rowData, columnNames);
		}
		
		@Override
		public JTableHeader getTableHeader() { // ������ͷ
			// ��ñ��ͷ����
			JTableHeader tableHeader = super.getTableHeader();
			tableHeader.setReorderingAllowed(false); // ���ñ���в�������
			DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tableHeader
					.getDefaultRenderer(); // ��ñ��ͷ�ĵ�Ԫ�����
			// ��������������ʾ
			hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			return tableHeader;
		}
		
		// ���嵥Ԫ��
		@Override
		public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {
			DefaultTableCellRenderer cr = (DefaultTableCellRenderer) super
					.getDefaultRenderer(columnClass); // ��ñ��ĵ�Ԫ�����
			// ���õ�Ԫ�����ݾ�����ʾ
			cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			return cr;
		}
		
		@Override
		public boolean isCellEditable(int row, int column) { // ��񲻿ɱ༭
			return false;
		}
	}
}
