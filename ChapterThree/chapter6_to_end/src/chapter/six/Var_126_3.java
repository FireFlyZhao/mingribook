package chapter.six;

import java.util.Arrays;

public class Var_126_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[] = new String[] { "ac", "bc", "dc", "yc" };
		System.out.println("Ìæ»»Ç°£º");
		for (String str : arr) {
			System.out.print(str+"\t");
		}
		Arrays.fill(arr, 2, 3, "bb");
		System.out.println("\nÌæ»»ºó£º");
		for (String str : arr) {
			System.out.print(str+"\t");
		}
	}

}
