public class GetTerm { // 创建主类
	public static void main(String args[]) { // 主方法
		int x = 20; // 声明int型局部变量
		if (x > 30) { // 判断变量x是否大于30
			System.out.println("a的值大于30"); // 条件成立的输出信息
		} else if (x > 10) { // 判断变量x是否大于10
			System.out.println("a的值大于10，但小于30"); // 条件成立的输出信息
		} else if (x > 0) { // 判断变量x是否大于0
			System.out.println("a的值大于0，但小于10"); // 条件成立的输出信息
		} else { // 当以上条件都不成立时，执行的语句块
			System.out.println("a的值小于0"); // 输出信息
		}
	}
}
