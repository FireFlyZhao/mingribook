package com.lzw.dao.model;

public class TbXsthDetail implements java.io.Serializable {// 销售退货详细信息（实现序列化接口）

	private Integer id;// 销售退货编号
	private String tbXsthMain;// 销售退货主表
	private String spid;// 商品编号
	private Double dj;// 单价
	private Integer sl;// 数量

	public TbXsthDetail() {// 缺省构造函数
	}

	public TbXsthDetail(String tbXsthMain, String spid, Double dj, Integer sl) {// 完整构造函数
		this.tbXsthMain = tbXsthMain;
		this.spid = spid;
		this.dj = dj;
		this.sl = sl;
	}

	// 使用Getters and Setters方法将销售退货详细信息类的私有属性封装起来
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTbXsthMain() {
		return this.tbXsthMain;
	}

	public void setTbXsthMain(String tbXsthMain) {
		this.tbXsthMain = tbXsthMain;
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