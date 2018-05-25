package com.lzw;

interface OutInterface { // 定义一个接口
	public void f();
}

public class InterfaceInner {
	public static void main(String args[]) {
		OuterClass2 out = new OuterClass2(); // 实例化一个OuterClass2对象
		// 调用doit()方法，返回一个OutInterface接口
		OutInterface outinter = out.doit();
		outinter.f(); // 调用f()方法
	}
}

class OuterClass2 {
	// 定义一个内部类实现OutInterface接口
	private class InnerClass implements OutInterface {
		InnerClass(String s) { // 内部类构造方法
			System.out.println(s);
		}
		
		public void f() { // 实现接口中的f()方法
			System.out.println("访问内部类中的f()方法");
		}
	}
	
	public OutInterface doit() { // 定义一个方法，返回值类型为OutInterface接口
		return new InnerClass("访问内部类构造方法");
	}
}
