import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class MDateField extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public MDateField() {
		super();
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setHgap(0);
		setLayout(flowLayout);

		textField = new JTextField();
		textField.setColumns(12);
		add(textField);

		final JButton button = new JButton();
		button.setText("...");
		button.setMargin(new Insets(0, 4, 0, 4));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dimension preferredSize = textField.getPreferredSize();
				Point locationOnScreen = textField.getLocationOnScreen();
				int x = (int) locationOnScreen.getX();
				int y = (int) (locationOnScreen.getY() + preferredSize
						.getHeight());
				int width = 310;
				int height = 187;
				JRootPane rootPane = textField.getRootPane();
				Point rootPaneLocationOnScreen = rootPane.getLocationOnScreen();
				if (height > rootPaneLocationOnScreen.getY()
						+ rootPane.getHeight() - y) {
					y = (int) (locationOnScreen.getY() - height);
				}
				ChooseDateDialog dialog = new ChooseDateDialog();
				dialog.setBounds(x, y, width, height);
				dialog.setVisible(true);
			}
		});
		add(button);
		//
	}

	class ChooseDateDialog extends JDialog {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private int year;

		private int month;

		private int day;

		private int[] daysOfMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30,
				31, 30, 31 };

		private JTextField yTextField;

		private JTextField mTextField;

		private DefaultTableModel tableModel;

		public ChooseDateDialog() {
			super();
			setModal(true);
			setUndecorated(true);
			setBounds(100, 100, 310, 153);

			Calendar today = Calendar.getInstance();
			year = today.get(Calendar.YEAR);
			month = today.get(Calendar.MONTH) + 1;
			day = today.get(Calendar.DAY_OF_MONTH);
			if (year % 4 == 0) {
				if (year % 100 != 0 || year % 400 == 0)
					daysOfMonth[2] = 29;
				else
					daysOfMonth[2] = 28;
			} else {
				daysOfMonth[2] = 28;
			}

			final JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			panel.setBorder(new LineBorder(Color.black, 1, false));
			getContentPane().add(panel, BorderLayout.CENTER);

			final JPanel buttonPanel = new JPanel();
			panel.add(buttonPanel, BorderLayout.NORTH);

			final JButton pyButton = new JButton();
			pyButton.setText("<<");
			pyButton.setToolTipText("��һ��");
			pyButton.setMargin(new Insets(0, 10, 0, 10));
			pyButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					yTextField.setText(--year + "");
					initTableModel();
				}
			});
			buttonPanel.add(pyButton);

			final JButton pmButton = new JButton();
			pmButton.setText("<");
			pmButton.setToolTipText("��һ��");
			pmButton.setMargin(new Insets(0, 12, 0, 12));
			pmButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					month--;
					if (month < 1) {
						month = 12;
						yTextField.setText(--year + "");
					}
					mTextField.setText(month + "");
					initTableModel();
				}
			});
			buttonPanel.add(pmButton);

			yTextField = new JTextField();
			yTextField.setColumns(4);
			yTextField.setEditable(false);
			yTextField.setHorizontalAlignment(JTextField.CENTER);
			yTextField.setText(year + "");
			buttonPanel.add(yTextField);

			final JLabel yLabel = new JLabel();
			yLabel.setText("��");
			buttonPanel.add(yLabel);

			mTextField = new JTextField();
			mTextField.setColumns(2);
			mTextField.setEditable(false);
			mTextField.setHorizontalAlignment(JTextField.CENTER);
			mTextField.setText(month + "");
			buttonPanel.add(mTextField);

			final JLabel mLabel = new JLabel();
			mLabel.setText("��");
			buttonPanel.add(mLabel);

			final JButton nmButton = new JButton();
			nmButton.setText(">");
			nmButton.setToolTipText("��һ��");
			nmButton.setMargin(new Insets(0, 12, 0, 12));
			nmButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					month++;
					if (month > 12) {
						month = 1;
						yTextField.setText(++year + "");
					}
					mTextField.setText(month + "");
					initTableModel();
				}
			});
			buttonPanel.add(nmButton);

			final JButton nyButton = new JButton();
			nyButton.setText(">>");
			nyButton.setToolTipText("��һ��");
			nyButton.setMargin(new Insets(0, 12, 0, 12));
			nyButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					yTextField.setText(++year + "");
					initTableModel();
				}
			});
			buttonPanel.add(nyButton);

			final JScrollPane scrollPane = new JScrollPane();
			panel.add(scrollPane, BorderLayout.CENTER);

			tableModel = new DefaultTableModel(6, 7);
			String[] columnNames = { "������", "����һ", "���ڶ�", "������", "������", "������",
					"������" };
			tableModel.setColumnIdentifiers(columnNames);
			initTableModel();

			final JTable table = new MTable(tableModel);
			table.setRowSelectionAllowed(false);
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					String dayS = table.getValueAt(table.getSelectedRow(),
							table.getSelectedColumn()).toString();
					if (!dayS.startsWith("[")) {
						day = Integer.valueOf(dayS);
						textField.setText(getSelectedDate());
						dispose();
					}
				}
			});
			scrollPane.setViewportView(table);

			final JLabel label = new JLabel();
			label.setText(" ");
			panel.add(label, BorderLayout.WEST);

			final JLabel label_1 = new JLabel();
			label_1.setText(" ");
			panel.add(label_1, BorderLayout.EAST);

			final JPanel todayPanel = new JPanel();
			panel.add(todayPanel, BorderLayout.SOUTH);

			final JLabel label_2 = new JLabel();
			label_2.setText("���죺" + year + "-" + month + "-" + day + "  ");
			todayPanel.add(label_2);

			final JButton button = new JButton();
			button.setText("...");
			button.setMargin(new Insets(0, 12, 0, 12));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Calendar today = Calendar.getInstance();
					year = today.get(Calendar.YEAR);
					month = today.get(Calendar.MONTH) + 1;
					day = today.get(Calendar.DAY_OF_MONTH);
					if (year % 4 == 0) {
						if (year % 100 != 0 || year % 400 == 0)
							daysOfMonth[2] = 29;
						else
							daysOfMonth[2] = 28;
					} else {
						daysOfMonth[2] = 28;
					}
					yTextField.setText(year + "");
					mTextField.setText(month + "");
					initTableModel();
				}
			});
			todayPanel.add(button);

		}

		private void initTableModel() {
			DateFormat dateFormat = DateFormat.getDateInstance();
			try {
				dateFormat.parse(year + "-" + month + "-" + 1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Calendar theDay = dateFormat.getCalendar();
			int dayOfWeek = theDay.get(Calendar.DAY_OF_WEEK);
			for (int col = 0; col < dayOfWeek - 1; col++) {
				int days = ((month - 1) < 1 ? 31 : daysOfMonth[month - 1]);
				int day = days - ((dayOfWeek - 1) - 1 - col);
				tableModel.setValueAt("[ " + day + " ]", 0, col);
			}
			int day = 1;
			for (int col = dayOfWeek - 1; col < 7; col++) {
				tableModel.setValueAt(day++, 0, col);
			}
			String s = "";
			String e = "";
			for (int row = 1; row < 6; row++) {
				for (int col = 0; col < 7; col++) {
					if (day > daysOfMonth[month]) {
						s = "[ ";
						e = " ]";
						day = 1;
					}
					tableModel.setValueAt(s + day++ + e, row, col);
				}
			}
		}

		public String getSelectedDate() {
			return year + "-" + month + "-" + day;
		}

	}

	class MTable extends JTable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MTable() {
			super();
		}

		public MTable(DefaultTableModel tableModel) {
			super(tableModel);
		}

		// ���������Ϣ
		@Override
		public JTableHeader getTableHeader() {
			// ��ñ��ͷ����
			JTableHeader tableHeader = super.getTableHeader();
			tableHeader.setReorderingAllowed(false);// ���ñ���в�������
			// ��ñ��ͷ�ĵ�Ԫ�����
			DefaultTableCellRenderer defaultRenderer = (DefaultTableCellRenderer) tableHeader
					.getDefaultRenderer();
			// ���õ�Ԫ�����ݣ���������������ʾ
			defaultRenderer
					.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			return tableHeader;
		}

		// �����ֵ������ʾ
		@Override
		public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {
			// ��ó����ͷ���ֵĵ�Ԫ�����
			DefaultTableCellRenderer defaultRenderer = (DefaultTableCellRenderer) super
					.getDefaultRenderer(columnClass);
			// ���õ�Ԫ�����ݾ�����ʾ
			defaultRenderer
					.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			return defaultRenderer;
		}

		// ��񲻿ɱ༭
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

		// �������ñ���ѡ����
		@Override
		public void setRowSelectionInterval(int fromRow, int toRow) {// �ع�����ķ���
			super.setRowSelectionInterval(fromRow, toRow);
		}

		// �������ñ���Ψһѡ����
		public void setRowSelectionInterval(int row) {// ͨ������ʵ���Լ��ķ���
			setRowSelectionInterval(row, row);
		}

	}

}
