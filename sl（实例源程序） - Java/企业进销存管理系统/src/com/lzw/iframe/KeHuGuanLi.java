package com.lzw.iframe;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.lzw.iframe.keHuGuanLi.*;

public class KeHuGuanLi extends JInternalFrame {// �ͻ������ڲ�����
	public KeHuGuanLi() {// �ͻ������ڲ�����Ĺ��췽��
		setIconifiable(true);// ����ͼ�껯
		setClosable(true);// ���Թر�
		setTitle("�ͻ���Ϣ����");// ���ÿͻ������ڲ�����ı���
		JTabbedPane tabPane = new JTabbedPane();// ����ѡ����
		final KeHuXiuGaiPanel khxgPanel = new KeHuXiuGaiPanel();// �ͻ��޸����
		final KeHuTianJiaPanel khtjPanel = new KeHuTianJiaPanel();// �ͻ�������
		tabPane.addTab("�ͻ���Ϣ���", null, khtjPanel, "�ͻ����");// �ѿͻ���������ӵ�ѡ������
		tabPane.addTab("�ͻ���Ϣ�޸���ɾ��", null, khxgPanel, "�޸���ɾ��");// �ѿͻ��޸������ӵ�ѡ������
		getContentPane().add(tabPane);// ��ѡ������ӵ��ͻ������ڲ���������������
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				khxgPanel.initComboBox();// ��ʼ���ͻ��޸�����еġ�ѡ��ͻ��������б�
			}
		});
		pack();// �ͻ������ڲ������е����������ѡ��С���в���
		setVisible(true);// ʹ�ͻ������ڲ�����ɼ�
	}
}
