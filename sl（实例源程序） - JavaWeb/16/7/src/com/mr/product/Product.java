package com.mr.product;
/**
 * ��Ʒ��Ϣ�ĳ־û���
 */
public class Product {
	
	private Integer id;//Ψһ�Ա�ʶ
	private String name;//��Ʒ����
	private Double price;//��Ʒ�۸�
	private String factory;//������
	private String remark;//��ע
	
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
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
