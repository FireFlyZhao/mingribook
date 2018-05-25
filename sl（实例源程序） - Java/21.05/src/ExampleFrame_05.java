import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;

public class ExampleFrame_05 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_05 frame = new ExampleFrame_05();
		frame.setVisible(true);
	}
	
	public ExampleFrame_05() {
		super();
		setTitle("表格模型与表格");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		String[] columnNames = { "A", "B" };// 定义表格列名数组
		String[][] tableValues = { { "A1", "B1" }, { "A2", "B2" },
				{ "A3", "B3" } };// 定义表格数据数组
		DefaultTableModel tableModel = new DefaultTableModel(tableValues,
				columnNames);// 创建指定表格列名和表格数据的表格模型
		JTable table = new JTable(tableModel);// 创建指定表格模型的表格
		table.setRowSorter(new TableRowSorter<>(tableModel));
		scrollPane.setViewportView(table);
	}
	
}
