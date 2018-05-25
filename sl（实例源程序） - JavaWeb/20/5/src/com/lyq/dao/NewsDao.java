package com.lyq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lyq.News;
/**
 * 新闻数据库操作
 * @author YongQinag Lee
 *
 */
public class NewsDao {
	public List<News> findAll(){
		List<News> list = null;
		Connection conn = DataBaseUtil.getConnection();
		try {
			String sql = "select * from tb_news";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<News>();
			while(rs.next()){
				News news = new News();
				news.setId(rs.getInt("id"));
				news.setContent(rs.getString("content"));
				news.setTitle(rs.getString("title"));
				news.setCreateTime(rs.getTimestamp("createTime"));
				list.add(news);
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeConnection(conn);
		}
		return list;
	}
}
