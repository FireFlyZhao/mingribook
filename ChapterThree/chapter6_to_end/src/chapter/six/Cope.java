package chapter.six;

import java.util.Arrays;

public class Cope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {23,42,12};
		int newarr[] = Arrays.copyOf(arr, 5);
		for (int i = 0; i < newarr.length; i++) {
			System.out.println(newarr[i]);
		}
	}

}
