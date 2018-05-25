package com.lzw;

import java.text.*;

public class RoundArea {
	static public void SimpleFormat(String pattern, double value) {	//使用实例化对象时设置格式化模式
		DecimalFormat myFormat = new DecimalFormat(pattern);	//实例化DecimalFormat对象
		String output = myFormat.format(value);				//将数字进行格式化
		System.out.println(value + " " + pattern + " " + output);
	} 
	public static double GetRoundArea(double r){
		return Math.PI*Math.pow(r, 2);
	}
	public static void main(String[] args) {
		System.out.print("圆的面积为：");
		SimpleFormat("#.#####",GetRoundArea(2));
	}

}
