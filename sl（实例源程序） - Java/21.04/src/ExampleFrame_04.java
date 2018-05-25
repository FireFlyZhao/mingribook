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
		setTitle("操纵表格");
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
		table.setRowSelectionInterval(1, 3);// 设置选中行
		table.addRowSelectionInterval(5, 5);// 添加选中行
		scrollPane.setViewportView(table);
		
		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		JButton selectAllButton = new JButton("全部选择");
		selectAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.selectAll();// 选中所有行
			}
		});
		buttonPanel.add(selectAllButton);
		
		JButton clearSelectionButton = new JButton("取消选择");
		clearSelectionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.clearSelection();// 取消所有选中行的选择状态
			}
		});
		buttonPanel.add(clearSelectionButton);
		//
		System.out.println("表格共有" + table.getRowCount() + "行"
				+ table.getColumnCount() + "列");
		System.out.println("共有" + table.getSelectedRowCount() + "行被选中");
		System.out.println("第3行的选择状态为：" + table.isRowSelected(2));
		System.out.println("第5行的选择状态为：" + table.isRowSelected(4));
		System.out.println("被选中的第一行的索引是：" + table.getSelectedRow());
		int[] selectedRows = table.getSelectedRows();// 获得所有被选中行的索引
		System.out.print("所有被选中行的索引是：");
		for (int row = 0; row < selectedRows.length; row++) {
			System.out.print(selectedRows[row] + "  ");
		}
		System.out.println();
		System.out.println("列移动前第2列的名称是：" + table.getColumnName(1));
		System.out.println("列移动前第2行第2列的值是：" + table.getValueAt(1, 1));
		table.moveColumn(1, 5);// 将位于索引1的列移动到索引5处
		System.out.println("列移动后第2列的名称是：" + table.getColumnName(1));
		System.out.println("列移动后第2行第2列的值是：" + table.getValueAt(1, 1));
	}
}
