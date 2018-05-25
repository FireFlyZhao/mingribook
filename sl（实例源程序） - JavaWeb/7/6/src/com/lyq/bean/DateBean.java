package com.lyq.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 获取当前时间的JavaBean
 * @author Li YongQiang
 * 
 */
public class DateBean {
	// 日期及时间
	private String dateTime;
	// 星期
	private String week;
	// Calendar对象
	private Calendar calendar = Calendar.getInstance();
	/**
	 * 获取当前日期及时间
	 * @return 日期及时间的字符串
	 */
	public String getDateTime() {
		// 获取当前时间
		Date currDate = Calendar.getInstance().getTime();
		// 实例化SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日　HH点mm分ss秒");
		// 格式化日期时间
		dateTime = sdf.format(currDate);
		// 返回日期及时间的字符串
		return dateTime;
	}
	/**
	 * 获取星期几
	 * @return 返回星期字符串
	 */
	public String getWeek() {
		// 定义数组
		String[] weeks = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		// 获取一星期的某天
		int index = calendar.get(Calendar.DAY_OF_WEEK);
		// 获取星期几
		week = weeks[index - 1];
		// 返回星期字符串
		return week;
	}
}
