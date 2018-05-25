package com.lzw.iframe.shangPinGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import com.lzw.Item;
import com.lzw.dao.Dao;
import com.lzw.dao.model.*;

public class ShangPinXiuGaiPanel extends JPanel {// 商品修改面板

	private JComboBox gysQuanCheng;// “供应商全称”下拉列表
	private JTextField beiZhu;// “备注”文本框
	private JTextField wenHao;// “批准文号”文本框
	private JTextField piHao;// “批号”文本框
	private JTextField baoZhuang;// “包装”文本框
	private JTextField guiGe;// “规格”文本框
	private JTextField danWei;// “单位”文本框
	private JTextField chanDi;// “产地”文本框
	private JTextField jianCheng;// “简称”文本框
	private JTextField quanCheng;// “商品名称”文本框
	private JButton modifyButton;// “修改”按钮
	private JButton delButton;// “删除”按钮
	private JComboBox sp;// “选择商品”下拉列表

	public ShangPinXiuGaiPanel() {// 商品修改面板
		setLayout(new GridBagLayout());// 设置商品修改面板的布局为网格布局
		setBounds(10, 10, 550, 400);// 设置商品修改面板的位置与宽高

		setupComponet(new JLabel("商品名称："), 0, 0, 1, 1, false);// 设置“商品名称”标签的位置并添加到容器中
		quanCheng = new JTextField();// “商品名称”文本框
		quanCheng.setEditable(false);// 设置“商品名称”文本框不可编辑
		setupComponet(quanCheng, 1, 0, 3, 1, true);// 设置“商品名称”文本框的位置并添加到容器中

		setupComponet(new JLabel("简称："), 0, 1, 1, 1, false);// 设置“简称”标签的位置并添加到容器中
		jianCheng = new JTextField();// “简称”文本框
		setupComponet(jianCheng, 1, 1, 3, 10, true);// 设置“简称”文本框的位置并添加到容器中

		setupComponet(new JLabel("产地："), 0, 2, 1, 1, false);// 设置“产地”标签的位置并添加到容器中
		chanDi = new JTextField();// “产地”文本框
		setupComponet(chanDi, 1, 2, 3, 300, true);// 设置“产地”文本框的位置并添加到容器中

		setupComponet(new JLabel("单位："), 0, 3, 1, 1, false);// 设置“单位”标签的位置并添加到容器中
		danWei = new JTextField();// “单位”文本框
		setupComponet(danWei, 1, 3, 1, 130, true);// 设置“单位”文本框的位置并添加到容器中

		setupComponet(new JLabel("规格："), 2, 3, 1, 1, false);// 设置“规格”标签的位置并添加到容器中
		guiGe = new JTextField();// “规格”文本框
		setupComponet(guiGe, 3, 3, 1, 1, true);// 设置“规格”文本框的位置并添加到容器中

		setupComponet(new JLabel("包装："), 0, 4, 1, 1, false);// 设置“包装”标签的位置并添加到容器中
		baoZhuang = new JTextField();// “包装”文本框
		setupComponet(baoZhuang, 1, 4, 1, 1, true);// 设置“包装”文本框的位置并添加到容器中

		setupComponet(new JLabel("批号："), 2, 4, 1, 1, false);// 设置“批号”标签的位置并添加到容器中
		piHao = new JTextField();// “批号”文本框
		setupComponet(piHao, 3, 4, 1, 1, true);// 设置“批号”文本框的位置并添加到容器中

		setupComponet(new JLabel("批准文号："), 0, 5, 1, 1, false);// 设置“批准文号”标签的位置并添加到容器中
		wenHao = new JTextField();// “批准文号”文本框
		setupComponet(wenHao, 1, 5, 3, 1, true);// 设置“批准文号”文本框的位置并添加到容器中

		setupComponet(new JLabel("供应商全称："), 0, 6, 1, 1, false);// 设置“供应商全称”标签的位置并添加到容器中
		gysQuanCheng = new JComboBox();// “供应商全称”下拉列表
		gysQuanCheng.setMaximumRowCount(5);// 设置“供应商全称”下拉列表显示的最大行数
		setupComponet(gysQuanCheng, 1, 6, 3, 1, true);// 设置“供应商全称”下拉列表的位置并添加到容器中

		setupComponet(new JLabel("备注："), 0, 7, 1, 1, false);// 设置“备注”标签的位置并添加到容器中
		beiZhu = new JTextField();// “备注”文本框
		setupComponet(beiZhu, 1, 7, 3, 1, true);// 设置“备注”文本框的位置并添加到容器中

		setupComponet(new JLabel("选择商品"), 0, 8, 1, 0, false);// 设置“选择商品”标签的位置并添加到容器中
		sp = new JComboBox();// “选择商品”下拉列表
		sp.setPreferredSize(new Dimension(230, 21));// 设置“选择商品”下拉列表的宽高
		sp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSpSelectAction();// “选择商品”下拉列表动作事件的监听
			}
		});
		setupComponet(sp, 1, 8, 2, 0, true);// 设置“选择商品”下拉列表的位置并添加到容器中
		modifyButton = new JButton("修改");// “修改”按钮
		delButton = new JButton("删除");// “删除”按钮
		JPanel panel = new JPanel();// 按钮面板
		panel.add(modifyButton);// 把“修改”按钮放到按钮面板中
		panel.add(delButton);// 把“删除”按钮放到按钮面板中
		setupComponet(panel, 3, 8, 1, 0, false);// 设置按钮面板的位置并添加到容器中

		delButton.addActionListener(new ActionListener() {// “删除”按钮动作事件的监听
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) sp.getSelectedItem();// 获得数据表公共类对象
				if (item == null || !(item instanceof Item))// 数据表公共类对象为空或数据表公共类对象不是数据表公共类的实例
					return;// 退出程序
				int confirm = JOptionPane.showConfirmDialog(ShangPinXiuGaiPanel.this, "确认删除商品信息吗？");// 弹出“确认删除商品信息吗？”提示框
				if (confirm == JOptionPane.YES_OPTION) {// 点击“确认”键
					int rs = Dao.delete("delete tb_spinfo where id='" + item.getId() + "'");// 获得删除商品信息的数量
					if (rs > 0) {// 删除商品信息的数量大于0
						JOptionPane.showMessageDialog(ShangPinXiuGaiPanel.this, "商品：" + item.getName() + "。删除成功");// 弹出提示框
						sp.removeItem(item);// 移除“选择商品”下拉列表中相匹配的数据表公共类对象
					}
				}
			}
		});

		modifyButton.addActionListener(new ActionListener() {// “修改”按钮动作事件的监听
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) sp.getSelectedItem();// 获得数据表公共类对象
				TbSpinfo spInfo = new TbSpinfo();// 商品信息
				spInfo.setId(item.getId());// 设置商品编号
				spInfo.setBz(baoZhuang.getText().trim());// 设置包装
				spInfo.setCd(chanDi.getText().trim());// 设置产地
				spInfo.setDw(danWei.getText().trim());// 设置商品计量单位
				spInfo.setGg(guiGe.getText().trim());// 设置商品规格
				spInfo.setGysname(gysQuanCheng.getSelectedItem().toString().trim());// 设置供应商全称
				spInfo.setJc(jianCheng.getText().trim());// 设置商品简称
				spInfo.setMemo(beiZhu.getText().trim());// 设置备注
				spInfo.setPh(piHao.getText().trim());// 设置批号
				spInfo.setPzwh(wenHao.getText().trim());// 设置批准文号
				spInfo.setSpname(quanCheng.getText().trim());// 设置商品名称
				if (Dao.updateSp(spInfo) == 1)// 更改商品信息的数量等于1
					JOptionPane.showMessageDialog(ShangPinXiuGaiPanel.this, "修改完成");// 弹出提示框
				else// 更改商品信息的数量不等于1
					JOptionPane.showMessageDialog(ShangPinXiuGaiPanel.this, "修改失败");// 弹出提示框
			}
		});
	}

	public void initComboBox() {// 初始化商品下拉选择框
		List khInfo = Dao.getSpInfos();// 获取商品信息
		List<Item> items = new ArrayList<Item>();// 创建数据公共表的集合
		sp.removeAllItems();// 移除下拉列表中现有的商品名称
		for (Iterator iter = khInfo.iterator(); iter.hasNext();) {// 遍历list集合
			List element = (List) iter.next();// 获得集合中下一个元素
			Item item = new Item();// 创建数据表公共类对象
			item.setId(element.get(0).toString().trim());// 设置编号属性
			item.setName(element.get(1).toString().trim());// 设置名称信息
			if (items.contains(item))// 集合中包含数据表公共类对象
				continue;// 跳过本次循环
			items.add(item);// 集合中不包含数据表公共类对象，向集合中添加数据表公共类对象
			sp.addItem(item);// 向下拉列表中添加数据表公共类对象
		}
		doSpSelectAction();// “选择商品”下拉列表动作事件的监听
	}

	public void initGysBox() {// 初始化供应商下拉列表
		List gysInfo = Dao.getGysInfos();// 获取供应商信息
		List<Item> items = new ArrayList<Item>();// 创建数据公共表的集合
		gysQuanCheng.removeAllItems();// 移除下拉列表中现有的供应商全称
		for (Iterator iter = gysInfo.iterator(); iter.hasNext();) {// 遍历list集合
			List element = (List) iter.next();// 获得集合中下一个元素
			Item item = new Item();// 创建数据表公共类对象
			item.setId(element.get(0).toString().trim());// 设置编号属性
			item.setName(element.get(1).toString().trim());// 设置名称信息
			if (items.contains(item))// 集合中包含数据表公共类对象
				continue;// 跳过本次循环
			items.add(item);// 集合中不包含数据表公共类对象，项集合中添加数据表公共类对象
			gysQuanCheng.addItem(item);// 项下拉列表中添加数据表公共类对象
		}
		doSpSelectAction();// “选择商品”下拉列表动作事件的监听
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

	private void doSpSelectAction() {// “选择商品”下拉列表动作事件的监听
		Item selectedItem;// “选择商品”下拉列表中的选项
		if (!(sp.getSelectedItem() instanceof Item)) {// “选择商品”下拉列表中的选项不是数据公共类的一个实例
			return;// 退出应用程序
		}
		selectedItem = (Item) sp.getSelectedItem();// 获得“选择商品”下拉列表中的选项
		TbSpinfo spInfo = Dao.getSpInfo(selectedItem);// 商品信息
		if (!spInfo.getId().isEmpty()) {// 商品编号不为空
			quanCheng.setText(spInfo.getSpname());// 设置“商品名称”文本框中的文本内容
			baoZhuang.setText(spInfo.getBz());// 设置“包装”文本框中的文本内容
			chanDi.setText(spInfo.getCd());// 设置“产地”文本框中的文本内容
			danWei.setText(spInfo.getDw());// 设置“单位”文本框中的文本内容
			guiGe.setText(spInfo.getGg());// 设置“规格”文本框中的文本内容
			jianCheng.setText(spInfo.getJc());// 设置“简称”文本框中的文本内容
			beiZhu.setText(spInfo.getMemo());// 设置“备注”文本框中的文本内容
			piHao.setText(spInfo.getPh());// 设置“批号”文本框中的文本内容
			wenHao.setText(spInfo.getPzwh());// 设置“批准文号”文本框中的文本内容
			
			Item item = new Item();// 数据表公共类
			item.setId(null);// 设置编号属性为空
			item.setName(spInfo.getGysname());// 设置名称信息为“供应商名称”
			TbGysinfo gysInfo = Dao.getGysInfo(item);// 获得供应商信息
			item.setId(gysInfo.getId());// 设置编号属性为供应商编号
			item.setName(gysInfo.getName());// 设置名称信息为“供应商名称”
			for (int i = 0; i < gysQuanCheng.getItemCount(); i++) {// 遍历“供应商全称”下拉列表中的选项
				Item gys = (Item) gysQuanCheng.getItemAt(i);// 获得“供应商全称”下拉列表的当前选择项
				if (gys.getName().equals(item.getName())) {// 供应商名称相同
					item = gys;// 为数据表公共类中的实例赋值
				}
			}
			gysQuanCheng.setSelectedItem(item);// 设置“供应商全称”下拉列表的当前选择项
		}
	}
}
