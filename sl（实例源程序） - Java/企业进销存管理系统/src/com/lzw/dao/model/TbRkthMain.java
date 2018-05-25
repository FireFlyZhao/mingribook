package com.lzw.dao.model;

import java.util.HashSet;
import java.util.Set;

public class TbRkthMain implements java.io.Serializable {// 进货退货主表（实现序列化接口）

	private String rkthId;// 进货退货编号
	private String pzs;// 销售品种数
	private String je;// 总计金额
	private String ysjl;// 验收结论
	private String gysname;// 供应商名称
	private String rtdate;// 进货退货时间
	private String czy;// 操作员
	private String jsr;// 经手人
	private String jsfs;// 结算方式
	private Set tbRkthDetails = new HashSet(0);// 进货退货详细信息

	public TbRkthMain() {// 缺省构造函数
	}

	public TbRkthMain(String rkthId, String pzs, String je, String ysjl, String gysname, String rtdate, String czy,
			String jsr, String jsfs) {// 完整构造函数
		this.rkthId = rkthId;
		this.pzs = pzs;
		this.je = je;
		this.ysjl = ysjl;
		this.gysname = gysname;
		this.rtdate = rtdate;
		this.czy = czy;
		this.jsr = jsr;
		this.jsfs = jsfs;
	}

	// 使用Getters and Setters方法将进货退货主表类的私有属性封装起来
	public String getRkthId() {
		return this.rkthId;
	}

	public void setRkthId(String rkthId) {
		this.rkthId = rkthId;
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

	public String getGysname() {
		return this.gysname;
	}

	public void setGysname(String gysname) {
		this.gysname = gysname;
	}

	public String getRtdate() {
		return this.rtdate;
	}

	public void setRtdate(String rtdate) {
		this.rtdate = rtdate;
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

	public Set getTbRkthDetails() {
		return this.tbRkthDetails;
	}

	public void setTbRkthDetails(Set tbRkthDetails) {
		this.tbRkthDetails = tbRkthDetails;
	}
}