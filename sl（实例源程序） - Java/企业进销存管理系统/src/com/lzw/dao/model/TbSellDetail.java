package com.lzw.dao.model;

public class TbSellDetail implements java.io.Serializable {// ������ϸ��ʵ�����л��ӿڣ�

	private Integer id;// ��ˮ��
	private String tbSellMain;// ��������
	private String spid;// ��Ʒ���
	private Double dj;// ���۵���
	private Integer sl;// ��������

	public TbSellDetail() {// ȱʡ���캯��
	}

	public TbSellDetail(String tbSellMain, String spid, Double dj, Integer sl) {// �������캯��
		this.tbSellMain = tbSellMain;
		this.spid = spid;
		this.dj = dj;
		this.sl = sl;
	}

	// ʹ��Getters and Setters������������ϸ���˽�����Է�װ����
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTbSellMain() {
		return this.tbSellMain;
	}

	public void setTbSellMain(String tbSellMain) {
		this.tbSellMain = tbSellMain;
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