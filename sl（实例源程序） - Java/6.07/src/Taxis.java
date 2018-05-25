import java.util.*;

public class Taxis { // 创建类
	public static void main(String[] args) { // 主方法
		int arr[] = new int[] { 23, 42, 12, 8 }; // 声明数组
		Arrays.sort(arr); // 将数组进行排序
		for (int i = 0; i < arr.length; i++) { // 循环遍历排序后的数组
			System.out.println(arr[i]); // 将排序后数组中的各个元素输出
		}
	}
}
