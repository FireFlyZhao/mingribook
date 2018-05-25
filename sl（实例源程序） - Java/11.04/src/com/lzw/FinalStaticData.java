package com.lzw;

import static java.lang.System.*;

import java.util.*;

public class FinalStaticData {
	private static Random rand = new Random(); // 实例化一个Random类对象
	// 随机产生0~10之间的随机数赋予定义为final的a1
	private final int a1 = rand.nextInt(10);
	// 随机产生0~10之间的随机数赋予定义为static final的a2
	private static final int a2 = rand.nextInt(10);
	
	public static void main(String[] args) {
		FinalStaticData fdata = new FinalStaticData(); // 实例化一个对象
		// 调用定义为final的a1
		out.println("重新实例化对象调用a1的值：" + fdata.a1);
		// 调用定义为static final的a2
		out.println("重新实例化对象调用a1的值：" + fdata.a2);
		// 实例化另外一个对象
		FinalStaticData fdata2 = new FinalStaticData();
		out.println("重新实例化对象调用a1的值：" + fdata2.a1);
		out.println("重新实例化对象调用a2的值：" + fdata2.a2);
	}
}
