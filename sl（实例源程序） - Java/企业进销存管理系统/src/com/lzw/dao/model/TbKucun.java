package com.lzw.dao.model;

public class TbKucun implements java.io.Serializable {// 库存信息（实现序列化接口）

	private String id;// 商品编号
	private String spname;// 商品名称
	private String jc;// 商品简称
	private String cd;// 产地
	private String gg;// 商品规格
	private String bz;// 包装
	private String dw;// 商品计量单位
	private Double dj;// 单价
	private Integer kcsl;// 库存数量

	public TbKucun() {// 缺省构造函数
	}

	public TbKucun(String id) {// 最小构造函数(主键)
		this.id = id;
	}

	public TbKucun(String id, String spname, String jc, String cd, String gg, String bz, String dw, Double dj,
			Integer kcsl) {// 完整构造函数
		this.id = id;
		this.spname = spname;
		this.jc = jc;
		this.cd = cd;
		this.gg = gg;
		this.bz = bz;
		this.dw = dw;
		this.dj = dj;
		this.kcsl = kcsl;
	}
	
	// 使用Getters and Setters方法将库存信息类的私有属性封装起来
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSpname() {
		return this.spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	public String getJc() {
		return this.jc;
	}

	public void setJc(String jc) {
		this.jc = jc;
	}

	public String getCd() {
		return this.cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getGg() {
		return this.gg;
	}

	public void setGg(String gg) {
		this.gg = gg;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getDw() {
		return this.dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public Double getDj() {
		return this.dj;
	}

	public void setDj(Double dj) {
		this.dj = dj;
	}

	public Integer getKcsl() {
		return this.kcsl;
	}

	public void setKcsl(Integer kcsl) {
		this.kcsl = kcsl;
	}

	public String toString() {
		return getSpname();
	}
}