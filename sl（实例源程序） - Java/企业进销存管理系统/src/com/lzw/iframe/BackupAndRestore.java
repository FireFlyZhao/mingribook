package com.lzw.iframe;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.lzw.dao.Dao;

public class BackupAndRestore extends JInternalFrame {// ���ݿⱸ����ָ��ڲ�����

	private JPanel jContentPane = null;// �������
	private JPanel backupPanel = null;// ���ݿⱸ�����
	private JPanel restorePanel = null;// ���ݿ�ָ����
	private JTextField backupTextField;// ���ݿⱸ���ı���
	private JTextField restoreTextField = null;// ���ݿ�ָ��ı���
	private JButton backupButton = null;// �����ݡ���ť
	private JButton browseButton2 = null;// ���������ť
	private JButton restoreButton = null;// ���ָ�����ť

	public BackupAndRestore() {// ���ݿⱸ����ָ�����Ĺ��췽��
		super();// ���ø���JInternalFrame�Ĺ�����
		initialize();// ��ʼ�����ݿⱸ����ָ�����
	}

	private void initialize() {// ��ʼ�����ݿⱸ����ָ�����
		this.setSize(475, 221);// �������ݿⱸ����ָ�����Ŀ��
		this.setIconifiable(true);// �������ݿⱸ����ָ��������ͼ�껯
		this.setClosable(true);// ���ÿ��Թر����ݿⱸ����ָ�����
		this.setTitle("���ݿⱸ����ָ�");// �������ݿⱸ����ָ�����ı���
		this.setContentPane(getJContentPane());// �����������
	}

	private JPanel getJContentPane() {// ����������
		if (jContentPane == null) {// ������岻����
			jContentPane = new JPanel();// �����������
			jContentPane.setLayout(new BoxLayout(getJContentPane(),
					BoxLayout.Y_AXIS));// �����������Ĳ���Ϊ��ֱ���в���
			jContentPane.add(getBackupPanel(), null);// ���ݿⱸ�������ӵ����������
			jContentPane.add(getRestorePanel(), null);// ���ݿ�ָ������ӵ����������
		}
		return jContentPane;// �����������
	}

	private JPanel getBackupPanel() {// ������ݿⱸ�����
		if (backupPanel == null) {// ���ݿⱸ����岻����
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints1.gridx = 2;// ���λ������ĺ�������Ϊ2
			gridBagConstraints1.anchor = GridBagConstraints.EAST;// ���������ʾ���������
			gridBagConstraints1.gridy = 1;// ���λ���������������Ϊ1
			GridBagConstraints gridBagConstraints = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints.fill = GridBagConstraints.BOTH;// ���ˮƽ����ֱͬʱ������ռ�ݿհ�����
			gridBagConstraints.gridy = 0;// ���λ���������������Ϊ0
			gridBagConstraints.weightx = 1.0;// ���ˮƽ�����Ȩ����1.0
			gridBagConstraints.gridwidth = 2;// ������2������
			gridBagConstraints.gridx = 1;// ���λ������ĺ�������Ϊ1
			backupPanel = new JPanel();// ���ݿⱸ�����
			backupPanel.setLayout(new GridBagLayout());// �������ݿⱸ�����Ĳ���Ϊ���񲼾�
			backupPanel.setBorder(BorderFactory.createTitledBorder(null,
					"\u6570\u636e\u5e93\u5907\u4efd",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.blue));// �������ݿⱸ�����ı߿���ʽ����������
			backupPanel.add(getBackupTextField(), gridBagConstraints);// �����ݿⱸ���������ӡ����ݿⱸ�ݡ��ı���
			backupPanel.add(getBackupButton(), gridBagConstraints1);// �����ݿⱸ���������ӡ����ݡ���ť
		}
		return backupPanel;// �������ݿⱸ�����
	}

	private JPanel getRestorePanel() {// ������ݿ�ָ����
		if (restorePanel == null) {// ���ݿ�ָ���岻����
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints5.gridx = 1;// ���λ������ĺ�������Ϊ1
			gridBagConstraints5.gridy = 1;// ���λ���������������Ϊ1
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints4.gridx = 0;// ���λ������ĺ�������Ϊ0
			gridBagConstraints4.weightx = 1.0;// ���ˮƽ�����Ȩ����1.0
			gridBagConstraints4.anchor = GridBagConstraints.EAST;// ���������ʾ���������
			gridBagConstraints4.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
			gridBagConstraints4.gridy = 1;// ���λ���������������Ϊ1
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints3.gridy = 0;// ���λ���������������Ϊ0
			gridBagConstraints3.weightx = 1.0;// ���ˮƽ�����Ȩ����1.0
			gridBagConstraints3.gridwidth = 2;// ������2������
			gridBagConstraints3.gridx = 0;// ���λ������ĺ�������Ϊ0
			restorePanel = new JPanel();// ���ݿ�ָ����
			restorePanel.setLayout(new GridBagLayout());// �������ݿ�ָ����Ĳ���Ϊ���񲼾�
			restorePanel.setBorder(BorderFactory.createTitledBorder(null,
					"\u6570\u636e\u5e93\u6062\u590d",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.red));// �������ݿ�ָ����ı߿���ʽ����������
			restorePanel.add(getRestoreTextField(), gridBagConstraints3);// �����ݿ�ָ��������ӡ����ݿ�ָ����ı���
			restorePanel.add(getBrowseButton2(), gridBagConstraints4);// �����ݿ�ָ��������ӡ��������ť
			restorePanel.add(getRestoreButton(), gridBagConstraints5);// �����ݿ�ָ��������ӡ��ָ�����ť
		}
		return restorePanel;// �������ݿ�ָ����
	}

	private JTextField getBackupTextField() {// ��á����ݿⱸ�ݡ��ı���
		backupTextField = new JTextField();// �����ݿⱸ�ݡ��ı���
		backupTextField.setEditable(false);// ���� �����ݿⱸ�ݡ��ı��򲻿ɱ༭
		backupTextField.setFont(new Font("��Բ", Font.PLAIN, 14));// ����
																// �����ݿⱸ�ݡ��ı����������ʽ�������С
		backupTextField.setForeground(Color.BLUE);// ���á����ݿⱸ�ݡ��ı����е�������ɫΪ��ɫ
		backupTextField.setText("���ݿⱸ��·����");// ���á����ݿⱸ�ݡ��ı�����ı�����
		return backupTextField;// ���ء����ݿⱸ�ݡ��ı���
	}

	private JButton getBackupButton() {// ��á����ݡ���ť
		if (backupButton == null) {// �����ݡ���ť������
			backupButton = new JButton();// ���������ݡ���ť
			backupButton.setText("����(K)");// ���á����ݡ���ť�е���������
			backupButton.setMnemonic(KeyEvent.VK_K);// ���á����ݡ���ť�ļ������Ƿ�ΪK
			backupButton.addActionListener(new java.awt.event.ActionListener() {// �����ݡ���ť��Ӷ����¼��ļ���
						public void actionPerformed(ActionEvent e) {
							try {
								String filePath = Dao.backup();// ��ñ���sql�ļ���·��
								backupTextField.setText("���ݿⱸ��·����" + filePath);// ���á����ݿⱸ�ݡ��ı����е��ı�����
							} catch (Exception e1) {
								e1.printStackTrace();// ��ӡ�쳣��Ϣ
								String message = e1.getMessage();// ���ȫ���쳣��Ϣ
								int index = message.lastIndexOf(']');// ��á�]�����쳣��Ϣ�����һ�γ��ִ�������
								message = message.substring(index + 1);// �ش�������һ�γ���']'����쳣��Ϣ
								JOptionPane.showMessageDialog(
										BackupAndRestore.this, message);// �����쳣��Ϣ��ʾ��
								return;// �˳�Ӧ�ó���
							}
							JOptionPane.showMessageDialog(
									BackupAndRestore.this, "���ݳɹ�");// ���������ݳɹ�������ʾ��
						}
					});
		}
		return backupButton;// ���ء����ݡ���ť
	}

	private JTextField getRestoreTextField() {// ��á����ݿ�ָ����ı���
		if (restoreTextField == null) {// ��������ݿ�ָ����ı��򲻴���
			restoreTextField = new JTextField();// ���������ݿ�ָ����ı���
		}
		return restoreTextField;// ���ء����ݿ�ָ����ı���
	}

	private JButton getBrowseButton2() {// ��á��������ť
		if (browseButton2 == null) {// ���������ť������
			browseButton2 = new JButton();// �������������ť
			browseButton2.setText("���(W)����");// ���á��������ť�е��ı�����
			browseButton2.setMnemonic(KeyEvent.VK_W);// ���á��������ť�ļ������Ƿ�ΪW
			browseButton2
					.addActionListener(new java.awt.event.ActionListener() {// Ϊ���������ť��Ӷ����¼��ļ���
						public void actionPerformed(java.awt.event.ActionEvent e) {
							JFileChooser dirChooser = new JFileChooser(
									"./backup/");// �ѡ�./backup/����Ϊ·�������ļ�ѡ����
							int option = dirChooser
									.showOpenDialog(BackupAndRestore.this);// ��á��򿪡�����ȡ�����ķ���ֵ
							if (option == JFileChooser.APPROVE_OPTION) {// ������򿪡���ť
								File selFile = dirChooser.getSelectedFile();// ����ļ�ѡ�����е��ļ�
								restoreTextField.setText(selFile
										.getAbsolutePath());// ���á����ݿ�ָ����ı����е��ı�����
							}
						}
					});
		}
		return browseButton2;// ���ء��������ť
	}

	private JButton getRestoreButton() {// ��á��ָ�����ť
		if (restoreButton == null) {// ���ָ�����ť������
			restoreButton = new JButton();// �������ָ�����ť
			restoreButton.setText("�ָ�(R)");// ���á��ָ�����ť�е��ı�����
			restoreButton.setMnemonic(KeyEvent.VK_R);// ���á��ָ�����ť�ļ������Ƿ�ΪR
			restoreButton
					.addActionListener(new java.awt.event.ActionListener() {// Ϊ���ָ�����ť��Ӷ����¼��ļ���
						public void actionPerformed(java.awt.event.ActionEvent e) {
							String path = restoreTextField.getText();// ��á����ݿ�ָ����ı����е�·��
							if (path == null || path.isEmpty())// ·�������ڻ�·����û���ļ�
								return;// �˳�Ӧ�ó���
							File restoreFile = new File(path);// ����·�������ļ�����
							restoreFile.getAbsolutePath();// ����ļ�����ľ���·��
							try {
								Dao.restore(restoreFile.getAbsolutePath());// ���ݿ�ָ�
							} catch (Exception e1) {
								e1.printStackTrace();// ��ӡ�쳣��Ϣ
								String message = e1.getMessage();// ���ȫ���쳣��Ϣ
								int index = message.lastIndexOf(']');// ��á�]�����쳣��Ϣ�����һ�γ��ִ�������
								message = message.substring(index + 1);// �ش�������һ�γ���']'����쳣��Ϣ
								JOptionPane.showMessageDialog(
										BackupAndRestore.this, message);// �����쳣��Ϣ��ʾ��
								return;// �˳�Ӧ�ó���
							}
							JOptionPane.showMessageDialog(
									BackupAndRestore.this, "�ָ��ɹ�");// �������ָ��ɹ�������ʾ��
						}
					});
		}
		return restoreButton;// ���ء��ָ�����ť
	}

}