package com.lzw.iframe.gysGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import keyListener.InputKeyListener;

import com.lzw.Item;
import com.lzw.dao.Dao;
import com.lzw.dao.model.TbGysinfo;

public class GysXiuGaiPanel extends JPanel {// 供应商修改面板
	
	private JTextField EMailF;// “电子信箱”文本框
	private JTextField yinHangF;// “开户银行”文本框
	private JTextField lianXiRenDianHuaF;// “联系人电话”文本框
	private JTextField lianXiRenF;// “联系人”文本框
	private JTextField chuanZhenF;// “传真”文本框
	private JTextField dianHuaF;// “电话”文本框
	private JTextField diZhiF;// “地址”文本框
	private JTextField bianMaF;// “邮政编码”文本框
	private JTextField jianChengF;// “简称”文本框
	private JTextField quanChengF;// “供应商全称”文本框
	private JComboBox gys;// “选择供应商”下拉列表
	
	public GysXiuGaiPanel() {// 供应商修改面板
		setLayout(new GridBagLayout());// 设置供应商修改面板的布局为网格布局
		setBounds(10, 10, 510, 302);// 设置供应商修改面板的位置和宽高

		setupComponet(new JLabel("供应商全称："), 0, 0, 1, 1, false);// 设置“供应商全称”标签的位置并添加到容器中
		quanChengF = new JTextField();// “供应商全称”文本框
		quanChengF.setEditable(false);// 设置“供应商全称”文本框不可编辑
		setupComponet(quanChengF, 1, 0, 3, 400, true);// 设置“供应商全称”文本框的位置并添加到容器中

		setupComponet(new JLabel("简称："), 0, 1, 1, 1, false);// 设置“简称”标签的位置并添加到容器中
		jianChengF = new JTextField();// “简称”文本框
		setupComponet(jianChengF, 1, 1, 1, 160, true);// 设置“简称”文本框的位置并添加到容器中

		setupComponet(new JLabel("邮政编码："), 2, 1, 1, 1, false);// 设置“邮政编码”标签的位置并添加到容器中
		bianMaF = new JTextField();// “邮政编码”文本框
		bianMaF.addKeyListener(new InputKeyListener());// 为“邮政编码”文本框添加键盘输入事件的监听
		setupComponet(bianMaF, 3, 1, 1, 0, true);// 设置“邮政编码”文本框的位置并添加到容器中

		setupComponet(new JLabel("地址："), 0, 2, 1, 1, false);// 设置“地址”标签的位置并添加到容器中
		diZhiF = new JTextField();// “地址”文本框
		setupComponet(diZhiF, 1, 2, 3, 0, true);// 设置“地址”文本框的位置并添加到容器中

		setupComponet(new JLabel("电话："), 0, 3, 1, 1, false);// 设置“电话”标签的位置并添加到容器中
		dianHuaF = new JTextField();// “电话”文本框
		dianHuaF.addKeyListener(new InputKeyListener());// 为“电话”文本框添加键盘输入事件的监听
		setupComponet(dianHuaF, 1, 3, 1, 0, true);// 设置“电话”文本框的位置并添加到容器中

		setupComponet(new JLabel("传真："), 2, 3, 1, 1, false);// 设置“传真”标签的位置并添加到容器中
		chuanZhenF = new JTextField();// “传真”文本框
		chuanZhenF.addKeyListener(new InputKeyListener());// 为“传真”文本框添加键盘输入事件的监听
		setupComponet(chuanZhenF, 3, 3, 1, 0, true);// 设置“传真”文本框的位置并添加到容器中

		setupComponet(new JLabel("联系人："), 0, 4, 1, 1, false);// 设置“联系人”标签的位置并添加到容器中
		lianXiRenF = new JTextField();// “联系人”文本框
		setupComponet(lianXiRenF, 1, 4, 1, 0, true);// 设置“联系人”文本框的位置并添加到容器中

		setupComponet(new JLabel("联系人电话："), 2, 4, 1, 1, false);// 设置“联系人电话”标签的位置并添加到容器中
		lianXiRenDianHuaF = new JTextField();// “联系人电话”文本框
		lianXiRenDianHuaF.addKeyListener(new InputKeyListener());// 为“联系人电话”文本框添加键盘输入事件的监听
		setupComponet(lianXiRenDianHuaF, 3, 4, 1, 0, true);// 设置“联系人电话”文本框的位置并添加到容器中

		setupComponet(new JLabel("开户银行："), 0, 5, 1, 1, false);// 设置“开户银行”标签的位置并添加到容器中
		yinHangF = new JTextField();// “开户银行”文本框
		setupComponet(yinHangF, 1, 5, 1, 0, true);// 设置“开户银行”文本框的位置并添加到容器中

		setupComponet(new JLabel("电子信箱："), 2, 5, 1, 1, false);// 设置“电子信箱”标签的位置并添加到容器中
		EMailF = new JTextField();// “电子信箱”文本框
		setupComponet(EMailF, 3, 5, 1, 0, true);// 设置“电子信箱”文本框的位置并添加到容器中

		setupComponet(new JLabel("选择供应商"), 0, 7, 1, 0, false);// 设置“选择供应商”标签的位置并添加到容器中
		gys = new JComboBox();// “选择供应商”下拉列表
		gys.setPreferredSize(new Dimension(230, 21));// 设置“选择供应商”下拉列表的宽高
		initComboBox();// 初始化“选择供应商”下拉列表
		gys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doGysSelectAction();// “选择供应商”下拉列表的选项事件
			}
		});
		setupComponet(gys, 1, 7, 2, 0, true);// 设置“选择供应商”下拉列表的位置并添加到容器中
		JButton modifyButton = new JButton("修改");// “修改”按钮
		JButton delButton = new JButton("删除");// “删除”按钮
		JPanel panel = new JPanel();// 按钮面板
		panel.add(modifyButton);// 把“修改”按钮放到按钮面板中
		panel.add(delButton);// 把“删除”按钮放到按钮面板中
		setupComponet(panel, 3, 7, 1, 0, false);// 设置按钮面板的位置并添加到容器中
		
		delButton.addActionListener(new ActionListener() {// “删除”按钮动作事件的监听
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) gys.getSelectedItem();// 获得数据表公共类对象
				if (item == null || !(item instanceof Item))// 数据表公共类对象为空或数据表公共类对象不是数据表公共类的实例
					return;// 退出程序
				int confirm = JOptionPane.showConfirmDialog(GysXiuGaiPanel.this, "确认删除供应商信息吗？");// 弹出“确认删除供应商信息吗？”提示框
				if (confirm == JOptionPane.YES_OPTION) {// 点击“确认”键
					int rs = Dao.delete("delete tb_gysInfo where id='" + item.getId() + "'");// 获得删除供应商信息的数量
					if (rs > 0) {// 删除供应商信息的数量大于0
						JOptionPane.showMessageDialog(GysXiuGaiPanel.this, "供应商：" + item.getName() + "。删除成功");// 弹出提示框
						gys.removeItem(item);// 移除“选择供应商”下拉列表中相匹配的数据表公共类对象
					} else {// 删除供应商信息的数量不大于0
						JOptionPane.showMessageDialog(GysXiuGaiPanel.this, "无法删除供应商：" + item.getName() + "。");// 弹出提示框
					}
				}
			}
		});
		
		modifyButton.addActionListener(new ActionListener() {// “修改”按钮动作事件的监听
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) gys.getSelectedItem();// 获得数据表公共类对象
				TbGysinfo gysInfo = new TbGysinfo();// 供应商信息
				gysInfo.setId(item.getId());// 设置供应商编号
				gysInfo.setAddress(diZhiF.getText().trim());// 设置供应商地址
				gysInfo.setBianma(bianMaF.getText().trim());// 设置邮政编码
				gysInfo.setFax(chuanZhenF.getText().trim());// 设置传真
				gysInfo.setYh(yinHangF.getText().trim());// 设置开户银行
				gysInfo.setJc(jianChengF.getText().trim());// 设置供应商简称
				gysInfo.setName(quanChengF.getText().trim());// 设置供应商名称
				gysInfo.setLian(lianXiRenF.getText().trim());// 设置联系人
				gysInfo.setLtel(lianXiRenDianHuaF.getText().trim());// 设置联系电话
				gysInfo.setMail(EMailF.getText().trim());// 设置电子信箱
				gysInfo.setTel(dianHuaF.getText().trim());// 设置电话
				if (Dao.updateGys(gysInfo) == 1)// 更改供应商信息的数量等于1
					JOptionPane.showMessageDialog(GysXiuGaiPanel.this, "修改完成");// 弹出提示框
				else// 更改供应商信息的数量不等于1
					JOptionPane.showMessageDialog(GysXiuGaiPanel.this, "修改失败");// 弹出提示框
			}
		});
	}
	
	public void initComboBox() {// 初始化“选择供应商”下拉列表
		List gysInfo = Dao.getGysInfos();// 获取供应商信息
		List<Item> items = new ArrayList<Item>();// 创建数据公共表的集合
		gys.removeAllItems();// 移除下拉列表中现有的供应商名称
		for (Iterator iter = gysInfo.iterator(); iter.hasNext();) {// 遍历list集合
			List element = (List) iter.next();// 获得集合中下一个元素
			Item item = new Item();// 创建数据表公共类对象
			item.setId(element.get(0).toString().trim());// 设置编号属性
			item.setName(element.get(1).toString().trim());// 设置名称信息
			if (items.contains(item))// 集合中包含数据表公共类对象
				continue;// 跳过本次循环
			items.add(item);// 集合中不包含数据表公共类对象，向集合中添加数据表公共类对象
			gys.addItem(item);// 向下拉列表中添加数据表公共类对象
		}
		doGysSelectAction();// “选择供应商”下拉列表的选项事件
	}
	
	private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {// 设置组件位置并添加到容器中
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();// 创建网格限制对象
		gridBagConstrains.gridx = gridx;// 设置组件位于网格的横向索引为gridx
		gridBagConstrains.gridy = gridy;// 设置组件位于网格的纵向索引为gridy
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);// 组件彼此的间距
		if (gridwidth > 1)// 组件横跨网格数大于1
			gridBagConstrains.gridwidth = gridwidth;// 设置组件横跨网格数为gridwidth
		if (ipadx > 0)// 组件横向填充的大小大于0
			gridBagConstrains.ipadx = ipadx;// 设置组件横向填充的大小
		if (fill)// 组件占据空白区域
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
		add(component, gridBagConstrains);// 添加组件
	}
	
	private void doGysSelectAction() {// “选择供应商”下拉列表的选项事件
		Item selectedItem;// “选择供应商”下拉列表中的选项
		if (!(gys.getSelectedItem() instanceof Item)) {// “选择供应商”下拉列表中的选项不是数据公共类的一个实例
			return;// 退出应用程序
		}
		selectedItem = (Item) gys.getSelectedItem();// 获得“选择供应商”下拉列表中的选项
		TbGysinfo gysInfo = Dao.getGysInfo(selectedItem);// 供应商信息
		quanChengF.setText(gysInfo.getName());// 设置“供应商全称”文本框中的文本内容
		diZhiF.setText(gysInfo.getAddress());// 设置“地址”文本框中的文本内容
		jianChengF.setText(gysInfo.getJc());// 设置“简称”文本框中的文本内容
		bianMaF.setText(gysInfo.getBianma());// 设置“邮政编码”文本框中的文本内容
		dianHuaF.setText(gysInfo.getTel());// 设置“电话”文本框中的文本内容
		chuanZhenF.setText(gysInfo.getFax());// 设置“传真”文本框中的文本内容
		lianXiRenF.setText(gysInfo.getLian());// 设置“联系人”文本框中的文本内容
		lianXiRenDianHuaF.setText(gysInfo.getLtel());// 设置“联系人电话”文本框中的文本内容
		EMailF.setText(gysInfo.getMail());// 设置“电子信箱”文本框中的文本内容
		yinHangF.setText(gysInfo.getYh());// 设置“开户银行”文本框中的文本内容
	}
}
