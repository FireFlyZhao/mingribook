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
		setTitle("创建不可滚动的表格");
		setBounds(100, 100, 240, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Vector<String> columnNameV = new Vector<>();// 定义表格列名向量
		columnNameV.add("A");// 添加列名
		columnNameV.add("B");// 添加列名
		Vector<Vector<String>> tableValueV = new Vector<>();// 定义表格数据向量
		for (int row = 1; row < 6; row++) {
			Vector<String> rowV = new Vector<>();// 定义表格行向量
			rowV.add("A" + row);// 添加单元格数据
			rowV.add("B" + row);// 添加单元格数据
			tableValueV.add(rowV);// 将表格行向量添加到表格数据向量中
		}
		// 创建指定表格列名和表格数据的表格
		JTable table = new JTable(tableValueV, columnNameV);
		// 将表格添加到边界布局的中间
		getContentPane().add(table, BorderLayout.CENTER);
		JTableHeader tableHeader = table.getTableHeader();// 获得表格头对象
		// 将表格头添加到边界布局的上方
		getContentPane().add(tableHeader, BorderLayout.NORTH);
	}
}