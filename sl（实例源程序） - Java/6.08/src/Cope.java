import java.util.*;

public class Cope { // 创建类
	public static void main(String[] args) { // 主方法
		int arr[] = new int[] { 23, 42, 12, }; // 定义数组
		int newarr[] = Arrays.copyOf(arr, 5); // 复制数组arr
		for (int i = 0; i < newarr.length; i++) { // 循环变量复制后的新数组
			System.out.println(newarr[i]); // 将新数组输出
		}
	}
}
