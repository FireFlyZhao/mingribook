package com.wgh;

public class StringDeal {
	public static String shiftEnter(String str) { // 定义公用的静态方法
		String newStr = str.replaceAll("\r\n", "<br>"); // 替换回车换行符
		newStr = newStr.replaceAll(" ", "&nbsp;");// 替换空格符
		return newStr;
	}
}
