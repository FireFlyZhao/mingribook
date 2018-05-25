package com.lzw.iframe;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import com.lzw.*;
import com.lzw.dao.Dao;
import com.lzw.dao.model.*;

public class JinHuoTuiHuo extends JInternalFrame {// ����-�˻��ڲ�����

	private final JTable table;// ���ģ��
	private final JTextField thsj = new JTextField();// ���˻�ʱ�䡱�ı���
	private JComboBox jsr = null;// �������ˡ������б�
	private final JComboBox jsfs = new JComboBox();// �����㷽ʽ�������б�
	private final JTextField lian = new JTextField();// ����ϵ�ˡ��ı���
	private final JComboBox gys = new JComboBox();// ����Ӧ�̡������б�
	private final JTextField piaoHao = new JTextField();// ���˻�Ʊ�š��ı���
	private final JTextField pzs = new JTextField("0");// ��Ʒ���������ı���
	private final JTextField hpzs = new JTextField("0");// ����Ʒ�������ı���
	private final JTextField hjje = new JTextField("0");// ���ϼƽ��ı���
	private final JTextField ysjl = new JTextField();// �����ս��ۡ��ı���
	private final JTextField czy = new JTextField();// ������Ա���ı���
	private Date thsjDate;// ���˻�ʱ�䡱
	private JComboBox sp;// ����Ʒ�������б�

	public JinHuoTuiHuo() {// ����-�˻��ڲ�����Ĺ��췽��
		super();// ���ø���JInternalFrame�Ĺ�����
		setMaximizable(true);// �������
		setIconifiable(true);// ����ͼ�껯
		setClosable(true);// ����-�˻��ڲ�������Թر�
		getContentPane().setLayout(new GridBagLayout());// ���ý���-�˻��ڲ�����Ĳ���Ϊ���񲼾�
		setTitle("����-�˻�");// ���ý���-�˻��ڲ�����ı���
		setBounds(50, 50, 700, 400);// ���ý���-�˻��ڲ������λ�úͿ��
		// ���˻�Ʊ�š���ǩ�롰�˻�Ʊ�š��ı���
		setupComponet(new JLabel("�˻�Ʊ�ţ�"), 0, 0, 1, 0, false);
		piaoHao.setFocusable(false);
		setupComponet(piaoHao, 1, 0, 1, 140, true);
		// ����Ӧ�̡���ǩ�롰��Ӧ�̡������б�
		setupComponet(new JLabel("��Ӧ�̣�"), 2, 0, 1, 0, false);
		gys.setPreferredSize(new Dimension(160, 21));
		gys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doGysSelectAction();// ����Ӧ�̡������б��ѡ���¼�
			}
		});
		setupComponet(gys, 3, 0, 1, 1, true);
		// ����ϵ�ˡ���ǩ�롰��ϵ�ˡ��ı���
		setupComponet(new JLabel("��ϵ�ˣ�"), 4, 0, 1, 0, false);
		lian.setFocusable(false);
		lian.setPreferredSize(new Dimension(80, 21));
		setupComponet(lian, 5, 0, 1, 0, true);
		// �����㷽ʽ����ǩ�롰���㷽ʽ�������б�
		setupComponet(new JLabel("���㷽ʽ��"), 0, 1, 1, 0, false);
		jsfs.addItem("�ֽ�");
		jsfs.addItem("֧Ʊ");
		jsfs.setEditable(true);
		setupComponet(jsfs, 1, 1, 1, 1, true);
		// ���˻�ʱ�䡱��ǩ�롰�˻�ʱ�䡱�ı���
		setupComponet(new JLabel("�˻�ʱ�䣺"), 2, 1, 1, 0, false);
		thsj.setFocusable(false);
		setupComponet(thsj, 3, 1, 1, 1, true);
		// �������ˡ���ǩ�롰�����ˡ������б�
		setupComponet(new JLabel("�����ˣ�"), 4, 1, 1, 0, false);
		setupComponet(getJsrComboBox(), 5, 1, 1, 1, true);
		// ����Ʒ�������б�
		sp = new JComboBox();
		sp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TbKucun info = (TbKucun) sp.getSelectedItem();
				if (info != null && info.getId() != null) {// ���ѡ����Ч�͸��±��
					updateTable();
				}
			}
		});
		// ���ģ��
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		initTable();
		table.addContainerListener(new computeInfo());// ����¼����Ʒ����������Ʒ�������ϼƽ��ļ���
		JScrollPane scrollPanel = new JScrollPane(table);
		scrollPanel.setPreferredSize(new Dimension(380, 200));
		setupComponet(scrollPanel, 0, 2, 6, 1, true);
		// ��Ʒ����������ǩ�롰Ʒ���������ı���
		setupComponet(new JLabel("Ʒ��������"), 0, 3, 1, 0, false);
		pzs.setFocusable(false);
		setupComponet(pzs, 1, 3, 1, 1, true);
		// ����Ʒ��������ǩ�롰��Ʒ�������ı���
		setupComponet(new JLabel("��Ʒ������"), 2, 3, 1, 0, false);
		hpzs.setFocusable(false);
		setupComponet(hpzs, 3, 3, 1, 1, true);
		// ���ϼƽ���ǩ�롰�ϼƽ��ı���
		setupComponet(new JLabel("�ϼƽ�"), 4, 3, 1, 0, false);
		hjje.setFocusable(false);
		setupComponet(hjje, 5, 3, 1, 1, true);
		// �����ս��ۡ���ǩ�롰���ս��ۡ��ı���
		setupComponet(new JLabel("���ս��ۣ�"), 0, 4, 1, 0, false);
		setupComponet(ysjl, 1, 4, 1, 1, true);
		// ��������Ա����ǩ�롰������Ա���ı���
		setupComponet(new JLabel("������Ա��"), 2, 4, 1, 0, false);
		czy.setFocusable(false);
		czy.setText(MainFrame.getCzyStateLabel().getText());
		setupComponet(czy, 3, 4, 1, 1, true);

		JButton tjButton = new JButton("���");// ����ӡ���ť
		tjButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ʼ���˺�Ʊ��
				initPiaoHao();
				// ���������û�б�д�ĵ�Ԫ
				stopTableCellEditing();
				// �������л��������У��Ͳ����������
				for (int i = 0; i < table.getRowCount(); i++) {
					TbKucun info = (TbKucun) table.getValueAt(i, 0);
					if (info == null || info.getId().isEmpty())
						return;
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Vector());
				initSpBox();
			}
		});
		setupComponet(tjButton, 4, 4, 1, 1, false);

		JButton rkButton = new JButton("�˻�");// ���˻�����ť
		rkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���������û�б�д�ĵ�Ԫ
				stopTableCellEditing();
				// �������
				clearEmptyRow();
				String hpzsStr = hpzs.getText();// ��Ʒ����
				String pzsStr = pzs.getText();// Ʒ����
				String jeStr = hjje.getText();// �ϼƽ��
				String jsfsStr = jsfs.getSelectedItem().toString();// ���㷽ʽ
				String jsrStr = jsr.getSelectedItem() + "";// ������
				String czyStr = czy.getText();// ����Ա
				String rkDate = thsjDate.toLocaleString();// ���ʱ��
				String ysjlStr = ysjl.getText().trim();// ���ս���
				String id = piaoHao.getText();// Ʊ��
				String gysName = gys.getSelectedItem().toString();// ��Ӧ������
				if (jsrStr == null || jsrStr.isEmpty()) {
					JOptionPane.showMessageDialog(JinHuoTuiHuo.this, "����д������");
					return;
				}
				if (ysjlStr == null || ysjlStr.isEmpty()) {
					JOptionPane.showMessageDialog(JinHuoTuiHuo.this, "��д���ս���");
					return;
				}
				if (table.getRowCount() <= 0) {
					JOptionPane.showMessageDialog(JinHuoTuiHuo.this, "����˻���Ʒ");
					return;
				}
				TbRkthMain rkthMain = new TbRkthMain(id, pzsStr, jeStr, ysjlStr, gysName, rkDate, czyStr, jsrStr, jsfsStr);
				Set<TbRkthDetail> set = rkthMain.getTbRkthDetails();
				int rows = table.getRowCount();
				for (int i = 0; i < rows; i++) {
					TbKucun kucun = (TbKucun) table.getValueAt(i, 0);
					String djStr = (String) table.getValueAt(i, 6);
					String slStr = (String) table.getValueAt(i, 7);
					Double dj = Double.valueOf(djStr);
					Integer sl = Integer.valueOf(slStr);
					TbRkthDetail detail = new TbRkthDetail();
					detail.setSpid(kucun.getId());
					detail.setTbRkthMain(rkthMain.getRkthId());
					detail.setDj(dj);
					detail.setSl(sl);
					set.add(detail);
				}
				boolean rs = Dao.insertRkthInfo(rkthMain);
				if (rs) {
					JOptionPane.showMessageDialog(JinHuoTuiHuo.this, "�˻����");
					DefaultTableModel dftm = new DefaultTableModel();
					table.setModel(dftm);
					initTable();
					pzs.setText("0");
					hpzs.setText("0");
					hjje.setText("0");
				}
			}
		});
		setupComponet(rkButton, 5, 4, 1, 1, false);
		addInternalFrameListener(new initTasks());// ��Ӵ������������ɳ�ʼ��
	}

	/**
	 * ��á������ˡ������б�ķ���
	 * 
	 * @return �������ˡ������б�
	 */
	private JComboBox getJsrComboBox() {
		if (jsr == null) {
			jsr = new JComboBox();
			List<List> czyList = Dao.getJsrs();
			for (List<String> list : czyList) {
				String id = list.get(0);
				String name = list.get(1);
				Item item = new Item(id, name);
				item.setId(id + "");
				item.setName(name);
				jsr.addItem(item);
			}
		}
		return jsr;
	}

	private void initTable() {// ��ʼ�����
		String[] columnNames = { "��Ʒ����", "��Ʒ���", "����", "��λ", "���", "��װ", "����", "����" };// ��ͷ
		((DefaultTableModel) table.getModel()).setColumnIdentifiers(columnNames);// �������ģ�Ͷ�����������ӱ�ͷ
		TableColumn column = table.getColumnModel().getColumn(0);// �Ա��ģ��������Ϊ0����������
		final DefaultCellEditor editor = new DefaultCellEditor(sp);// ������Ԫ��༭��
		editor.setClickCountToStart(2);// ��ʼ�༭��Ԫ������ĵ�������Ϊ2��
		column.setCellEditor(editor);// �༭�������е�Ԫ��ʱ���õı༭��
	}

	private void initSpBox() {// ��ʼ������Ʒ�������б�
		List list = new ArrayList();
		ResultSet set = Dao.query("select * from tb_kucun where " + "id in(select id from tb_spinfo where gysName='"
				+ gys.getSelectedItem() + "')");
		sp.removeAllItems();
		sp.addItem(new TbKucun());
		for (int i = 0; table != null && i < table.getRowCount(); i++) {
			TbKucun tmpInfo = (TbKucun) table.getValueAt(i, 0);
			if (tmpInfo != null && tmpInfo.getId() != null)
				list.add(tmpInfo.getId());
		}
		try {
			while (set.next()) {
				TbKucun kucun = new TbKucun();
				kucun.setId(set.getString("id").trim());
				if (list.contains(kucun.getId()))// ���������Դ���ͬ����Ʒ����Ʒ�������оͲ��ٰ�������Ʒ
					continue;
				kucun.setSpname(set.getString("spname").trim());
				kucun.setCd(set.getString("cd").trim());
				kucun.setJc(set.getString("jc").trim());
				kucun.setDw(set.getString("dw").trim());
				kucun.setGg(set.getString("gg").trim());
				kucun.setBz(set.getString("bz").trim());
				kucun.setDj(Double.valueOf(set.getString("dj").trim()));
				kucun.setKcsl(Integer.valueOf(set.getString("kcsl").trim()));
				sp.addItem(kucun);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		getContentPane().add(component, gridBagConstrains);// ������
	}

	private void doGysSelectAction() {// ѡ��Ӧ��ʱ������ϵ���ֶ�
		Item item = (Item) gys.getSelectedItem();
		TbGysinfo gysInfo = Dao.getGysInfo(item);
		lian.setText(gysInfo.getLian());
	}

	private final class computeInfo implements ContainerListener {// ���¼��м���Ʒ����������Ʒ�������ϼƽ��
		public void componentRemoved(ContainerEvent e) {
			// �������
			clearEmptyRow();
			// �������
			int rows = table.getRowCount();
			int count = 0;
			double money = 0.0;
			// ����Ʒ������
			TbKucun column = null;
			if (rows > 0)
				column = (TbKucun) table.getValueAt(rows - 1, 0);
			if (rows > 0 && (column == null || column.getId().isEmpty()))
				rows--;
			// �����Ʒ�����ͽ��
			for (int i = 0; i < rows; i++) {
				String column7 = (String) table.getValueAt(i, 7);
				String column6 = (String) table.getValueAt(i, 6);
				int c7 = (column7 == null || column7.isEmpty()) ? 0 : Integer.parseInt(column7);
				Double c6 = (column6 == null || column6.isEmpty()) ? 0 : Double.valueOf(column6);
				count += c7;
				money += c6 * c7;
			}
			pzs.setText(rows + "");
			hpzs.setText(count + "");
			hjje.setText(money + "");
		}

		public void componentAdded(ContainerEvent e) {
		}
	}

	private final class initTasks extends InternalFrameAdapter {// ����ĳ�ʼ������
		public void internalFrameActivated(InternalFrameEvent e) {
			super.internalFrameActivated(e);
			initTimeField();// �����˻�ʱ���߳�
			initGysField();// ��ʼ����Ӧ���ֶ�
			initPiaoHao();// ��ʼ�����˻�Ʊ�š�
			initSpBox();// ��ʼ������Ʒ�������б�
		}

		private void initGysField() {// ��ʼ����Ӧ���ֶ�
			List gysInfos = Dao.getGysInfos();
			for (Iterator iter = gysInfos.iterator(); iter.hasNext();) {
				List list = (List) iter.next();
				Item item = new Item();
				item.setId(list.get(0).toString().trim());
				item.setName(list.get(1).toString().trim());
				gys.addItem(item);
			}
			doGysSelectAction();
		}

		private void initTimeField() {// �����˻�ʱ���߳�
			new Thread(new Runnable() {
				public void run() {
					try {
						while (true) {
							thsjDate = new Date();
							thsj.setText(thsjDate.toLocaleString());
							Thread.sleep(1000);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

	private void initPiaoHao() {// ��ʼ�����˻�Ʊ�š�
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		String maxId = Dao.getRkthMainMaxId(date);
		piaoHao.setText(maxId);
	}

	private synchronized void updateTable() {// ������Ʒ�������ѡ�񣬸��±��ǰ�е�����
		TbKucun kucun = (TbKucun) sp.getSelectedItem();
		int row = table.getSelectedRow();
		if (row >= 0 && kucun != null) {
			table.setValueAt(kucun.getId(), row, 1);
			table.setValueAt(kucun.getCd(), row, 2);
			table.setValueAt(kucun.getDw(), row, 3);
			table.setValueAt(kucun.getGg(), row, 4);
			table.setValueAt(kucun.getBz(), row, 5);
			table.setValueAt(kucun.getDj().toString(), row, 6);
			table.setValueAt(kucun.getKcsl().toString(), row, 7);
			table.editCellAt(row, 7);
		}
	}

	private synchronized void clearEmptyRow() {// �������
		DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		for (int i = 0; i < table.getRowCount(); i++) {
			TbKucun kucun = (TbKucun) table.getValueAt(i, 0);
			if (kucun == null || kucun.getId() == null || kucun.getId().isEmpty()) {
				dftm.removeRow(i);
			}
		}
	}

	private void stopTableCellEditing() {// ֹͣ���Ԫ�ı༭
		TableCellEditor cellEditor = table.getCellEditor();
		if (cellEditor != null)
			cellEditor.stopCellEditing();
	}
}
