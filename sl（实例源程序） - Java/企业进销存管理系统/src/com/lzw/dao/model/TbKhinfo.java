package com.lzw.dao.model;

public class TbKhinfo implements java.io.Serializable {// �ͻ���Ϣ��ʵ�����л��ӿڣ�

	private String id;// �ͻ����
	private String khname;// �ͻ�����
	private String jian;// �ͻ����
	private String address;// �ͻ���ַ
	private String bianma;// �ʱ�
	private String tel;// �绰
	private String fax;// ����
	private String lian;// ��ϵ��
	private String ltel;// ��ϵ�绰
	private String mail;// ��������
	private String xinhang;// ��������
	private String hao;// �����˺�

	public TbKhinfo() {// ȱʡ���캯��
	}

	public TbKhinfo(String id) {// ��С���캯��(����)
		this.id = id;
	}

	public TbKhinfo(String id, String khname, String jian, String address, String bianma, String tel, String fax,
			String lian, String ltel, String mail, String xinhang, String hao) {// �������캯��
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
	
	// ʹ��Getters and Setters�������ͻ���Ϣ���˽�����Է�װ����
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