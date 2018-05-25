package chapter.sixteen;

import java.lang.reflect.Array;

public class Answer_1606 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test = new Test();
		Object o1 = new Object();
		Object[] o = {o1, o1, o1};
		Class oC = o.getClass().getComponentType();
		test.is.getClass();
		test.print();
		test.is = (int[])addArrayLength(test.is, 10);
		test.ss = (String[]) addArrayLength(test.ss, 10);
		
		test.print();
	}

	public static Object addArrayLength(Object array, int newLength) {
		Object newArray = null;
		Class get = array.getClass();
		get = get.getComponentType();
		Class componentType = array.getClass().getComponentType();
		newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(array, 0, newArray, 0, Array.getLength(array));
		return newArray;
	}
}

class Test{
	public int[] is = {1, 2, 3};
	public int i = 0;
	public String[] ss = {"A", "B", "C"};
	public void print() {
		
		for (int index = 0; index < is.length; index++) {
			System.out.println("is[" + index + "]=" + is[index]);
		}
		System.out.println();
		
		for (int index = 0; index < ss.length; index++) {
			System.out.println("ss[" + index + "]=" + ss[index]);
		}
		System.out.println();
	}
}