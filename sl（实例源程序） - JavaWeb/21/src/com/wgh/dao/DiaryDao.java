package com.wgh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wgh.model.Diary;
import com.wgh.tools.ConnDB;

public class DiaryDao {
	private ConnDB conn = null;// 创建数据库连接对象

	public DiaryDao() {
		conn = new ConnDB();// 实例化数据库连接对象
	}

	/**
	 * 查询日记
	 * 
	 * @param sql
	 * @return
	 */
	public List<Diary> queryDiary(String sql) {
		ResultSet rs = conn.executeQuery(sql);// 执行查询语句
		List<Diary> list = new ArrayList<Diary>();
		try {// 捕获异常
			while (rs.next()) {
				Diary diary = new Diary();
				diary.setId(rs.getInt(1));// 获取并设置ID
				diary.setTitle(rs.getString(2));// 获取并设置日记标题
				diary.setAddress(rs.getString(3));// 获取并设置图片地址
				Date date;
				try {
					date = DateFormat.getDateTimeInstance().parse(
							rs.getString(4));
					diary.setWriteTime(date);// 设置写日记的时间
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();// 输出异常信息到控制台
				}

				diary.setUserid(rs.getInt(5));// 获取并设置用户ID
				diary.setUsername(rs.getString(6));// 获取并设置用户名
				list.add(diary);// 将日记信息保存到list集合中

			}
		} catch (SQLException e) {
			e.printStackTrace();// 输出异常信息
		} finally {
			conn.close();// 关闭数据库连接
		}
		return list;
	}

	/**
	 * 功能：保存九宫格日记到数据库
	 * 
	 * @param diary
	 * @return
	 */
	public int saveDiary(Diary diary) {
		String sql = "INSERT INTO tb_diary (title,address,userid) VALUES('"
				+ diary.getTitle() + "','" + diary.getAddress() + "',"
				+ diary.getUserid() + ")";		//保存数据的SQL语句
		int ret = conn.executeUpdate(sql);// 执行更新语句
		conn.close();// 关闭数据库连接
		return ret;
	}

	/**
	 * 删除指定日记
	 * 
	 * @param id
	 * @return
	 */
	public int delDiary(int id) {
		String sql = "DELETE FROM tb_diary WHERE id=" + id;
		int ret = 0;
		try {
			ret = conn.executeUpdate(sql);// 执行更新语句
		} catch (Exception e) {
			e.printStackTrace();// 输出异常信息
		} finally {
			conn.close();// 关闭数据连接
		}
		return ret;
	}
}
