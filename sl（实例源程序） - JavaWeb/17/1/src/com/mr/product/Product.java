package com.mr.product;

import com.mr.factory.Factory;

/**
 * 商品信息的持久化类
 */
public class Product {
	
	private Integer id;//唯一性标识
	private String name;//产品名称
	private Double price;//产品价格
	private Factory factory;//关联的生产商
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Factory getFactory() {
		return factory;
	}
	public void setFactory(Factory factory) {
		this.factory = factory;
	}
}
