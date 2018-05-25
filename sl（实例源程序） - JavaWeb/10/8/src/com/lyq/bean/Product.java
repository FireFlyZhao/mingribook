package com.lyq.bean;

/**
 * 商品
 * @author Li YongQiang
 *
 */
public class Product {
	public static final int PAGE_SIZE = 2;
	// 编号
	private int id;
	// 名称
	private String name;
	// 价格
	private double price;
	// 数量
	private int num;
	// 单位
	private String unit;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
}
