public class Summation { // 创建类Summation
	public static void main(String args[]) { // 主方法
		String str[] = { "89", "12", "10", "18", "35" }; // 定义String数组
		int sum = 0; // 定义int型变量sum
		for (int i = 0; i < str.length; i++) { // 循环遍历数组
		   int myint=Integer.parseInt(str[i]);//将数组中的每个元素都转换为int型
			sum = sum + myint; // 将数组中的各元素相加
		}
		System.out.println("数组中的各元素之和是：" + sum); // 将计算后结果输出
	}
}
