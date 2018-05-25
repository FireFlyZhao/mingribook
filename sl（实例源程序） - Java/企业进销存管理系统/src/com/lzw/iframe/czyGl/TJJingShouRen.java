package com.lzw.iframe.czyGl;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.lzw.dao.Dao;
import com.lzw.dao.model.TbJsr;

public class TJJingShouRen extends JPanel {// ��Ӿ��������

	private JTextField jsrName;// ���������ı���
	private JTextField tel;// ���绰���ı���
	private JTextField age;// �����䡱�ı���
	private JComboBox sex;// ���Ա������б�

	private void clear() {// ����ı������ݵķ���
		// �����ı��������Ϊ��
		jsrName.setText(null);
		tel.setText(null);
		age.setText(null);
	}

	public TJJingShouRen() {// ��Ӿ��������
		super();// ���ø���JPanel�Ĺ�����
		setLayout(new GridBagLayout());// ������Ӿ��������Ĳ���Ϊ���񲼾�
		setBounds(0, 0, 280, 236);// ������Ӿ���������λ�úͿ��
		
		final JLabel label_4 = new JLabel();// ����������ǩ
		label_4.setFont(new Font("", Font.PLAIN, 14));// ���á���������ǩ���������ʽ�ʹ�С
		label_4.setText("������");// ���á���������ǩ�ڵ��ı�����
		final GridBagConstraints gridBagConstraints_10 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_10.gridx = 0;// ���λ������ĺ�������Ϊ0
		gridBagConstraints_10.gridy = 0;// ���λ���������������Ϊ0
		add(label_4, gridBagConstraints_10);// ����Ӿ������������ӡ���������ǩ
		
		jsrName = new JTextField();// ���������ı���
		final GridBagConstraints gridBagConstraints_11 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_11.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_11.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_11.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_11.gridwidth = 2;// ��������Խ2������
		gridBagConstraints_11.gridy = 0;// ���λ���������������Ϊ0
		gridBagConstraints_11.gridx = 1;// ���λ������ĺ�������Ϊ1
		add(jsrName, gridBagConstraints_11);// ����Ӿ������������ӡ��������ı���
		
		final JLabel label = new JLabel();// ���Ա𡱱�ǩ
		label.setFont(new Font("", Font.PLAIN, 14));// ���á��Ա𡱱�ǩ���������ʽ�ʹ�С
		label.setText("�Ա�");// ���á��Ա𡱱�ǩ�ڵ��ı�����
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints.gridy = 1;// ���λ���������������Ϊ1
		gridBagConstraints.gridx = 0;// ���λ������ĺ�������Ϊ0
		add(label, gridBagConstraints);// ����Ӿ������������ӡ��Ա𡱱�ǩ
		
		sex = new JComboBox();// ���Ա������б�
		sex.addItem("��");// ���á��Ա������б��е�ѡ������
		sex.addItem("Ů");// ���á��Ա������б��е�ѡ������
		final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_1.weightx = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_1.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_1.ipadx = -250;// ����������250����
		gridBagConstraints_1.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_1.gridwidth = 2;// ��������Խ2������
		gridBagConstraints_1.gridy = 1;// ���λ���������������Ϊ1
		gridBagConstraints_1.gridx = 1;// ���λ������ĺ�������Ϊ1
		add(sex, gridBagConstraints_1);// ����Ӿ������������ӡ��Ա������б�
		
		final JLabel label_2 = new JLabel();// �����䡱��ǩ
		label_2.setFont(new Font("", Font.PLAIN, 14));// ���á����䡱��ǩ���������ʽ�ʹ�С
		label_2.setText("���䣺");// ���á����䡱��ǩ�ڵ��ı�����
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_4.gridy = 2;// ���λ���������������Ϊ2
		gridBagConstraints_4.gridx = 0;// ���λ������ĺ�������Ϊ0
		add(label_2, gridBagConstraints_4);// ����Ӿ������������ӡ����䡱��ǩ
		
		age = new JTextField();// �����䡱�ı���
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_5.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_5.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_5.gridwidth = 2;// ��������Խ2������
		gridBagConstraints_5.gridy = 2;// ���λ���������������Ϊ2
		gridBagConstraints_5.gridx = 1;// ���λ������ĺ�������Ϊ1
		add(age, gridBagConstraints_5);// ����Ӿ������������ӡ����䡱�ı���
		
		final JLabel label_3 = new JLabel();// ���绰����ǩ
		label_3.setFont(new Font("", Font.PLAIN, 14));// ���á��绰����ǩ���������ʽ�ʹ�С
		label_3.setText("�绰��");// ���á��绰����ǩ�ڵ��ı�����
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_6.gridy = 3;// ���λ���������������Ϊ3
		gridBagConstraints_6.gridx = 0;// ���λ������ĺ�������Ϊ0
		add(label_3, gridBagConstraints_6);// ����Ӿ������������ӡ��绰����ǩ
		
		tel = new JTextField();// ���绰���ı���
		final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_7.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_7.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_7.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_7.gridwidth = 2;// ��������Խ2������
		gridBagConstraints_7.gridy = 3;// ���λ���������������Ϊ3
		gridBagConstraints_7.gridx = 1;// ���λ������ĺ�������Ϊ1
		add(tel, gridBagConstraints_7);// ����Ӿ������������ӡ��绰���ı���
		
		final JButton button = new JButton("���");// ����ӡ���ť
		button.addActionListener(new ActionListener() {// ����ӡ���ť�����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				String nameStr = jsrName.getText();// ��á��������ı����е��ı�����
				if (nameStr == null || nameStr.isEmpty())// ���������ı���Ϊ�ջ��������ı����е��ı�����Ϊ��
					return;// �˳�Ӧ�ó���
				String ageStr = new String(age.getText());// ��á����䡱�ı����е��ı�����
				TbJsr user = Dao.getJsr(nameStr, ageStr);// ��������Ϣ
				if (user.getSex() != null && !user.getSex().isEmpty()) {// �����˵��Ա�Ϊ���Ҿ����˱�ʾ�Ա���ַ����ĳ��Ȳ�Ϊ0
					JOptionPane.showMessageDialog(TJJingShouRen.this, "������(" + user.getName() + ")�Ѿ�����");// �����Ի���
					sex.setFocusable(true);// // ���Ա������б��ý���
					return;// �˳�Ӧ�ó���
				}
				String sexStr = sex.getSelectedItem() + "";// ��þ����˵��Ա�
				TbJsr jsr = new TbJsr();// ��������Ϣ
				jsr.setTel(tel.getText());// ���þ����˵绰
				jsr.setAge(age.getText());// ���þ���������
				jsr.setName(nameStr);// ���þ���������
				jsr.setSex(sexStr);// ���þ������Ա�
				int i = Dao.addJsr(jsr);// ��Ӿ�����
				if (i > 0)// ��Ӿ����˵���Ŀ����1
					JOptionPane.showMessageDialog(TJJingShouRen.this, "��ӳɹ�");// ������ʾ��
				clear();// ����ı��������
			}
		});
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_8.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_8.anchor = GridBagConstraints.EAST;// ��������ڸ������ʾ���������
		gridBagConstraints_8.gridy = 5;// ���λ���������������Ϊ5
		gridBagConstraints_8.gridx = 1;// ���λ������ĺ�������Ϊ1
		add(button, gridBagConstraints_8);// ����Ӿ������������ӡ���ӡ���ť

		final JButton button_1 = new JButton();// �����á���ť
		button_1.addActionListener(new ActionListener() {// Ϊ�����á���ť��Ӷ����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				clear();// ����ı��������
			}
		});
		button_1.setText("����");// ���á����á���ť�е���������
		final GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_9.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_9.gridy = 5;// ���λ���������������Ϊ5
		gridBagConstraints_9.gridx = 2;// ���λ������ĺ�������Ϊ2
		add(button_1, gridBagConstraints_9);// ����Ӿ������������ӡ����á���ť
	}
}
