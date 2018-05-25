import java.util.*;

public class Text { // 创建类
	public static void main(String[] args) {
		String arr[] = new String[] { "ac", "bc", "dc", "yc" };
		System.out.println("替换前：");
		for (String str : arr) {
			System.out.print(str+"\t");
		}
		Arrays.fill(arr, 2, 3, "bb");
		System.out.println("\n替换后：");
		for (String str2 : arr) {
			System.out.print(str2+"\t");
		}
	}
}
