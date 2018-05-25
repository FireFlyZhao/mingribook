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
	// �ƶ��б��ģ�Ͷ���
	private FloatingColumnTableModel floatingColumnTableModel;
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
	// �����̶��б��ģ�Ͷ���
	fixedColumnTableModel = new FixedColumnTableModel();
	// �����̶��б�����
	fixedColumnTable = new JTable(fixedColumnTableModel);
	// ���ѡ��ģ�Ͷ���
	ListSelectionModel fixed = fixedColumnTable.getSelectionModel();
	// ѡ��ģʽΪ��ѡ
	fixed.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	// ����б�ѡ�е��¼�������
	fixed.addListSelectionListener(new MListSelectionListener(true));
	// �������ƶ��б��ģ�Ͷ���
	floatingColumnTableModel = new FloatingColumnTableModel();
	// �������ƶ��б�����
	floatingColumnTable = new JTable(floatingColumnTableModel);
	// �رձ����Զ���������
	floatingColumnTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	ListSelectionModel floating = floatingColumnTable
			.getSelectionModel();// ���ѡ��ģ�Ͷ���
	// ѡ��ģʽΪ��ѡ
	floating.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	// ����б�ѡ�е��¼�������
	MListSelectionListener listener = new MListSelectionListener(false);
	floating.addListSelectionListener(listener);
	JScrollPane scrollPane = new JScrollPane();// ����һ������������
	// ���̶��б��ͷ�ŵ������������Ϸ�
	scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER,
			fixedColumnTable.getTableHeader());
	// ����һ��������ʾ������Ϣ���ӿڶ���
	JViewport viewport = new JViewport();
	viewport.setView(fixedColumnTable);// ���̶��б����ӵ��ӿ���
	// �����ӿڵ���ѡ��СΪ�̶��б�����ѡ��С
	viewport.setPreferredSize(fixedColumnTable.getPreferredSize());
	// ���ӿ���ӵ��������ı����ӿ���
	 scrollPane.setRowHeaderView(viewport);
	// �����ƶ������ӵ�Ĭ���ӿ�
	scrollPane.setViewportView(floatingColumnTable);
	add(scrollPane, BorderLayout.CENTER);
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
		
		// ����ָ����Ԫ���ֵ
		public Object getValueAt(int rowIndex, int columnIndex) {
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
		
		// ����ָ����Ԫ���ֵ
		public Object getValueAt(int rowIndex, int columnIndex) {
			// ��ҪΪ���������Ϲ̶��е�����
			return tableValueV.get(rowIndex)
					.get(columnIndex + fixedColumn);
		}
		
		@Override
		public String getColumnName(int columnIndex) {// ����ָ���е�����
			// ��ҪΪ���������Ϲ̶��е�����
			return columnNameV.get(columnIndex + fixedColumn);
		}
	}
	
	private class MListSelectionListener implements ListSelectionListener {
		boolean isFixedColumnTable = true; // Ĭ����ѡ�й̶��б���е��д���
		
		public MListSelectionListener(boolean isFixedColumnTable) {
			this.isFixedColumnTable = isFixedColumnTable;
		}
		
		public void valueChanged(ListSelectionEvent e) {
			if (isFixedColumnTable) { // ��ѡ�й̶��б���е��д���
				// ��ù̶��б���е�ѡ����
				int row = fixedColumnTable.getSelectedRow();
				// ͬʱѡ���Ҳ���ƶ��б���е���Ӧ��
				floatingColumnTable.setRowSelectionInterval(row, row);
			} else { // ��ѡ�п��ƶ��б���е��д���
				// ��ÿ��ƶ��б���е�ѡ����
				int row = floatingColumnTable.getSelectedRow();
				// ͬʱѡ�����̶��б���е���Ӧ��
				fixedColumnTable.setRowSelectionInterval(row, row);
			}
		}
	}
}
