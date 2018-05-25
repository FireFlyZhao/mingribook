package com.lzw.iframe.keHuGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import keyListener.InputKeyListener;

import com.lzw.dao.Dao;
import com.lzw.dao.model.TbKhinfo;

public class KeHuTianJiaPanel extends JPanel {// �ͻ�������

	private JTextField keHuQuanCheng;// ���ͻ�ȫ�ơ��ı���
	private JTextField yinHangZhangHao;// �������˺š��ı���
	private JTextField kaiHuYinHang;// ���������С��ı���
	private JTextField EMail;// ��E-Mail���ı���
	private JTextField lianXiDianHua;// ����ϵ�绰���ı���
	private JTextField lianXiRen;// ����ϵ�ˡ��ı���
	private JTextField chuanZhen;// �����桱�ı���
	private JTextField dianHua;// ���绰���ı���
	private JTextField youZhengBianMa;// ���������롱�ı���
	private JTextField diZhi;// ���ͻ���ַ���ı���
	private JTextField keHuJianCheng;// ���ͻ���ơ��ı���
	private JButton resetButton;// �����á���ť�ı���

	public KeHuTianJiaPanel() {// �ͻ�������
		super();// ���ø���JPanel�Ĺ�����
		setBounds(10, 10, 460, 300);// ���ÿͻ��������λ������
		setLayout(new GridBagLayout());// ���ÿͻ�������Ĳ���Ϊ���񲼾�
		setVisible(true);// ʹ�ͻ�������ɼ�
		
		final JLabel khName = new JLabel();// ���ͻ�ȫ�ơ���ǩ
		khName.setText("�ͻ�ȫ�ƣ�");// ���á��ͻ�ȫ�ơ���ǩ���ı�����
		setupComponet(khName, 0, 0, 1, 0, false);// ���á��ͻ�ȫ�ơ���ǩ��λ�ò���ӵ�������
		keHuQuanCheng = new JTextField();// ���ͻ�ȫ�ơ��ı���
		setupComponet(keHuQuanCheng, 1, 0, 3, 350, true);// ���á��ͻ�ȫ�ơ��ı����λ�ò���ӵ�������
		
		final JLabel addressLabel = new JLabel("�ͻ���ַ��");// ���ͻ���ַ����ǩ
		setupComponet(addressLabel, 0, 1, 1, 0, false);// ���á��ͻ���ַ����ǩ��λ�ò���ӵ�������
		diZhi = new JTextField();// ���ͻ���ַ���ı���
		setupComponet(diZhi, 1, 1, 3, 0, true);// ���á��ͻ���ַ���ı����λ�ò���ӵ�������
		
		final JLabel jc = new JLabel();// ���ͻ���ơ���ǩ
		jc.setText("�ͻ���ƣ�");// ���á��ͻ���ơ���ǩ���ı�����
		setupComponet(jc, 0, 2, 1, 0, false);// ���á��ͻ���ơ���ǩ��λ�ò���ӵ�������
		keHuJianCheng = new JTextField();// ���ͻ���ơ��ı���
		setupComponet(keHuJianCheng, 1, 2, 1, 100, true);// ���á��ͻ���ơ��ı����λ�ò���ӵ�������
		
		setupComponet(new JLabel("�������룺"), 2, 2, 1, 0, false);// ���á��������롱��ǩ��λ�ò���ӵ�������
		youZhengBianMa = new JTextField();// ���������롱�ı���
		setupComponet(youZhengBianMa, 3, 2, 1, 100, true);// ���á��������롱�ı����λ�ò���ӵ�������
		youZhengBianMa.addKeyListener(new InputKeyListener());// Ϊ���������롱�ı�����Ӽ��������¼��ļ���
		
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
		
		final JButton saveButton = new JButton("����");// �����桱��ť
		setupComponet(saveButton, 1, 7, 1, 0, false);// ���á����桱��ť��λ�ò���ӵ�������
		saveButton.addActionListener(new SaveButtonActionListener());// Ϊ�����桱��ť��Ӷ����¼��ļ���
		
		resetButton = new JButton("����");// �����á���ť
		setupComponet(resetButton, 3, 7, 1, 0, false);// ���á����á���ť��λ�ò���ӵ�������
		resetButton.addActionListener(new ChongZheButtonActionListener());// Ϊ�����á���ť��Ӷ����¼��ļ���
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

	private final class SaveButtonActionListener implements ActionListener {// �����桱��ť�����¼��ļ���
		public void actionPerformed(final ActionEvent e) {
			// �ı���Ϊ��ʱ��������ʾ��
			if (diZhi.getText().equals("") || youZhengBianMa.getText().equals("") || chuanZhen.getText().equals("")
					|| yinHangZhangHao.getText().equals("") || keHuJianCheng.getText().equals("")
					|| keHuQuanCheng.getText().equals("") || lianXiRen.getText().equals("")
					|| lianXiDianHua.getText().equals("") || EMail.getText().equals("") || dianHua.getText().equals("")
					|| kaiHuYinHang.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "����дȫ����Ϣ");
				return;// �˳�Ӧ�ó���
			}
			// ִ��SQL��ѯ����õĽ����
			ResultSet haveUser = Dao.query("select * from tb_khinfo where khname='" + keHuQuanCheng.getText().trim() + "'");
			try {
				if (haveUser.next()) {// �����haveUser���г���һ���ļ�¼
					System.out.println("error");// ����̨���error
					JOptionPane.showMessageDialog(KeHuTianJiaPanel.this, "�ͻ���Ϣ���ʧ�ܣ�����ͬ���ͻ�", "�ͻ������Ϣ",
							JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
					return;
				}
			} catch (Exception er) {
				er.printStackTrace();
			}
			ResultSet set = Dao.query("select max(id) from tb_khinfo");// ִ��SQL��ѯ����õĽ����
			String id = null;// �����ͻ����
			try {
				if (set != null && set.next()) {// �����set��Ϊ���ҽ����set���г���һ���ļ�¼
					String sid = set.getString(1);// ��ý����set�еĵ�һ������ֵ
					if (sid == null)// ��һ������ֵΪ��
						id = "kh1001";// Ϊ��Ʒ��Ÿ�ֵ
					else {
						String str = sid.substring(2);// ������Ϊ2����ʼ��ȡ�ַ���
						id = "kh" + (Integer.parseInt(str) + 1);// ����ƴ���ַ�����ò�Ʒ���
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			TbKhinfo khinfo = new TbKhinfo();// �ͻ���Ϣ
			khinfo.setId(id);// ������Ʒ���
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
			Dao.addKeHu(khinfo);// ��ӿͻ���Ϣ
			JOptionPane.showMessageDialog(KeHuTianJiaPanel.this, "�ѳɹ���ӿͻ�", "�ͻ������Ϣ", JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
			resetButton.doClick();// �����á���ťִ�е���¼�
		}
	}

	private class ChongZheButtonActionListener implements ActionListener {// �����á���ť�����¼��ļ���
		public void actionPerformed(final ActionEvent e) {
			// �����ı��������Ϊ��
			keHuQuanCheng.setText("");
			yinHangZhangHao.setText("");
			kaiHuYinHang.setText("");
			EMail.setText("");
			lianXiDianHua.setText("");
			lianXiRen.setText("");
			chuanZhen.setText("");
			dianHua.setText("");
			youZhengBianMa.setText("");
			diZhi.setText("");
			keHuJianCheng.setText("");
		}
	}
}