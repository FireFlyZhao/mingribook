package com.lzw.dao.model;

public class TbSellDetail implements java.io.Serializable {// 销售明细（实现序列化接口）

	private Integer id;// 流水号
	private String tbSellMain;// 销售主表
	private String spid;// 商品编号
	private Double dj;// 销售单价
	private Integer sl;// 销售数量

	public TbSellDetail() {// 缺省构造函数
	}

	public TbSellDetail(String tbSellMain, String spid, Double dj, Integer sl) {// 完整构造函数
		this.tbSellMain = tbSellMain;
		this.spid = spid;
		this.dj = dj;
		this.sl = sl;
	}

	// 使用Getters and Setters方法将销售明细类的私有属性封装起来
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTbSellMain() {
		return this.tbSellMain;
	}

	public void setTbSellMain(String tbSellMain) {
		this.tbSellMain = tbSellMain;
	}

	public String getSpid() {
		return this.spid;
	}

	public void setSpid(String spid) {
		this.spid = spid;
	}

	public Double getDj() {
		return this.dj;
	}

	public void setDj(Double dj) {
		this.dj = dj;
	}

	public Integer getSl() {
		return this.sl;
	}

	public void setSl(Integer sl) {
		this.sl = sl;
	}
}