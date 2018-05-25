public class Arith { // 创建类
	public static void main(String[] args) { // 主方法
		float number1 = 45.56f; // 声明float型变量并赋值
		int number2 = 152; // 声明int型变量并赋值
		System.out.println("和为：" + number1 + number2); // 将变量相加之和输出
		System.out.println("差为：" + (number2-number1));//将变量相减之差输出
		System.out.println("积为：" + number1 * number2); // 将变量相乘的积输出
		System.out.println("商为：" + number1 / number2); // 将变量相除的商输出
	}
}
