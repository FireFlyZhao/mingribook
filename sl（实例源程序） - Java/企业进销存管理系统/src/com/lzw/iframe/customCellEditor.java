package com.lzw.iframe;

import java.awt.Component;
import java.sql.*;
import java.util.EventObject;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.TableCellEditor;

import com.lzw.dao.Dao;
import com.lzw.dao.model.TbSpinfo;

public class customCellEditor extends JComboBox implements TableCellEditor {// �༭��

	private CellEditorListener list;// ������������CellEditor�и��ĵĶ���Ľӿ�
	private String gysName;// ��Ӧ������
	private ChangeEvent ce = new ChangeEvent(this);

	public customCellEditor() {// �༭���Ĺ��췽��
		super();
	}

	public Object getCellEditorValue() {
		return getSelectedItem();// ���ر༭���а�����ֵ
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		ResultSet set = Dao.query("select * from tb_spinfo where gysName='" + gysName + "'");
		DefaultComboBoxModel dfcbm = (DefaultComboBoxModel) getModel();
		dfcbm.removeAllElements();
		dfcbm.addElement(new TbSpinfo());
		try {
			while (set.next()) {
				TbSpinfo spinfo = new TbSpinfo();// ��Ʒ��Ϣ
				spinfo.setId(set.getString("id").trim());// ��Ʒ���
				spinfo.setSpname(set.getString("spname").trim());// ��Ʒ����
				spinfo.setCd(set.getString("cd").trim());// ����
				spinfo.setJc(set.getString("jc").trim());// ��Ʒ���
				spinfo.setDw(set.getString("dw").trim());// ��Ʒ������λ
				spinfo.setGg(set.getString("gg").trim());// ��Ʒ���
				spinfo.setBz(set.getString("bz").trim());// ��װ
				spinfo.setPh(set.getString("ph").trim());// ����
				spinfo.setPzwh(set.getString("pzwh").trim());// ��׼�ĺ�
				spinfo.setMemo(set.getString("memo").trim());// ��ע
				spinfo.setGysname(set.getString("gysname").trim());// ��Ӧ������
				dfcbm.addElement(spinfo);// �����������������ݣ���Ʒ��Ϣ��
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this;
	}
	// ��дʵ��TableCellEditor�ӿڵ�addCellEditorListener���������༭��ֹͣ������ȡ���༭ʱ����֪ͨ���б����һ����������
	public void addCellEditorListener(CellEditorListener arg0) {
		list = arg0;
	}
	// ��дʵ��TableCellEditor�ӿڵ�cancelCellEditing��������֪�༭��ȡ���༭���Ҳ������κ��Ѳ��ֱ༭��ֵ��
	public void cancelCellEditing() {
		list.editingCanceled(ce);
	}
	// ��дʵ��TableCellEditor�ӿڵ�isCellEditable������ѯ�ʱ༭�����Ƿ����ʹ��anEvent��ʼ���б༭��
	public boolean isCellEditable(EventObject arg0) {
		return true;
	}
	// ��дʵ��TableCellEditor�ӿڵ�removeCellEditorListener�������ӱ�֪ͨ���б����Ƴ�һ�������� ��
	public void removeCellEditorListener(CellEditorListener arg0) {
	}
	// ��дʵ��TableCellEditor�ӿڵ�shouldSelectCell���������Ӧ��ѡ�����༭�ĵ�Ԫ���򷵻�true�����򷵻�false��
	public boolean shouldSelectCell(EventObject arg0) {
		return true;
	}
	// ��дʵ��TableCellEditor�ӿڵ�stopCellEditing��������֪�༭��ֹͣ�༭�������κ��Ѳ��ֱ༭��ֵ��Ϊ�༭����ֵ��
	public boolean stopCellEditing() {
		list.editingStopped(ce);
		return true;
	}
	// ��ù�Ӧ������
	public String getGysName() {
		return gysName;
	}
	// ���ù�Ӧ������
	public void setGysName(String gysName) {
		this.gysName = gysName;
	}
}
