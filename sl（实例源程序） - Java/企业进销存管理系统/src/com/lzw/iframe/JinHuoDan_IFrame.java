package com.lzw.iframe;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.*;

import com.lzw.*;
import com.lzw.dao.Dao;
import com.lzw.dao.model.*;

public class JinHuoDan_IFrame extends JInternalFrame {// 进货单内部窗体

	private JPanel jContentPane = null;// 内容面板
	private JPanel topPanel = null;// 顶部面板
	private JLabel idLabel = null;// “进货票号”标签
	private JTextField idField = null;// “进货票号”文本框
	private JLabel gysLabel = null;// “供应商”标签
	private JLabel lxrLabel = null;// “联系人”标签
	private JTextField lxrField = null;// “联系人”文本框
	private JLabel jsfsLabel = null;// “结算方式”标签
	private JComboBox jsfsComboBox = null;// “结算方式”下拉列表
	private JLabel thsjLabel = null;// “进货时间”标签
	private JTextField jhsjField = null;// “进货时间”文本框
	private JLabel jsrLabel = null;// “经手人”标签
	private JTextField czyField = null;// “操作员”文本框
	private JPanel bottomPanel = null;// 底部面板
	private JLabel pzslLabel = null;// “品种数量”标签
	private JTextField pzslField = null;// “品种数量”文本框
	private JLabel hpzsLabel = null;// “货品总数”标签
	private JTextField hpzsField = null;// “货品总数”文本框
	private JLabel hjjeLabel = null;// “合计金额”标签
	private JTextField hjjeField = null;// “合计金额”文本框
	private JLabel ysjlLabel = null;// “验收结论”标签
	private JTextField ysjlField = null;// “验收结论”文本框
	private JLabel czyLabel = null;// “操作员”标签
	private JButton tjButton = null;// “添加”按钮
	private JButton rukuButton = null;// “入库”按钮
	private JScrollPane tablePane = null;// 表格面板
	private JTable table = null;// 表格模型
	private JComboBox spComboBox = null;// 商品下拉列表
	private JComboBox gysComboBox = null;// “供应商”下拉列表
	private JComboBox jsrComboBox = null;// “经手人”下拉列表

	private Date jhsjDate = new Date();// 创建日期对象之“进货时间”

	/**
	 * 进货单窗体的构造方法
	 */
	public JinHuoDan_IFrame() {
		super();
		initialize();
	}

	/**
	 * 初始化进货单窗体的方法
	 */
	private void initialize() {
		this.setSize(600, 320);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);
		this.setTitle("进货单");
		this.setClosable(true);
		this.setContentPane(getJContentPane());
	}

	/**
	 * 获得内容面板的方法
	 * 
	 * @return 内容面板
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getTopPanel(), java.awt.BorderLayout.NORTH);
			jContentPane.add(getBottomPanel(), java.awt.BorderLayout.SOUTH);
			jContentPane.add(getTablePane(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * 获得顶部面板的方法（内含组件）
	 * 
	 * @return 顶部面板（内含组件）
	 */
	private JPanel getTopPanel() {
		if (topPanel == null) {
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.fill = GridBagConstraints.BOTH;
			gridBagConstraints21.gridy = 1;
			gridBagConstraints21.weightx = 1.0;
			gridBagConstraints21.gridx = 9;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.gridx = 5;
			GridBagConstraints gridBagConstraints101 = new GridBagConstraints();
			gridBagConstraints101.gridx = 8;
			gridBagConstraints101.gridy = 1;
			jsrLabel = new JLabel();
			jsrLabel.setText("\u7ecf\u624b\u4eba\uff1a");
			GridBagConstraints gridBagConstraints91 = new GridBagConstraints();
			gridBagConstraints91.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints91.gridy = 1;
			gridBagConstraints91.weightx = 1.0;
			gridBagConstraints91.gridx = 5;
			GridBagConstraints gridBagConstraints81 = new GridBagConstraints();
			gridBagConstraints81.gridx = 4;
			gridBagConstraints81.gridy = 1;
			thsjLabel = new JLabel();
			thsjLabel.setText("进货时间：");
			GridBagConstraints gridBagConstraints71 = new GridBagConstraints();
			gridBagConstraints71.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints71.gridy = 1;
			gridBagConstraints71.weightx = 1.0;
			gridBagConstraints71.gridx = 1;
			GridBagConstraints gridBagConstraints61 = new GridBagConstraints();
			gridBagConstraints61.gridx = 0;
			gridBagConstraints61.gridy = 1;
			jsfsLabel = new JLabel();
			jsfsLabel.setText("\u7ed3\u7b97\u65b9\u5f0f\uff1a");
			GridBagConstraints gridBagConstraints51 = new GridBagConstraints();
			gridBagConstraints51.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints51.gridy = 0;
			gridBagConstraints51.weightx = 1.0;
			gridBagConstraints51.gridx = 9;
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.fill = GridBagConstraints.NONE;
			gridBagConstraints41.gridy = 0;
			gridBagConstraints41.gridx = 8;
			lxrLabel = new JLabel();
			lxrLabel.setText("\u8054\u7cfb\u4eba\uff1a");
			GridBagConstraints gridBagConstraints25 = new GridBagConstraints();
			gridBagConstraints25.gridx = 4;
			gridBagConstraints25.gridy = 0;
			gysLabel = new JLabel();
			gysLabel.setText("\u4f9b\u5e94\u5546\uff1a");
			GridBagConstraints gridBagConstraints110 = new GridBagConstraints();
			gridBagConstraints110.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints110.gridx = 1;
			gridBagConstraints110.gridy = 0;
			gridBagConstraints110.weightx = 1.0;
			gridBagConstraints110.insets = new Insets(0, 0, 0, 1);
			GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
			gridBagConstraints24.gridx = 0;
			gridBagConstraints24.gridy = 0;
			idLabel = new JLabel();
			idLabel.setText("进货票号：");
			topPanel = new JPanel();
			topPanel.setLayout(new GridBagLayout());
			topPanel.add(idLabel, gridBagConstraints24);
			topPanel.add(getIdField(), gridBagConstraints110);
			topPanel.add(gysLabel, gridBagConstraints25);
			topPanel.add(getGysComboBox(), gridBagConstraints);
			topPanel.add(lxrLabel, gridBagConstraints41);
			topPanel.add(getLxrField(), gridBagConstraints51);
			topPanel.add(jsfsLabel, gridBagConstraints61);
			topPanel.add(getJsfsComboBox(), gridBagConstraints71);
			topPanel.add(thsjLabel, gridBagConstraints81);
			topPanel.add(getJhsjField(), gridBagConstraints91);
			topPanel.add(jsrLabel, gridBagConstraints101);
			topPanel.add(getJsrComboBox(), gridBagConstraints21);
		}
		return topPanel;
	}

	/**
	 * 获得“进货票号”文本框的方法
	 * 
	 * @return “进货票号”文本框
	 */
	private JTextField getIdField() {
		if (idField == null) {
			idField = new JTextField();
			idField.setEditable(false);
		}
		return idField;
	}

	/**
	 * 获得“联系人”文本框的方法
	 * 
	 * @return “联系人”文本框
	 */
	private JTextField getLxrField() {
		if (lxrField == null) {
			lxrField = new JTextField();
		}
		return lxrField;
	}

	/**
	 * 获得“计算方式”文本框的方法
	 * 
	 * @return “计算方式”文本框
	 */
	private JComboBox getJsfsComboBox() {
		if (jsfsComboBox == null) {
			jsfsComboBox = new JComboBox();
			jsfsComboBox.addItem("现金结款");
			jsfsComboBox.addItem("支票结款");
		}
		return jsfsComboBox;
	}

	/**
	 * 获得“进货时间”文本框的方法
	 * 
	 * @return “进货时间”文本框
	 */
	private JTextField getJhsjField() {
		if (jhsjField == null) {
			jhsjField = new JTextField();
		}
		return jhsjField;
	}

	/**
	 * 获得“操作员”文本框的方法
	 * 
	 * @return “操作员”文本框
	 */
	private JTextField getCzyField() {
		if (czyField == null) {
			czyField = new JTextField();
			czyField.setEditable(false);
			czyField.setText(MainFrame.getCzyStateLabel().getText());
		}
		return czyField;
	}

	/**
	 * 获得底部面板的方法（内含组件）
	 * 
	 * @return 底部面板（内含组件）
	 */
	private JPanel getBottomPanel() {
		if (bottomPanel == null) {
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints2.gridy = 1;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.gridx = 3;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.gridx = 9;
			GridBagConstraints gridBagConstraints231 = new GridBagConstraints();
			gridBagConstraints231.fill = GridBagConstraints.NONE;
			gridBagConstraints231.gridy = 1;
			gridBagConstraints231.weightx = 0.3;
			gridBagConstraints231.gridx = 6;
			GridBagConstraints gridBagConstraints221 = new GridBagConstraints();
			gridBagConstraints221.gridx = 5;
			gridBagConstraints221.weightx = 0.3;
			gridBagConstraints221.gridy = 1;
			GridBagConstraints gridBagConstraints201 = new GridBagConstraints();
			gridBagConstraints201.gridx = 2;
			gridBagConstraints201.gridy = 1;
			czyLabel = new JLabel();
			czyLabel.setText("\u64cd\u4f5c\u5458\uff1a");
			GridBagConstraints gridBagConstraints191 = new GridBagConstraints();
			gridBagConstraints191.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints191.gridy = 1;
			gridBagConstraints191.weightx = 1.0;
			gridBagConstraints191.gridx = 1;
			GridBagConstraints gridBagConstraints181 = new GridBagConstraints();
			gridBagConstraints181.gridx = 0;
			gridBagConstraints181.gridy = 1;
			ysjlLabel = new JLabel();
			ysjlLabel.setText("\u9a8c\u6536\u7ed3\u8bba\uff1a");
			GridBagConstraints gridBagConstraints171 = new GridBagConstraints();
			gridBagConstraints171.anchor = GridBagConstraints.WEST;
			gridBagConstraints171.gridwidth = 2;
			gridBagConstraints171.gridx = 5;
			gridBagConstraints171.gridy = 0;
			gridBagConstraints171.weightx = 0.6;
			gridBagConstraints171.fill = GridBagConstraints.HORIZONTAL;
			GridBagConstraints gridBagConstraints161 = new GridBagConstraints();
			gridBagConstraints161.gridx = 4;
			gridBagConstraints161.gridy = 0;
			hjjeLabel = new JLabel();
			hjjeLabel.setText("\u5408\u8ba1\u91d1\u989d\uff1a");
			GridBagConstraints gridBagConstraints151 = new GridBagConstraints();
			gridBagConstraints151.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints151.gridy = 0;
			gridBagConstraints151.weightx = 1.0;
			gridBagConstraints151.gridx = 3;
			GridBagConstraints gridBagConstraints141 = new GridBagConstraints();
			gridBagConstraints141.gridx = 2;
			gridBagConstraints141.gridy = 0;
			hpzsLabel = new JLabel();
			hpzsLabel.setText("\u8d27\u54c1\u603b\u6570\uff1a");
			GridBagConstraints gridBagConstraints131 = new GridBagConstraints();
			gridBagConstraints131.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints131.gridy = 0;
			gridBagConstraints131.weightx = 1.0;
			gridBagConstraints131.gridx = 1;
			GridBagConstraints gridBagConstraints121 = new GridBagConstraints();
			gridBagConstraints121.anchor = GridBagConstraints.WEST;
			gridBagConstraints121.gridy = 0;
			gridBagConstraints121.gridx = 0;
			pzslLabel = new JLabel();
			pzslLabel.setText("\u54c1\u79cd\u6570\u91cf\uff1a");
			bottomPanel = new JPanel();
			bottomPanel.setLayout(new GridBagLayout());
			bottomPanel.add(pzslLabel, gridBagConstraints121);
			bottomPanel.add(getPzslField(), gridBagConstraints131);
			bottomPanel.add(hpzsLabel, gridBagConstraints141);
			bottomPanel.add(getHpzsField(), gridBagConstraints151);
			bottomPanel.add(hjjeLabel, gridBagConstraints161);
			bottomPanel.add(getHjjeField(), gridBagConstraints171);
			bottomPanel.add(ysjlLabel, gridBagConstraints181);
			bottomPanel.add(getYsjlField(), gridBagConstraints191);
			bottomPanel.add(czyLabel, gridBagConstraints201);
			bottomPanel.add(getCzyField(), gridBagConstraints2);
			bottomPanel.add(getTjButton(), gridBagConstraints221);
			bottomPanel.add(getRukuButton(), gridBagConstraints231);
		}
		return bottomPanel;
	}

	/**
	 * 获得“品种数量”文本框的方法
	 * 
	 * @return “品种数量”文本框
	 */
	private JTextField getPzslField() {
		if (pzslField == null) {
			pzslField = new JTextField();
			pzslField.setEditable(false);
		}
		return pzslField;
	}

	/**
	 * 获得“货品总数”文本框的方法
	 * 
	 * @return “货品总数”文本框
	 */
	private JTextField getHpzsField() {
		if (hpzsField == null) {
			hpzsField = new JTextField();
			hpzsField.setEditable(false);
		}
		return hpzsField;
	}

	/**
	 * 获得“合计金额”文本框的方法
	 * 
	 * @return “合计金额”
	 */
	private JTextField getHjjeField() {
		if (hjjeField == null) {
			hjjeField = new JTextField();
			hjjeField.setEditable(false);
		}
		return hjjeField;
	}

	/**
	 * 获得“验收结论”文本框的方法
	 * 
	 * @return “验收结论”文本框
	 */
	private JTextField getYsjlField() {
		if (ysjlField == null) {
			ysjlField = new JTextField();
		}
		return ysjlField;
	}

	/**
	 * 获得“添加”按钮的方法
	 * 
	 * @return “添加”按钮
	 */
	private JButton getTjButton() {
		if (tjButton == null) {
			tjButton = new JButton();
			tjButton.setText("添加");
			tjButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 获得票号
					java.sql.Date date = new java.sql.Date(jhsjDate.getTime());
					jhsjField.setText(date.toString());
					String maxId = Dao.getRuKuMainMaxId(date);// 获取入库单的最大ID
					idField.setText(maxId);
					// 结束表格中没有编写的单元
					stopTableCellEditing();
					// 如果表格中不包含空行，就添加新行
					for (int i = 0; i <= table.getRowCount() - 1; i++) {
						if (table.getValueAt(i, 0) == null)
							return;
					}
					DefaultTableModel model = (DefaultTableModel) table
							.getModel();
					model.addRow(new Vector());
				}
			});
		}
		return tjButton;
	}

	/**
	 * 获得“入库”按钮的方法
	 * 
	 * @return “入库”按钮
	 */
	private JButton getRukuButton() {
		if (rukuButton == null) {
			rukuButton = new JButton();
			rukuButton.setText("入库");
			rukuButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					stopTableCellEditing();// 结束表格中没有编写的单元
					String pzsStr = pzslField.getText();// 品种数
					String jeStr = hjjeField.getText();// 合计金额
					String jsfsStr = jsfsComboBox.getSelectedItem().toString();// 结算方式
					String jsrStr = jsrComboBox.getSelectedItem() + "";// 经手人
					String czyStr = jsrComboBox.getSelectedItem() + "";// 操作员
					String rkDate = jhsjField.getText();// 入库时间
					String ysjlStr = ysjlField.getText().trim();// 验收结论
					String id = idField.getText();// 票号
					String gysName = gysComboBox.getSelectedItem() + "";// 供应商名字
					if (jsrStr == null || jsrStr.isEmpty()) {
						JOptionPane.showMessageDialog(JinHuoDan_IFrame.this,
								"请填写经手人");
						return;
					}
					if (ysjlStr == null || ysjlStr.isEmpty()) {
						JOptionPane.showMessageDialog(JinHuoDan_IFrame.this,
								"填写验收结论");
						return;
					}
					if (table.getRowCount() <= 0) {
						JOptionPane.showMessageDialog(JinHuoDan_IFrame.this,
								"填加入库商品");
						return;
					}
					TbRukuMain ruMain = new TbRukuMain(id, pzsStr, jeStr,
							ysjlStr, gysName, rkDate, czyStr, jsrStr, jsfsStr);// 入库主表
					Set<TbRukuDetail> set = ruMain.getTabRukuDetails();
					int rows = table.getRowCount();
					for (int i = 0; i < rows; i++) {
						TbSpinfo spinfo = (TbSpinfo) table.getValueAt(i, 0);
						if (spinfo == null || spinfo.getId() == null
								|| spinfo.getId().isEmpty())
							continue;
						String djStr = (String) table.getValueAt(i, 6);
						String slStr = (String) table.getValueAt(i, 7);
						Double dj = Double.valueOf(djStr);
						Integer sl = Integer.valueOf(slStr);
						TbRukuDetail detail = new TbRukuDetail();
						detail.setTabSpinfo(spinfo.getId());
						detail.setTabRukuMain(ruMain.getRkId());
						detail.setDj(dj);
						detail.setSl(sl);
						set.add(detail);
					}
					boolean rs = Dao.insertRukuInfo(ruMain);
					if (rs) {
						JOptionPane.showMessageDialog(JinHuoDan_IFrame.this,
								"入库完成");
						DefaultTableModel dftm = new DefaultTableModel();
						table.setModel(dftm);
						pzslField.setText("0");
						hpzsField.setText("0");
						hjjeField.setText("0");
					}
				}
			});
		}
		return rukuButton;
	}

	/**
	 * 获得表格面板的方法
	 * 
	 * @return 表格面板
	 */
	private JScrollPane getTablePane() {
		if (tablePane == null) {
			tablePane = new JScrollPane();
			tablePane.setViewportView(getTable());
		}
		return tablePane;
	}

	/**
	 * 获得表格模型的方法
	 * 
	 * @return 表格模型
	 */
	private JTable getTable() {
		if (table == null) {
			String[] columnNames = { "商品名称", "商品编号", "产地", "单位", "规格", "包装",
					"单价", "数量", "批号", "批准文号" };
			table = new JTable();
			table.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			table.setShowGrid(true);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			((DefaultTableModel) table.getModel())
					.setColumnIdentifiers(columnNames);
			TableColumn column = table.getColumnModel().getColumn(0);
			final DefaultCellEditor editor = new DefaultCellEditor(
					getSpComboBox());
			column.setCellEditor(editor);
			table.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(java.beans.PropertyChangeEvent e) {
					if ((e.getPropertyName().equals("tableCellEditor"))) {// 属于表格编辑事件
						ComputeInfo();
					}
				}
			});
		}
		return table;
	}

	/**
	 * 获得“商品”下拉列表的方法
	 * 
	 * @return “商品”下拉列表
	 */
	private JComboBox getSpComboBox() {
		if (spComboBox == null) {
			spComboBox = new JComboBox();
			spComboBox.addItem(new TbSpinfo());
			spComboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ResultSet set = Dao
							.query("select * from tb_spinfo where gysName='"
									+ getGysComboBox().getSelectedItem() + "'");
					updateSpComboBox(set);
				}
			});
			spComboBox.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					TbSpinfo info = (TbSpinfo) spComboBox.getSelectedItem();
					// 如果选择有效就更新表格
					if (info != null && info.getId() != null) {
						updateTable();
					}
				}
			});
		}
		return spComboBox;
	}

	/**
	 * 更新商品下拉列表的方法
	 * 
	 * @param set
	 *            ：JDBC返回的ResultSet结果集
	 */
	private void updateSpComboBox(ResultSet set) {
		try {
			while (set.next()) {
				TbSpinfo spinfo = new TbSpinfo();
				spinfo.setId(set.getString("id").trim());
				spinfo.setSpname(set.getString("spname").trim());
				spinfo.setCd(set.getString("cd").trim());
				spinfo.setJc(set.getString("jc").trim());
				spinfo.setDw(set.getString("dw").trim());
				spinfo.setGg(set.getString("gg").trim());
				spinfo.setBz(set.getString("bz").trim());
				spinfo.setPh(set.getString("ph").trim());
				spinfo.setPzwh(set.getString("pzwh").trim());
				spinfo.setMemo(set.getString("memo").trim());
				spinfo.setGysname(set.getString("gysname").trim());
				DefaultComboBoxModel model = (DefaultComboBoxModel) spComboBox
						.getModel();
				if (model.getIndexOf(spinfo) < 0)// 下来选择框不包含该商品
					spComboBox.addItem(spinfo);// 则添加选项
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 根据商品下拉列表的选择，更新表格当前行的内容
	 */
	private synchronized void updateTable() {
		TbSpinfo spinfo = (TbSpinfo) spComboBox.getSelectedItem();
		int row = table.getSelectedRow();
		if (row >= 0 && spinfo != null) {
			table.setValueAt(spinfo.getId(), row, 1);
			table.setValueAt(spinfo.getCd(), row, 2);
			table.setValueAt(spinfo.getDw(), row, 3);
			table.setValueAt(spinfo.getGg(), row, 4);
			table.setValueAt(spinfo.getBz(), row, 5);
			table.setValueAt("0", row, 6);
			table.setValueAt("0", row, 7);
			table.setValueAt(spinfo.getPh(), row, 8);
			table.setValueAt(spinfo.getPzwh(), row, 9);
			table.editCellAt(row, 6);
		}
	}

	/**
	 * 获得“供应商”下拉列表的方法
	 * 
	 * @return “供应商”下拉列表
	 */
	private JComboBox getGysComboBox() {
		if (gysComboBox == null) {
			gysComboBox = new JComboBox();
			List gysInfos = Dao.getGysInfos();
			for (Iterator iter = gysInfos.iterator(); iter.hasNext();) {
				List list = (List) iter.next();
				Item item = new Item();
				item.setId(list.get(0).toString().trim());
				item.setName(list.get(1).toString().trim());
				gysComboBox.addItem(item);
			}
			Item item = (Item) gysComboBox.getSelectedItem();
			TbGysinfo gysInfo = Dao.getGysInfo(item);
			getLxrField().setText(gysInfo.getLian());
		}
		return gysComboBox;
	}

	/**
	 * 该方法用于停止表格单元的编辑
	 */
	private void stopTableCellEditing() {
		TableCellEditor cellEditor = table.getCellEditor();
		if (cellEditor != null)
			cellEditor.stopCellEditing();
	}

	/**
	 * 获得“经手人”下拉列表的方法
	 * 
	 * @return “经手人”下拉列表
	 */
	private JComboBox getJsrComboBox() {
		if (jsrComboBox == null) {
			jsrComboBox = new JComboBox();
			List<List> czyList = Dao.getJsrs();
			for (List<String> list : czyList) {
				String id = list.get(0);
				String name = list.get(1);
				Item item = new Item(id, name);
				item.setId(id + "");
				item.setName(name);
				jsrComboBox.addItem(item);
			}
		}
		return jsrComboBox;
	}

	/**
	 * 事件处理器，该处理器用于计算货品总数、合计金额等信息。
	 */
	private final void ComputeInfo() {
		// 计算代码
		int rows = table.getRowCount();
		int count = 0;
		double money = 0.0;
		// 计算品种数量
		TbSpinfo column = null;
		Object valueAt = table.getValueAt(rows - 1, 0);
		if (!(valueAt instanceof TbSpinfo))
			return;
		if (rows > 0)
			column = (TbSpinfo) valueAt;
		if (rows > 0 && (column == null || column.getId().isEmpty()))
			rows--;
		// 计算货品总数和金额
		for (int i = 0; i < rows; i++) {
			String column7 = (String) table.getValueAt(i, 7);
			String column6 = (String) table.getValueAt(i, 6);
			int c7 = (column7 == null || column7.isEmpty()) ? 0 : Integer
					.parseInt(column7);
			float c6 = (column6 == null || column6.isEmpty()) ? 0 : Float
					.parseFloat(column6);
			count += c7;
			money += c6 * c7;
		}
		pzslField.setText(rows + "");
		hpzsField.setText(count + "");
		hjjeField.setText(money + "");
	}
}
