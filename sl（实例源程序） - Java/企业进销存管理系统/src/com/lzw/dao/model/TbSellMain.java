package com.lzw.dao.model;

import java.util.HashSet;
import java.util.Set;

public class TbSellMain implements java.io.Serializable {// ��������ʵ�����л��ӿڣ�

	private String sellId;// ���۱��
	private String pzs;// ����Ʒ����
	private String je;// �ܼƽ��
	private String ysjl;// ���ս���
	private String khname;// �ͻ�����
	private String xsdate;// ��������
	private String czy;// ����Ա
	private String jsr;// ������
	private String jsfs;// ���㷽ʽ
	private Set tbSellDetails = new HashSet(0);// ������ϸ

	public TbSellMain() {// ȱʡ���캯��
	}

	public TbSellMain(String sellId, String pzs, String je, String ysjl, String khname, String xsdate, String czy,
			String jsr, String jsfs) {// �������캯��
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

	// ʹ��Getters and Setters�����������������˽�����Է�װ����
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