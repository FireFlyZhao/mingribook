package chapter.six;

import java.util.Arrays;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ia[] = new int[] {1,3,8,9,4,5};
		Arrays.sort(ia);
		int index = Arrays.binarySearch(ia, 10);
		System.out.println(index);
		System.out.println(ia.length);
	}

}
