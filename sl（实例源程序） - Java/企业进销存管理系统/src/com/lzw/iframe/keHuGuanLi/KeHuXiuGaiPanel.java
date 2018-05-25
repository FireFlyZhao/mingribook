package com.lzw.iframe.keHuGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import keyListener.InputKeyListener;

import com.lzw.Item;
import com.lzw.dao.Dao;
import com.lzw.dao.model.TbKhinfo;

public class KeHuXiuGaiPanel extends JPanel {// �ͻ��޸����

	private JTextField keHuQuanCheng;// ���ͻ�ȫ�ơ��ı���
	private JTextField yinHangZhangHao;// �������˺š��ı���
	private JTextField kaiHuYinHang;// ���������С��ı���
	private JTextField EMail;// ��E-Mail���ı���
	private JTextField lianXiDianHua;// ����ϵ�绰���ı���
	private JTextField lianXiRen;// ����ϵ�ˡ��ı���
	private JTextField chuanZhen;// �����桱�ı���
	private JTextField dianHua;// ���绰���ı���
	private JTextField youZhengBianMa;// ���������롱�ı���
	private JTextField diZhi;// ����ַ���ı���
	private JTextField keHuJianCheng;// ���ͻ���ơ��ı���
	private JButton modifyButton;// ���޸ġ���ť
	private JButton delButton;// ��ɾ������ť
	private JComboBox kehu;// ��ѡ��ͻ��������б�

	public KeHuXiuGaiPanel() {// �ͻ��޸����
		setBounds(10, 10, 460, 300);// ���ÿͻ��޸�����λ������
		setLayout(new GridBagLayout());// ���ÿͻ��޸����Ĳ���Ϊ���񲼾�
		setVisible(true);// ʹ�ͻ��޸����ɼ�

		final JLabel khName = new JLabel();// ���ͻ�ȫ�ơ���ǩ
		khName.setText("�ͻ�ȫ�ƣ�");// ���á��ͻ�ȫ�ơ���ǩ���ı�����
		setupComponet(khName, 0, 0, 1, 0, false);// ���á��ͻ�ȫ�ơ���ǩ��λ�ò���ӵ�������
		keHuQuanCheng = new JTextField();// ���ͻ�ȫ�ơ��ı���
		keHuQuanCheng.setEditable(false);// ���á��ͻ�ȫ�ơ��ı��򲻿ɱ༭
		setupComponet(keHuQuanCheng, 1, 0, 3, 350, true);// ���á��ͻ�ȫ�ơ��ı����λ�ò���ӵ�������

		final JLabel addressLabel = new JLabel("�ͻ���ַ��");// ���ͻ���ַ����ǩ
		setupComponet(addressLabel, 0, 1, 1, 0, false);// ���á��ͻ���ַ����ǩ��λ�ò���ӵ�������
		diZhi = new JTextField();// ���ͻ���ַ���ı���
		setupComponet(diZhi, 1, 1, 3, 0, true);// ���á��ͻ���ַ���ı����λ�ò���ӵ�������

		setupComponet(new JLabel("�ͻ���ƣ�"), 0, 2, 1, 0, false);// ���á��ͻ���ơ���ǩ��λ�ò���ӵ�������
		keHuJianCheng = new JTextField();// ���ͻ���ơ��ı���
		setupComponet(keHuJianCheng, 1, 2, 1, 130, true);// ���á��ͻ���ơ��ı����λ�ò���ӵ�������

		setupComponet(new JLabel("�������룺"), 2, 2, 1, 0, false);// ���á��������롱��ǩ��λ�ò���ӵ�������
		youZhengBianMa = new JTextField();// ���������롱�ı���
		setupComponet(youZhengBianMa, 3, 2, 1, 100, true);// ���á��������롱�ı����λ�ò���ӵ�������
		youZhengBianMa.addKeyListener(new InputKeyListener());// Ϊ���������롱�ı�����Ӽ���ʱ��ļ���

		setupComponet(new JLabel("�绰��"), 0, 3, 1, 0, false);// ���á��绰����ǩ��λ�ò���ӵ�������
		dianHua = new JTextField();// ���绰���ı���
		setupComponet(dianHua, 1, 3, 1, 100, true);// ���á��绰���ı����λ�ò���ӵ�������
		dianHua.addKeyListener(new InputKeyListener());// Ϊ���绰���ı�����Ӽ��������¼��ļ���

		setupComponet(new JLabel("���棺"), 2, 3, 1, 0, false);// ���á����桱��ǩ��λ�ò���ӵ�������
		chuanZhen = new JTextField();// �����桱�ı���
		chuanZhen.addKeyListener(new InputKeyListener());// Ϊ�����桱�ı�����Ӽ��������¼��ļ���
		setupComponet(chuanZhen, 3, 3, 1, 100, true);// ���á����桱�ı����λ�ò���ӵ�������

		setupComponet(new JLabel("��ϵ�ˣ�"), 0, 4, 1, 0, false);// ���á���ϵ�ˡ���ǩ��λ�ò���ӵ�������
		lianXiRen = new JTextField();// ����ϵ�ˡ��ı���
		setupComponet(lianXiRen, 1, 4, 1, 100, true);// ���á���ϵ�ˡ��ı����λ�ò���ӵ�������

		setupComponet(new JLabel("��ϵ�绰��"), 2, 4, 1, 0, false);// ���á���ϵ�绰����ǩ��λ�ò���ӵ�������
		lianXiDianHua = new JTextField();// ����ϵ�绰���ı���
		setupComponet(lianXiDianHua, 3, 4, 1, 100, true);// ���á���ϵ�绰���ı����λ�ò���ӵ�������
		lianXiDianHua.addKeyListener(new InputKeyListener());// Ϊ����ϵ�绰���ı�����Ӽ��������¼��ļ���

		setupComponet(new JLabel("E-Mail��"), 0, 5, 1, 0, false);// ���á�E-Mail����ǩ��λ�ò���ӵ�������
		EMail = new JTextField();// ��E-Mail���ı���
		setupComponet(EMail, 1, 5, 3, 350, true);// ���á�E-Mail���ı����λ�ò���ӵ�������

		setupComponet(new JLabel("�������У�"), 0, 6, 1, 0, false);// ���á��������С���ǩ��λ�ò���ӵ�������
		kaiHuYinHang = new JTextField();// ���������С��ı���
		setupComponet(kaiHuYinHang, 1, 6, 1, 100, true);// ���á��������С��ı����λ�ò���ӵ�������

		setupComponet(new JLabel("�����˺ţ�"), 2, 6, 1, 0, false);// ���á������˺š���ǩ��λ�ò���ӵ�������
		yinHangZhangHao = new JTextField();// �������˺š��ı���
		setupComponet(yinHangZhangHao, 3, 6, 1, 100, true);// ���á������˺š��ı����λ�ò���ӵ�������

		setupComponet(new JLabel("ѡ��ͻ�"), 0, 7, 1, 0, false);// ���á�ѡ��ͻ�����ǩ��λ�ò���ӵ�������
		kehu = new JComboBox();// ��ѡ��ͻ��������б�
		kehu.setPreferredSize(new Dimension(230, 21));// ���á�ѡ��ͻ��������б���
		initComboBox();// ��ʼ������ѡ���
		kehu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doKeHuSelectAction();// Ϊ��ѡ��ͻ��������б���Ӷ����¼��ļ���
			}
		});
		setupComponet(kehu, 1, 7, 2, 0, true);// ���á�ѡ��ͻ��������б��λ�ò���ӵ�������
		modifyButton = new JButton("�޸�");// ���޸ġ���ť
		delButton = new JButton("ɾ��");// ��ɾ������ť
		JPanel panel = new JPanel();// ������
		panel.add(modifyButton);// �����������ӡ��޸ġ���ť
		panel.add(delButton);// �����������ӡ�ɾ������ť
		setupComponet(panel, 3, 7, 1, 0, false);// ���ñ������λ�ò���ӵ�������
		
		delButton.addActionListener(new ActionListener() {// ��ɾ������ť�Ķ����¼��ļ���
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) kehu.getSelectedItem();// ������ݱ��������
				if (item == null || !(item instanceof Item))// ���ݱ��������Ϊ�ջ����ݱ�������������ݱ������ʵ��
					return;// �˳�����
				int confirm = JOptionPane.showConfirmDialog(KeHuXiuGaiPanel.this, "ȷ��ɾ���ͻ���Ϣ��");// ������ȷ��ɾ���ͻ���Ϣ�𣿡���ʾ��
				if (confirm == JOptionPane.YES_OPTION) {// �����ȷ�ϡ���
					int rs = Dao.delete("delete tb_khinfo where id='" + item.getId() + "'");// ���ɾ���ͻ���Ϣ������
					if (rs > 0) {// ɾ���ͻ���Ϣ����������0
						JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "�ͻ���" + item.getName() + "��ɾ���ɹ�");// ������ʾ��
						kehu.removeItem(item);// �Ƴ���ѡ��ͻ��������б�����ƥ������ݱ��������
					}
				}
			}
		});
		
		modifyButton.addActionListener(new ActionListener() {// ���޸ġ���ť�Ķ����¼��ļ���
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) kehu.getSelectedItem();// ������ݱ��������
				TbKhinfo khinfo = new TbKhinfo();// �ͻ���Ϣ
				khinfo.setId(item.getId());// ���ÿͻ����
				khinfo.setAddress(diZhi.getText().trim());// ���ÿͻ���ַ
				khinfo.setBianma(youZhengBianMa.getText().trim());// �����ʱ�
				khinfo.setFax(chuanZhen.getText().trim());// ���ô���
				khinfo.setHao(yinHangZhangHao.getText().trim());// ���������˺�
				khinfo.setJian(keHuJianCheng.getText().trim());// ���ÿͻ����
				khinfo.setKhname(keHuQuanCheng.getText().trim());// ���ÿͻ�����
				khinfo.setLian(lianXiRen.getText().trim());// ������ϵ��
				khinfo.setLtel(lianXiDianHua.getText().trim());// ������ϵ�绰
				khinfo.setMail(EMail.getText().trim());// ���õ�������
				khinfo.setTel(dianHua.getText().trim());// ���õ绰
				khinfo.setXinhang(kaiHuYinHang.getText());// ���ÿ�������
				if (Dao.updateKeHu(khinfo) == 1)// ���Ŀͻ���Ϣ����������1
					JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "�޸����");// ������ʾ��
				else// ���Ŀͻ���Ϣ������������1
					JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "�޸�ʧ��");// ������ʾ��
			}
		});
	}

	public void initComboBox() {// ��ʼ����ѡ��ͻ��������б�
		List khInfo = Dao.getKhInfos();// ��ȡ�ͻ���Ϣ
		List<Item> items = new ArrayList<Item>();// �������ݹ�����ļ���
		kehu.removeAllItems();// �Ƴ������б������еĿͻ�����
		for (Iterator iter = khInfo.iterator(); iter.hasNext();) {// ����list����
			List element = (List) iter.next();// ��ü�������һ��Ԫ��
			Item item = new Item();// �������ݱ��������
			item.setId(element.get(0).toString().trim());// ���ñ������
			item.setName(element.get(1).toString().trim());// ����������Ϣ
			if (items.contains(item))// �����а������ݱ��������
				continue;// ��������ѭ��
			items.add(item);// �����в��������ݱ���������򼯺���������ݱ��������
			kehu.addItem(item);// �������б���������ݱ��������
		}
		doKeHuSelectAction();// ��ѡ��ͻ��������б����¼��ļ���
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

	private void doKeHuSelectAction() {// ��ѡ��ͻ��������б����¼��ļ���
		Item selectedItem;// ��ѡ��ͻ��������б��е�ѡ��
		if (!(kehu.getSelectedItem() instanceof Item)) {// ��ѡ��ͻ��������б��е�ѡ������ݹ������һ��ʵ��
			return;// �˳�Ӧ�ó���
		}
		selectedItem = (Item) kehu.getSelectedItem();// ��á�ѡ��ͻ��������б��е�ѡ��
		TbKhinfo khInfo = Dao.getKhInfo(selectedItem);// �ͻ���Ϣ
		keHuQuanCheng.setText(khInfo.getKhname());// ���á��ͻ�ȫ�ơ��ı����е��ı�����
		diZhi.setText(khInfo.getAddress());// ���á���ַ���ı����е��ı�����
		keHuJianCheng.setText(khInfo.getJian());// ���á��ͻ���ơ��ı����е��ı�����
		youZhengBianMa.setText(khInfo.getBianma());// ���á��������롱�ı����е��ı�����
		dianHua.setText(khInfo.getTel());// ���á��绰���ı����е��ı�����
		chuanZhen.setText(khInfo.getFax());// ���á����桱�ı����е��ı�����
		lianXiRen.setText(khInfo.getLian());// ���á���ϵ�ˡ��ı����е��ı�����
		lianXiDianHua.setText(khInfo.getLtel());// ���á���ϵ�绰���ı����е��ı�����
		EMail.setText(khInfo.getMail());// ���á�E-Mail���ı����е��ı�����
		kaiHuYinHang.setText(khInfo.getXinhang());// ���á��������С��ı����е��ı�����
		yinHangZhangHao.setText(khInfo.getHao());// ���á������˺š��ı����е��ı�����
	}
}
