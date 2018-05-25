package com.lzw.iframe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.*;

import com.lzw.*;
import com.lzw.dao.Dao;
import com.lzw.dao.model.TbSpinfo;

public class KuCunPanDian extends JInternalFrame {// ����̵��ڲ�����

	private final JTable table;// ���ģ��
	private final JTextField pdsj = new JTextField();// ���̵�ʱ�䡱�ı���
	private final JTextField pzs = new JTextField("0");// ��Ʒ�������ı���
	private JTextField czy = new JTextField();// ������Ա���ı���
	private Date pdDate = new Date();// �̵�����

	public KuCunPanDian() {// ����̵��ڲ�����Ĺ��췽��
		super();// ���ø���JInternalFrame�Ĺ�����
		setMaximizable(true);// �������
		setIconifiable(true);// ����ͼ�껯
		setClosable(true);// ���Թر�
		getContentPane().setLayout(new GridBagLayout());// ���ÿ���̵��ڲ�����Ĳ���Ϊ���񲼾�
		setTitle("����̵�");// ���ÿ���̵��ڲ�����ı���
		setBounds(50, 50, 750, 400);// �������ÿ���̵��ڲ������λ�úͿ��
		// ������Ա����ǩ�롰����Ա���ı���
		setupComponet(new JLabel("�� �� Ա��"), 0, 0, 1, 0, false);
		czy.setFocusable(false);
		czy.setText(MainFrame.getCzyStateLabel().getText());
		czy.setPreferredSize(new Dimension(120, 21));
		setupComponet(czy, 1, 0, 1, 0, true);
		// ���̵�ʱ�䡱��ǩ�롰�̵�ʱ�䡱�ı���
		setupComponet(new JLabel("�̵�ʱ�䣺"), 2, 0, 1, 0, false);
		pdsj.setFocusable(false);
		pdsj.setText(pdDate.toLocaleString());
		pdsj.setPreferredSize(new Dimension(180, 21));
		setupComponet(pdsj, 3, 0, 1, 1, true);
		// ��Ʒ��������ǩ�롰Ʒ�������ı���
		setupComponet(new JLabel("Ʒ �� ����"), 4, 0, 1, 0, false);
		pzs.setFocusable(false);
		pzs.setPreferredSize(new Dimension(80, 21));
		setupComponet(pzs, 5, 0, 1, 20, true);
		// ���ģ��
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		initTable();
		// �������
		JScrollPane scrollPanel = new JScrollPane(table);
		scrollPanel.setPreferredSize(new Dimension(700, 300));
		setupComponet(scrollPanel, 0, 2, 6, 1, true);
	}

	private void initTable() {// ��ʼ�����
		String[] columnNames = { "��Ʒ����", "��Ʒ���", "��Ӧ��", "����", "��λ", "���", "����", "����", "��װ", "�̵�����", "��������" };
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setColumnIdentifiers(columnNames);
		// �����̵��ֶ�ֻ������������
		final JTextField pdField = new JTextField(0);
		pdField.setEditable(false);
		pdField.addKeyListener(new PanDianKeyAdapter(pdField));
		JTextField readOnlyField = new JTextField(0);
		readOnlyField.setEditable(false);

		DefaultCellEditor pdEditor = new DefaultCellEditor(pdField);
		DefaultCellEditor readOnlyEditor = new DefaultCellEditor(readOnlyField);
		// ���ñ��ԪΪֻ����ʽ
		for (int i = 0; i < columnNames.length; i++) {
			TableColumn column = table.getColumnModel().getColumn(i);
			column.setCellEditor(readOnlyEditor);
		}
		// ��ñ���е���������༭�����е�Ԫ��ʱ���õı༭��
		TableColumn pdColumn = table.getColumnModel().getColumn(9);
		TableColumn syColumn = table.getColumnModel().getColumn(10);
		pdColumn.setCellEditor(pdEditor);
		syColumn.setCellEditor(readOnlyEditor);
		// ��ʼ���������
		List kcInfos = Dao.getKucunInfos();
		for (int i = 0; i < kcInfos.size(); i++) {
			List info = (List) kcInfos.get(i);
			Item item = new Item();
			item.setId((String) info.get(0));
			item.setName((String) info.get(1));
			TbSpinfo spinfo = Dao.getSpInfo(item);
			Object[] row = new Object[columnNames.length];
			if (spinfo.getId() != null && !spinfo.getId().isEmpty()) {
				row[0] = spinfo.getSpname();
				row[1] = spinfo.getId();
				row[2] = spinfo.getGysname();
				row[3] = spinfo.getCd();
				row[4] = spinfo.getDw();
				row[5] = spinfo.getGg();
				row[6] = info.get(2).toString();
				row[7] = info.get(3).toString();
				row[8] = spinfo.getBz();
				row[9] = 0;
				row[10] = 0;
				tableModel.addRow(row);
				String pzsStr = pzs.getText();
				int pzsInt = Integer.parseInt(pzsStr);
				pzsInt++;
				pzs.setText(pzsInt + "");
			}
		}
	}

	// �̵��ֶεİ���������
	private class PanDianKeyAdapter extends KeyAdapter {
		private final JTextField field;

		private PanDianKeyAdapter(JTextField field) {
			this.field = field;
		}

		public void keyTyped(KeyEvent e) {// ����ĳ����ʱ
			if (("0123456789" + (char) 8).indexOf(e.getKeyChar() + "") < 0) {
				e.consume();
			}
			field.setEditable(true);
		}

		public void keyReleased(KeyEvent e) {// �ͷ�ĳ����ʱ
			String pdStr = field.getText();//��ȡ�̵�����
			String kcStr = "0";
			int row = table.getSelectedRow();//��ȡ��ǰѡ����
			if (row >= 0) {
				kcStr = (String) table.getValueAt(row, 7);//��ȡ�����е�Ԫ�񣬿������
			}
			try {
				int pdNum = Integer.parseInt(pdStr);
				int kcNum = Integer.parseInt(kcStr);
				if (row >= 0) {
					table.setValueAt(kcNum - pdNum, row, 10);//���㲢�������浥Ԫ�������
				}
				if (e.getKeyChar() != 8)
					field.setEditable(false);
			} catch (NumberFormatException e1) {
				field.setText("0");
			}
		}
	}

	// �������λ�ò���ӵ�������
	private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();// �����������ƶ���
		gridBagConstrains.gridx = gridx;// �������λ������ĺ�������Ϊgridx
		gridBagConstrains.gridy = gridy;// �������λ���������������Ϊgridy
		gridBagConstrains.insets = new Insets(5, 1, 3, 5);// ����˴˵ļ��
		if (gridwidth > 1)// ����������������1
			gridBagConstrains.gridwidth = gridwidth;// ����������������Ϊgridwidth
		if (ipadx > 0)// ����������Ĵ�С����0
			gridBagConstrains.ipadx = ipadx;// ��������������Ĵ�С
		if (fill)// ���ռ�ݿհ�����
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		getContentPane().add(component, gridBagConstrains);// ������
	}
}
