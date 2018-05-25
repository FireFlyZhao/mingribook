package com.wgh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wgh.model.User;
import com.wgh.tools.ConnDB;

public class UserDao {
	private ConnDB conn = null;

	public UserDao() {
		conn = new ConnDB();
	}

	// 验证用户的方法，返回值为1表示登录成功，否则表示登录失败
	public int login(User user) {
		int flag = 0;
		String sql = "SELECT * FROM tb_user where userName='"
				+ user.getUsername() + "'";
		ResultSet rs = conn.executeQuery(sql);// 执行SQL语句
		try {
			if (rs.next()) {
				String pwd = user.getPwd();// 获取密码
				int uid = rs.getInt(1);// 获取第一列的数据
				if (pwd.equals(rs.getString(3))) {
					flag = uid;
					rs.last(); // 定位到最后一条记录
					int rowSum = rs.getRow();// 获取记录总数
					rs.first();// 定位到第一条记录
					if (rowSum != 1) {
						flag = 0;
					}
				} else {
					flag = 0;
				}
			} else {
				flag = 0;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();// 输出异常信息
			flag = 0;
		} finally {
			conn.close();// 关闭数据库连接
		}
		return flag;
	}

	/**
	 * 功能：检测用户名是否为空
	 * 
	 * @param sql
	 * @return
	 */
	public String checkUser(String sql) {
		ResultSet rs = conn.executeQuery(sql); // 执行查询语句
		String result = "";
		try {
			if (rs.next()) {
				result = "很抱歉，[" + rs.getString(2) + "]已经被注册！";
			} else {
				result = "1"; // 表示用户没有被注册
			}
		} catch (SQLException e) {
			e.printStackTrace(); // 输出异常信息
		} finally {
			conn.close(); // 关闭数据库连接
		}
		return result; // 返回判断结果
	}

	/**
	 * 功能：保存用户注册信息
	 * 
	 * @param sql
	 * @return
	 */
	public String save(String sql) {
		int rtn = conn.executeUpdate(sql); // 执行更新语句
		String result = "";
		if (rtn > 0) {
			result = "用户注册成功！";
		} else {
			result = "用户注册失败！";
		}
		conn.close(); // 关闭数据库的连接
		return result; // 返回执行结果
	}

	/**
	 * 找回密码第一步
	 * 
	 * @param username
	 * @return
	 */
	public String forgetPwd1(String username) {
		String sql = "SELECT question FROM tb_user WHERE username='" + username
				+ "'";
		ResultSet rs = conn.executeQuery(sql);// 执行SQL语句
		String result = "";
		try {
			if (rs.next()) {
				result = rs.getString(1);// 获取第一列的数据
			} else {
				result = "您输入的用户名不存在！"; // 表示输入的用户名不存在
			}
		} catch (SQLException e) {
			e.printStackTrace(); // 输出异常信息
			result = "您输入的用户名不存在！"; // 表示输入的用户名不存在
		} finally {
			conn.close(); // 关闭数据库连接
		}
		return result;
	}

	/**
	 * 找回密码第二步
	 * 
	 * @param username
	 * @return
	 */
	public String forgetPwd2(String username, String question, String answer) {
		String sql = "SELECT pwd FROM tb_user WHERE username='" + username
				+ "' AND question='" + question + "' AND answer='" + answer
				+ "'";
		ResultSet rs = conn.executeQuery(sql);// 执行SQL语句
		String result = "";
		try {
			if (rs.next()) {
				result = rs.getString(1);// 获取第一列的数据
			} else {
				result = "您输入的密码提示问题答案错误！"; // 表示输入的密码提示问题答案错误
			}
		} catch (SQLException e) {
			e.printStackTrace();// 输出异常信息
		} finally {
			conn.close(); // 关闭数据库连接
		}
		return result;
	}
}
