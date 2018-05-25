import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class Answer_2407 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JPanel cardPanel;
	private CardLayout cardLayout;
	private JTable decTable;
	private JTable novTable;
	private JTable octTable;
	private JTable sepTable;
	private JTable augTable;
	private JTable julTable;
	private JTable junTable;
	private JTable mayTable;
	private JTable aprTable;
	private JTable marTable;
	private JTable febTable;
	private JTable janTable;
	private JPanel buttonPanel;
	private static int year;
	private static int month;
	private static int day;
	private static int dayOfWeek;
	private static int dayOfWeekInMonth;
	private static int[] daysOfMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31,
			30, 31, 30, 31 };
	static {
		Calendar today = Calendar.getInstance();
		year = today.get(Calendar.YEAR);
		month = today.get(Calendar.MONTH) + 1;
		day = today.get(Calendar.DAY_OF_MONTH);
		dayOfWeek = today.get(Calendar.DAY_OF_WEEK) - 2;
		if (dayOfWeek < 0)
			dayOfWeek = 6;
		dayOfWeekInMonth = today.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		if (year % 100 == 0) {
			if (year % 400 == 0)
				daysOfMonth[2] = 29;
		} else {
			if (year % 4 == 0)
				daysOfMonth[2] = 29;
		}
	}
	
	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Answer_2407 frame = new Answer_2407();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame
	 */
	public Answer_2407() {
		super();
		setTitle("年历");
		setResizable(false);
		setBounds(100, 100, 600, 418);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel();
		label.setForeground(new Color(255, 0, 0));
		label.setFont(new Font("", Font.BOLD, 22));
		label.setText(year + " 年 " + month + " 月");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label, BorderLayout.NORTH);
		
		cardPanel = new JPanel();
		cardLayout = new CardLayout();
		cardPanel.setLayout(cardLayout);
		getContentPane().add(cardPanel, BorderLayout.CENTER);
		
		final String[] columnNames = { "星期一", "星期二", "星期三", "星期四", "星期五",
				"星期六", "星期日" };
		
		final JScrollPane janScrollPane = new JScrollPane();
		janScrollPane.setName("1 月");
		cardPanel.add(janScrollPane, janScrollPane.getName());
		
		janTable = new MTable(new String[6][7], columnNames);
		janScrollPane.setViewportView(janTable);
		
		final JScrollPane febScrollPane = new JScrollPane();
		febScrollPane.setName("2 月");
		cardPanel.add(febScrollPane, febScrollPane.getName());
		
		febTable = new MTable(new String[6][7], columnNames);
		febScrollPane.setViewportView(febTable);
		
		final JScrollPane marScrollPane = new JScrollPane();
		marScrollPane.setName("3 月");
		cardPanel.add(marScrollPane, marScrollPane.getName());
		
		marTable = new MTable(new String[6][7], columnNames);
		marScrollPane.setViewportView(marTable);
		
		final JScrollPane aprScrollPane = new JScrollPane();
		aprScrollPane.setName("4 月");
		cardPanel.add(aprScrollPane, aprScrollPane.getName());
		
		aprTable = new MTable(new String[6][7], columnNames);
		aprScrollPane.setViewportView(aprTable);
		
		final JScrollPane mayScrollPane = new JScrollPane();
		mayScrollPane.setName("5 月");
		cardPanel.add(mayScrollPane, mayScrollPane.getName());
		
		mayTable = new MTable(new Object[6][7], columnNames);
		mayScrollPane.setViewportView(mayTable);
		
		final JScrollPane junScrollPane = new JScrollPane();
		junScrollPane.setName("6 月");
		cardPanel.add(junScrollPane, junScrollPane.getName());
		
		junTable = new MTable(new String[6][7], columnNames);
		junScrollPane.setViewportView(junTable);
		
		final JScrollPane julScrollPane = new JScrollPane();
		julScrollPane.setName("7 月");
		cardPanel.add(julScrollPane, julScrollPane.getName());
		
		julTable = new MTable(new String[6][7], columnNames);
		julScrollPane.setViewportView(julTable);
		
		final JScrollPane augScrollPane = new JScrollPane();
		augScrollPane.setName("8 月");
		cardPanel.add(augScrollPane, augScrollPane.getName());
		
		augTable = new MTable(new String[6][7], columnNames);
		augScrollPane.setViewportView(augTable);
		
		final JScrollPane sepScrollPane = new JScrollPane();
		sepScrollPane.setName("9 月");
		cardPanel.add(sepScrollPane, sepScrollPane.getName());
		
		sepTable = new MTable(new String[6][7], columnNames);
		sepScrollPane.setViewportView(sepTable);
		
		final JScrollPane octScrollPane = new JScrollPane();
		octScrollPane.setName("10 月");
		cardPanel.add(octScrollPane, octScrollPane.getName());
		
		octTable = new MTable(new String[6][7], columnNames);
		octScrollPane.setViewportView(octTable);
		
		final JScrollPane novScrollPane = new JScrollPane();
		novScrollPane.setName("11 月");
		cardPanel.add(novScrollPane, novScrollPane.getName());
		
		novTable = new MTable(new String[6][7], columnNames);
		novScrollPane.setViewportView(novTable);
		
		final JScrollPane decScrollPane = new JScrollPane();
		decScrollPane.setName("12 月");
		cardPanel.add(decScrollPane, decScrollPane.getName());
		
		decTable = new MTable(new String[6][7], columnNames);
		decScrollPane.setViewportView(decTable);
		
		buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		final JButton previousButton = new JButton();
		previousButton.setText("上一月");
		previousButton.setMargin(new Insets(0, 0, 0, 0));
		previousButton.addActionListener(new ButtonAL());
		buttonPanel.add(previousButton);
		
		final JButton janButton = new MButton();
		janButton.setText("1 月");
		buttonPanel.add(janButton);
		
		final JButton febButton = new MButton();
		febButton.setText("2 月");
		buttonPanel.add(febButton);
		
		final JButton marButton = new MButton();
		marButton.setText("3 月");
		buttonPanel.add(marButton);
		
		final JButton aprButton = new MButton();
		aprButton.setText("4 月");
		buttonPanel.add(aprButton);
		
		final JButton mayButton = new MButton();
		mayButton.setText("5 月");
		buttonPanel.add(mayButton);
		
		final JButton junButton = new MButton();
		junButton.setText("6 月");
		buttonPanel.add(junButton);
		
		final JButton julButton = new MButton();
		julButton.setText("7 月");
		buttonPanel.add(julButton);
		
		final JButton augButton = new MButton();
		augButton.setText("8 月");
		buttonPanel.add(augButton);
		
		final JButton sepButton = new MButton();
		sepButton.setText("9 月");
		buttonPanel.add(sepButton);
		
		final JButton octButton = new MButton();
		octButton.setText("10 月");
		buttonPanel.add(octButton);
		
		final JButton novButton = new MButton();
		novButton.setText("11 月");
		buttonPanel.add(novButton);
		
		final JButton decButton = new MButton();
		decButton.setText("12 月");
		buttonPanel.add(decButton);
		
		final JButton nextButton = new MButton();
		nextButton.setText("下一月");
		buttonPanel.add(nextButton);
		//
		initTable();
	}
	
	private void initTable() {
		DateFormat dateFormat = DateFormat.getDateInstance();
		try {
			dateFormat.parse(year + "-1-1");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar theDay = dateFormat.getCalendar();
		int col = theDay.get(Calendar.DAY_OF_WEEK) - 2;
		if (col < 0)
			col = 6;
		JTable[] tables = { null, janTable, febTable, marTable, aprTable,
				mayTable, junTable, julTable, augTable, sepTable, octTable,
				novTable, decTable };
		for (int i = 1; i < tables.length; i++) {
			int row = 0;
			JTable table = tables[i];
			for (int day = 1; day <= daysOfMonth[i]; day++) {
				table.setValueAt(day + "", row, col);
				if (col == 6) {
					row += 1;
					col = 0;
				} else {
					col++;
				}
			}
		}
		JTable table = tables[month];
		table.setValueAt("[ " + day + " ]", dayOfWeekInMonth, dayOfWeek);
		table.setRowSelectionInterval(dayOfWeekInMonth, dayOfWeekInMonth);
		table.setColumnSelectionInterval(dayOfWeek, dayOfWeek);
		cardLayout.show(cardPanel, month + " 月");
		JButton button = (JButton) buttonPanel.getComponent(month);
		button.setBackground(Color.GREEN);
	}
	
	private class ButtonAL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			String text = button.getText();
			if (text.equals("上一月")) {
				if (month == 1)
					month = 12;
				else
					month--;
				cardLayout.previous(cardPanel);
			} else if (text.equals("下一月")) {
				if (month == 12)
					month = 1;
				else
					month++;
				cardLayout.next(cardPanel);
			} else {
				month = Integer.valueOf(text.substring(0, 1));
				cardLayout.show(cardPanel, text);
			}
			label.setText(year + " 年 " + month + " 月");
		}
	}
	
	private class MTable extends JTable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MTable(Object[][] tableDatas, String[] columnNames) {
			super(tableDatas, columnNames);
			setRowHeight(50);
			setFont(new Font("", Font.BOLD, 14));
		}
		
		// 不允许选中表格行
		@Override
		public void setRowSelectionAllowed(boolean rowSelectionAllowed) {
			super.setRowSelectionAllowed(false);
		}
		
		// 不允许编辑单元格
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
		// 单元格内容居中显示
		@Override
		public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {
			// 获得除表格头部分的单元格对象
			DefaultTableCellRenderer tableRenderer = (DefaultTableCellRenderer) super
					.getDefaultRenderer(columnClass);
			// 设置单元格内容居中显示
			tableRenderer
					.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			return tableRenderer;
		}
		
	}
	
	private class MButton extends JButton {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MButton() {
			super();
			setMargin(new Insets(0, 2, 0, 1));
			addActionListener(new ButtonAL());
		}
	}
	
}
