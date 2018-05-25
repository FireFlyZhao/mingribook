import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

public class ExampleFrame_06 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;// ������ģ�Ͷ���
	private JTable table;// ���������
	private JTextField aTextField;
	private JTextField bTextField;
	
	public static void main(String args[]) {
		ExampleFrame_06 frame = new ExampleFrame_06();
		frame.setVisible(true);
	}
	
	public ExampleFrame_06() {
		super();
		setTitle("ά�����ģ��");
		setBounds(100, 100, 510, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		String[] columnNames = { "A", "B" };// ��������������
		String[][] tableValues = { { "A1", "B1" }, { "A2", "B2" },
				{ "A3", "B3" } };// ��������������
		// ����ָ����������ͱ�����ݵı��ģ��
		tableModel = new DefaultTableModel(tableValues, columnNames);
		
		table = new JTable(tableModel);// ����ָ�����ģ�͵ı��
		table.setRowSorter(new TableRowSorter<>(tableModel));// ���ñ���������
		// ���ñ���ѡ��ģʽΪ��ѡ
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Ϊ����������¼�������
		table.addMouseListener(new MouseAdapter() {
			// �����˵���¼�
			public void mouseClicked(MouseEvent e) {
				// ��ñ�ѡ���е�����
				int selectedRow = table.getSelectedRow();
				// �ӱ��ģ���л��ָ����Ԫ���ֵ
				Object oa = tableModel.getValueAt(selectedRow, 0);
				// �ӱ��ģ���л��ָ����Ԫ���ֵ
				Object ob = tableModel.getValueAt(selectedRow, 1);
				aTextField.setText(oa.toString());// ��ֵ��ֵ���ı���
				bTextField.setText(ob.toString());// ��ֵ��ֵ���ı���
			}
		});
		scrollPane.setViewportView(table);
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.add(new JLabel("A��"));
		aTextField = new JTextField("A4", 10);
		panel.add(aTextField);
		panel.add(new JLabel("B��"));
		bTextField = new JTextField("B4", 10);
		panel.add(bTextField);
		final JButton addButton = new JButton("���");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] rowValues = { aTextField.getText(),
						bTextField.getText() };// �������������
				tableModel.addRow(rowValues);// ����ģ�������һ��
				int rowCount = table.getRowCount() + 1;
				aTextField.setText("A" + rowCount);
				bTextField.setText("B" + rowCount);
			}
		});
		panel.add(addButton);
		final JButton updButton = new JButton("�޸�");
		updButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();// ��ñ�ѡ���е�����
				if (selectedRow != -1) {// �ж��Ƿ���ڱ�ѡ����
					tableModel.setValueAt(aTextField.getText(),
							selectedRow, 0);// �޸ı��ģ�͵��е�ָ��ֵ
					tableModel.setValueAt(bTextField.getText(),
							selectedRow, 1);// �޸ı��ģ�͵��е�ָ��ֵ
				}
			}
		});
		panel.add(updButton);
		final JButton delButton = new JButton("ɾ��");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();// ��ñ�ѡ���е�����
				if (selectedRow != -1)// �ж��Ƿ���ڱ�ѡ����
					// �ӱ��ģ�͵���ɾ��ָ����
					tableModel.removeRow(selectedRow);
			}
		});
		panel.add(delButton);
	}
}