import java.util.*;

public class Swap { // 创建类
	public static void main(String[] args) { // 主方法
		int arr[] = new int[5]; // 创建int型数组
		Arrays.fill(arr, 8); // 使用同一个值对数组进行填充
		for (int i = 0; i < arr.length; i++) { // 循环遍历数组中的元素
			// 将数组中的元素依次输出
			System.out.println("第" + i + "个元素是：" + arr[i]);
		}
	}
}
