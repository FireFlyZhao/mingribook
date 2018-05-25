import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class Answer_2509 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textField;

	private DefaultTableModel tableModel;

	private JTable table;

	private JLabel label;

	public static void main(String args[]) {
		try {
			Answer_2509 frame = new Answer_2509();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Answer_2509() {
		super();
		setTitle("25-9");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);

		final JLabel label_1 = new JLabel();
		label_1.setText("数量：");
		panel.add(label_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setEditable(false);
		textField.setText((int) (Math.random() * 1000) + "");
		panel.add(textField);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] rowValues = { table.getRowCount() + 1,
						Integer.valueOf(textField.getText()) };
				tableModel.addRow(rowValues);
				textField.setText((int) (Math.random() * 1000) + "");
			}
		});
		button.setText("插入");
		panel.add(button);

		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		String[] columnNames = { "编号", "数量" };

		tableModel = new DefaultTableModel(null, columnNames);
		tableModel.addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent e) {
				int sum = 0;
				for (int i = 0; i < table.getRowCount(); i++) {
					sum += (Integer) tableModel.getValueAt(i, 1);
				}
				label.setText("数量总计：" + sum);
			}
		});

		table = new JTable(tableModel);
		scrollPane.setViewportView(table);

		label = new JLabel();
		label.setText("数量总计：0");
		getContentPane().add(label, BorderLayout.SOUTH);
		//
	}

}
