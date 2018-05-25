package com.lzw.iframe.shangPinGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import com.lzw.Item;
import com.lzw.dao.Dao;
import com.lzw.dao.model.TbSpinfo;

public class ShangPinTianJiaPanel extends JPanel {// ��Ʒ������

	private JComboBox gysQuanCheng;// ����Ӧ��ȫ�ơ������б�
	private JTextField beiZhu;// ����ע���ı���
	private JTextField wenHao;// ����׼�ĺš��ı���
	private JTextField piHao;// �����š��ı���
	private JTextField baoZhuang;// ����װ���ı���
	private JTextField guiGe;// ������ı���
	private JTextField danWei;// ����λ���ı���
	private JTextField chanDi;// �����ء��ı���
	private JTextField jianCheng;// ����ơ��ı���
	private JTextField quanCheng;// ����Ʒ���ơ��ı���
	private JButton resetButton;// �����á���ť

	public ShangPinTianJiaPanel() {// ��Ʒ������
		setLayout(new GridBagLayout());// ������Ʒ������Ĳ���Ϊ���񲼾�
		setBounds(10, 10, 550, 400);// ������Ʒ�������λ������
		setupComponent(new JLabel("��Ʒ���ƣ�"), 0, 0, 1, 1, false);// ���á���Ʒ���ơ���ǩ��λ�ò���ӵ�������
		quanCheng = new JTextField();// ����Ʒ���ơ��ı���
		setupComponent(quanCheng, 1, 0, 3, 1, true);// ���á���Ʒ���ơ��ı����λ�ò���ӵ�������
		setupComponent(new JLabel("��ƣ�"), 0, 1, 1, 1, false);// ���á���ơ���ǩ��λ�ò���ӵ�������
		jianCheng = new JTextField();// ����ơ��ı���
		setupComponent(jianCheng, 1, 1, 3, 10, true);// ���á���ơ��ı����λ�ò���ӵ�������
		setupComponent(new JLabel("���أ�"), 0, 2, 1, 1, false);// ���á����ء���ǩ��λ�ò���ӵ�������
		chanDi = new JTextField();// �����ء��ı���
		setupComponent(chanDi, 1, 2, 3, 300, true);// ���á����ء��ı����λ�ò���ӵ�������
		setupComponent(new JLabel("��λ��"), 0, 3, 1, 1, false);// ���á���λ����ǩ��λ�ò���ӵ�������
		danWei = new JTextField();// ����λ���ı���
		setupComponent(danWei, 1, 3, 1, 130, true);// ���á���λ���ı����λ�ò���ӵ�������
		setupComponent(new JLabel("���"), 2, 3, 1, 1, false);// ���á���񡱱�ǩ��λ�ò���ӵ�������
		guiGe = new JTextField();// ������ı���
		setupComponent(guiGe, 3, 3, 1, 1, true);// ���á�����ı����λ�ò���ӵ�������
		setupComponent(new JLabel("��װ��"), 0, 4, 1, 1, false);// ���á���װ����ǩ��λ�ò���ӵ�������
		baoZhuang = new JTextField();// ����װ���ı���
		setupComponent(baoZhuang, 1, 4, 1, 1, true);// ���á���װ���ı����λ�ò���ӵ�������
		setupComponent(new JLabel("���ţ�"), 2, 4, 1, 1, false);// ���á����š���ǩ��λ�ò���ӵ�������
		piHao = new JTextField();// �����š��ı���
		setupComponent(piHao, 3, 4, 1, 1, true);// ���á����š��ı����λ�ò���ӵ�������
		setupComponent(new JLabel("��׼�ĺţ�"), 0, 5, 1, 1, false);// ���á���׼�ĺš���ǩ��λ�ò���ӵ�������
		wenHao = new JTextField();// ����׼�ĺš��ı���
		setupComponent(wenHao, 1, 5, 3, 1, true);// ���á���׼�ĺš��ı����λ�ò���ӵ�������
		setupComponent(new JLabel("��Ӧ��ȫ�ƣ�"), 0, 6, 1, 1, false);// ���á���Ӧ��ȫ�ơ���ǩ��λ�ò���ӵ�������
		gysQuanCheng = new JComboBox();// ����Ӧ��ȫ�ơ������б�
		gysQuanCheng.setMaximumRowCount(5);// ���á���Ӧ��ȫ�ơ������б���ʾ���������
		setupComponent(gysQuanCheng, 1, 6, 3, 1, true);// ���á���Ӧ��ȫ�ơ������б��λ�ò���ӵ�������
		setupComponent(new JLabel("��ע��"), 0, 7, 1, 1, false);// ���á���ע����ǩ��λ�ò���ӵ�������
		beiZhu = new JTextField();// ����ע���ı���
		setupComponent(beiZhu, 1, 7, 3, 1, true);// ���á���ע���ı����λ�ò���ӵ�������
		final JButton tjButton = new JButton();// ����ӡ���ť
		tjButton.addActionListener(new ActionListener() {// Ϊ����ӡ���ť��Ӷ����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				// �ı���Ϊ��ʱ��������ʾ��
				if (baoZhuang.getText().equals("") || chanDi.getText().equals("") || danWei.getText().equals("")
						|| guiGe.getText().equals("") || jianCheng.getText().equals("") || piHao.getText().equals("")
						|| wenHao.getText().equals("") || quanCheng.getText().equals("")) {
					JOptionPane.showMessageDialog(ShangPinTianJiaPanel.this, "�����δ��д����Ϣ��", "��Ʒ���",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				// ִ��SQL��ѯ����õĽ����
				ResultSet haveUser = Dao.query("select * from tb_spinfo where spname='" + quanCheng.getText().trim() + "'");
				try {
					if (haveUser.next()) {// �����haveUser���г���һ���ļ�¼
						System.out.println("error");// ����̨���error
						JOptionPane.showMessageDialog(ShangPinTianJiaPanel.this, "��Ʒ��Ϣ���ʧ�ܣ�����ͬ����Ʒ", "�ͻ������Ϣ",
								JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
						return;
					}
				} catch (Exception er) {
					er.printStackTrace();
				}
				ResultSet set = Dao.query("select max(id) from tb_spinfo");// ִ��SQL��ѯ����õĽ����
				String id = null;// ������Ʒ���
				try {
					if (set != null && set.next()) {// �����set��Ϊ���ҽ����set���г���һ���ļ�¼
						String sid = set.getString(1);// ��ý����set�еĵ�һ������ֵ
						if (sid == null)// ��һ������ֵΪ��
							id = "sp1001";// Ϊ��Ʒ��Ÿ�ֵ
						else {
							String str = sid.substring(2);// ������Ϊ2����ʼ��ȡ�ַ���
							id = "sp" + (Integer.parseInt(str) + 1);// ����ƴ���ַ�����ò�Ʒ���
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				TbSpinfo spInfo = new TbSpinfo();// ��Ʒ��Ϣ
				spInfo.setId(id);// ������Ʒ���
				spInfo.setBz(baoZhuang.getText().trim());// ���ð�װ
				spInfo.setCd(chanDi.getText().trim());// ���ò���
				spInfo.setDw(danWei.getText().trim());// ������Ʒ������λ
				spInfo.setGg(guiGe.getText().trim());// ������Ʒ���
				spInfo.setGysname(gysQuanCheng.getSelectedItem().toString().trim());// ���ù�Ӧ��ȫ��
				spInfo.setJc(jianCheng.getText().trim());// ������Ʒ���
				spInfo.setMemo(beiZhu.getText().trim());// ���ñ�ע
				spInfo.setPh(piHao.getText().trim());// ��������
				spInfo.setPzwh(wenHao.getText().trim());// ������׼�ĺ�
				spInfo.setSpname(quanCheng.getText().trim());// ������Ʒ����
				Dao.addSp(spInfo);// �����Ʒ��Ϣ
				JOptionPane.showMessageDialog(ShangPinTianJiaPanel.this, "��Ʒ��Ϣ�Ѿ��ɹ����", "��Ʒ���",
						JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
				resetButton.doClick();// �����á���ťִ�е���¼�
			}
		});
		tjButton.setText("���");// ����ӡ���ť
		setupComponent(tjButton, 1, 8, 1, 1, false);// ���á���ӡ���ť��λ�ò���ӵ�������
		final GridBagConstraints gridBagConstraints_20 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_20.weighty = 1.0;// ����ӡ���ť���������Ȩ����1.0
		gridBagConstraints_20.insets = new Insets(0, 65, 0, 15);// ����ӡ���ť����������˴˵ļ��
		gridBagConstraints_20.gridy = 8;// ����ӡ���ťλ���������������Ϊ8
		gridBagConstraints_20.gridx = 1;// ����ӡ���ťλ������ĺ�������Ϊ1
		resetButton = new JButton();// �����á���ť
		setupComponent(resetButton, 3, 8, 1, 1, false);// ���á����á���ť��λ�ò���ӵ�������
		resetButton.addActionListener(new ActionListener() {// �����á���ť�����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				// �����ı��������Ϊ��
				baoZhuang.setText("");
				chanDi.setText("");
				danWei.setText("");
				guiGe.setText("");
				jianCheng.setText("");
				beiZhu.setText("");
				piHao.setText("");
				wenHao.setText("");
				quanCheng.setText("");
			}
		});
		resetButton.setText("����");// ���á����á���ť�е��ı�����
	}

	private void setupComponent(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {// ���������λ�ò���ӵ�������
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

	public void initGysBox() {// ��ʼ����Ӧ������ѡ���
		List gysInfo = Dao.getGysInfos();// ��ȡ��Ӧ����Ϣ
		List<Item> items = new ArrayList<Item>();// �������ݹ�����ļ���
		gysQuanCheng.removeAllItems();// �Ƴ������б������еĹ�Ӧ��ȫ��
		for (Iterator iter = gysInfo.iterator(); iter.hasNext();) {// ����list����
			List element = (List) iter.next();// ��ü�������һ��Ԫ��
			Item item = new Item();// �������ݱ��������
			item.setId(element.get(0).toString().trim());// ���ñ������
			item.setName(element.get(1).toString().trim());// ����������Ϣ
			if (items.contains(item))// �����а������ݱ��������
				continue;// ��������ѭ��
			items.add(item);// �����в��������ݱ�������������������ݱ��������
			gysQuanCheng.addItem(item);// �������б���������ݱ��������
		}
	}
}