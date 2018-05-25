package com.lzw.iframe;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.lzw.dao.Dao;

public class BackupAndRestore extends JInternalFrame {// 数据库备份与恢复内部窗体

	private JPanel jContentPane = null;// 内容面板
	private JPanel backupPanel = null;// 数据库备份面板
	private JPanel restorePanel = null;// 数据库恢复面板
	private JTextField backupTextField;// 数据库备份文本框
	private JTextField restoreTextField = null;// 数据库恢复文本框
	private JButton backupButton = null;// “备份”按钮
	private JButton browseButton2 = null;// “浏览”按钮
	private JButton restoreButton = null;// “恢复”按钮

	public BackupAndRestore() {// 数据库备份与恢复窗体的构造方法
		super();// 调用父类JInternalFrame的构造器
		initialize();// 初始化数据库备份与恢复窗体
	}

	private void initialize() {// 初始化数据库备份与恢复窗体
		this.setSize(475, 221);// 设置数据库备份与恢复窗体的宽高
		this.setIconifiable(true);// 设置数据库备份与恢复窗体可以图标化
		this.setClosable(true);// 设置可以关闭数据库备份与恢复窗体
		this.setTitle("数据库备份与恢复");// 设置数据库备份与恢复窗体的标题
		this.setContentPane(getJContentPane());// 加载内容面板
	}

	private JPanel getJContentPane() {// 获得内容面板
		if (jContentPane == null) {// 内容面板不存在
			jContentPane = new JPanel();// 创建内容面板
			jContentPane.setLayout(new BoxLayout(getJContentPane(),
					BoxLayout.Y_AXIS));// 设置内容面板的布局为垂直排列布局
			jContentPane.add(getBackupPanel(), null);// 数据库备份面板添加到内容面板中
			jContentPane.add(getRestorePanel(), null);// 数据库恢复面板添加到内容面板中
		}
		return jContentPane;// 返回内容面板
	}

	private JPanel getBackupPanel() {// 获得数据库备份面板
		if (backupPanel == null) {// 数据库备份面板不存在
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();// 创建网格限制对象
			gridBagConstraints1.gridx = 2;// 组件位于网格的横向索引为2
			gridBagConstraints1.anchor = GridBagConstraints.EAST;// 组件在其显示区域的右中
			gridBagConstraints1.gridy = 1;// 组件位于网格的纵向索引为1
			GridBagConstraints gridBagConstraints = new GridBagConstraints();// 创建网格限制对象
			gridBagConstraints.fill = GridBagConstraints.BOTH;// 组件水平、垂直同时扩大以占据空白区域
			gridBagConstraints.gridy = 0;// 组件位于网格的纵向索引为0
			gridBagConstraints.weightx = 1.0;// 组件水平扩大的权重是1.0
			gridBagConstraints.gridwidth = 2;// 组件横跨2个网格
			gridBagConstraints.gridx = 1;// 组件位于网格的横向索引为1
			backupPanel = new JPanel();// 数据库备份面板
			backupPanel.setLayout(new GridBagLayout());// 设置数据库备份面板的布局为网格布局
			backupPanel.setBorder(BorderFactory.createTitledBorder(null,
					"\u6570\u636e\u5e93\u5907\u4efd",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.blue));// 设置数据库备份面板的边框样式和字体内容
			backupPanel.add(getBackupTextField(), gridBagConstraints);// 向数据库备份面板中添加“数据库备份”文本框
			backupPanel.add(getBackupButton(), gridBagConstraints1);// 向数据库备份面板中添加“备份”按钮
		}
		return backupPanel;// 返回数据库备份面板
	}

	private JPanel getRestorePanel() {// 获得数据库恢复面板
		if (restorePanel == null) {// 数据库恢复面板不存在
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();// 创建网格限制对象
			gridBagConstraints5.gridx = 1;// 组件位于网格的横向索引为1
			gridBagConstraints5.gridy = 1;// 组件位于网格的纵向索引为1
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();// 创建网格限制对象
			gridBagConstraints4.gridx = 0;// 组件位于网格的横向索引为0
			gridBagConstraints4.weightx = 1.0;// 组件水平扩大的权重是1.0
			gridBagConstraints4.anchor = GridBagConstraints.EAST;// 组件在其显示区域的右中
			gridBagConstraints4.insets = new Insets(0, 0, 0, 10);// 组件彼此的间距
			gridBagConstraints4.gridy = 1;// 组件位于网格的纵向索引为1
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();// 创建网格限制对象
			gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
			gridBagConstraints3.gridy = 0;// 组件位于网格的纵向索引为0
			gridBagConstraints3.weightx = 1.0;// 组件水平扩大的权重是1.0
			gridBagConstraints3.gridwidth = 2;// 组件横跨2个网格
			gridBagConstraints3.gridx = 0;// 组件位于网格的横向索引为0
			restorePanel = new JPanel();// 数据库恢复面板
			restorePanel.setLayout(new GridBagLayout());// 设置数据库恢复面板的布局为网格布局
			restorePanel.setBorder(BorderFactory.createTitledBorder(null,
					"\u6570\u636e\u5e93\u6062\u590d",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.red));// 设置数据库恢复面板的边框样式和字体内容
			restorePanel.add(getRestoreTextField(), gridBagConstraints3);// 向数据库恢复面板中添加“数据库恢复”文本框
			restorePanel.add(getBrowseButton2(), gridBagConstraints4);// 向数据库恢复面板中添加“浏览”按钮
			restorePanel.add(getRestoreButton(), gridBagConstraints5);// 向数据库恢复面板中添加“恢复”按钮
		}
		return restorePanel;// 返回数据库恢复面板
	}

	private JTextField getBackupTextField() {// 获得“数据库备份”文本框
		backupTextField = new JTextField();// “数据库备份”文本框
		backupTextField.setEditable(false);// 设置 “数据库备份”文本框不可编辑
		backupTextField.setFont(new Font("幼圆", Font.PLAIN, 14));// 设置
																// “数据库备份”文本框的字体样式和字体大小
		backupTextField.setForeground(Color.BLUE);// 设置“数据库备份”文本框中的字体颜色为蓝色
		backupTextField.setText("数据库备份路径：");// 设置“数据库备份”文本框的文本内容
		return backupTextField;// 返回“数据库备份”文本框
	}

	private JButton getBackupButton() {// 获得“备份”按钮
		if (backupButton == null) {// “备份”按钮不存在
			backupButton = new JButton();// 创建“备份”按钮
			backupButton.setText("备份(K)");// 设置“备份”按钮中的字体内容
			backupButton.setMnemonic(KeyEvent.VK_K);// 设置“备份”按钮的键盘助记符为K
			backupButton.addActionListener(new java.awt.event.ActionListener() {// “备份”按钮添加动作事件的监听
						public void actionPerformed(ActionEvent e) {
							try {
								String filePath = Dao.backup();// 获得备份sql文件的路径
								backupTextField.setText("数据库备份路径：" + filePath);// 设置“数据库备份”文本框中的文本内容
							} catch (Exception e1) {
								e1.printStackTrace();// 打印异常信息
								String message = e1.getMessage();// 获得全部异常信息
								int index = message.lastIndexOf(']');// 获得“]”在异常信息中最后一次出现处的索引
								message = message.substring(index + 1);// 截串获得最后一次出现']'后的异常信息
								JOptionPane.showMessageDialog(
										BackupAndRestore.this, message);// 弹出异常信息提示框
								return;// 退出应用程序
							}
							JOptionPane.showMessageDialog(
									BackupAndRestore.this, "备份成功");// 弹出“备份成功”的提示框
						}
					});
		}
		return backupButton;// 返回“备份”按钮
	}

	private JTextField getRestoreTextField() {// 获得“数据库恢复”文本框
		if (restoreTextField == null) {// 如果“数据库恢复”文本框不存在
			restoreTextField = new JTextField();// 创建“数据库恢复”文本框
		}
		return restoreTextField;// 返回“数据库恢复”文本框
	}

	private JButton getBrowseButton2() {// 获得“浏览”按钮
		if (browseButton2 == null) {// “浏览”按钮不存在
			browseButton2 = new JButton();// 创建“浏览”按钮
			browseButton2.setText("浏览(W)……");// 设置“浏览”按钮中的文本内容
			browseButton2.setMnemonic(KeyEvent.VK_W);// 设置“浏览”按钮的键盘助记符为W
			browseButton2
					.addActionListener(new java.awt.event.ActionListener() {// 为“浏览”按钮添加动作事件的监听
						public void actionPerformed(java.awt.event.ActionEvent e) {
							JFileChooser dirChooser = new JFileChooser(
									"./backup/");// 把“./backup/”作为路径创建文件选择器
							int option = dirChooser
									.showOpenDialog(BackupAndRestore.this);// 获得“打开”、“取消”的返回值
							if (option == JFileChooser.APPROVE_OPTION) {// 点击“打开”按钮
								File selFile = dirChooser.getSelectedFile();// 获得文件选择器中的文件
								restoreTextField.setText(selFile
										.getAbsolutePath());// 设置“数据库恢复”文本框中的文本内容
							}
						}
					});
		}
		return browseButton2;// 返回“浏览”按钮
	}

	private JButton getRestoreButton() {// 获得“恢复”按钮
		if (restoreButton == null) {// “恢复”按钮不存在
			restoreButton = new JButton();// 创建“恢复”按钮
			restoreButton.setText("恢复(R)");// 设置“恢复”按钮中的文本内容
			restoreButton.setMnemonic(KeyEvent.VK_R);// 设置“恢复”按钮的键盘助记符为R
			restoreButton
					.addActionListener(new java.awt.event.ActionListener() {// 为“恢复”按钮添加动作事件的监听
						public void actionPerformed(java.awt.event.ActionEvent e) {
							String path = restoreTextField.getText();// 获得“数据库恢复”文本框中的路径
							if (path == null || path.isEmpty())// 路径不存在或路径下没有文件
								return;// 退出应用程序
							File restoreFile = new File(path);// 根据路径创建文件对象
							restoreFile.getAbsolutePath();// 获得文件对象的绝对路径
							try {
								Dao.restore(restoreFile.getAbsolutePath());// 数据库恢复
							} catch (Exception e1) {
								e1.printStackTrace();// 打印异常信息
								String message = e1.getMessage();// 获得全部异常信息
								int index = message.lastIndexOf(']');// 获得“]”在异常信息中最后一次出现处的索引
								message = message.substring(index + 1);// 截串获得最后一次出现']'后的异常信息
								JOptionPane.showMessageDialog(
										BackupAndRestore.this, message);// 弹出异常信息提示框
								return;// 退出应用程序
							}
							JOptionPane.showMessageDialog(
									BackupAndRestore.this, "恢复成功");// 弹出“恢复成功”的提示框
						}
					});
		}
		return restoreButton;// 返回“恢复”按钮
	}

}