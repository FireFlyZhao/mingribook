package com.lzw.iframe;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.lzw.iframe.gysGuanLi.*;

public class GysGuanLi extends JInternalFrame {// ��Ӧ�̹����ڲ�����

	public GysGuanLi() {// ��Ӧ�̹�����Ĺ��췽��
		setIconifiable(true);// ���ù�Ӧ�̹��������ͼ�껯
		setClosable(true);// ���ÿ��Թرչ�Ӧ�̹�����
		setTitle("��Ӧ�̹���");// ���ù�Ӧ�̹�����ı���
		JTabbedPane tabPane = new JTabbedPane();// ����ѡ����
		final GysXiuGaiPanel spxgPanel = new GysXiuGaiPanel();// ��Ӧ���޸����
		final GysTianJiaPanel sptjPanel = new GysTianJiaPanel();// ��Ӧ��������
		tabPane.addTab("��Ӧ����Ϣ���", null, sptjPanel, "��Ӧ�����");// �ѹ�Ӧ����������ӵ�ѡ������
		tabPane.addTab("��Ӧ����Ϣ�޸���ɾ��", null, spxgPanel, "�޸���ɾ��");// �ѹ�Ӧ���޸������ӵ�ѡ������
		getContentPane().add(tabPane);// ��ѡ������ӵ���Ӧ�̹���������������
		tabPane.addChangeListener(new ChangeListener() {// ѡ������Ӳ���ѡ��ѡ������ı���¼�����
			public void stateChanged(ChangeEvent e) {
				spxgPanel.initComboBox();// ��ʼ����Ӧ���޸�����еġ�ѡ��Ӧ�̡������б�
			}
		});
		pack();// ��Ӧ�̹������е����������ѡ��С���в���
		setVisible(true);// ʹ��Ӧ�̹�����ɼ�
	}

}