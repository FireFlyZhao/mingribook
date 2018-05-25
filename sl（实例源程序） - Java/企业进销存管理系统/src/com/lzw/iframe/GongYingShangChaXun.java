package com.lzw.iframe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.lzw.Item;
import com.lzw.dao.Dao;
import com.lzw.dao.model.TbGysinfo;

public class GongYingShangChaXun extends JInternalFrame {// ��Ӧ�̲�ѯ�ڲ�����

	private JTable table;// ���ģ��
	private JTextField conditionContent;// ���������ݡ��ı���
	private JComboBox conditionOperation;// ���������㡱�����б�
	private JComboBox conditionName;// ���������ơ������б�

	public GongYingShangChaXun() {// ��Ӧ�̲�ѯ�ڲ�����Ĺ��췽��
		setMaximizable(true);// �������
		setIconifiable(true);// ����ͼ�껯
		setClosable(true);// ���Թرմ���
		setTitle("��Ӧ����Ϣ��ѯ");// ���ù�Ӧ�̲�ѯ�ڲ�����ı���
		getContentPane().setLayout(new GridBagLayout());// ���ù�Ӧ�̲�ѯ�ڲ�����Ĳ���Ϊ���񲼾�
		setBounds(100, 100, 609, 375);// ���ù�Ӧ�̲�ѯ�ڲ������λ�úͿ��
		// ���ģ��
		table = new JTable();
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
		final DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		String[] tableHeads = new String[] { "��Ӧ��ID", "��Ӧ��ȫ��", "���", "��������", "��ַ", "�绰", "����", "��ϵ��", "��ϵ�˵绰", "��������",
				"��������" };
		dftm.setColumnIdentifiers(tableHeads);
		// �������
		final JScrollPane scrollPane = new JScrollPane(table);
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.weighty = 1.0;
		gridBagConstraints_6.anchor = GridBagConstraints.NORTH;
		gridBagConstraints_6.insets = new Insets(0, 10, 0, 10);
		gridBagConstraints_6.fill = GridBagConstraints.BOTH;
		gridBagConstraints_6.gridwidth = 6;
		gridBagConstraints_6.gridy = 1;
		gridBagConstraints_6.gridx = 0;
		getContentPane().add(scrollPane, gridBagConstraints_6);
		// ��ѡ���ѯ��������ǩ�͡��������ơ������б�
		setupComponet(new JLabel(" ѡ���ѯ������"), 0, 0, 1, 1, false);
		conditionName = new JComboBox();
		conditionName.setModel(new DefaultComboBoxModel(new String[] { "��Ӧ��ȫ��", "���" }));
		setupComponet(conditionName, 1, 0, 1, 30, true);
		// ���������㡱�����б�
		conditionOperation = new JComboBox();
		conditionOperation.setModel(new DefaultComboBoxModel(new String[] { "����", "����" }));
		setupComponet(conditionOperation, 2, 0, 1, 30, true);
		// ���������ݡ��ı���
		conditionContent = new JTextField();
		setupComponet(conditionContent, 3, 0, 1, 140, true);
		// ����ѯ����ť
		final JButton queryButton = new JButton();
		queryButton.addActionListener(new queryAction(dftm));
		setupComponet(queryButton, 4, 0, 1, 1, false);
		queryButton.setText("��ѯ");
		// ����ʾȫ�����ݡ���ť
		final JButton showAllButton = new JButton();
		showAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				conditionContent.setText("");
				List list = Dao.getGysInfos();
				updateTable(list, dftm);
			}
		});
		setupComponet(showAllButton, 5, 0, 1, 1, false);
		showAllButton.setText("��ʾȫ������");
	}
	// �������ʾȫ�����ݡ���ť�󣬸��±������
	private void updateTable(List list, final DefaultTableModel dftm) {
		int num = dftm.getRowCount();
		for (int i = 0; i < num; i++)
			dftm.removeRow(0);
		Iterator iterator = list.iterator();
		TbGysinfo gysInfo;// ��Ӧ����Ϣ
		while (iterator.hasNext()) {
			List info = (List) iterator.next();
			Item item = new Item();
			item.setId((String) info.get(0));
			item.setName((String) info.get(1));
			gysInfo = Dao.getGysInfo(item);
			Vector rowData = new Vector();
			rowData.add(gysInfo.getId());// ��Ӧ�̱��
			rowData.add(gysInfo.getName());// ��Ӧ������
			rowData.add(gysInfo.getJc());// ��Ӧ�̼��
			rowData.add(gysInfo.getBianma());// ��������
			rowData.add(gysInfo.getAddress());// ��Ӧ�̵�ַ
			rowData.add(gysInfo.getTel());// �绰
			rowData.add(gysInfo.getFax());// ����
			rowData.add(gysInfo.getLian());// ��ϵ��
			rowData.add(gysInfo.getLtel());// ��ϵ�绰
			rowData.add(gysInfo.getYh());// ��������
			rowData.add(gysInfo.getMail());// ��������
			dftm.addRow(rowData);// �����������������ݣ���Ӧ����Ϣ��
		}
	}

	// �������λ�ò���ӵ�������
	private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx = gridx;
		gridBagConstrains.gridy = gridy;
		if (gridwidth > 1)
			gridBagConstrains.gridwidth = gridwidth;
		if (ipadx > 0)
			gridBagConstrains.ipadx = ipadx;
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);
		if (fill)
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(component, gridBagConstrains);
	}
	// ������ѯ
	private final class queryAction implements ActionListener {
		private final DefaultTableModel dftm;

		private queryAction(DefaultTableModel dftm) {
			this.dftm = dftm;
		}

		public void actionPerformed(final ActionEvent e) {
			String conName, conOperation, content;
			List list = null;
			conName = conditionName.getSelectedItem().toString().trim();
			conOperation = conditionOperation.getSelectedItem().toString().trim();
			content = conditionContent.getText().trim();
			String sql = "select * from tb_gysInfo where ";
			if (conName.equals("��Ӧ��ȫ��")) {
				if (conOperation.equals("����"))
					list = Dao.findForList(sql + "name='" + content + "'");
				else
					list = Dao.findForList(sql + "name like '%" + content + "%'");
			} else {
				if (conOperation.equals("����"))
					list = Dao.findForList(sql + "jc='" + content + "'");
				else
					list = Dao.findForList(sql + "jc like '%" + content + "%'");
			}
			updateTable(list, dftm);
		}
	}
}
