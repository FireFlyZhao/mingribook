package com.lzw.iframe.shangPinGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import com.lzw.Item;
import com.lzw.dao.Dao;
import com.lzw.dao.model.*;

public class ShangPinXiuGaiPanel extends JPanel {// ��Ʒ�޸����

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
	private JButton modifyButton;// ���޸ġ���ť
	private JButton delButton;// ��ɾ������ť
	private JComboBox sp;// ��ѡ����Ʒ�������б�

	public ShangPinXiuGaiPanel() {// ��Ʒ�޸����
		setLayout(new GridBagLayout());// ������Ʒ�޸����Ĳ���Ϊ���񲼾�
		setBounds(10, 10, 550, 400);// ������Ʒ�޸�����λ������

		setupComponet(new JLabel("��Ʒ���ƣ�"), 0, 0, 1, 1, false);// ���á���Ʒ���ơ���ǩ��λ�ò���ӵ�������
		quanCheng = new JTextField();// ����Ʒ���ơ��ı���
		quanCheng.setEditable(false);// ���á���Ʒ���ơ��ı��򲻿ɱ༭
		setupComponet(quanCheng, 1, 0, 3, 1, true);// ���á���Ʒ���ơ��ı����λ�ò���ӵ�������

		setupComponet(new JLabel("��ƣ�"), 0, 1, 1, 1, false);// ���á���ơ���ǩ��λ�ò���ӵ�������
		jianCheng = new JTextField();// ����ơ��ı���
		setupComponet(jianCheng, 1, 1, 3, 10, true);// ���á���ơ��ı����λ�ò���ӵ�������

		setupComponet(new JLabel("���أ�"), 0, 2, 1, 1, false);// ���á����ء���ǩ��λ�ò���ӵ�������
		chanDi = new JTextField();// �����ء��ı���
		setupComponet(chanDi, 1, 2, 3, 300, true);// ���á����ء��ı����λ�ò���ӵ�������

		setupComponet(new JLabel("��λ��"), 0, 3, 1, 1, false);// ���á���λ����ǩ��λ�ò���ӵ�������
		danWei = new JTextField();// ����λ���ı���
		setupComponet(danWei, 1, 3, 1, 130, true);// ���á���λ���ı����λ�ò���ӵ�������

		setupComponet(new JLabel("���"), 2, 3, 1, 1, false);// ���á���񡱱�ǩ��λ�ò���ӵ�������
		guiGe = new JTextField();// ������ı���
		setupComponet(guiGe, 3, 3, 1, 1, true);// ���á�����ı����λ�ò���ӵ�������

		setupComponet(new JLabel("��װ��"), 0, 4, 1, 1, false);// ���á���װ����ǩ��λ�ò���ӵ�������
		baoZhuang = new JTextField();// ����װ���ı���
		setupComponet(baoZhuang, 1, 4, 1, 1, true);// ���á���װ���ı����λ�ò���ӵ�������

		setupComponet(new JLabel("���ţ�"), 2, 4, 1, 1, false);// ���á����š���ǩ��λ�ò���ӵ�������
		piHao = new JTextField();// �����š��ı���
		setupComponet(piHao, 3, 4, 1, 1, true);// ���á����š��ı����λ�ò���ӵ�������

		setupComponet(new JLabel("��׼�ĺţ�"), 0, 5, 1, 1, false);// ���á���׼�ĺš���ǩ��λ�ò���ӵ�������
		wenHao = new JTextField();// ����׼�ĺš��ı���
		setupComponet(wenHao, 1, 5, 3, 1, true);// ���á���׼�ĺš��ı����λ�ò���ӵ�������

		setupComponet(new JLabel("��Ӧ��ȫ�ƣ�"), 0, 6, 1, 1, false);// ���á���Ӧ��ȫ�ơ���ǩ��λ�ò���ӵ�������
		gysQuanCheng = new JComboBox();// ����Ӧ��ȫ�ơ������б�
		gysQuanCheng.setMaximumRowCount(5);// ���á���Ӧ��ȫ�ơ������б���ʾ���������
		setupComponet(gysQuanCheng, 1, 6, 3, 1, true);// ���á���Ӧ��ȫ�ơ������б��λ�ò���ӵ�������

		setupComponet(new JLabel("��ע��"), 0, 7, 1, 1, false);// ���á���ע����ǩ��λ�ò���ӵ�������
		beiZhu = new JTextField();// ����ע���ı���
		setupComponet(beiZhu, 1, 7, 3, 1, true);// ���á���ע���ı����λ�ò���ӵ�������

		setupComponet(new JLabel("ѡ����Ʒ"), 0, 8, 1, 0, false);// ���á�ѡ����Ʒ����ǩ��λ�ò���ӵ�������
		sp = new JComboBox();// ��ѡ����Ʒ�������б�
		sp.setPreferredSize(new Dimension(230, 21));// ���á�ѡ����Ʒ�������б�Ŀ��
		sp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSpSelectAction();// ��ѡ����Ʒ�������б����¼��ļ���
			}
		});
		setupComponet(sp, 1, 8, 2, 0, true);// ���á�ѡ����Ʒ�������б��λ�ò���ӵ�������
		modifyButton = new JButton("�޸�");// ���޸ġ���ť
		delButton = new JButton("ɾ��");// ��ɾ������ť
		JPanel panel = new JPanel();// ��ť���
		panel.add(modifyButton);// �ѡ��޸ġ���ť�ŵ���ť�����
		panel.add(delButton);// �ѡ�ɾ������ť�ŵ���ť�����
		setupComponet(panel, 3, 8, 1, 0, false);// ���ð�ť����λ�ò���ӵ�������

		delButton.addActionListener(new ActionListener() {// ��ɾ������ť�����¼��ļ���
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) sp.getSelectedItem();// ������ݱ��������
				if (item == null || !(item instanceof Item))// ���ݱ��������Ϊ�ջ����ݱ�������������ݱ������ʵ��
					return;// �˳�����
				int confirm = JOptionPane.showConfirmDialog(ShangPinXiuGaiPanel.this, "ȷ��ɾ����Ʒ��Ϣ��");// ������ȷ��ɾ����Ʒ��Ϣ�𣿡���ʾ��
				if (confirm == JOptionPane.YES_OPTION) {// �����ȷ�ϡ���
					int rs = Dao.delete("delete tb_spinfo where id='" + item.getId() + "'");// ���ɾ����Ʒ��Ϣ������
					if (rs > 0) {// ɾ����Ʒ��Ϣ����������0
						JOptionPane.showMessageDialog(ShangPinXiuGaiPanel.this, "��Ʒ��" + item.getName() + "��ɾ���ɹ�");// ������ʾ��
						sp.removeItem(item);// �Ƴ���ѡ����Ʒ�������б�����ƥ������ݱ��������
					}
				}
			}
		});

		modifyButton.addActionListener(new ActionListener() {// ���޸ġ���ť�����¼��ļ���
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) sp.getSelectedItem();// ������ݱ��������
				TbSpinfo spInfo = new TbSpinfo();// ��Ʒ��Ϣ
				spInfo.setId(item.getId());// ������Ʒ���
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
				if (Dao.updateSp(spInfo) == 1)// ������Ʒ��Ϣ����������1
					JOptionPane.showMessageDialog(ShangPinXiuGaiPanel.this, "�޸����");// ������ʾ��
				else// ������Ʒ��Ϣ������������1
					JOptionPane.showMessageDialog(ShangPinXiuGaiPanel.this, "�޸�ʧ��");// ������ʾ��
			}
		});
	}

	public void initComboBox() {// ��ʼ����Ʒ����ѡ���
		List khInfo = Dao.getSpInfos();// ��ȡ��Ʒ��Ϣ
		List<Item> items = new ArrayList<Item>();// �������ݹ�����ļ���
		sp.removeAllItems();// �Ƴ������б������е���Ʒ����
		for (Iterator iter = khInfo.iterator(); iter.hasNext();) {// ����list����
			List element = (List) iter.next();// ��ü�������һ��Ԫ��
			Item item = new Item();// �������ݱ��������
			item.setId(element.get(0).toString().trim());// ���ñ������
			item.setName(element.get(1).toString().trim());// ����������Ϣ
			if (items.contains(item))// �����а������ݱ��������
				continue;// ��������ѭ��
			items.add(item);// �����в��������ݱ���������򼯺���������ݱ��������
			sp.addItem(item);// �������б���������ݱ��������
		}
		doSpSelectAction();// ��ѡ����Ʒ�������б����¼��ļ���
	}

	public void initGysBox() {// ��ʼ����Ӧ�������б�
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
		doSpSelectAction();// ��ѡ����Ʒ�������б����¼��ļ���
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

	private void doSpSelectAction() {// ��ѡ����Ʒ�������б����¼��ļ���
		Item selectedItem;// ��ѡ����Ʒ�������б��е�ѡ��
		if (!(sp.getSelectedItem() instanceof Item)) {// ��ѡ����Ʒ�������б��е�ѡ������ݹ������һ��ʵ��
			return;// �˳�Ӧ�ó���
		}
		selectedItem = (Item) sp.getSelectedItem();// ��á�ѡ����Ʒ�������б��е�ѡ��
		TbSpinfo spInfo = Dao.getSpInfo(selectedItem);// ��Ʒ��Ϣ
		if (!spInfo.getId().isEmpty()) {// ��Ʒ��Ų�Ϊ��
			quanCheng.setText(spInfo.getSpname());// ���á���Ʒ���ơ��ı����е��ı�����
			baoZhuang.setText(spInfo.getBz());// ���á���װ���ı����е��ı�����
			chanDi.setText(spInfo.getCd());// ���á����ء��ı����е��ı�����
			danWei.setText(spInfo.getDw());// ���á���λ���ı����е��ı�����
			guiGe.setText(spInfo.getGg());// ���á�����ı����е��ı�����
			jianCheng.setText(spInfo.getJc());// ���á���ơ��ı����е��ı�����
			beiZhu.setText(spInfo.getMemo());// ���á���ע���ı����е��ı�����
			piHao.setText(spInfo.getPh());// ���á����š��ı����е��ı�����
			wenHao.setText(spInfo.getPzwh());// ���á���׼�ĺš��ı����е��ı�����
			
			Item item = new Item();// ���ݱ�����
			item.setId(null);// ���ñ������Ϊ��
			item.setName(spInfo.getGysname());// ����������ϢΪ����Ӧ�����ơ�
			TbGysinfo gysInfo = Dao.getGysInfo(item);// ��ù�Ӧ����Ϣ
			item.setId(gysInfo.getId());// ���ñ������Ϊ��Ӧ�̱��
			item.setName(gysInfo.getName());// ����������ϢΪ����Ӧ�����ơ�
			for (int i = 0; i < gysQuanCheng.getItemCount(); i++) {// ��������Ӧ��ȫ�ơ������б��е�ѡ��
				Item gys = (Item) gysQuanCheng.getItemAt(i);// ��á���Ӧ��ȫ�ơ������б�ĵ�ǰѡ����
				if (gys.getName().equals(item.getName())) {// ��Ӧ��������ͬ
					item = gys;// Ϊ���ݱ������е�ʵ����ֵ
				}
			}
			gysQuanCheng.setSelectedItem(item);// ���á���Ӧ��ȫ�ơ������б�ĵ�ǰѡ����
		}
	}
}
