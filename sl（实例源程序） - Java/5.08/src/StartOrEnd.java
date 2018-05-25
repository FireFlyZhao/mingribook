public class StartOrEnd { // 创建类
	public static void main(String args[]) { // 主方法
		String num1 = "22045612"; // 定义字符串num1
		String num2 = "21304578"; // 定义字符串num2
		boolean b = num1.startsWith("22"); // 判断字符串num1是否以'22'开头
		boolean b2 = num1.endsWith("78"); // 判断字符串num1是否以'78'结束
		boolean b3 = num2.startsWith("22"); // 判断字符串num2是否以'22'开头
		boolean b4 = num2.endsWith("78"); // 判断字符串num2是否以'78'结束
		System.out.println("字符串num1是以'22'开始的吗？" + b);
		System.out.println("字符串num1是以'78'结束的吗？" + b2); // 输出信息
		System.out.println("字符串num2是以'22'开始的吗？" + b3);
		System.out.println("字符串num2是以'78'结束的吗？" + b4);
	}
}
