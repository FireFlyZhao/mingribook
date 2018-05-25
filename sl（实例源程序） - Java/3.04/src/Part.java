public class Part { // 新建类Part
	// 声明常量PI，此时如不对PI进行赋值，则会出现错误提示
	static final double PI = 3.14;
	static int age = 23; // 声明int型变量age并进行赋值
	
	public static void main(String[] args) { // 主方法
		final int number; // 声明int型常量number
		number = 1235; // 对常量进行赋值
		age = 22; // 再次对变量进行赋值
		// number = 1236;
		// //错误的代码，因为number为常量，只能进行一次赋值
		System.out.println("常量PI的值为：" + PI); // 将PI的值输出
		System.out.println("赋值后number的值为:" +number);//将number的值输出
		System.out.println("int型变量age的值为：" + age); // 将age的值输出
	}
}
