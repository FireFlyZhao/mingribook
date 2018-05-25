package com.lzw.iframe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;

import com.lzw.Item;
import com.lzw.dao.Dao;
import com.lzw.dao.model.TbKucun;

public class JiaGeTiaoZheng extends JInternalFrame {// �۸�����ڲ�����

	private TbKucun kcInfo;// �����Ϣ
	private JLabel guiGe;// ����񡱱�ǩ
	private JTextField kuCunJinE;// �������ı���
	private JTextField kuCunShuLiang;// ������������ı���
	private JTextField danJia;// �����ۡ��ı���
	private JComboBox shangPinMingCheng;// ����Ʒ���ơ������б�

	private void updateJinE() {// ���Ŀ����ķ���
		Double dj = Double.valueOf(danJia.getText());// �������ۡ��ı����е�����ת��ΪDouble��
		Integer sl = Integer.valueOf(kuCunShuLiang.getText());// ��������������ı����е�����ת��ΪInteger��
		kuCunJinE.setText((dj * sl) + "");// ���ġ������ı����е�����
	}

	public JiaGeTiaoZheng() {// �۸��������Ĺ��췽��
		super();// ���ø���JInternalFrame�Ĺ�����
		addInternalFrameListener(new InternalFrameAdapter() {// ����ڲ�����ļ����¼�
			public void internalFrameActivated(final InternalFrameEvent e) {
				DefaultComboBoxModel mingChengModel = (DefaultComboBoxModel) shangPinMingCheng.getModel();// �����б��Ĭ��ģ��
				mingChengModel.removeAllElements();// ����б�
				List list = Dao.getKucunInfos();// ��ÿ����Ϣ�ļ���
				Iterator iterator = list.iterator();// ����뼯��list��Ӧ�ĵ�����
				while (iterator.hasNext()) {// �������ļ���Ԫ���Ƿ񱻱�����
					List element = (List) iterator.next();// ��ü����е���һ��Ԫ��
					Item item = new Item();// ������ݱ�����
					item.setId((String) element.get(0));// ���ñ������
					item.setName((String) element.get(1));// ����������Ϣ
					mingChengModel.addElement(item);// �����ݱ�����Ķ�����ӵ������б���
				}
			}
		});
		setIconifiable(true);// ���ü۸�����������ͼ�껯
		setClosable(true);// ���ÿ��Թرռ۸��������
		getContentPane().setLayout(new GridBagLayout());// ���ü۸���������������Ĳ���Ϊ���񲼾�
		setTitle("�۸����");// ���ü۸��������ı���
		setBounds(100, 100, 531, 253);// ���ü۸���������λ������
		
		setupComponet(new JLabel("��Ʒ���ƣ�"), 0, 0, 1, 1, false);// ���á���Ʒ���ơ���ǩ��λ�ò���ӵ�������
		shangPinMingCheng = new JComboBox();// ����Ʒ���ơ������б�
		shangPinMingCheng.setPreferredSize(new Dimension(220, 21));// ���á���Ʒ���ơ������б�Ŀ��
		setupComponet(shangPinMingCheng, 1, 0, 1, 1, true);// ���á���Ʒ���ơ������б��λ�ò���ӵ�������
		
		setupComponet(new JLabel("�桡����"), 2, 0, 1, 0, false);// ���á���񡱱�ǩ��λ�ò���ӵ�������
		guiGe = new JLabel();// ����񡱱�ǩ
		guiGe.setForeground(Color.BLUE);// ���á���񡱱�ǩ�е�������ɫΪ��ɫ
		guiGe.setPreferredSize(new Dimension(130, 21));// ���á���񡱱�ǩ�Ŀ��
		setupComponet(guiGe, 3, 0, 1, 1, true);// ���á���񡱱�ǩ��λ�ò���ӵ�������
		
		setupComponet(new JLabel("�������أ� "), 0, 1, 1, 0, false);// ���á����ء���ǩ��λ�ò���ӵ�������
		final JLabel chanDi = new JLabel();// �����ء���ǩ
		chanDi.setForeground(Color.BLUE);// ���á����ء���ǩ�е�������ɫΪ��ɫ
		setupComponet(chanDi, 1, 1, 1, 1, true);// ���á����ء���ǩ��λ�ò���ӵ�������
		
		setupComponet(new JLabel("�򡡡��ƣ�"), 2, 1, 1, 0, false);// ���á���ơ���ǩ��λ�ò���ӵ�������
		final JLabel jianCheng = new JLabel();// ����ơ���ǩ
		jianCheng.setForeground(Color.BLUE);// ���á���ơ���ǩ�е�������ɫΪ��ɫ
		setupComponet(jianCheng, 3, 1, 1, 1, true);// ���á���ơ���ǩ��λ�ò���ӵ�������
		
		setupComponet(new JLabel("������װ��"), 0, 2, 1, 0, false);// ���á���װ����ǩ��λ�ò���ӵ�������
		final JLabel baoZhuang = new JLabel();// ����װ����ǩ
		baoZhuang.setForeground(Color.BLUE);// ���á���װ����ǩ�е�������ɫΪ��ɫ
		setupComponet(baoZhuang, 1, 2, 1, 1, true);// ���á���װ����ǩ��λ�ò���ӵ�������
		
		setupComponet(new JLabel("������λ��"), 2, 2, 1, 0, false);// ���á���λ����ǩ��λ�ò���ӵ�������
		final JLabel danWei = new JLabel();// ����λ����ǩ
		danWei.setForeground(Color.BLUE);// ���á���λ����ǩ�е�������ɫΪ��ɫ
		setupComponet(danWei, 3, 2, 1, 1, true);// ���á���λ����ǩ��λ�ò���ӵ�������
		
		setupComponet(new JLabel("�������ۣ�"), 0, 3, 1, 0, false);// ���á����ۡ���ǩ��λ�ò���ӵ�������
		danJia = new JTextField();// �����ۡ��ı���
		danJia.addKeyListener(new KeyAdapter() {// Ϊ�����ۡ��ı�����Ӽ����¼��ļ���
			public void keyReleased(final KeyEvent e) {
				updateJinE();// ���Ŀ����ķ���
			}
		});
		setupComponet(danJia, 1, 3, 1, 1, true);// ���á����ۡ��ı����λ�ò���ӵ�������
		
		setupComponet(new JLabel("���������"), 2, 3, 1, 0, false);// ���á������������ǩ��λ�ò���ӵ�������
		kuCunShuLiang = new JTextField();// ������������ı���
		kuCunShuLiang.setEditable(false);// ���á�����������ı��򲻿ɱ༭
		setupComponet(kuCunShuLiang, 3, 3, 1, 1, true);// ���á�����������ı����λ�ò���ӵ�������

		setupComponet(new JLabel("����"), 0, 4, 1, 0, false);// ���á�������ǩ��λ�ò���ӵ�������
		kuCunJinE = new JTextField();// �������ı���
		kuCunJinE.setEditable(false);// ���á������ı��򲻿ɱ༭
		setupComponet(kuCunJinE, 1, 4, 1, 1, true);// ���á������ı����λ�ò���ӵ�������

		final JButton okButton = new JButton();// ��ȷ������ť
		okButton.addActionListener(new ActionListener() {// Ϊ��ȷ������ť��Ӷ����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				kcInfo.setDj(Double.valueOf(danJia.getText()));// ���ÿ����Ϣ���еĵ���
				kcInfo.setKcsl(Integer.valueOf(kuCunShuLiang.getText()));// ���ÿ����Ϣ���еĿ������
				int rs = Dao.updateKucunDj(kcInfo);// ����޸Ŀ��ļ�¼����
				if (rs > 0)// �޸Ŀ��ļ�¼��������0
					JOptionPane.showMessageDialog(getContentPane(), "�۸������ϡ�", kcInfo.getSpname() + "�۸����",
							JOptionPane.QUESTION_MESSAGE);// �������۸������ϡ���ʾ��
			}
		});
		okButton.setText("ȷ��");// ���á�ȷ������ť�е��ı�����
		setupComponet(okButton, 1, 5, 1, 1, false);// ���á�ȷ������ť��λ�ò���ӵ�������

		final JButton closeButton = new JButton();// ���رա���ť
		closeButton.addActionListener(new ActionListener() {// Ϊ���رա���ť��Ӷ����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				JiaGeTiaoZheng.this.doDefaultCloseAction();// �رռ۸��������
			}
		});
		closeButton.setText("�ر�");// ���á��رա���ť�е��ı�����
		setupComponet(closeButton, 2, 5, 1, 1, false);// ���á��رա���ť��λ�ò���ӵ�������

		shangPinMingCheng.addItemListener(new ItemListener() {// Ϊ����Ʒ���ơ������б����ѡ���¼��ļ���
			public void itemStateChanged(final ItemEvent e) {
				Object selectedItem = shangPinMingCheng.getSelectedItem();// ��á���Ʒ���ơ������б�ѡ�е�ѡ��
				if (selectedItem == null)// ����Ʒ���ơ������б�ѡ�е�ѡ�����
					return;// �˳�Ӧ�ó���
				Item item = (Item) selectedItem;// ������ݱ�����
				kcInfo = Dao.getKucun(item);// ��ȡ�����Ϣ
				if (kcInfo.getId() == null)// �����Ϣ�е���Ʒ��Ų�����
					return;// �˳�Ӧ�ó���
				int dj, sl;// ���������ۡ��������������
				dj = kcInfo.getDj().intValue();// Ϊ�����ۡ���ֵ
				sl = kcInfo.getKcsl().intValue();// Ϊ�������������ֵ
				chanDi.setText(kcInfo.getCd());// ���á����ء���ǩ����ı�����
				jianCheng.setText(kcInfo.getJc());// ���á���ơ���ǩ����ı�����
				baoZhuang.setText(kcInfo.getBz());// ���á���װ����ǩ����ı�����
				danWei.setText(kcInfo.getDw());// ���á���λ����ǩ����ı�����
				danJia.setText(kcInfo.getDj() + "");// ���á����ۡ��ı�������ı�����
				kuCunShuLiang.setText(kcInfo.getKcsl() + "");// ���á�����������ı�������ı�����
				kuCunJinE.setText(dj * sl + "");// ���á������ı�������ı�����
				guiGe.setText(kcInfo.getGg());// ���á���񡱱�ǩ����ı�����
			}
		});
	}

	private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {// �������λ�ò���ӵ�������
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();// �����������ƶ���
		gridBagConstrains.gridx = gridx;// �������λ������ĺ�������Ϊgridx
		gridBagConstrains.gridy = gridy;// �������λ���������������Ϊgridy
		gridBagConstrains.insets = new Insets(5, 1, 3, 5);// ����˴˵ļ��
		if (gridwidth > 1)// ����������������1
			gridBagConstrains.gridwidth = gridwidth;// ����������������Ϊgridwidth
		if (ipadx > 0)// ����������Ĵ�С����0
			gridBagConstrains.ipadx = ipadx;// ��������������Ĵ�С
		if (fill)// ���ռ�ݿհ�����
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		getContentPane().add(component, gridBagConstrains);// ������
	}
}
