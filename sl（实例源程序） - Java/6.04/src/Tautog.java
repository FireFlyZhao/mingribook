public class Tautog { // 创建类
	public static void main(String[] args) { // 主方法
		int arr2[][] = { { 4, 3 }, { 1, 2 } }; // 定义二维数组
		System.out.println("数组中的元素是："); // 提示信息
		int i = 0;// 外层循环计数器变量
		for (int x[] : arr2) { // 外层循环变量为一维数组
			i++;// 外层计数器递增
			int j = 0;// 内层循环计数器
			for (int e : x) { // 循环遍历每一个数组元素
				j++;// 内层计数器递增
				if (i == arr2.length && j == x.length) { // 判断变量是二维数组中的最后一个元素
					System.out.print(e); // 输出二维数组的最后一个元素
				} else
					// 如果不是二维数组中的最后一个元素
					System.out.print(e + "、"); // 输出信息
			}
		}
	}
}
