package com.mr.product;

import com.mr.factory.Factory;

/**
 * ��Ʒ��Ϣ�ĳ־û���
 */
public class Product {
	
	private Integer id;//Ψһ�Ա�ʶ
	private String name;//��Ʒ����
	private Double price;//��Ʒ�۸�
	private Factory factory;//������������
	
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
