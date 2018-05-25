package com.lzw.dao.model;

public class TbKhinfo implements java.io.Serializable {// 客户信息（实现序列化接口）

	private String id;// 客户编号
	private String khname;// 客户名称
	private String jian;// 客户简称
	private String address;// 客户地址
	private String bianma;// 邮编
	private String tel;// 电话
	private String fax;// 传真
	private String lian;// 联系人
	private String ltel;// 联系电话
	private String mail;// 电子邮箱
	private String xinhang;// 开户银行
	private String hao;// 银行账号

	public TbKhinfo() {// 缺省构造函数
	}

	public TbKhinfo(String id) {// 最小构造函数(主键)
		this.id = id;
	}

	public TbKhinfo(String id, String khname, String jian, String address, String bianma, String tel, String fax,
			String lian, String ltel, String mail, String xinhang, String hao) {// 完整构造函数
		this.id = id;
		this.khname = khname;
		this.jian = jian;
		this.address = address;
		this.bianma = bianma;
		this.tel = tel;
		this.fax = fax;
		this.lian = lian;
		this.ltel = ltel;
		this.mail = mail;
		this.xinhang = xinhang;
		this.hao = hao;
	}
	
	// 使用Getters and Setters方法将客户信息类的私有属性封装起来
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKhname() {
		return this.khname;
	}

	public void setKhname(String khname) {
		this.khname = khname;
	}

	public String getJian() {
		return this.jian;
	}

	public void setJian(String jian) {
		this.jian = jian;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBianma() {
		return this.bianma;
	}

	public void setBianma(String bianma) {
		this.bianma = bianma;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getLian() {
		return this.lian;
	}

	public void setLian(String lian) {
		this.lian = lian;
	}

	public String getLtel() {
		return this.ltel;
	}

	public void setLtel(String ltel) {
		this.ltel = ltel;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getXinhang() {
		return this.xinhang;
	}

	public void setXinhang(String xinhang) {
		this.xinhang = xinhang;
	}

	public String getHao() {
		return this.hao;
	}

	public void setHao(String hao) {
		this.hao = hao;
	}

}