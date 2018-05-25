package chapter.seventeen;

import java.util.*;

public class UseCase3<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UseCase3<? extends List<Object>> a =
				new UseCase3<ArrayList<Object>>();
		a.doSomething(new UseCase3<ArrayList<Object>>());
		a.doSomething(new UseCase3<LinkedList<Object>>());
		UseCase3<? super List<Object>> a2 = null;
		a2 = new UseCase3<Object>();
		UseCase3 u = new UseCase3();
		u.doSomething(new UseCase3<ArrayList<Object>>());
	}
	
	public void doSomething(UseCase3<? extends List<Object>> a) {
		System.out.println(a.getClass().getName());
		System.out.println(a.getClass());
	}
}
