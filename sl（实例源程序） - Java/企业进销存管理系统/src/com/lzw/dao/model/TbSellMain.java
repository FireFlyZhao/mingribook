package com.lzw.dao.model;

import java.util.HashSet;
import java.util.Set;

public class TbSellMain implements java.io.Serializable {// 销售主表（实现序列化接口）

	private String sellId;// 销售编号
	private String pzs;// 销售品种数
	private String je;// 总计金额
	private String ysjl;// 验收结论
	private String khname;// 客户名称
	private String xsdate;// 销售日期
	private String czy;// 操作员
	private String jsr;// 经手人
	private String jsfs;// 结算方式
	private Set tbSellDetails = new HashSet(0);// 销售明细

	public TbSellMain() {// 缺省构造函数
	}

	public TbSellMain(String sellId, String pzs, String je, String ysjl, String khname, String xsdate, String czy,
			String jsr, String jsfs) {// 完整构造函数
		this.sellId = sellId;
		this.pzs = pzs;
		this.je = je;
		this.ysjl = ysjl;
		this.khname = khname;
		this.xsdate = xsdate;
		this.czy = czy;
		this.jsr = jsr;
		this.jsfs = jsfs;
		this.tbSellDetails = tbSellDetails;
	}

	// 使用Getters and Setters方法将销售主表类的私有属性封装起来
	public String getSellId() {
		return this.sellId;
	}

	public void setSellId(String sellId) {
		this.sellId = sellId;
	}

	public String getPzs() {
		return this.pzs;
	}

	public void setPzs(String pzs) {
		this.pzs = pzs;
	}

	public String getJe() {
		return this.je;
	}

	public void setJe(String je) {
		this.je = je;
	}

	public String getYsjl() {
		return this.ysjl;
	}

	public void setYsjl(String ysjl) {
		this.ysjl = ysjl;
	}

	public String getKhname() {
		return this.khname;
	}

	public void setKhname(String khname) {
		this.khname = khname;
	}

	public String getXsdate() {
		return this.xsdate;
	}

	public void setXsdate(String xsdate) {
		this.xsdate = xsdate;
	}

	public String getCzy() {
		return this.czy;
	}

	public void setCzy(String czy) {
		this.czy = czy;
	}

	public String getJsr() {
		return this.jsr;
	}

	public void setJsr(String jsr) {
		this.jsr = jsr;
	}

	public String getJsfs() {
		return this.jsfs;
	}

	public void setJsfs(String jsfs) {
		this.jsfs = jsfs;
	}

	public Set getTbSellDetails() {
		return this.tbSellDetails;
	}

	public void setTbSellDetails(Set tbSellDetails) {
		this.tbSellDetails = tbSellDetails;
	}
}