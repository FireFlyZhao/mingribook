package com.lzw.dao;

public class Columns {
	private String name;// ����
	private String type;// �ֶ�����
	private boolean isNull;// �Ƿ����Ϊnull
	private boolean isKey;// �Ƿ�������
	private boolean isIncrement;// �Ƿ�����

	public Columns() {
		super();
	}

	public Columns(String name, String type, boolean isNull, boolean isKey,
			boolean isIncrement) {
		super();
		this.name = name;
		this.type = type;
		this.isNull = isNull;
		this.isKey = isKey;
		this.isIncrement = isIncrement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isNull() {
		return isNull;
	}

	public void setNull(boolean isNull) {
		this.isNull = isNull;
	}

	public boolean isKey() {
		return isKey;
	}

	public void setKey(boolean isKey) {
		this.isKey = isKey;
	}

	public boolean isIncrement() {
		return isIncrement;
	}

	public void setIncrement(boolean isIncrement) {
		this.isIncrement = isIncrement;
	}

	@Override
	public String toString() {
		return "Columns [name=" + name + ", type=" + type + ", isNull="
				+ isNull + ", isKey=" + isKey + ", isIncrement=" + isIncrement
				+ "]";
	}

}
