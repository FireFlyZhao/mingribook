import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class MFixedColumnTable extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable fixedColumnTable;// �̶��б�����

	private FixedColumnTableModel fixedColumnTableModel;// �̶��б��ģ�Ͷ���

	private JTable floatingColumnTable;// �ƶ��б�����

	private FloatingColumnTableModel floatingColumnTableModel;// �ƶ��б��ģ�Ͷ���

	private Vector<String> columnNameV;// �����������

	private Vector<Vector<Object>> tableValueV;// �����������

	private int fixedColumn = 1;// �̶�������

public MFixedColumnTable(Vector<String> columnNameV,
		Vector<Vector<Object>> tableValueV, int fixedColumn) {
	super();
	setLayout(new BorderLayout());

	this.columnNameV = columnNameV;
	this.tableValueV = tableValueV;
	this.fixedColumn = fixedColumn;

	fixedColumnTableModel = new FixedColumnTableModel();// �����̶��б��ģ�Ͷ���

	fixedColumnTable = new JTable(fixedColumnTableModel);// �����̶��б�����
	ListSelectionModel fixed = fixedColumnTable.getSelectionModel();// ���ѡ��ģ�Ͷ���
	fixed.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// ѡ��ģʽΪ��ѡ
	fixed.addListSelectionListener(new MListSelectionListener(true));// ����б�ѡ�е��¼�������

	floatingColumnTableModel = new FloatingColumnTableModel();// �������ƶ��б��ģ�Ͷ���

	floatingColumnTable = new JTable(floatingColumnTableModel);// �������ƶ��б�����
	floatingColumnTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// �رձ����Զ���������
	ListSelectionModel floating = floatingColumnTable.getSelectionModel();// ���ѡ��ģ�Ͷ���
	floating.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// ѡ��ģʽΪ��ѡ
	floating.addListSelectionListener(new MListSelectionListener(false));// ����б�ѡ�е��¼�������

	JScrollPane scrollPane = new JScrollPane();// ����һ������������
	scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, fixedColumnTable
			.getTableHeader()); // ���̶��б��ͷ�ŵ������������Ϸ�

	JViewport viewport = new JViewport();// ����һ��������ʾ������Ϣ���ӿڶ���
	viewport.setView(fixedColumnTable);// ���̶��б����ӵ��ӿ���
	viewport.setPreferredSize(fixedColumnTable.getPreferredSize());// �����ӿڵ���ѡ��СΪ�̶��б�����ѡ��С
	scrollPane.setRowHeaderView(viewport);// ���ӿ���ӵ��������ı����ӿ���

	scrollPane.setViewportView(floatingColumnTable);// �����ƶ������ӵ�Ĭ���ӿ�

	add(scrollPane, BorderLayout.CENTER);
	//
}

	private class FixedColumnTableModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public int getColumnCount() {// ���ع̶��е�����
			return fixedColumn;
		}

		public int getRowCount() {// ��������
			return tableValueV.size();
		}

		public Object getValueAt(int rowIndex, int columnIndex) {// ����ָ����Ԫ���ֵ
			return tableValueV.get(rowIndex).get(columnIndex);
		}

		@Override
		public String getColumnName(int columnIndex) {// ����ָ���е�����
			return columnNameV.get(columnIndex);
		}

	}

	private class FloatingColumnTableModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public int getColumnCount() {// ���ؿ��ƶ��е�����
			return columnNameV.size() - fixedColumn;// ��Ҫ�۳��̶��е�����
		}

		public int getRowCount() {// ��������
			return tableValueV.size();
		}

		public Object getValueAt(int rowIndex, int columnIndex) {// ����ָ����Ԫ���ֵ
			return tableValueV.get(rowIndex).get(columnIndex + fixedColumn);// ��ҪΪ���������Ϲ̶��е�����
		}

		@Override
		public String getColumnName(int columnIndex) {// ����ָ���е�����
			return columnNameV.get(columnIndex + fixedColumn);// ��ҪΪ���������Ϲ̶��е�����
		}

	}

	private class MListSelectionListener implements ListSelectionListener {
		boolean isFixedColumnTable = true; // Ĭ����ѡ�й̶��б���е��д���

		public MListSelectionListener(boolean isFixedColumnTable) {
			this.isFixedColumnTable = isFixedColumnTable;
		}

		public void valueChanged(ListSelectionEvent e) {
			if (isFixedColumnTable) { // ��ѡ�й̶��б���е��д���
				int row = fixedColumnTable.getSelectedRow(); // ��ù̶��б���е�ѡ����
				floatingColumnTable.setRowSelectionInterval(row, row); // ͬʱѡ���Ҳ���ƶ��б���е���Ӧ��
			} else { // ��ѡ�п��ƶ��б���е��д���
				int row = floatingColumnTable.getSelectedRow(); // ��ÿ��ƶ��б���е�ѡ����
				fixedColumnTable.setRowSelectionInterval(row, row); // ͬʱѡ�����̶��б���е���Ӧ��
			}
		}
	}

}
