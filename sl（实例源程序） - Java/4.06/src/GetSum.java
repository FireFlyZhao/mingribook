public class GetSum { // 创建类
	public static void main(String args[]) { // 主方法
		int x = 1; // 定义int型变量x，并赋给初值
		int sum = 0; // 定义变量用于保存相加后的结果
		while (x <= 10) {
			sum = sum + x; // while循环语句当变量满足条件表达式时执行循环体语句
			x++;
		}
		System.out.println("sum = " + sum); // 将变量sum输出
	}
}
