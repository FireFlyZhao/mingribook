import java.awt.*;
import java.util.*;

import javax.swing.*;

public class Answer_2109 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		try {
			Answer_2109 frame = new Answer_2109();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Answer_2109() {
		super();
		setTitle("提供行标题栏的表格");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Vector<String> columnNameV = new Vector<>();
		columnNameV.add("日期");
		columnNameV.add("营业额");// 添加一个日营业额列
		for (int i = 1; i < 21; i++) {
			columnNameV.add("商品" + i);
		}
		Vector<Vector<Object>> tableValueV = new Vector<>();
		for (int row = 1; row < 31; row++) {
			Vector<Object> rowV = new Vector<>();
			rowV.add(row);
			int sum = 0;// 日营业额
			for (int col = 0; col < 20; col++) {
				int value = (int) (Math.random() * 1000);
				rowV.add(value);
				sum += value;// 累计日营业额
			}
			rowV.insertElementAt(sum, 1);// 插入日营业额数据
			tableValueV.add(rowV);
		}

		final MFixedColumnTable panel = new MFixedColumnTable(columnNameV,
				tableValueV, 2);// 修改固定列数量
		getContentPane().add(panel, BorderLayout.CENTER);
		//
	}
}
