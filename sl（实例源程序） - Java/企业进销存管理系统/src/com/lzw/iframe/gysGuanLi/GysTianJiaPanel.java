package com.lzw.iframe.gysGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import keyListener.InputKeyListener;

import com.lzw.dao.Dao;
import com.lzw.dao.model.TbGysinfo;

public class GysTianJiaPanel extends JPanel {// ��Ӧ��������

	private JTextField EMailF;// ���������䡱�ı���
	private JTextField yinHangF;// ���������С��ı���
	private JTextField lianXiRenDianHuaF;// ����ϵ�˵绰���ı���
	private JTextField lianXiRenF;// ����ϵ�ˡ��ı���
	private JTextField chuanZhenF;// �����桱�ı���
	private JTextField dianHuaF;// ���绰���ı���
	private JTextField diZhiF;// ����ַ���ı���
	private JTextField bianMaF;// ���������롱�ı���
	private JTextField jianChengF;// ����ơ��ı���
	private JTextField quanChengF;// ����Ӧ��ȫ�ơ��ı���
	private JButton resetButton;// �����á��ı���

	public GysTianJiaPanel() {// ��Ӧ��������
		setLayout(new GridBagLayout());// ���ù�Ӧ��������Ĳ���Ϊ���񲼾�
		setBounds(10, 10, 510, 302);// ���ù�Ӧ���������λ������

		setupComponet(new JLabel("��Ӧ��ȫ�ƣ�"), 0, 0, 1, 1, false);// ���á���Ӧ��ȫ�ơ���ǩ��λ�ò���ӵ�������
		quanChengF = new JTextField();// ����Ӧ��ȫ�ơ��ı���
		setupComponet(quanChengF, 1, 0, 3, 400, true);// ���á���Ӧ��ȫ�ơ��ı����λ�ò���ӵ�������

		setupComponet(new JLabel("��ƣ�"), 0, 1, 1, 1, false);// ���á���ơ���ǩ��λ�ò���ӵ�������
		jianChengF = new JTextField();// ����ơ��ı���
		setupComponet(jianChengF, 1, 1, 1, 160, true);// ���á���ơ��ı����λ�ò���ӵ�������

		setupComponet(new JLabel("�������룺"), 2, 1, 1, 1, false);// ���á��������롱��ǩ��λ�ò���ӵ�������
		bianMaF = new JTextField();// ���������롱�ı���
		bianMaF.addKeyListener(new InputKeyListener());// Ϊ���������롱�ı�����Ӽ��������¼��ļ���
		setupComponet(bianMaF, 3, 1, 1, 0, true);// ���á��������롱�ı����λ�ò���ӵ�������

		setupComponet(new JLabel("��ַ��"), 0, 2, 1, 1, false);// ���á���ַ����ǩ��λ�ò���ӵ�������
		diZhiF = new JTextField();// ����ַ���ı���
		setupComponet(diZhiF, 1, 2, 3, 0, true);// ���á���ַ���ı����λ�ò���ӵ�������

		setupComponet(new JLabel("�绰��"), 0, 3, 1, 1, false);// ���á��绰����ǩ��λ�ò���ӵ�������
		dianHuaF = new JTextField();// ���绰���ı���
		dianHuaF.addKeyListener(new InputKeyListener());// Ϊ���绰���ı�����Ӽ��������¼��ļ���
		setupComponet(dianHuaF, 1, 3, 1, 0, true);// ���á��绰���ı����λ�ò���ӵ�������

		setupComponet(new JLabel("���棺"), 2, 3, 1, 1, false);// ���á����桱��ǩ��λ�ò���ӵ�������
		chuanZhenF = new JTextField();// �����桱�ı���
		chuanZhenF.addKeyListener(new InputKeyListener());// Ϊ�����桱�ı�����Ӽ��������¼��ļ���
		setupComponet(chuanZhenF, 3, 3, 1, 0, true);// ���á����桱�ı����λ�ò���ӵ�������

		setupComponet(new JLabel("��ϵ�ˣ�"), 0, 4, 1, 1, false);// ���á���ϵ�ˡ���ǩ��λ�ò���ӵ�������
		lianXiRenF = new JTextField();// ����ϵ�ˡ��ı���
		setupComponet(lianXiRenF, 1, 4, 1, 0, true);// ���á���ϵ�ˡ��ı����λ�ò���ӵ�������

		setupComponet(new JLabel("��ϵ�˵绰��"), 2, 4, 1, 1, false);// ���á���ϵ�˵绰����ǩ��λ�ò���ӵ�������
		lianXiRenDianHuaF = new JTextField();// ����ϵ�˵绰���ı���
		lianXiRenDianHuaF.addKeyListener(new InputKeyListener());// Ϊ����ϵ�˵绰���ı�����Ӽ��������¼��ļ���
		setupComponet(lianXiRenDianHuaF, 3, 4, 1, 0, true);// ���á���ϵ�˵绰���ı����λ�ò���ӵ�������

		setupComponet(new JLabel("�������У�"), 0, 5, 1, 1, false);// ���á��������С���ǩ��λ�ò���ӵ�������
		yinHangF = new JTextField();// ���������С��ı���
		setupComponet(yinHangF, 1, 5, 1, 0, true);// ���á��������С��ı����λ�ò���ӵ�������

		setupComponet(new JLabel("�������䣺"), 2, 5, 1, 1, false);// ���á��������䡱��ǩ��λ�ò���ӵ�������
		EMailF = new JTextField();// ���������䡱�ı���
		setupComponet(EMailF, 3, 5, 1, 0, true);// ���á��������䡱�ı����λ�ò���ӵ�������

		final JButton tjButton = new JButton();// ����ӡ���ť
		tjButton.addActionListener(new ActionListener() {// ����ӡ���ť�����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				// �ı���Ϊ��ʱ��������ʾ��
				if (diZhiF.getText().equals("") || quanChengF.getText().equals("") || chuanZhenF.getText().equals("")
						|| jianChengF.getText().equals("") || yinHangF.getText().equals("")
						|| bianMaF.getText().equals("") || diZhiF.getText().equals("")
						|| lianXiRenF.getText().equals("") || lianXiRenDianHuaF.getText().equals("")
						|| EMailF.getText().equals("") || dianHuaF.getText().equals("")) {
					JOptionPane.showMessageDialog(GysTianJiaPanel.this, "����дȫ����Ϣ");
					return;
				}
				// ִ��SQL��ѯ����õĽ����
				ResultSet haveUser = Dao.query("select * from tb_gysinfo where name='" + quanChengF.getText().trim() + "'");
				try {
					if (haveUser.next()) {// �����haveUser���г���һ���ļ�¼
						System.out.println("error");// ����̨���error
						JOptionPane.showMessageDialog(GysTianJiaPanel.this, "��Ӧ����Ϣ���ʧ�ܣ�����ͬ����Ӧ��", "��Ӧ�������Ϣ",
								JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
						return;
					}
				} catch (Exception er) {
					er.printStackTrace();
				}
				ResultSet set = Dao.query("select max(id) from tb_gysinfo");// ִ��SQL��ѯ����õĽ����
				String id = null;// ������Ӧ�̱��
				try {
					if (set != null && set.next()) {// �����set��Ϊ���ҽ����set���г���һ���ļ�¼
						String sid = set.getString(1).trim();// ��ý����set�еĵ�һ������ֵ
						if (sid == null)// ��һ������ֵΪ��
							id = "gys1001";// Ϊ��Ʒ��Ÿ�ֵ
						else {
							String str = sid.substring(3);// ������Ϊ3����ʼ��ȡ�ַ���
							id = "gys" + (Integer.parseInt(str) + 1);// ����ƴ���ַ�����ò�Ʒ���
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				TbGysinfo gysInfo = new TbGysinfo();// ��Ӧ����Ϣ
				gysInfo.setId(id);// ���ù�Ӧ�̱��
				gysInfo.setAddress(diZhiF.getText().trim());// ���ù�Ӧ�̵�ַ
				gysInfo.setBianma(bianMaF.getText().trim());// ������������
				gysInfo.setFax(chuanZhenF.getText().trim());// ���ô���
				gysInfo.setYh(yinHangF.getText().trim());// ���ÿ�������
				gysInfo.setJc(jianChengF.getText().trim());// ���ù�Ӧ�̼��
				gysInfo.setName(quanChengF.getText().trim());// ���ù�Ӧ������
				gysInfo.setLian(lianXiRenF.getText().trim());// ������ϵ��
				gysInfo.setLtel(lianXiRenDianHuaF.getText().trim());// ������ϵ�绰
				gysInfo.setMail(EMailF.getText().trim());// ���õ�������
				gysInfo.setTel(dianHuaF.getText().trim());// ���õ绰
				Dao.addGys(gysInfo);// ��ӹ�Ӧ����Ϣ
				JOptionPane.showMessageDialog(GysTianJiaPanel.this, "�ѳɹ���ӿͻ�", "�ͻ������Ϣ",
						JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
				resetButton.doClick();// �����á���ťִ�е���¼�
			}
		});
		tjButton.setText("���");// ����ӡ���ť
		setupComponet(tjButton, 2, 6, 1, 0, false);// ���á���ӡ���ť��λ�ò���ӵ�������

		resetButton = new JButton();// �����á���ť
		setupComponet(resetButton, 3, 6, 1, 0, false);// ���á����á���ť��λ�ò���ӵ�������
		resetButton.addActionListener(new ActionListener() {// �����á���ť�����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				// �����ı��������Ϊ��
				diZhiF.setText("");
				bianMaF.setText("");
				chuanZhenF.setText("");
				jianChengF.setText("");
				lianXiRenF.setText("");
				lianXiRenDianHuaF.setText("");
				EMailF.setText("");
				quanChengF.setText("");
				dianHuaF.setText("");
				yinHangF.setText("");
			}
		});
		resetButton.setText("����");// ���á����á���ť�е��ı�����
	}

	private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {// �������λ�ò���ӵ�������
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();// �����������ƶ���
		gridBagConstrains.gridx = gridx;// �������λ������ĺ�������Ϊgridx
		gridBagConstrains.gridy = gridy;// �������λ���������������Ϊgridy
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);// ����˴˵ļ��
		if (gridwidth > 1)// ����������������1
			gridBagConstrains.gridwidth = gridwidth;// ����������������Ϊgridwidth
		if (ipadx > 0)// ����������Ĵ�С����0
			gridBagConstrains.ipadx = ipadx;// ��������������Ĵ�С
		if (fill)// ���ռ�ݿհ�����
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		add(component, gridBagConstrains);// ������
	}
}