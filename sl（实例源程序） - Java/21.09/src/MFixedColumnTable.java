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

	private JTable fixedColumnTable;// 固定列表格对象

	private FixedColumnTableModel fixedColumnTableModel;// 固定列表格模型对象

	private JTable floatingColumnTable;// 移动列表格对象

	private FloatingColumnTableModel floatingColumnTableModel;// 移动列表格模型对象

	private Vector<String> columnNameV;// 表格列名数组

	private Vector<Vector<Object>> tableValueV;// 表格数据数组

	private int fixedColumn = 1;// 固定列数量

public MFixedColumnTable(Vector<String> columnNameV,
		Vector<Vector<Object>> tableValueV, int fixedColumn) {
	super();
	setLayout(new BorderLayout());

	this.columnNameV = columnNameV;
	this.tableValueV = tableValueV;
	this.fixedColumn = fixedColumn;

	fixedColumnTableModel = new FixedColumnTableModel();// 创建固定列表格模型对象

	fixedColumnTable = new JTable(fixedColumnTableModel);// 创建固定列表格对象
	ListSelectionModel fixed = fixedColumnTable.getSelectionModel();// 获得选择模型对象
	fixed.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 选择模式为单选
	fixed.addListSelectionListener(new MListSelectionListener(true));// 添加行被选中的事件监听器

	floatingColumnTableModel = new FloatingColumnTableModel();// 创建可移动列表格模型对象

	floatingColumnTable = new JTable(floatingColumnTableModel);// 创建可移动列表格对象
	floatingColumnTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 关闭表格的自动调整功能
	ListSelectionModel floating = floatingColumnTable.getSelectionModel();// 获得选择模型对象
	floating.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 选择模式为单选
	floating.addListSelectionListener(new MListSelectionListener(false));// 添加行被选中的事件监听器

	JScrollPane scrollPane = new JScrollPane();// 创建一个滚动面版对象
	scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, fixedColumnTable
			.getTableHeader()); // 将固定列表格头放到滚动面版的左上方

	JViewport viewport = new JViewport();// 创建一个用来显示基础信息的视口对象
	viewport.setView(fixedColumnTable);// 将固定列表格添加到视口中
	viewport.setPreferredSize(fixedColumnTable.getPreferredSize());// 设置视口的首选大小为固定列表格的首选大小
	scrollPane.setRowHeaderView(viewport);// 将视口添加到滚动面版的标题视口中

	scrollPane.setViewportView(floatingColumnTable);// 将可移动表格添加到默认视口

	add(scrollPane, BorderLayout.CENTER);
	//
}

	private class FixedColumnTableModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public int getColumnCount() {// 返回固定列的数量
			return fixedColumn;
		}

		public int getRowCount() {// 返回行数
			return tableValueV.size();
		}

		public Object getValueAt(int rowIndex, int columnIndex) {// 返回指定单元格的值
			return tableValueV.get(rowIndex).get(columnIndex);
		}

		@Override
		public String getColumnName(int columnIndex) {// 返回指定列的名称
			return columnNameV.get(columnIndex);
		}

	}

	private class FloatingColumnTableModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public int getColumnCount() {// 返回可移动列的数量
			return columnNameV.size() - fixedColumn;// 需要扣除固定列的数量
		}

		public int getRowCount() {// 返回行数
			return tableValueV.size();
		}

		public Object getValueAt(int rowIndex, int columnIndex) {// 返回指定单元格的值
			return tableValueV.get(rowIndex).get(columnIndex + fixedColumn);// 需要为列索引加上固定列的数量
		}

		@Override
		public String getColumnName(int columnIndex) {// 返回指定列的名称
			return columnNameV.get(columnIndex + fixedColumn);// 需要为列索引加上固定列的数量
		}

	}

	private class MListSelectionListener implements ListSelectionListener {
		boolean isFixedColumnTable = true; // 默认由选中固定列表格中的行触发

		public MListSelectionListener(boolean isFixedColumnTable) {
			this.isFixedColumnTable = isFixedColumnTable;
		}

		public void valueChanged(ListSelectionEvent e) {
			if (isFixedColumnTable) { // 由选中固定列表格中的行触发
				int row = fixedColumnTable.getSelectedRow(); // 获得固定列表格中的选中行
				floatingColumnTable.setRowSelectionInterval(row, row); // 同时选中右侧可移动列表格中的相应行
			} else { // 由选中可移动列表格中的行触发
				int row = floatingColumnTable.getSelectedRow(); // 获得可移动列表格中的选中行
				fixedColumnTable.setRowSelectionInterval(row, row); // 同时选中左侧固定列表格中的相应行
			}
		}
	}

}
