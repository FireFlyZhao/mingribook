package com.lzw.iframe;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.lzw.iframe.czyGl.*;

public class JsrGL extends JInternalFrame {// �����˹����ڲ�����
	public JsrGL() {// �����˹����ڲ�����Ĺ��췽��
		setIconifiable(true);// ����ͼ�껯
		setClosable(true);// ���Թر�
		setBounds(100, 100, 491, 200);// ���þ����˹����ڲ������λ�úͿ��
		setTitle("�����˹���");// ���þ����˹����ڲ�����ı���
		JTabbedPane tabPane = new JTabbedPane();// ����ѡ����
		final TJJingShouRen tjPanel = new TJJingShouRen();// ��Ӿ��������
		final SetJSR setPanel = new SetJSR();// ���þ��������
		tabPane.addTab("��Ӿ�����", null, tjPanel, "��Ӿ�����");// ����Ӿ����������ӵ�ѡ������
		tabPane.addTab("���þ�����", null, setPanel, "���þ�����");// �����þ����������ӵ�ѡ������
		getContentPane().add(tabPane);// ��ѡ������ӵ������˹����ڲ���������������
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				setPanel.initTable();// ��ʼ�����þ���������еı��ģ��
			}
		});
		pack();// �����˹����ڲ������е����������ѡ��С���в���
		setVisible(true);// ʹ�����˹����ڲ�����ɼ�
	}
}
