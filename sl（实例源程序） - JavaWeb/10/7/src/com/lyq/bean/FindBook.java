package com.lyq.bean;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FindBook {
	/**
	 * ��ȡ���ݿ�����
	 * @return Connection����
	 */
	public Connection getConnection(){
		// ���ݿ�����
		Connection conn = null;
		try {
			// �������ݿ�������ע�ᵽ����������
			Class.forName("com.mysql.jdbc.Driver");
			// ���ݿ������ַ���
			String url = "jdbc:mysql://localhost:3306/db_database10";
			// ���ݿ��û���
			String username = "root";
			// ���ݿ�����
			String password = "111";
			// ����Connection����
			conn = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// �������ݿ�����
		return conn;
	}
	/**
	 * ͨ���洢���̲�ѯ����
	 * @return  List<Book> 
	 */
	public List<Book> findAll(){
		// ʵ����List����
		List<Book> list = new ArrayList<Book>();
		// �������ݿ�����
		Connection conn = getConnection();
			//���ô洢����
			try {
				CallableStatement cs = conn.prepareCall("{call findAllBook()}");		
			// ִ�в�ѯ����������ȡ�����
			ResultSet rs = cs.executeQuery();
			System.out.println("sssssssssssss:"+(rs == null));
			// �жϹ������ƶ������ж��Ƿ���Ч
			while(rs.next()){
				// ʵ����Book����
				Book book = new Book();
				// ��id���Ը�ֵ
				book.setId(rs.getInt("id"));
				// ��name���Ը�ֵ
				book.setName(rs.getString("name"));
				// ��price���Ը�ֵ
				book.setPrice(rs.getDouble("price"));
				// ��bookCount���Ը�ֵ
				book.setBookCount(rs.getInt("bookCount"));
				// ��author���Ը�ֵ
				book.setAuthor(rs.getString("author"));
				System.out.println("ssssssss");
				// ��ͼ�������ӵ�������
				list.add(book);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ����list
		return list;
	}
}
