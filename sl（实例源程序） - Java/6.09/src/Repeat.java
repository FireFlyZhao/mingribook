import java.util.*;

public class Repeat { // 创建类
	public static void main(String[] args) { // 主方法
		int arr[] = new int[] { 23, 42, 12, 84, 10 }; // 定义数组
		int newarr[] = Arrays.copyOfRange(arr, 0, 3); // 复制数组
		for (int i = 0; i < newarr.length; i++) { // 循环遍历复制后的新数组
			System.out.println(newarr[i]); // 将新数组中的每个元素输出
		}
	}
}
