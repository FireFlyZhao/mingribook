package com.lzw.dao.model;

public class TbKucun implements java.io.Serializable {// �����Ϣ��ʵ�����л��ӿڣ�

	private String id;// ��Ʒ���
	private String spname;// ��Ʒ����
	private String jc;// ��Ʒ���
	private String cd;// ����
	private String gg;// ��Ʒ���
	private String bz;// ��װ
	private String dw;// ��Ʒ������λ
	private Double dj;// ����
	private Integer kcsl;// �������

	public TbKucun() {// ȱʡ���캯��
	}

	public TbKucun(String id) {// ��С���캯��(����)
		this.id = id;
	}

	public TbKucun(String id, String spname, String jc, String cd, String gg, String bz, String dw, Double dj,
			Integer kcsl) {// �������캯��
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
	
	// ʹ��Getters and Setters�����������Ϣ���˽�����Է�װ����
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