package com.lzw.iframe.gysGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import keyListener.InputKeyListener;

import com.lzw.Item;
import com.lzw.dao.Dao;
import com.lzw.dao.model.TbGysinfo;

public class GysXiuGaiPanel extends JPanel {// ��Ӧ���޸����
	
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
	private JComboBox gys;// ��ѡ��Ӧ�̡������б�
	
	public GysXiuGaiPanel() {// ��Ӧ���޸����
		setLayout(new GridBagLayout());// ���ù�Ӧ���޸����Ĳ���Ϊ���񲼾�
		setBounds(10, 10, 510, 302);// ���ù�Ӧ���޸�����λ�úͿ��

		setupComponet(new JLabel("��Ӧ��ȫ�ƣ�"), 0, 0, 1, 1, false);// ���á���Ӧ��ȫ�ơ���ǩ��λ�ò���ӵ�������
		quanChengF = new JTextField();// ����Ӧ��ȫ�ơ��ı���
		quanChengF.setEditable(false);// ���á���Ӧ��ȫ�ơ��ı��򲻿ɱ༭
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

		setupComponet(new JLabel("ѡ��Ӧ��"), 0, 7, 1, 0, false);// ���á�ѡ��Ӧ�̡���ǩ��λ�ò���ӵ�������
		gys = new JComboBox();// ��ѡ��Ӧ�̡������б�
		gys.setPreferredSize(new Dimension(230, 21));// ���á�ѡ��Ӧ�̡������б�Ŀ��
		initComboBox();// ��ʼ����ѡ��Ӧ�̡������б�
		gys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doGysSelectAction();// ��ѡ��Ӧ�̡������б��ѡ���¼�
			}
		});
		setupComponet(gys, 1, 7, 2, 0, true);// ���á�ѡ��Ӧ�̡������б��λ�ò���ӵ�������
		JButton modifyButton = new JButton("�޸�");// ���޸ġ���ť
		JButton delButton = new JButton("ɾ��");// ��ɾ������ť
		JPanel panel = new JPanel();// ��ť���
		panel.add(modifyButton);// �ѡ��޸ġ���ť�ŵ���ť�����
		panel.add(delButton);// �ѡ�ɾ������ť�ŵ���ť�����
		setupComponet(panel, 3, 7, 1, 0, false);// ���ð�ť����λ�ò���ӵ�������
		
		delButton.addActionListener(new ActionListener() {// ��ɾ������ť�����¼��ļ���
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) gys.getSelectedItem();// ������ݱ��������
				if (item == null || !(item instanceof Item))// ���ݱ��������Ϊ�ջ����ݱ�������������ݱ������ʵ��
					return;// �˳�����
				int confirm = JOptionPane.showConfirmDialog(GysXiuGaiPanel.this, "ȷ��ɾ����Ӧ����Ϣ��");// ������ȷ��ɾ����Ӧ����Ϣ�𣿡���ʾ��
				if (confirm == JOptionPane.YES_OPTION) {// �����ȷ�ϡ���
					int rs = Dao.delete("delete tb_gysInfo where id='" + item.getId() + "'");// ���ɾ����Ӧ����Ϣ������
					if (rs > 0) {// ɾ����Ӧ����Ϣ����������0
						JOptionPane.showMessageDialog(GysXiuGaiPanel.this, "��Ӧ�̣�" + item.getName() + "��ɾ���ɹ�");// ������ʾ��
						gys.removeItem(item);// �Ƴ���ѡ��Ӧ�̡������б�����ƥ������ݱ��������
					} else {// ɾ����Ӧ����Ϣ������������0
						JOptionPane.showMessageDialog(GysXiuGaiPanel.this, "�޷�ɾ����Ӧ�̣�" + item.getName() + "��");// ������ʾ��
					}
				}
			}
		});
		
		modifyButton.addActionListener(new ActionListener() {// ���޸ġ���ť�����¼��ļ���
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) gys.getSelectedItem();// ������ݱ��������
				TbGysinfo gysInfo = new TbGysinfo();// ��Ӧ����Ϣ
				gysInfo.setId(item.getId());// ���ù�Ӧ�̱��
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
				if (Dao.updateGys(gysInfo) == 1)// ���Ĺ�Ӧ����Ϣ����������1
					JOptionPane.showMessageDialog(GysXiuGaiPanel.this, "�޸����");// ������ʾ��
				else// ���Ĺ�Ӧ����Ϣ������������1
					JOptionPane.showMessageDialog(GysXiuGaiPanel.this, "�޸�ʧ��");// ������ʾ��
			}
		});
	}
	
	public void initComboBox() {// ��ʼ����ѡ��Ӧ�̡������б�
		List gysInfo = Dao.getGysInfos();// ��ȡ��Ӧ����Ϣ
		List<Item> items = new ArrayList<Item>();// �������ݹ�����ļ���
		gys.removeAllItems();// �Ƴ������б������еĹ�Ӧ������
		for (Iterator iter = gysInfo.iterator(); iter.hasNext();) {// ����list����
			List element = (List) iter.next();// ��ü�������һ��Ԫ��
			Item item = new Item();// �������ݱ��������
			item.setId(element.get(0).toString().trim());// ���ñ������
			item.setName(element.get(1).toString().trim());// ����������Ϣ
			if (items.contains(item))// �����а������ݱ��������
				continue;// ��������ѭ��
			items.add(item);// �����в��������ݱ���������򼯺���������ݱ��������
			gys.addItem(item);// �������б���������ݱ��������
		}
		doGysSelectAction();// ��ѡ��Ӧ�̡������б��ѡ���¼�
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
	
	private void doGysSelectAction() {// ��ѡ��Ӧ�̡������б��ѡ���¼�
		Item selectedItem;// ��ѡ��Ӧ�̡������б��е�ѡ��
		if (!(gys.getSelectedItem() instanceof Item)) {// ��ѡ��Ӧ�̡������б��е�ѡ������ݹ������һ��ʵ��
			return;// �˳�Ӧ�ó���
		}
		selectedItem = (Item) gys.getSelectedItem();// ��á�ѡ��Ӧ�̡������б��е�ѡ��
		TbGysinfo gysInfo = Dao.getGysInfo(selectedItem);// ��Ӧ����Ϣ
		quanChengF.setText(gysInfo.getName());// ���á���Ӧ��ȫ�ơ��ı����е��ı�����
		diZhiF.setText(gysInfo.getAddress());// ���á���ַ���ı����е��ı�����
		jianChengF.setText(gysInfo.getJc());// ���á���ơ��ı����е��ı�����
		bianMaF.setText(gysInfo.getBianma());// ���á��������롱�ı����е��ı�����
		dianHuaF.setText(gysInfo.getTel());// ���á��绰���ı����е��ı�����
		chuanZhenF.setText(gysInfo.getFax());// ���á����桱�ı����е��ı�����
		lianXiRenF.setText(gysInfo.getLian());// ���á���ϵ�ˡ��ı����е��ı�����
		lianXiRenDianHuaF.setText(gysInfo.getLtel());// ���á���ϵ�˵绰���ı����е��ı�����
		EMailF.setText(gysInfo.getMail());// ���á��������䡱�ı����е��ı�����
		yinHangF.setText(gysInfo.getYh());// ���á��������С��ı����е��ı�����
	}
}
