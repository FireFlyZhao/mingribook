package com.lzw.dao.model;

public class TbGysinfo implements java.io.Serializable {// ��Ӧ����Ϣ��ʵ�����л��ӿڣ�

	private String id;// ��Ӧ�̱��
	private String name;// ��Ӧ������
	private String jc;// ��Ӧ�̼��
	private String address;// ��Ӧ�̵�ַ
	private String bianma;// ��������
	private String tel;// �绰
	private String fax;// ����
	private String lian;// ��ϵ��
	private String ltel;// ��ϵ�绰
	private String yh;// ��������
	private String mail;// ��������

	public TbGysinfo() {// ȱʡ���캯��
	}

	public TbGysinfo(String id) {// ��С���캯��(����)
		this.id = id;
	}

	public TbGysinfo(String id, String name, String jc, String address, String bianma, String tel, String fax,
			String lian, String ltel, String yh, String mail) {// �������캯��
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

	// ʹ��Getters and Setters��������Ӧ����Ϣ���˽�����Է�װ����
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