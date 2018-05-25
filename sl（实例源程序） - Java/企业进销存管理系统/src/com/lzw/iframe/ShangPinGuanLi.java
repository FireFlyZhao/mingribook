package com.lzw.iframe;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import com.lzw.iframe.shangPinGuanLi.*;

public class ShangPinGuanLi extends JInternalFrame {// ��Ʒ�����ڲ�����
	public ShangPinGuanLi() {// ��Ʒ�����ڲ�����Ĺ��췽��
		setIconifiable(true);// ����ͼ�껯
		setClosable(true);// ���Թر�
		setTitle("��Ʒ����");// ������Ʒ�����ڲ�����ı���
		JTabbedPane tabPane = new JTabbedPane();// ����ѡ����
		final ShangPinXiuGaiPanel spxgPanel = new ShangPinXiuGaiPanel();// ��Ʒ�޸����
		final ShangPinTianJiaPanel sptjPanel = new ShangPinTianJiaPanel();// ��Ʒ������
		tabPane.addTab("��Ʒ��Ϣ���", null, sptjPanel, "��Ʒ���");// ����Ʒ��������ӵ�ѡ������
		tabPane.addTab("��Ʒ��Ϣ�޸���ɾ��", null, spxgPanel, "�޸���ɾ��");// ����Ʒ�޸������ӵ�ѡ������
		getContentPane().add(tabPane);// ��ѡ������ӵ���Ʒ�����ڲ���������������
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spxgPanel.initComboBox();// ��ʼ����Ʒ�޸�����е���Ʒ����ѡ���
				spxgPanel.initGysBox();// ��ʼ����Ʒ�޸�����еĹ�Ӧ�������б�
			}
		});
		addInternalFrameListener(new InternalFrameAdapter(){
			public void internalFrameActivated(InternalFrameEvent e) {
				super.internalFrameActivated(e);
				sptjPanel.initGysBox();//��ʼ����Ʒ�������еĹ�Ӧ������ѡ���
			}
		});
		pack();// ��Ʒ�����ڲ������е����������ѡ��С���в���
		setVisible(true);// ʹ��Ʒ�����ڲ�����ɼ�
	}
}
