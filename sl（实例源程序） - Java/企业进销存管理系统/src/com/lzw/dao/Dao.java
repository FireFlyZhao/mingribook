package com.lzw.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import com.lzw.Item;
import com.lzw.dao.model.TbGysinfo;
import com.lzw.dao.model.TbJsr;
import com.lzw.dao.model.TbKhinfo;
import com.lzw.dao.model.TbKucun;
import com.lzw.dao.model.TbRkthDetail;
import com.lzw.dao.model.TbRkthMain;
import com.lzw.dao.model.TbRukuDetail;
import com.lzw.dao.model.TbRukuMain;
import com.lzw.dao.model.TbSellDetail;
import com.lzw.dao.model.TbSellMain;
import com.lzw.dao.model.TbSpinfo;
import com.lzw.dao.model.TbXsthDetail;
import com.lzw.dao.model.TbXsthMain;

public class Dao {

	protected static String dbClassName = "com.mysql.jdbc.Driver";// MySQL数据库驱动类的名称
	protected static String dbUrl = "jdbc:mysql://127.0.0.1:3306/db_database28";// 访问MySQL数据库的路径
	protected static String dbUser = "root";// 访问MySQL数据库的用户名
	protected static String dbPwd = "123456";// 访问MySQL数据库的密码
	protected static String dbName = "db_database28";// 访问MySQL数据库中的实例(db_database28)
	protected static String second = null;//
	public static Connection conn = null;// MySQL数据库的连接对象

	static {// 静态初始化Dao类
		try {
			if (conn == null) {
				Class.forName(dbClassName).newInstance();// 实例化MySQL数据库的驱动
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);// 连接MySQL数据库
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "请将MySQL的JDBC驱动包复制到lib文件夹中。");// 捕获异常后，弹出提示框
			System.exit(-1);// 系统停止运行
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Dao() {
	}

	// 数据库备份
	public static String backup() throws SQLException {
		LinkedList<String> sqls = new LinkedList<String>();// 备份文件中的所有sql
		// 涉及的相关表命数组
		String tables[] = { "tb_gysinfo", "tb_jsr", "tb_khinfo", "tb_kucun",
				"tb_rkth_detail", "tb_rkth_main", "tb_ruku_detail",
				"tb_ruku_main", "tb_sell_detail", "tb_sell_main", "tb_spinfo",
				"tb_userlist", "tb_xsth_detail", "tb_xsth_main" };
		ArrayList<Tables> tableList = new ArrayList<Tables>();// 创建保存所有表对象的集合
		for (int i = 0; i < tables.length; i++) {// 遍历表名称数组
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("desc " + tables[i]);// 查询表结构
			ArrayList<Columns> columns = new ArrayList<Columns>();// 列集合
			while (rs.next()) {
				Columns c = new Columns();// 创建列对象
				c.setName(rs.getString("Field"));// 读取列名
				c.setType(rs.getString("Type"));// 读取列类型
				String isnull = rs.getString("Null");// 读取为空类型
				if ("YES".equals(isnull)) {// 如果列可以为空
					c.setNull(true);// 列可以为空
				}
				String key = rs.getString("Key");// 读取主键类型
				if ("PRI".equals(key)) {// 如果是主键
					c.setKey(true);// 列为主键
					String increment = rs.getString("Extra");// 读取特殊属性
					if ("auto_increment".equals(increment)) {// 表主键是否自增
						c.setIncrement(true);// 主键自增
					}
				}
				columns.add(c);// 列集合添加此列
			}
			Tables table = new Tables(tables[i], columns);// 创建表示此表命和拥有对应列对象的表对象
			tableList.add(table);// 表集合保存此表对象
			rs.close();// 关闭结果集
			stmt.close();// 关闭sql语句接口
		}

		for (int i = 0; i < tableList.size(); i++) {// 遍历表对象集合
			Tables table = tableList.get(i);// 获取表格对象

			String dropsql = "DROP TABLE IF EXISTS " + table.getName() + " ;";// 删除表sql
			sqls.add(dropsql);// 添加删除表sql

			StringBuilder createsql = new StringBuilder();// 创建表sql
			createsql.append("CREATE TABLE " + table.getName() + "( ");// 创建语句句头
			ArrayList<Columns> columns = table.getColumns();// 获取表中所有列对象
			for (int k = 0; k < columns.size(); k++) {// 遍历列集合
				Columns c = columns.get(k);// 获取列对象
				createsql.append(c.getName() + " " + c.getType());// 添加列名和类型声明语句
				if (!c.isNull()) {// 如果列可以为空
					createsql.append(" not null ");// 添加可以为空语句
				}
				if (c.isKey()) {// 如果是主键
					createsql.append(" primary key ");// 添加主键语句
					if (c.isIncrement()) {// 如果是主键自增
						createsql.append(" AUTO_INCREMENT ");// 添加自增语句
					}
				}
				if (k < columns.size() - 1) {// 如果不是最后一列
					createsql.append(",");// 添加逗号
				} else {// 如果是最后一列
					createsql.append(");");// 创建语句结尾
				}
			}
			sqls.add(createsql.toString());// 添加创建表sql

			Statement stmt = conn.createStatement();// 执行sql接口
			ResultSet rs = stmt
					.executeQuery("select * from " + table.getName());
			while (rs.next()) {
				StringBuilder insertsql = new StringBuilder();// 插入值sql
				insertsql.append("INSERT INTO " + table.getName() + " VALUES(");
				for (int j = 0; j < columns.size(); j++) {// 遍历表中所有列
					Columns c = columns.get(j);// 获取列对象
					String type = c.getType();// 获取列字段修饰符
					if (type.startsWith("varchar") || type.startsWith("char")
							|| type.startsWith("datetime")) {// 如果数据类型开头用varchar、char、datetime任意一种修饰
						insertsql.append("'" + rs.getString(c.getName()) + "'");// 获取本列数据，两端加逗号
					} else {
						insertsql.append(rs.getString(c.getName()));// 获取本列数据，两端不加逗号
					}
					if (j < columns.size() - 1) {// 如果不是最后一列
						insertsql.append(",");// 添加逗号
					} else {// 如果是最后一列
						insertsql.append(");");// 添加句尾
					}
				}
				sqls.add(insertsql.toString());// 添加插入数据sql
			}
			rs.close();// 关闭结果集
			stmt.close();// 关闭sql语句接口
		}
		sqls.add("DROP VIEW IF EXISTS v_rukuView;"); // 插入删除视图语句
		// 插入创建爱视图语句
		sqls.add("CREATE VIEW v_rukuView AS SELECT tb_ruku_main.rkID, tb_ruku_detail.spid, tb_spinfo.spname, tb_spinfo.gg, tb_ruku_detail.dj, tb_ruku_detail.sl,tb_ruku_detail.dj * tb_ruku_detail.sl AS je, tb_spinfo.gysname, tb_ruku_main.rkdate, tb_ruku_main.czy, tb_ruku_main.jsr,tb_ruku_main.jsfs FROM tb_ruku_detail INNER JOIN tb_ruku_main ON tb_ruku_detail.rkID = tb_ruku_main.rkID INNER JOIN tb_spinfo ON tb_ruku_detail.spid = tb_spinfo.id;");
		sqls.add("DROP VIEW IF EXISTS v_sellView;");// 插入删除视图语句
		// 插入创建爱视图语句
		sqls.add("CREATE VIEW v_sellView AS SELECT tb_sell_main.sellID, tb_spinfo.spname, tb_sell_detail.spid, tb_spinfo.gg, tb_sell_detail.dj, tb_sell_detail.sl,tb_sell_detail.sl * tb_sell_detail.dj AS je, tb_sell_main.khname, tb_sell_main.xsdate, tb_sell_main.czy, tb_sell_main.jsr,tb_sell_main.jsfs FROM tb_sell_detail INNER JOIN tb_sell_main ON tb_sell_detail.sellID = tb_sell_main.sellID INNER JOIN tb_spinfo ON tb_sell_detail.spid = tb_spinfo.id;");

		java.util.Date date = new java.util.Date();// 通过Date对象获得当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");// 设置当前时间的输出格式
		String backupTime = sdf.format(date);// 格式化Date对象
		String filePath = "backup\\" + backupTime + ".sql";// 通过拼接字符串获得备份文件的存放路径

		File sqlFile = new File(filePath);// 创建备份文件对象
		FileOutputStream fos = null;// 文件字节输出流
		OutputStreamWriter osw = null;// 字节流转为字符流
		BufferedWriter rw = null;// 缓冲字符流
		try {
			fos = new FileOutputStream(sqlFile);
			osw = new OutputStreamWriter(fos);
			rw = new BufferedWriter(osw);
			for (String tmp : sqls) {// 遍历所有备份sql
				rw.write(tmp);// 向文件中写入sql
				rw.newLine();// 文件换行
				rw.flush();// 字符流刷新
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 倒序依次关闭所有IO流
			if (rw != null) {
				try {
					rw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return filePath;
	}

	// 数据库恢复
	public static void restore(String filePath) {
		File sqlFile = new File(filePath);// 创建备份文件对象
		Statement stmt = null;// sql语句直接接口
		FileInputStream fis = null;// 文件输入字节流
		InputStreamReader isr = null;// 字节流转为字符流
		BufferedReader br = null;// 缓存输入字符流
		try {
			fis = new FileInputStream(sqlFile);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			String readStr = null;// 缓冲字符串，保存备份文件中一行的内容
			while ((readStr = br.readLine()) != null) {// 逐行读取备份文件中的内容
				if (!"".equals(readStr.trim())) {// 如果读取的内容不为空
					stmt = conn.createStatement();// 创建sql语句直接接口
					int count = stmt.executeUpdate(readStr);// 执行sql语句
					stmt.close();// 关闭接口
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 倒序依次关闭所有IO流
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 读取所有客户信息
	public static List getKhInfos() {
		List list = findForList("select id,khname from tb_khinfo");
		return list;
	}

	// 读取所有供应商信息
	public static List getGysInfos() {
		List list = findForList("select id,name from tb_gysinfo");
		return list;
	}

	// 读取客户信息
	public static TbKhinfo getKhInfo(Item item) {
		String where = "khname='" + item.getName() + "'";
		if (item.getId() != null)
			where = "id='" + item.getId() + "'";
		TbKhinfo info = new TbKhinfo();
		ResultSet set = findForResultSet("select * from tb_khinfo where "
				+ where);
		try {
			if (set.next()) {
				info.setId(set.getString("id").trim());
				info.setKhname(set.getString("khname").trim());
				info.setJian(set.getString("jian").trim());
				info.setAddress(set.getString("address").trim());
				info.setBianma(set.getString("bianma").trim());
				info.setFax(set.getString("fax").trim());
				info.setHao(set.getString("hao").trim());
				info.setLian(set.getString("lian").trim());
				info.setLtel(set.getString("ltel").trim());
				info.setMail(set.getString("mail").trim());
				info.setTel(set.getString("tel").trim());
				info.setXinhang(set.getString("xinhang").trim());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}

	// 读取指定供应商信息
	public static TbGysinfo getGysInfo(Item item) {
		String where = "name='" + item.getName() + "'";
		if (item.getId() != null)
			where = "id='" + item.getId() + "'";
		TbGysinfo info = new TbGysinfo();
		ResultSet set = findForResultSet("select * from tb_gysinfo where "
				+ where);
		try {
			if (set.next()) {
				info.setId(set.getString("id").trim());
				info.setAddress(set.getString("address").trim());
				info.setBianma(set.getString("bianma").trim());
				info.setFax(set.getString("fax").trim());
				info.setJc(set.getString("jc").trim());
				info.setLian(set.getString("lian").trim());
				info.setLtel(set.getString("ltel").trim());
				info.setMail(set.getString("mail").trim());
				info.setName(set.getString("name").trim());
				info.setTel(set.getString("tel").trim());
				info.setYh(set.getString("yh").trim());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}

	// 读取经手人
	public static TbJsr getJsr(String name, String password) {
		TbJsr user = new TbJsr();
		ResultSet rs = findForResultSet("select * from tb_jsr where name='"
				+ name + "'");
		try {
			if (rs.next()) {
				user.setSex(name);
				user.setAge(rs.getString("pass"));
				if (user.getAge().equals(password)) {
					user.setName(rs.getString("name"));
					user.setTel(rs.getString("quan"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	// 执行指定查询
	public static ResultSet query(String QueryStr) {
		ResultSet set = findForResultSet(QueryStr);
		return set;
	}

	// 执行删除
	public static int delete(String sql) {
		return update(sql);
	}

	// 添加客户信息的方法
	public static boolean addKeHu(TbKhinfo khinfo) {
		if (khinfo == null)
			return false;
		return insert("insert tb_khinfo values('" + khinfo.getId() + "','"
				+ khinfo.getKhname() + "','" + khinfo.getJian() + "','"
				+ khinfo.getAddress() + "','" + khinfo.getBianma() + "','"
				+ khinfo.getTel() + "','" + khinfo.getFax() + "','"
				+ khinfo.getLian() + "','" + khinfo.getLtel() + "','"
				+ khinfo.getMail() + "','" + khinfo.getXinhang() + "','"
				+ khinfo.getHao() + "')");
	}

	// 修改客户信息的方法
	public static int updateKeHu(TbKhinfo khinfo) {
		return update("update tb_khinfo set jian='" + khinfo.getJian()
				+ "',address='" + khinfo.getAddress() + "',bianma='"
				+ khinfo.getBianma() + "',tel='" + khinfo.getTel() + "',fax='"
				+ khinfo.getFax() + "',lian='" + khinfo.getLian() + "',ltel='"
				+ khinfo.getLtel() + "',mail='" + khinfo.getMail()
				+ "',xinhang='" + khinfo.getXinhang() + "',hao='"
				+ khinfo.getHao() + "' where id='" + khinfo.getId() + "'");
	}

	// 修改库存的方法
	public static int updateKucunDj(TbKucun kcInfo) {
		return update("update tb_kucun set dj=" + kcInfo.getDj()
				+ " where id='" + kcInfo.getId() + "'");
	}

	// 修改供应商信息的方法
	public static int updateGys(TbGysinfo gysInfo) {
		return update("update tb_gysinfo set jc='" + gysInfo.getJc()
				+ "',address='" + gysInfo.getAddress() + "',bianma='"
				+ gysInfo.getBianma() + "',tel='" + gysInfo.getTel()
				+ "',fax='" + gysInfo.getFax() + "',lian='" + gysInfo.getLian()
				+ "',ltel='" + gysInfo.getLtel() + "',mail='"
				+ gysInfo.getMail() + "',yh='" + gysInfo.getYh()
				+ "' where id='" + gysInfo.getId() + "'");
	}

	// 添加供应商信息的方法
	public static boolean addGys(TbGysinfo gysInfo) {
		if (gysInfo == null)
			return false;
		return insert("insert tb_gysinfo values('" + gysInfo.getId() + "','"
				+ gysInfo.getName() + "','" + gysInfo.getJc() + "','"
				+ gysInfo.getAddress() + "','" + gysInfo.getBianma() + "','"
				+ gysInfo.getTel() + "','" + gysInfo.getFax() + "','"
				+ gysInfo.getLian() + "','" + gysInfo.getLtel() + "','"
				+ gysInfo.getMail() + "','" + gysInfo.getYh() + "')");
	}

	// 添加商品
	public static boolean addSp(TbSpinfo spInfo) {
		if (spInfo == null)
			return false;
		return insert("insert tb_spinfo values('" + spInfo.getId() + "','"
				+ spInfo.getSpname() + "','" + spInfo.getJc() + "','"
				+ spInfo.getCd() + "','" + spInfo.getDw() + "','"
				+ spInfo.getGg() + "','" + spInfo.getBz() + "','"
				+ spInfo.getPh() + "','" + spInfo.getPzwh() + "','"
				+ spInfo.getMemo() + "','" + spInfo.getGysname() + "')");
	}

	// 更新商品
	public static int updateSp(TbSpinfo spInfo) {
		return update("update tb_spinfo set jc='" + spInfo.getJc() + "',cd='"
				+ spInfo.getCd() + "',dw='" + spInfo.getDw() + "',gg='"
				+ spInfo.getGg() + "',bz='" + spInfo.getBz() + "',ph='"
				+ spInfo.getPh() + "',pzwh='" + spInfo.getPzwh() + "',memo='"
				+ spInfo.getMemo() + "',gysname='" + spInfo.getGysname()
				+ "' where id='" + spInfo.getId() + "'");
	}

	// 读取商品信息
	public static TbSpinfo getSpInfo(Item item) {
		String where = "spname='" + item.getName() + "'";
		if (item.getId() != null)
			where = "id='" + item.getId() + "'";
		ResultSet rs = findForResultSet("select * from tb_spinfo where "
				+ where);
		TbSpinfo spInfo = new TbSpinfo();
		try {
			if (rs.next()) {
				spInfo.setId(rs.getString("id").trim());
				spInfo.setBz(rs.getString("bz").trim());
				spInfo.setCd(rs.getString("cd").trim());
				spInfo.setDw(rs.getString("dw").trim());
				spInfo.setGg(rs.getString("gg").trim());
				spInfo.setGysname(rs.getString("gysname").trim());
				spInfo.setJc(rs.getString("jc").trim());
				spInfo.setMemo(rs.getString("memo").trim());
				spInfo.setPh(rs.getString("ph").trim());
				spInfo.setPzwh(rs.getString("pzwh").trim());
				spInfo.setSpname(rs.getString("spname").trim());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return spInfo;
	}

	// 获取所有商品信息
	public static List getSpInfos() {
		List list = findForList("select * from tb_spinfo");
		return list;
	}

	// 获取库存商品信息
	public static TbKucun getKucun(Item item) {
		String where = "spname='" + item.getName() + "'";
		if (item.getId() != null)
			where = "id='" + item.getId() + "'";
		ResultSet rs = findForResultSet("select * from tb_kucun where " + where);
		TbKucun kucun = new TbKucun();
		try {
			if (rs.next()) {
				kucun.setId(rs.getString("id"));
				kucun.setSpname(rs.getString("spname"));
				kucun.setJc(rs.getString("jc"));
				kucun.setBz(rs.getString("bz"));
				kucun.setCd(rs.getString("cd"));
				kucun.setDj(rs.getDouble("dj"));
				kucun.setDw(rs.getString("dw"));
				kucun.setGg(rs.getString("gg"));
				kucun.setKcsl(rs.getInt("kcsl"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kucun;
	}

	// 获取入库单的最大ID，即最大入库票号
	public static String getRuKuMainMaxId(Date date) {
		return getMainTypeTableMaxId(date, "tb_ruku_main", "RK", "rkid");
	}

	// 在事务中添加入库信息
	public static boolean insertRukuInfo(TbRukuMain ruMain) {
		try {
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			// 添加入库主表记录
			insert("insert into tb_ruku_main values('" + ruMain.getRkId()
					+ "','" + ruMain.getPzs() + "'," + ruMain.getJe() + ",'"
					+ ruMain.getYsjl() + "','" + ruMain.getGysname() + "','"
					+ ruMain.getRkdate() + "','" + ruMain.getCzy() + "','"
					+ ruMain.getJsr() + "','" + ruMain.getJsfs() + "')");
			Set<TbRukuDetail> rkDetails = ruMain.getTabRukuDetails();
			for (Iterator<TbRukuDetail> iter = rkDetails.iterator(); iter
					.hasNext();) {
				TbRukuDetail details = iter.next();
				// 添加入库详细表记录
				insert("insert into tb_ruku_detail values('" + ruMain.getRkId()
						+ "','" + details.getTabSpinfo() + "',"
						+ details.getDj() + "," + details.getSl() + ")");
				// 添加或修改库存表记录
				Item item = new Item();
				item.setId(details.getTabSpinfo());
				TbSpinfo spInfo = getSpInfo(item);
				if (spInfo.getId() != null && !spInfo.getId().isEmpty()) {
					TbKucun kucun = getKucun(item);
					if (kucun.getId() == null || kucun.getId().isEmpty()) {
						insert("insert into tb_kucun values('" + spInfo.getId()
								+ "','" + spInfo.getSpname() + "','"
								+ spInfo.getJc() + "','" + spInfo.getCd()
								+ "','" + spInfo.getGg() + "','"
								+ spInfo.getBz() + "','" + spInfo.getDw()
								+ "'," + details.getDj() + ","
								+ details.getSl() + ")");
					} else {
						int sl = kucun.getKcsl() + details.getSl();
						update("update tb_kucun set kcsl=" + sl + ",dj="
								+ details.getDj() + " where id='"
								+ kucun.getId() + "'");
					}
				}
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static ResultSet findForResultSet(String sql) {
		if (conn == null)
			return null;
		long time = System.currentTimeMillis();
		ResultSet rs = null;
		try {
			Statement stmt = null;
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			second = ((System.currentTimeMillis() - time) / 1000d) + "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	// 添加数据
	public static boolean insert(String sql) {
		boolean result = false;
		try {
			Statement stmt = conn.createStatement();
			result = stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 更新数据
	public static int update(String sql) {
		int result = 0;
		try {
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List findForList(String sql) {
		List<List> list = new ArrayList<List>();
		ResultSet rs = findForResultSet(sql);
		try {
			ResultSetMetaData metaData = rs.getMetaData();
			int colCount = metaData.getColumnCount();
			while (rs.next()) {
				List<String> row = new ArrayList<String>();
				for (int i = 1; i <= colCount; i++) {
					String str = rs.getString(i);
					if (str != null && !str.isEmpty())
						str = str.trim();
					row.add(str);
				}
				list.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 获取退货最大ID
	public static String getRkthMainMaxId(Date date) {
		return getMainTypeTableMaxId(date, "tb_rkth_main", "RT", "rkthId");
	}

	// 在事务中添加入库退货信息
	public static boolean insertRkthInfo(TbRkthMain rkthMain) {
		try {
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			// 添加入库退货主表记录
			insert("insert into tb_rkth_main values('" + rkthMain.getRkthId()
					+ "','" + rkthMain.getPzs() + "'," + rkthMain.getJe()
					+ ",'" + rkthMain.getYsjl() + "','" + rkthMain.getGysname()
					+ "','" + rkthMain.getRtdate() + "','" + rkthMain.getCzy()
					+ "','" + rkthMain.getJsr() + "','" + rkthMain.getJsfs()
					+ "')");
			Set<TbRkthDetail> rkDetails = rkthMain.getTbRkthDetails();
			for (Iterator<TbRkthDetail> iter = rkDetails.iterator(); iter
					.hasNext();) {
				TbRkthDetail details = iter.next();
				// 添加入库详细表记录
				insert("insert into tb_rkth_detail values('"
						+ rkthMain.getRkthId() + "','" + details.getSpid()
						+ "'," + details.getDj() + "," + details.getSl() + ")");
				// 添加或修改库存表记录
				Item item = new Item();
				item.setId(details.getSpid());
				TbSpinfo spInfo = getSpInfo(item);
				if (spInfo.getId() != null && !spInfo.getId().isEmpty()) {
					TbKucun kucun = getKucun(item);
					if (kucun.getId() != null && !kucun.getId().isEmpty()) {
						int sl = kucun.getKcsl() - details.getSl();
						update("update tb_kucun set kcsl=" + sl + " where id='"
								+ kucun.getId() + "'");
					}
				}
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 获取销售主表最大ID
	public static String getSellMainMaxId(Date date) {
		return getMainTypeTableMaxId(date, "tb_sell_main", "XS", "sellID");
	}

	// 在事务中添加销售信息
	public static boolean insertSellInfo(TbSellMain sellMain) {
		try {
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			// 添加销售主表记录
			insert("insert into tb_sell_main values('" + sellMain.getSellId()
					+ "','" + sellMain.getPzs() + "'," + sellMain.getJe()
					+ ",'" + sellMain.getYsjl() + "','" + sellMain.getKhname()
					+ "','" + sellMain.getXsdate() + "','" + sellMain.getCzy()
					+ "','" + sellMain.getJsr() + "','" + sellMain.getJsfs()
					+ "')");
			Set<TbSellDetail> rkDetails = sellMain.getTbSellDetails();
			for (Iterator<TbSellDetail> iter = rkDetails.iterator(); iter
					.hasNext();) {
				TbSellDetail details = iter.next();
				// 添加销售详细表记录
				insert("insert into tb_sell_detail values('"
						+ sellMain.getSellId() + "','" + details.getSpid()
						+ "'," + details.getDj() + "," + details.getSl() + ")");
				// 修改库存表记录
				Item item = new Item();
				item.setId(details.getSpid());
				TbSpinfo spInfo = getSpInfo(item);
				if (spInfo.getId() != null && !spInfo.getId().isEmpty()) {
					TbKucun kucun = getKucun(item);
					if (kucun.getId() != null && !kucun.getId().isEmpty()) {
						int sl = kucun.getKcsl() - details.getSl();
						update("update tb_kucun set kcsl=" + sl + " where id='"
								+ kucun.getId() + "'");
					}
				}
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 获取更类主表最大ID
	private static String getMainTypeTableMaxId(Date date, String table,
			String idChar, String idName) {
		String dateStr = date.toString().replace("-", "");
		String id = idChar + dateStr;
		String sql = "select max(" + idName + ") from " + table + " where "
				+ idName + " like '" + id + "%'";
		ResultSet set = query(sql);
		String baseId = null;
		try {
			if (set.next())
				baseId = set.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		baseId = baseId == null ? "000" : baseId.substring(baseId.length() - 3);
		int idNum = Integer.parseInt(baseId) + 1;
		id += String.format("%03d", idNum);
		return id;
	}

	// 获得最大的销售退货编号
	public static String getXsthMainMaxId(Date date) {
		return getMainTypeTableMaxId(date, "tb_xsth_main", "XT", "xsthID");
	}

	// 获得库存信息
	public static List getKucunInfos() {
		List list = findForList("select id,spname,dj,kcsl from tb_kucun");
		return list;
	}

	// 在事务中添加销售退货信息
	public static boolean insertXsthInfo(TbXsthMain xsthMain) {
		try {
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			// 添加销售退货主表记录
			insert("insert into tb_xsth_main values('" + xsthMain.getXsthId()
					+ "','" + xsthMain.getPzs() + "'," + xsthMain.getJe()
					+ ",'" + xsthMain.getYsjl() + "','" + xsthMain.getKhname()
					+ "','" + xsthMain.getThdate() + "','" + xsthMain.getCzy()
					+ "','" + xsthMain.getJsr() + "','" + xsthMain.getJsfs()
					+ "')");
			Set<TbXsthDetail> xsthDetails = xsthMain.getTbXsthDetails();
			for (Iterator<TbXsthDetail> iter = xsthDetails.iterator(); iter
					.hasNext();) {
				TbXsthDetail details = iter.next();
				// 添加销售退货详细表记录
				insert("insert into tb_xsth_detail values('"
						+ xsthMain.getXsthId() + "','" + details.getSpid()
						+ "'," + details.getDj() + "," + details.getSl() + ")");
				// 修改库存表记录
				Item item = new Item();
				item.setId(details.getSpid());
				TbSpinfo spInfo = getSpInfo(item);
				if (spInfo.getId() != null && !spInfo.getId().isEmpty()) {
					TbKucun kucun = getKucun(item);
					if (kucun.getId() != null && !kucun.getId().isEmpty()) {
						int sl = kucun.getKcsl() + details.getSl();
						update("update tb_kucun set kcsl=" + sl + " where id='"
								+ kucun.getId() + "'");
					}
				}
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	// 添加用户
	public static int addJsr(TbJsr jsr) {
		String sql = "insert tb_jsr values('" + jsr.getName() + "','"
				+ jsr.getSex() + "','" + jsr.getAge() + "','" + jsr.getTel()
				+ "',1)";
		System.out.println(sql);
		return update(sql);
	}

	public static List getJsrs() {
		List list = findForList("select * from tb_jsr where enable=1");
		return list;
	}

	// 修改用户方法
	public static int modifyPassword(String oldPass, String pass) {
		return update("update tb_userlist set pass='" + pass + "' where pass='"
				+ oldPass + "'");
	}

	// 获取用户对象的方法
	public static TbJsr getUser(Item item) {
		String where = "username='" + item.getName() + "'";
		if (item.getId() != null)
			where = "name='" + item.getId() + "'";
		ResultSet rs = findForResultSet("select * from tb_userlist where "
				+ where);
		TbJsr user = new TbJsr();
		try {
			if (rs.next()) {
				user.setName(rs.getString("name").trim());
				user.setSex(rs.getString("username").trim());
				user.setAge(rs.getString("pass").trim());
				user.setTel(rs.getString("quan").trim());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	// 验证登录
	public static boolean checkLogin(String userStr, String passStr)
			throws SQLException {
		ResultSet rs = findForResultSet("select * from tb_userlist where name='"
				+ userStr + "' and pass='" + passStr + "'");
		if (rs == null)
			return false;
		return rs.next();
	}

}