import java.util.*;

public class Displace { // 创建类
	public static void main(String[] args) { // 主方法
		int arr[] = new int[] { 45, 12, 2, 10 }; // 定义并初始化int型数组arr
		Arrays.fill(arr, 1, 2, 8); // 使用fill方法对数组进行初始化
		for (int i = 0; i < arr.length; i++) { // 循环遍历数组中元素
			// 将数组中的每个元素输出
			System.out.println("第" + i + "个元素是：" + arr[i]);
		}
	}
}
