package chapter.six;

import java.util.Arrays;

public class var_126_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1,2,3,4,5};
		int[] arr2 = Arrays.copyOf(arr, 3);
		for (int i : arr)
			System.out.print(i);
		System.out.println();
		for (int i : arr2)
			System.out.print(i);
		System.out.println();
	}

}
