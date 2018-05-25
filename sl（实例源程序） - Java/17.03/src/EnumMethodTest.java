import static java.lang.System.*;

public class EnumMethodTest {
	enum Constants2 { // 将常量放置在枚举类型中
		Constants_A, Constants_B
	}
	
	// 定义比较枚举类型方法，参数类型为枚举类型
	public static void compare(Constants2 c) {
		// 根据values()方法返回的数组做循环操作
		for (int i = 0; i < Constants2.values().length; i++) {
			// 将比较结果返回
			out.println(c + "与" + Constants2.values()[i] + "的比较结果为："
					+ c.compareTo(Constants2.values()[i]));
		}
	}
	
	// 在主方法中调用compare()方法
	public static void main(String[] args) {
		compare(Constants2.valueOf("Constants_B"));
	}
}
