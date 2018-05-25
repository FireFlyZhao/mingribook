package com.lyq.bean;
/**
 * 商品对象
 * @author Li YongQiang
 */
public class Produce {
	// 商品名称
	private String name = "电吉他";
	// 商品价格
	private double price = 1880.5;
	// 数量
	private int count = 100;
	// 出厂地址
	private String factoryAdd = "吉林省长春市xxx琴行";
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getCount() {
		return count;
	}
	public String getFactoryAdd() {
		return factoryAdd;
	}
}
