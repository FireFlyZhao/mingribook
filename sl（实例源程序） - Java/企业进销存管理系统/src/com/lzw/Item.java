package com.lzw;

public class Item {// ���ݱ�����

	private String id;// �������
	private String name;// ������Ϣ

	public Item() {// ȱʡ���캯��
	}

	public Item(String id, String name) {// �������캯��
		this.id = id;
		this.name = name;
	}

	// ʹ��Getters and Setters���������ݱ������˽�����Է�װ����
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// ��дtoString()������ֻ���������Ϣ
	public String toString() {
		return getName();
	}
}
