package com.lyq.bean;
/**
 * ͼ��ʵ����
 * @author Li YongQiang
 */
public class Book {
	// ���
	private int id;
	// ͼ������
	private String name;
	// �۸�
	private double price;
	// ����
	private int bookCount;
	// ����
	private String author;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getBookCount() {
		return bookCount;
	}
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
