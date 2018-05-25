package com.lzw;

import java.util.*;

public class UseCase3<T> {
	public void doSomething(UseCase3<? extends List<Object>> a) {
		System.out.println(a.getClass().getName());
	}
	
	public static void main(String[] args) {
		// TODO 自动生成方法存根
		UseCase3<? extends List<Object>> a = new UseCase3<ArrayList<Object>>();
		a.doSomething(new UseCase3<ArrayList<Object>>());
		a.doSomething(new UseCase3<LinkedList<Object>>());
		UseCase3<? super List<Object>> a2 = null;
		a2 = new UseCase3<Object>();
	}
}