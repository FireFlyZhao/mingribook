package com.lzw.dao.model;

public class TbGysinfo implements java.io.Serializable {// 供应商信息（实现序列化接口）

	private String id;// 供应商编号
	private String name;// 供应商名称
	private String jc;// 供应商简称
	private String address;// 供应商地址
	private String bianma;// 邮政编码
	private String tel;// 电话
	private String fax;// 传真
	private String lian;// 联系人
	private String ltel;// 联系电话
	private String yh;// 开户银行
	private String mail;// 电子信箱

	public TbGysinfo() {// 缺省构造函数
	}

	public TbGysinfo(String id) {// 最小构造函数(主键)
		this.id = id;
	}

	public TbGysinfo(String id, String name, String jc, String address, String bianma, String tel, String fax,
			String lian, String ltel, String yh, String mail) {// 完整构造函数
		this.id = id;
		this.name = name;
		this.jc = jc;
		this.address = address;
		this.bianma = bianma;
		this.tel = tel;
		this.fax = fax;
		this.lian = lian;
		this.ltel = ltel;
		this.yh = yh;
		this.mail = mail;
	}

	// 使用Getters and Setters方法将供应商信息类的私有属性封装起来
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJc() {
		return this.jc;
	}

	public void setJc(String jc) {
		this.jc = jc;
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

	public String getYh() {
		return this.yh;
	}

	public void setYh(String yh) {
		this.yh = yh;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}