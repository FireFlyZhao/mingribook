package com.lzw.dao.model;

import java.util.HashSet;
import java.util.Set;

public class TbXsthMain implements java.io.Serializable {// 销售退货主表（实现序列化接口）

	private String xsthId;// 销售退货编号
	private String pzs;// 品种数量
	private String je;// 总计金额
	private String ysjl;// 验收结论
	private String khname;// 客户名称
	private String thdate;// 退货日期
	private String czy;// 操作员
	private String jsr;// 经手人
	private String jsfs;// 结算方式
	private Set tbXsthDetails = new HashSet(0);// 销售退货详细信息

	public TbXsthMain() {// 缺省构造函数
	}

	public TbXsthMain(String xsthId, String pzs, String je, String ysjl, String khname, String thdate, String czy,
			String jsr, String jsfs) {// 完整构造函数
		this.xsthId = xsthId;
		this.pzs = pzs;
		this.je = je;
		this.ysjl = ysjl;
		this.khname = khname;
		this.thdate = thdate;
		this.czy = czy;
		this.jsr = jsr;
		this.jsfs = jsfs;
	}

	// 使用Getters and Setters方法将销售退货主表类的私有属性封装起来
	public String getXsthId() {
		return this.xsthId;
	}

	public void setXsthId(String xsthId) {
		this.xsthId = xsthId;
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

	public String getThdate() {
		return this.thdate;
	}

	public void setThdate(String thdate) {
		this.thdate = thdate;
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

	public Set getTbXsthDetails() {
		return this.tbXsthDetails;
	}

	public void setTbXsthDetails(Set tbXsthDetails) {
		this.tbXsthDetails = tbXsthDetails;
	}
}