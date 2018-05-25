import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

public class TableModelEvent_Example extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;// ����һ��������
	private DefaultTableModel tableModel;// ����һ�����ģ�Ͷ���
	private JTextField aTextField;
	private JTextField bTextField;
	public static void main(String args[]) {
		TableModelEvent_Example frame = new TableModelEvent_Example();
		frame.setVisible(true);
	}
	public TableModelEvent_Example() {
		super();
		setTitle("���ģ���¼�ʾ��");
		setBounds(100, 100, 548, 213);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		String[] columnNames = { "A", "B" };
		String[][] rowValues = { { "A1", "B1" }, { "A2", "B2" },
				{ "A3", "B3" }, { "A4", "B4" } };
		// �������ģ�Ͷ���
		tableModel = new DefaultTableModel(rowValues, columnNames);
		// Ϊ���ģ������¼�������
		tableModel.addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent e) {
				int type = e.getType();// ����¼�������
				int row = e.getFirstRow() + 1;// ��ô����˴��¼��ı��������
				int column = e.getColumn() + 1;// ��ô����˴��¼��ı��������
				if (type == TableModelEvent.INSERT) {// �ж��Ƿ��в����д���
					System.out.print("�˴��¼��� ���� �д�����");
					System.out.println("�˴β�����ǵ� " + row + " �У�");
					// �ж��Ƿ����޸��д���
				} else if (type == TableModelEvent.UPDATE) {
					System.out.print("�˴��¼��� �޸� �д�����");
					System.out.println("�˴��޸ĵ��ǵ� " + row + " �е� " + column
							+ " �У�");
					// �ж��Ƿ���ɾ���д���
				} else if (type == TableModelEvent.DELETE) {
					System.out.print("�˴��¼��� ɾ�� �д�����");
					System.out.println("�˴�ɾ�����ǵ� " + row + " �У�");
				} else {
					System.out.println("�˴��¼��� ����ԭ�� ������");
				}
			}
		});
		table = new JTable(tableModel);// ���ñ��ģ�Ͷ��󴴽�������
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		final JLabel aLabel = new JLabel("A��");
		panel.add(aLabel);
		aTextField = new JTextField(15);
		panel.add(aTextField);
		final JLabel bLabel = new JLabel("B��");
		panel.add(bLabel);
		bTextField = new JTextField(15);
		panel.add(bTextField);
		final JButton addButton = new JButton("���");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] rowValues = { aTextField.getText(),
						bTextField.getText() };
				tableModel.addRow(rowValues);// ����ģ�������һ��
				aTextField.setText(null);
				bTextField.setText(null);
			}
		});
		panel.add(addButton);
		final JButton delButton = new JButton("ɾ��");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ñ���е�ѡ����
				int[] selectedRows = table.getSelectedRows();
				for (int row = 0; row < selectedRows.length; row++) {
					// �ӱ��ģ�����Ƴ�����е�ѡ����
					tableModel.removeRow(selectedRows[row] - row);
				}
			}
		});
		panel.add(delButton);
	}
}
