package com.lzw.iframe.czyGl;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.lzw.dao.Dao;
import com.lzw.iframe.JsrGL;

public class SetJSR extends JPanel {// ���þ��������

	private JTextField sexField;// ���Ա��ı���
	private JTextField ageField;// �����䡱�ı���
	private JTextField nameField;// ���������ı���
	private JTable table;// ���ģ��
	private DefaultTableModel dftm;// ����������
	private String[] columnNames;// �洢�б��������

	public SetJSR() {// ���þ��������
		super();// ���ø���JPanel�Ĺ�����
		setBounds(0, 0, 491, 200);// ���á����þ�������塱��λ�úͿ��
		setLayout(new GridBagLayout());// ���á����þ�������塱�Ĳ���Ϊ���񲼾�

		final JScrollPane scrollPane = new JScrollPane();// �������
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints.weightx = 1.0;// ������������Ȩ����1.0
		gridBagConstraints.insets = new Insets(0, 0, 20, 0);// ����˴˵ļ��
		gridBagConstraints.gridwidth = 12;// ��������Խ12������
		gridBagConstraints.fill = GridBagConstraints.BOTH;// ���ˮƽ����ֵͬʱ������ռ�ݿհ�����
		gridBagConstraints.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints.gridx = 0;// ���λ������ĺ�������Ϊ0
		gridBagConstraints.gridy = 0;// ���λ���������������Ϊ0
		gridBagConstraints.ipadx = 35;// �����������35����
		gridBagConstraints.ipady = -195;// ����������195����
		add(scrollPane, gridBagConstraints);// �����þ������������ӹ������

		table = new JTable();// ���ģ��
		dftm = (DefaultTableModel) table.getModel();// ����������
		columnNames = new String[] { "���", "����", "�Ա�", "����", "��ϵ�绰", "����" };// �洢�б��������
		dftm.setColumnIdentifiers(columnNames);// ���б��������е�Ԫ���滻�������е��б�ʶ��
		table.addMouseListener(new MouseAdapter() {// Ϊ���ģ�����������¼�
			public void mouseClicked(final MouseEvent e) {
				String nameStr, ageStr, sexStr;// �����������������Ա𡱡������䡱
				int selRow = table.getSelectedRow();// ѡ���е�����
				nameStr = table.getValueAt(selRow, 1).toString().trim();// ��á�������
				ageStr = table.getValueAt(selRow, 3).toString().trim();// ��á����䡱
				sexStr = table.getValueAt(selRow, 2).toString().trim();// ��á��Ա�
				nameField.setText(nameStr);// ���á��������ı����е�����
				ageField.setText(ageStr);// ���á����䡱�ı����е�����
				sexField.setText(sexStr);// ���á��Ա��ı����е�����
			}
		});
		scrollPane.setViewportView(table);// �ѱ��ģ�����ڹ��������

		final JLabel label = new JLabel();// ����������ǩ
		final GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_3.gridy = 2;// ���λ���������������Ϊ2
		gridBagConstraints_3.gridx = 0;// ���λ������ĺ�������Ϊ0
		add(label, gridBagConstraints_3);// �����þ������������ӡ���������ǩ
		label.setText("������");// ���á���������ǩ�е��ı�����

		nameField = new JTextField();// ���������ı���
		nameField.setEditable(false);// ���á��������ı��򲻿ɱ༭
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_4.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_4.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_4.weightx = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_4.gridy = 2;// ���λ���������������Ϊ2
		gridBagConstraints_4.gridx = 3;// ���λ������ĺ�������Ϊ3
		add(nameField, gridBagConstraints_4);// �����þ������������ӡ��������ı���

		final JLabel label_2 = new JLabel();// ���Ա𡱱�ǩ
		label_2.setText("�Ա�");// ���á��Ա𡱱�ǩ�е��ı�����
		final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_7.gridy = 2;// ���λ���������������Ϊ2
		gridBagConstraints_7.gridx = 4;// ���λ������ĺ�������Ϊ4
		add(label_2, gridBagConstraints_7);// �����þ������������ӡ��Ա𡱱�ǩ

		sexField = new JTextField();// ���Ա��ı���
		sexField.setEditable(false);// ���á��Ա��ı��򲻿ɱ༭
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_8.weightx = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_8.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_8.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_8.gridy = 2;// ���λ���������������Ϊ2
		gridBagConstraints_8.gridx = 5;// ���λ������ĺ�������Ϊ5
		add(sexField, gridBagConstraints_8);// �����þ������������ӡ��Ա��ı���

		final JLabel label_1 = new JLabel();// �����䡱��ǩ
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_6.gridy = 2;// ���λ���������������Ϊ2
		gridBagConstraints_6.gridx = 6;// ���λ������ĺ�������Ϊ6
		add(label_1, gridBagConstraints_6);// �����þ������������ӡ��Ա��ı���
		label_1.setText("���䣺");// ���á����䡱��ǩ�е��ı�����

		ageField = new JTextField();// �����䡱�ı���
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_5.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_5.weightx = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_5.gridy = 2;// ���λ���������������Ϊ2
		gridBagConstraints_5.gridx = 7;// ���λ������ĺ�������Ϊ7
		add(ageField, gridBagConstraints_5);// �����þ������������ӡ����䡱�ı���
		ageField.setEditable(false);

		final JButton button = new JButton("ɾ��");// ��ɾ������ť
		final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_1.insets = new Insets(5, 0, 5, 0);// ����˴˵ļ��
		gridBagConstraints_1.gridy = 7;// ���λ���������������Ϊ7
		gridBagConstraints_1.gridx = 4;// ���λ������ĺ�������Ϊ4
		add(button, gridBagConstraints_1);// �����þ������������ӡ�ɾ������ť
		button.addActionListener(new ActionListener() {// ��ɾ������ť�����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(SetJSR.this, "ȷ��Ҫɾ���ò���Ա��");// ������ȷ��Ҫɾ���ò���Ա��������ʾ��
				if (op == JOptionPane.OK_OPTION) {// �����ȷ�ϡ�
					int selRow = table.getSelectedRow();// ѡ���е�����
					if (selRow < 0)// ѡ���е�����С��0
						return;// �˳�Ӧ�ó���
					String id = table.getValueAt(selRow, 0).toString().trim();// ��þ����˱��
					Dao.delete("delete tb_jsr where id='" + id + "'");// ִ��SQLɾ�����
					sexField.setText("");// ���á��Ա��ı����е�����Ϊ��
					ageField.setText("");// ���á����䡱�ı����е�����Ϊ��
					nameField.setText("");// ���á��������ı����е�����Ϊ��
					initTable();// ��ʼ�����ģ��
				}
			}
		});

		final JButton enableButton = new JButton("����/����");// ������/���á���ť
		final GridBagConstraints gridBagConstraints4 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints4.insets = new Insets(5, 0, 5, 0);// ����˴˵ļ��
		gridBagConstraints4.gridy = 7;// ���λ���������������Ϊ7
		gridBagConstraints4.gridx = 3;// ���λ������ĺ�������Ϊ3
		add(enableButton, gridBagConstraints4);// �����þ������������ӡ�����/���á���ť
		enableButton.addActionListener(new ActionListener() {// ������/���á���ť�����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				int selRow = table.getSelectedRow();// ѡ���е�����
				if (selRow < 0)// ѡ���е�����С��0
					return;// �˳�Ӧ�ó���
				int op = JOptionPane.showConfirmDialog(SetJSR.this, "ȷ��Ҫ�޸ĸò���Ա״̬��");// ������ȷ��Ҫ�޸ĸò���Ա״̬��������ʾ��
				if (op == JOptionPane.OK_OPTION) {// �����ȷ�ϡ�
					if (selRow < 0)// ѡ���е�����С��0
						return;// �˳�Ӧ�ó���
					String id = table.getValueAt(selRow, 0).toString().trim();// ��þ����˱��
					Dao.update("update tb_jsr set enable=enable-1 where id='" + id + "'");// ִ��SQL�޸����
					initTable();// ��ʼ�����ģ��
				}
			}
		});

		final JButton button_1 = new JButton("�ر�");// ���رա���ť
		final GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_2.insets = new Insets(5, 0, 5, 0);// ����˴˵ļ��
		gridBagConstraints_2.gridy = 7;// ���λ���������������Ϊ7
		gridBagConstraints_2.gridx = 6;// ���λ������ĺ�������Ϊ6
		add(button_1, gridBagConstraints_2);// �����þ������������ӡ��رա���ť
		button_1.addActionListener(new ActionListener() {// ���رա���ť�����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				JsrGL parent = (JsrGL) SetJSR.this.getRootPane().getParent();// ��þ��������ô���
				parent.doDefaultCloseAction();// �رվ��������ô���
			}
		});
	}

	public void initTable() {// ��ʼ�����ģ��
		List ul = Dao.getJsrs();// ��ñ����õľ����˼���
		Iterator it = ul.iterator();// ��ȡ�����˼��ϵĵ�����
		String[] data = new String[6];// ��������Ϊ6���ַ�������
		dftm.setDataVector(null, columnNames);// ���ñ��ģ�Ͷ��������
		while (it.hasNext()) {// �����˵ļ����е�Ԫ���Ƿ񱻱�����
			List userlist = (List) it.next();// ��þ����˵ļ����е���һ��Ԫ��
			// �Ѽ�����Ԫ�ش�����ַ���������
			data[0] = (String) userlist.get(0);
			data[1] = (String) userlist.get(1);
			data[2] = (String) userlist.get(2);
			data[3] = (String) userlist.get(3);
			data[4] = (String) userlist.get(4);
			data[5] = ((String) userlist.get(5)).equals("1") ? "����" : "����";
			dftm.addRow(data);// ������������������
		}
		setVisible(true);// ʹ���ģ�Ϳɼ�
	}
}
