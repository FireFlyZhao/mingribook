package com.lzw;

import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import com.lzw.dao.*;

public class ToolBar extends JToolBar {// ������
	
	private MenuBar menuBar;// �˵���

	/**
	 * ȱʡ���캯��
	 */
	private ToolBar() {
	}

	/**
	 * �������캯��
	 */
	public ToolBar(MenuBar frameMenuBar) {
		super();// ���ø���JToolBar�Ĺ�����
		this.menuBar = frameMenuBar;
		initialize();// �����ʼ������
	}

	/**
	 * �����ʼ������
	 */
	private void initialize() {
		setSize(new Dimension(600, 24));// ���ù������Ŀ��
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));// ���ù������ı߿�
		add(createToolButton(menuBar.getJinhuoItem()));// �򹤾�������ӽ�����
		add(createToolButton(menuBar.getXiaoshou_danItem()));// �򹤾�����������۵�
		add(createToolButton(menuBar.getKucun_pandianItem()));// �򹤾�������ӿ���̵�
		add(createToolButton(menuBar.getJiage_tiaozhengItem()));// �򹤾�������Ӽ۸����
		add(createToolButton(menuBar.getShangpin_chaxunItem()));// �򹤾����������Ʒ��ѯ
		add(createToolButton(menuBar.getShangpin_guanliItem()));// �򹤾����������Ʒ���Ϲ���
		add(createToolButton(menuBar.getKehu_guanliItem()));// �򹤾�������ӿͻ����Ϲ���
		add(createToolButton(menuBar.getGys_guanliItem()));// �򹤾�������ӹ�Ӧ�����Ϲ���
		add(createToolButton(menuBar.getExitItem()));// �򹤾���������˳�ϵͳ
	}

	/**
	 * ������������ť�ķ���
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton createToolButton(final JMenuItem item) {
		JButton button = new JButton();// ��������ť
		button.setText(item.getText());// ���ù�������ť���ı�����
		button.setToolTipText(item.getText());// ���ù�������ť������Ч��
		button.setIcon(item.getIcon());// ���ù�������ť��ͼ��
		button.setFocusable(false);// �ù�������ťʧȥ����
		button.addActionListener(new java.awt.event.ActionListener() {// Ϊ��������ť��Ӷ����¼��ļ���
			public void actionPerformed(java.awt.event.ActionEvent e) {
				item.doClick();// �˵���ĵ���¼�
			}
		});
		return button;
	}

	public void setMenuBar(MenuBar menuBar) {// ���ò˵���
		this.menuBar = menuBar;
	}
}
