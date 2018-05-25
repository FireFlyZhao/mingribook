import java.util.*;

public class DateAndTime { // 创建类
	public static void main(String[] args) { // 主方法
		Date date = new Date(); // 创建Date对象date
		String time = String.format("%tc", date); // 将date格式化
		String form = String.format("%tF", date);
		 // 将格式化后的日期时间输出
		System.out.println("全部的时间信息是：" + time);
		System.out.println("年-月-日格式：" + form);
	}
}
