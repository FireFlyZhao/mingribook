package com.lzw;

public class UseCase2 {
	public void doSomething(){
		System.out.println("����.doSomething()");
	}
	public void doAnything(){
		System.out.println("����.doAnything()");
	}
	public static void main(String args[]){
		UseCase2 u=new sub();
		u.doSomething();
		u.doAnything();
	}
}
class sub extends UseCase2{
	public void doAnything(){
		System.out.println("����.doAnything()");
	}
}
