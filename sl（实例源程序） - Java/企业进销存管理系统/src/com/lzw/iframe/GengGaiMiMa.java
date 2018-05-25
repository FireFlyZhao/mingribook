package com.lzw.iframe;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.lzw.dao.Dao;
import com.lzw.dao.model.TbJsr;

public class GengGaiMiMa extends JInternalFrame {// ���������ڲ�����

	// private JLabel name;
	private JPasswordField oldPass;// �������롱�����
	private JPasswordField newPass2;// ��ȷ�������롱�����
	private JPasswordField newPass1;// �������롱�����

	public GengGaiMiMa() {// �������봰��Ĺ��췽��
		super();// ���ø���JInternalFrame�Ĺ�����
		setIconifiable(true);// ���ø������봰�����ͼ�껯
		setTitle("��������");// ���ø������봰��ı���
		setClosable(true);// ���ÿ��Թرո������봰��
		getContentPane().setLayout(new GridBagLayout());// ���ø������봰�����������Ĳ��������񲼾�
		setBounds(100, 100, 300, 228);// ���ø������봰���λ������

		/*name = new JLabel();
		final GridBagConstraints gridBagConstraints_12 = new GridBagConstraints();
		gridBagConstraints_12.gridy = 2;
		gridBagConstraints_12.gridx = 1;
		gridBagConstraints_12.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(name, gridBagConstraints_12);*/

		final JLabel label_1 = new JLabel();// �������룺����ǩ
		label_1.setFont(new Font("", Font.PLAIN, 14));// ���á������룺����ǩ�е�������ʽ�ʹ�С
		label_1.setText("��  ��  �룺");// ���á������룺����ǩ�е��ı�����
		final GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_2.gridy = 3;// ���λ���������������Ϊ3
		gridBagConstraints_2.gridx = 0;// ���λ������ĺ�������Ϊ0
		getContentPane().add(label_1, gridBagConstraints_2);// ��������봰���е����������ӡ������룺����ǩ

		oldPass = new JPasswordField();// �������롱�����
		final GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_3.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_3.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_3.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_3.gridwidth = 3;// ������3������
		gridBagConstraints_3.gridy = 3;// ���λ���������������Ϊ3
		gridBagConstraints_3.gridx = 1;// ���λ������ĺ�������Ϊ1
		getContentPane().add(oldPass, gridBagConstraints_3);// ��������봰���е����������ӡ������롱�����

		final JLabel label_2 = new JLabel();// �������룺����ǩ
		label_2.setFont(new Font("", Font.PLAIN, 14));// ���á������룺����ǩ�е�������ʽ�ʹ�С
		label_2.setText("��  ��  �룺");// ���á������룺����ǩ�е��ı�����
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_4.gridy = 4;// ���λ���������������Ϊ4
		gridBagConstraints_4.gridx = 0;// ���λ������ĺ�������Ϊ0
		getContentPane().add(label_2, gridBagConstraints_4);// ��������봰���е����������ӡ������룺����ǩ

		newPass1 = new JPasswordField();// �������롱�����
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_5.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_5.ipadx = 30;// �����������30����
		gridBagConstraints_5.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_5.gridwidth = 3;// ������3������
		gridBagConstraints_5.gridy = 4;// ���λ���������������Ϊ4
		gridBagConstraints_5.gridx = 1;// ���λ������ĺ�������Ϊ1
		getContentPane().add(newPass1, gridBagConstraints_5);// ��������봰���е����������ӡ������롱�����

		final JLabel label_3 = new JLabel();// ��ȷ�������룺����ǩ
		label_3.setFont(new Font("", Font.PLAIN, 14));// ���á�ȷ�������룺����ǩ�е�������ʽ�ʹ�С
		label_3.setText("ȷ�������룺");// ���á�ȷ�������룺����ǩ�е��ı�����
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_6.gridy = 5;// ���λ���������������Ϊ5
		gridBagConstraints_6.gridx = 0;// ���λ������ĺ�������Ϊ0
		getContentPane().add(label_3, gridBagConstraints_6);// ��������봰���е����������ӡ�ȷ�������룺����ǩ

		newPass2 = new JPasswordField();// ��ȷ�������롱�����
		final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_7.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_7.ipadx = 30;// �����������30����
		gridBagConstraints_7.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_7.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_7.weightx = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_7.gridwidth = 3;// ������3������
		gridBagConstraints_7.gridy = 5;// ���λ���������������Ϊ5
		gridBagConstraints_7.gridx = 1;// ���λ������ĺ�������Ϊ1
		getContentPane().add(newPass2, gridBagConstraints_7);// ��������봰���е����������ӡ�ȷ�������롱�����

		final JButton button = new JButton("ȷ��");// ��ȷ�ϡ���ť
		button.addActionListener(new ActionListener() {// Ϊ��ȷ�ϡ���ť��Ӷ����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				String newPass1Str = newPass1.getText();// ��ȡ�������롱������е��ı�����
				String newPass2Str = newPass2.getText();// ��ȡ��ȷ�������롱������е��ı�����
				if (newPass1Str.equals(newPass2Str)) {// �������롱������е��ı������롰ȷ�������롱������е��ı�������ͬ
					String oldPassStr = oldPass.getText();// ��ȡ�������롱������е��ı�����
					int res = Dao.modifyPassword(oldPassStr, newPass1Str);// ��ø�������ļ�¼����
					if (res <= 0) {// ��������ļ�¼����������0
						String failed = "�����޸�ʧ�ܣ�����������Ƿ���ȷ��";// ��ʼ�������޸�ʧ�ܵ��ַ���
						JOptionPane.showMessageDialog(getContentPane(), failed);// ���������޸�ʧ�ܵ���ʾ��
						return;// �˳�Ӧ�ó���
					}
					JOptionPane.showMessageDialog(getContentPane(), "�����޸ĳɹ���");// ���������޸ĳɹ�����ʾ��
				} else {// �������롱������е��ı������롰ȷ�������롱������е��ı����ݲ���ͬ
					JOptionPane.showMessageDialog(getContentPane(), "������������벻һ�£����������롣");// ����������������벻һ�µ���ʾ��
				}
			}
		});
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_8.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_8.anchor = GridBagConstraints.EAST;// ���������ʾ���������
		gridBagConstraints_8.gridy = 6;// ���λ���������������Ϊ6
		gridBagConstraints_8.gridx = 1;// ���λ������ĺ�������Ϊ1
		getContentPane().add(button, gridBagConstraints_8);// ��������봰���е����������ӡ�ȷ�ϡ���ť

		final JButton button_1 = new JButton();// �����á���ť
		button_1.addActionListener(new ActionListener() {// Ϊ�����á���ť��Ӷ����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				oldPass.setText(null);// ���á������롱�������ı�����Ϊ��
				newPass1.setText(null);// ���á������롱�������ı�����Ϊ��
				newPass2.setText(null);// ���á�ȷ�������롱�������ı�����Ϊ��
			}
		});
		button_1.setText("����");// ���á����á���ť�е��ı�����Ϊ�����á�
		final GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_9.gridwidth = 2;// ������2������
		gridBagConstraints_9.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_9.gridy = 6;// ���λ���������������Ϊ6
		gridBagConstraints_9.gridx = 2;// ���λ������ĺ�������Ϊ2
		getContentPane().add(button_1, gridBagConstraints_9);// ��������봰���е����������ӡ����á���ť
	}
}
