package com.lzw.dao.model;

import java.util.HashSet;
import java.util.Set;

public class TbRkthMain implements java.io.Serializable {// �����˻�����ʵ�����л��ӿڣ�

	private String rkthId;// �����˻����
	private String pzs;// ����Ʒ����
	private String je;// �ܼƽ��
	private String ysjl;// ���ս���
	private String gysname;// ��Ӧ������
	private String rtdate;// �����˻�ʱ��
	private String czy;// ����Ա
	private String jsr;// ������
	private String jsfs;// ���㷽ʽ
	private Set tbRkthDetails = new HashSet(0);// �����˻���ϸ��Ϣ

	public TbRkthMain() {// ȱʡ���캯��
	}

	public TbRkthMain(String rkthId, String pzs, String je, String ysjl, String gysname, String rtdate, String czy,
			String jsr, String jsfs) {// �������캯��
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

	// ʹ��Getters and Setters�����������˻��������˽�����Է�װ����
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