package com.lzw;

public abstract class UseCase1 {
	abstract void testAbstract();
	UseCase1(){//（1）首先执行父类构造方法
		System.out.println("before testAbstract()");
		testAbstract();//如果调用了抽象方法，调用子类覆盖的方法。这里调用Atest类的testAbstract（）方法
		System.out.println("after testAbstarcat()");
	}
	public static void main(String args[]){
		new Atest();
	}
}
class Atest extends UseCase1{
	private int i=1;//（2）使成员变量进行初始化
	void testAbstract(){
		System.out.println("testAbstract()"+i);
	}
	public Atest(){//（3）调用子类构造方法
		System.out.println(i);
	}
}
