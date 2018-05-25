package com.lzw.iframe;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.table.*;
import javax.swing.JComboBox;

public class Jinhuo_Tuihuo_IFram extends JInternalFrame {// �����˻��ڲ�����

	private JPanel jContentPane = null;// �������
	private JPanel topPanel = null;// �������
	private JPanel bottomPanel = null;// �ײ����
	private JScrollPane tablePane = null;// ������
	private JTable table = null;// ���ģ��
	private JLabel idLabel = null;// ���˻�Ʊ�š���ǩ
	private JTextField idField = null;// ���˻�Ʊ�š��ı���
	private JLabel gysLabel = null;// ����Ӧ�̡���ǩ
	private JTextField gysField = null;// ����Ӧ�̡��ı���
	private JLabel lxrLabel = null;// ����ϵ�ˡ���ǩ
	private JTextField lxrField = null;// ����ϵ�ˡ��ı���
	private JLabel jsfsLabel = null;// �����㷽ʽ����ǩ
	private JComboBox jsfsComboBox = null;// �����㷽ʽ�������б�
	private JLabel thsjLabel = null;// ���˻�ʱ�䡱��ǩ
	private JTextField thsjField = null;// ���˻�ʱ�䡱�ı���
	private JLabel jsrLabel = null;// �������ˡ���ǩ
	private JTextField jsrField = null;// �������ˡ��ı���
	private JLabel pzslLabel = null;// ��Ʒ����������ǩ
	private JTextField pzslField = null;// ��Ʒ���������ı���
	private JLabel hpzsLabel = null;// ����Ʒ��������ǩ
	private JTextField hpzsField = null;// ����Ʒ�������ı���
	private JLabel hjjeLabel = null;// ���ϼƽ���ǩ
	private JTextField hjjeField = null;// ���ϼƽ��ı���
	private JLabel ysjlLabel = null;// �����ս��ۡ���ǩ
	private JTextField ysjlField = null;// �����ս��ۡ��ı���
	private JLabel czyLabel = null;// ������Ա����ǩ
	private JTextField czyField = null;// ������Ա���ı���
	private JButton tjButton = null;// ����ӡ���ť
	private JButton thButton = null;// ���˻�����ť
	private JComboBox spComboBox = null;// ����Ʒ�������б�

	public Jinhuo_Tuihuo_IFram() {// ����-�˻�����Ĺ��췽��
		super();// ���ø���JInternalFrame�Ĺ��췽��
		initialize();// ��ʼ������-�˻�����
	}

	private void initialize() {// ��ʼ������-�˻�����
		this.setSize(600, 320);// ���ý���-�˻�����Ŀ��
		this.setResizable(true);// ���Ե�������-�˻�����Ĵ�С
		this.setIconifiable(true);// ���ý���-�˻��������ͼ�껯
		this.setMaximizable(true);// ���ý���-�˻�����������
		this.setTitle("�����˻�");// ���ý���-�˻�����ı���
		this.setClosable(true);// ���ý���-�˻�������Թر�
		this.setContentPane(getJContentPane());// �����������
	}

	private JPanel getJContentPane() {// ����������
		if (jContentPane == null) {// ������岻����
			BorderLayout borderLayout = new BorderLayout();// �����߽粼��
			jContentPane = new JPanel();// �����������
			jContentPane.setLayout(borderLayout);// �����������Ĳ���Ϊ�߽粼��
			jContentPane.add(getTopPanel(), BorderLayout.NORTH);// �Ѷ�����������������ı���
			jContentPane.add(getBottomPanel(), BorderLayout.SOUTH);// �ѵײ�����������������ϲ�
			jContentPane.add(getTablePane(), BorderLayout.CENTER);// �ѱ������������������м�
		}
		return jContentPane;// �����������
	}

	private JPanel getTopPanel() {// ��ö������
		if (topPanel == null) {// ���������岻����
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints11.gridx = 9;// ���λ������ĺ�������Ϊ9
			gridBagConstraints11.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints11.weightx = 1.0;// �����������Ȩ����1.0
			gridBagConstraints11.gridy = 1;// ���λ���������������Ϊ1
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints10.gridy = 1;// ���λ���������������Ϊ1
			gridBagConstraints10.gridx = 8;// ���λ������ĺ�������Ϊ8
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints9.gridx = 5;// ���λ������ĺ�������Ϊ5
			gridBagConstraints9.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints9.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints9.gridy = 1;// ���λ���������������Ϊ1
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints8.gridy = 1;// ���λ���������������Ϊ1
			gridBagConstraints8.gridx = 4;// ���λ������ĺ�������Ϊ4
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints7.gridx = 1;// ���λ������ĺ�������Ϊ1
			gridBagConstraints7.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints7.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints7.gridy = 1;// ���λ���������������Ϊ1
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints6.gridy = 1;// ���λ���������������Ϊ1
			gridBagConstraints6.gridx = 0;// ���λ������ĺ�������Ϊ0
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints5.gridx = 9;// ���λ������ĺ�������Ϊ9
			gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints5.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints5.gridy = 0;// ���λ���������������Ϊ0
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints4.gridy = 0;// ���λ���������������Ϊ0
			gridBagConstraints4.fill = GridBagConstraints.NONE;// ���������
			gridBagConstraints4.gridx = 8;// ���λ������ĺ�������Ϊ8
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints3.gridx = 5;// ���λ������ĺ�������Ϊ5
			gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints3.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints3.gridy = 0;// ���λ���������������Ϊ0
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints2.gridy = 0;// ���λ���������������Ϊ0
			gridBagConstraints2.gridx = 4;// ���λ������ĺ�������Ϊ4
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints1.gridx = 1;// ���λ������ĺ�������Ϊ1
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints1.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints1.insets = new Insets(0, 0, 0, 1);// ����˴˵ļ��
			gridBagConstraints1.gridy = 0;// ���λ���������������Ϊ0
			GridBagConstraints gridBagConstraints = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints.gridy = 0;// ���λ���������������Ϊ0
			gridBagConstraints.gridx = 0;// ���λ������ĺ�������Ϊ0
			jsrLabel = new JLabel();// �������ˡ���ǩ
			jsrLabel.setText("�����ˣ�");// ���á������ˡ���ǩ����ı�����
			thsjLabel = new JLabel();// ���˻�ʱ�䡱��ǩ
			thsjLabel.setText("�˻�ʱ�䣺");// ���á��˻�ʱ�䡱��ǩ����ı�����
			jsfsLabel = new JLabel();// �����㷽ʽ����ǩ
			jsfsLabel.setText("���㷽ʽ��");// ���á����㷽ʽ����ǩ����ı�����
			lxrLabel = new JLabel();// ����ϵ�ˡ���ǩ
			lxrLabel.setText("��ϵ�ˣ�");// ���á���ϵ�ˡ���ǩ����ı�����
			gysLabel = new JLabel();// ����Ӧ�̡���ǩ
			gysLabel.setText("��Ӧ�̣�");// ���á���Ӧ�̡���ǩ����ı�����
			idLabel = new JLabel();// ���˻�Ʊ�š���ǩ
			idLabel.setText("�˻�Ʊ�ţ�");// ���á��˻�Ʊ�š���ǩ����ı�����
			topPanel = new JPanel();// �����������
			topPanel.setLayout(new GridBagLayout());// ���ö������Ĳ���Ϊ���񲼾�
			topPanel.add(idLabel, gridBagConstraints);// �ѡ��˻�Ʊ�š���ǩ�������񲼾�����Ӧ���������ƶ�����
			topPanel.add(getIdField(), gridBagConstraints1);// �ѡ��˻�Ʊ�š��ı����������񲼾�����Ӧ���������ƶ�����
			topPanel.add(gysLabel, gridBagConstraints2);// �ѡ���Ӧ�̡���ǩ�������񲼾�����Ӧ���������ƶ�����
			topPanel.add(getGysField(), gridBagConstraints3);// �ѡ���Ӧ�̡��ı����������񲼾�����Ӧ���������ƶ�����
			topPanel.add(lxrLabel, gridBagConstraints4);// �ѡ���ϵ�ˡ���ǩ�������񲼾�����Ӧ���������ƶ�����
			topPanel.add(getLxrField(), gridBagConstraints5);// �ѡ���ϵ�ˡ��ı����������񲼾�����Ӧ���������ƶ�����
			topPanel.add(jsfsLabel, gridBagConstraints6);// �ѡ����㷽ʽ����ǩ�������񲼾�����Ӧ���������ƶ�����
			topPanel.add(getJsfsComboBox(), gridBagConstraints7);// �ѡ����㷽ʽ�������б��������񲼾�����Ӧ���������ƶ�����
			topPanel.add(thsjLabel, gridBagConstraints8);// �ѡ��˻�ʱ�䡱��ǩ�������񲼾�����Ӧ���������ƶ�����
			topPanel.add(getThsjField(), gridBagConstraints9);// �ѡ��˻�ʱ�䡱�ı����������񲼾�����Ӧ���������ƶ�����
			topPanel.add(jsrLabel, gridBagConstraints10);// �ѡ������ˡ���ǩ�������񲼾�����Ӧ���������ƶ�����
			topPanel.add(getJsrField(), gridBagConstraints11);// �ѡ������ˡ��ı����������񲼾�����Ӧ���������ƶ�����
		}
		return topPanel;// ���ض������
	}

	private JPanel getBottomPanel() {// ��õײ����
		if (bottomPanel == null) {// ����ײ���岻����
			GridBagConstraints gridBagConstraints23 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints23.gridx = 6;// ���λ������ĺ�������Ϊ6
			gridBagConstraints23.fill = GridBagConstraints.NONE;// ���������
			gridBagConstraints23.gridy = 1;// ���λ���������������Ϊ1
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints22.gridx = 5;// ���λ������ĺ�������Ϊ5
			gridBagConstraints22.gridy = 1;// ���λ���������������Ϊ1
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints21.gridy = 1;// ���λ���������������Ϊ1
			gridBagConstraints21.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints21.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints21.gridx = 3;// ���λ������ĺ�������Ϊ3
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints20.gridx = 2;// ���λ������ĺ�������Ϊ2
			gridBagConstraints20.gridy = 1;// ���λ���������������Ϊ1
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints19.gridy = 1;// ���λ���������������Ϊ1
			gridBagConstraints19.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints19.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints19.gridx = 1;// ���λ������ĺ�������Ϊ1
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints18.gridx = 0;// ���λ������ĺ�������Ϊ0
			gridBagConstraints18.gridy = 1;// ���λ���������������Ϊ1
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints17.gridy = 0;// ���λ���������������Ϊ0
			gridBagConstraints17.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints17.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints17.anchor = GridBagConstraints.WEST;// ���������ʾ���������
			gridBagConstraints17.gridwidth = 2;// ������2������
			gridBagConstraints17.gridx = 5;// ���λ������ĺ�������Ϊ5
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints16.gridx = 4;// ���λ������ĺ�������Ϊ4
			gridBagConstraints16.gridy = 0;// ���λ���������������Ϊ0
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints15.gridy = 0;// ���λ���������������Ϊ0
			gridBagConstraints15.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints15.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints15.gridx = 3;// ���λ������ĺ�������Ϊ3
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints14.gridx = 2;// ���λ������ĺ�������Ϊ2
			gridBagConstraints14.gridy = 0;// ���λ���������������Ϊ0
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints13.gridy = 0;// ���λ���������������Ϊ0
			gridBagConstraints13.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints13.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints13.gridx = 1;// ���λ������ĺ�������Ϊ1
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints12.gridx = 0;// ���λ������ĺ�������Ϊ0
			gridBagConstraints12.anchor = GridBagConstraints.WEST;// ���������ʾ���������
			gridBagConstraints12.gridy = 0;// ���λ���������������Ϊ0
			czyLabel = new JLabel();// ������Ա����ǩ
			czyLabel.setText("����Ա��");// ���á�����Ա����ǩ����ı�����
			ysjlLabel = new JLabel();// �����ս��ۡ���ǩ
			ysjlLabel.setText("���ս��ۣ�");// ���á����ս��ۡ���ǩ����ı�����
			hjjeLabel = new JLabel();// ���ϼƽ���ǩ
			hjjeLabel.setText("�ϼƽ�");// ���á��ϼƽ���ǩ����ı�����
			hpzsLabel = new JLabel();// ����Ʒ��������ǩ
			hpzsLabel.setText("��Ʒ������");// ���á���Ʒ��������ǩ����ı�����
			pzslLabel = new JLabel();// ��Ʒ����������ǩ
			pzslLabel.setText("Ʒ��������");// ���á�Ʒ����������ǩ����ı�����
			bottomPanel = new JPanel();// �����ײ����
			bottomPanel.setLayout(new GridBagLayout());// ���õײ����Ĳ���Ϊ���񲼾�
			bottomPanel.add(pzslLabel, gridBagConstraints12);// �ѡ�Ʒ����������ǩ�������񲼾�����Ӧ���������ƶ�����
			bottomPanel.add(getPzslField(), gridBagConstraints13);// �ѡ�Ʒ���������ı����������񲼾�����Ӧ���������ƶ�����
			bottomPanel.add(hpzsLabel, gridBagConstraints14);// �ѡ���Ʒ��������ǩ�������񲼾�����Ӧ���������ƶ�����
			bottomPanel.add(getHpzsField(), gridBagConstraints15);// �ѡ���Ʒ�������ı����������񲼾�����Ӧ���������ƶ�����
			bottomPanel.add(hjjeLabel, gridBagConstraints16);// �ѡ��ϼƽ���ǩ�������񲼾�����Ӧ���������ƶ�����
			bottomPanel.add(getHjjeField(), gridBagConstraints17);// �ѡ��ϼƽ��ı����������񲼾�����Ӧ���������ƶ�����
			bottomPanel.add(ysjlLabel, gridBagConstraints18);// �ѡ����ս��ۡ���ǩ�������񲼾�����Ӧ���������ƶ�����
			bottomPanel.add(getYsjlField(), gridBagConstraints19);// �ѡ����ս��ۡ��ı����������񲼾�����Ӧ���������ƶ�����
			bottomPanel.add(czyLabel, gridBagConstraints20);// �ѡ�����Ա����ǩ�������񲼾�����Ӧ���������ƶ�����
			bottomPanel.add(getCzyField(), gridBagConstraints21);// �ѡ�����Ա���ı����������񲼾�����Ӧ���������ƶ�����
			bottomPanel.add(getTjButton(), gridBagConstraints22);// �ѡ���ӡ���ť�������񲼾�����Ӧ���������ƶ�����
			bottomPanel.add(getThButton(), gridBagConstraints23);// �ѡ��˻�����ť�������񲼾�����Ӧ���������ƶ�����
		}
		return bottomPanel;// ���صײ����
	}

	private JScrollPane getTablePane() {// ��ñ�����
		if (tablePane == null) {// ��������岻����
			tablePane = new JScrollPane();// �����������
			tablePane.setViewportView(getTable());// �������ģ�ʹ���
		}
		return tablePane;// ���ر�����
	}

	private JTable getTable() {// ��ñ��ģ��
		if (table == null) {// ������ģ��Ϊ��
			table = new JTable();// �������ģ��
			table.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));// ���ñ��ģ�͵ı߿���ʽ
			table.setShowGrid(true);// ����������
			String[] columnNames = { "��Ʒ����", "��Ʒ���", "����", "��λ", "���", "��װ", "����", "����" };// ��ͷ
			((DefaultTableModel) table.getModel()).setColumnIdentifiers(columnNames);// �������ģ�Ͷ�����������ӱ�ͷ
			TableColumn column = table.getColumnModel().getColumn(0);// �Ա��ģ��������Ϊ0����������
			final DefaultCellEditor editor = new DefaultCellEditor(getSpComboBox());// ������Ԫ��༭��
			editor.setClickCountToStart(2);// ��ʼ�༭��Ԫ������ĵ�������Ϊ2��
			column.setCellEditor(editor);// �༭�������е�Ԫ��ʱ���õı༭��
		}
		return table;// ���ر��ģ��
	}

	private JTextField getIdField() {// ��á��˻�Ʊ�š��ı���
		if (idField == null) {// ������˻�Ʊ�š��ı��򲻴���
			idField = new JTextField();// �������˻�Ʊ�š��ı���
		}
		return idField;// ���ء��˻�Ʊ�š��ı���
	}

	private JTextField getGysField() {// ��á���Ӧ�̡��ı���
		if (gysField == null) {// �������Ӧ�̡��ı��򲻴���
			gysField = new JTextField();// ��������Ӧ�̡��ı���
		}
		return gysField;// ���ء���Ӧ�̡��ı���
	}

	private JTextField getLxrField() {// ��á���ϵ�ˡ��ı���
		if (lxrField == null) {// �������ϵ�ˡ��ı��򲻴���
			lxrField = new JTextField();// ��������ϵ�ˡ��ı���
		}
		return lxrField;// ���ء���ϵ�ˡ��ı���
	}

	private JComboBox getJsfsComboBox() {// ��á����㷽ʽ�������б�
		if (jsfsComboBox == null) {// ��������㷽ʽ�������б�����
			jsfsComboBox = new JComboBox();// ���������㷽ʽ�������б�
		}
		return jsfsComboBox;// ���ء����㷽ʽ�������б�
	}

	private JTextField getThsjField() {// ��á��˻�ʱ�䡱�ı���
		if (thsjField == null) {// ������˻�ʱ�䡱�ı��򲻴���
			thsjField = new JTextField();// �������˻�ʱ�䡱�ı���
		}
		return thsjField;// ���ء��˻�ʱ�䡱�ı���
	}

	private JTextField getJsrField() {// ��á������ˡ��ı���
		if (jsrField == null) {// ����������ˡ��ı��򲻴���
			jsrField = new JTextField();// �����������ˡ��ı���
		}
		return jsrField;// ���ء������ˡ��ı���
	}

	private JTextField getPzslField() {// ��á�Ʒ���������ı���
		if (pzslField == null) {// �����Ʒ���������ı��򲻴���
			pzslField = new JTextField();// ������Ʒ���������ı���
		}
		return pzslField;// ���ء�Ʒ���������ı���
	}

	private JTextField getHpzsField() {// ��á���Ʒ�������ı���
		if (hpzsField == null) {// �������Ʒ�������ı��򲻴���
			hpzsField = new JTextField();// ��������Ʒ�������ı���
		}
		return hpzsField;// ���ء���Ʒ�������ı���
	}

	private JTextField getHjjeField() {// ��á��ϼƽ��ı���
		if (hjjeField == null) {// ������ϼƽ��ı��򲻴���
			hjjeField = new JTextField();// �������ϼƽ��ı���
		}
		return hjjeField;// ���ء��ϼƽ��ı���
	}

	private JTextField getYsjlField() {// ��á����ս��ۡ��ı���
		if (ysjlField == null) {// ��������ս��ۡ��ı��򲻴���
			ysjlField = new JTextField();// ���������ս��ۡ��ı���
		}
		return ysjlField;// ���ء����ս��ۡ��ı���
	}

	private JTextField getCzyField() {// ������Ա���ı���
		if (czyField == null) {// ���������Ա���ı��򲻴���
			czyField = new JTextField();// ����������Ա���ı���
		}
		return czyField;// ���ء�����Ա���ı���
	}

	private JButton getTjButton() {// ��á���ӡ���ť
		if (tjButton == null) {// �������ӡ���ť������
			tjButton = new JButton();// ��������ӡ���ť
			tjButton.setText("���");// ���á���ӡ���ť���ı�����
		}
		return tjButton;// ���ء���ӡ���ť
	}

	private JButton getThButton() {// ��á��˻�����ť
		if (thButton == null) {// ������˻�����ť������
			thButton = new JButton();// �������˻�����ť
			thButton.setText("�˻�");// ���á��˻�����ť���ı�����
		}
		return thButton;// ���ء��˻���ť��
	}

	private JComboBox getSpComboBox() {// ��á���Ʒ�������б�
		if (spComboBox == null) {// �������Ʒ�������б�����
			spComboBox = new JComboBox();// ��������Ʒ�������б�
		}
		return spComboBox;// ���ء���Ʒ�������б�
	}

}
