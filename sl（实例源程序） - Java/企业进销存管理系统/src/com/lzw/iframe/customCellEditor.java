package com.lzw.iframe;

import java.awt.Component;
import java.sql.*;
import java.util.EventObject;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.TableCellEditor;

import com.lzw.dao.Dao;
import com.lzw.dao.model.TbSpinfo;

public class customCellEditor extends JComboBox implements TableCellEditor {// 编辑器

	private CellEditorListener list;// 创建用于侦听CellEditor中更改的对象的接口
	private String gysName;// 供应商名称
	private ChangeEvent ce = new ChangeEvent(this);

	public customCellEditor() {// 编辑器的构造方法
		super();
	}

	public Object getCellEditorValue() {
		return getSelectedItem();// 返回编辑器中包含的值
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		ResultSet set = Dao.query("select * from tb_spinfo where gysName='" + gysName + "'");
		DefaultComboBoxModel dfcbm = (DefaultComboBoxModel) getModel();
		dfcbm.removeAllElements();
		dfcbm.addElement(new TbSpinfo());
		try {
			while (set.next()) {
				TbSpinfo spinfo = new TbSpinfo();// 商品信息
				spinfo.setId(set.getString("id").trim());// 商品编号
				spinfo.setSpname(set.getString("spname").trim());// 商品名称
				spinfo.setCd(set.getString("cd").trim());// 产地
				spinfo.setJc(set.getString("jc").trim());// 商品简称
				spinfo.setDw(set.getString("dw").trim());// 商品计量单位
				spinfo.setGg(set.getString("gg").trim());// 商品规格
				spinfo.setBz(set.getString("bz").trim());// 包装
				spinfo.setPh(set.getString("ph").trim());// 批号
				spinfo.setPzwh(set.getString("pzwh").trim());// 批准文号
				spinfo.setMemo(set.getString("memo").trim());// 备注
				spinfo.setGysname(set.getString("gysname").trim());// 供应商名称
				dfcbm.addElement(spinfo);// 向表格对象中添加行数据（商品信息）
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this;
	}
	// 重写实现TableCellEditor接口的addCellEditorListener方法（当编辑器停止运作或取消编辑时，向被通知的列表添加一个侦听器）
	public void addCellEditorListener(CellEditorListener arg0) {
		list = arg0;
	}
	// 重写实现TableCellEditor接口的cancelCellEditing方法（告知编辑器取消编辑并且不接受任何已部分编辑的值）
	public void cancelCellEditing() {
		list.editingCanceled(ce);
	}
	// 重写实现TableCellEditor接口的isCellEditable方法（询问编辑器它是否可以使用anEvent开始进行编辑）
	public boolean isCellEditable(EventObject arg0) {
		return true;
	}
	// 重写实现TableCellEditor接口的removeCellEditorListener方法（从被通知的列表中移除一个侦听器 ）
	public void removeCellEditorListener(CellEditorListener arg0) {
	}
	// 重写实现TableCellEditor接口的shouldSelectCell方法（如果应该选择正编辑的单元格，则返回true，否则返回false）
	public boolean shouldSelectCell(EventObject arg0) {
		return true;
	}
	// 重写实现TableCellEditor接口的stopCellEditing方法（告知编辑器停止编辑并接受任何已部分编辑的值作为编辑器的值）
	public boolean stopCellEditing() {
		list.editingStopped(ce);
		return true;
	}
	// 获得供应商名称
	public String getGysName() {
		return gysName;
	}
	// 设置供应商名称
	public void setGysName(String gysName) {
		this.gysName = gysName;
	}
}
