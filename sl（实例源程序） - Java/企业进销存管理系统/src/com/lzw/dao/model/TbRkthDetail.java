package com.lzw.dao.model;

public class TbRkthDetail implements java.io.Serializable {// 进货退货详细信息（实现序列化接口）

	private Integer id;// 进货退货编号
	private String tbRkthMain;// 进货退货主表
	private String spid;// 商品编号
	private Double dj;// 单价
	private Integer sl;// 数量

	public TbRkthDetail() {// 缺省构造函数
	}

	public TbRkthDetail(String tbRkthMain, String spid, Double dj, Integer sl) {// 完整构造函数
		this.tbRkthMain = tbRkthMain;
		this.spid = spid;
		this.dj = dj;
		this.sl = sl;
	}

	// 使用Getters and Setters方法将进货退货详细信息类的私有属性封装起来
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTbRkthMain() {
		return this.tbRkthMain;
	}

	public void setTbRkthMain(String tbRkthMain) {
		this.tbRkthMain = tbRkthMain;
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