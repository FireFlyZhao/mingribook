import static java.lang.System.*;

public class EnumIndexTest {
	enum Constants2 { // 将常量放置在枚举类型中
		Constants_A, Constants_B, Constants_C
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < Constants2.values().length; i++) {
			// 在循环中获取枚举类型成员的索引位置
			out.println(Constants2.values()[i] + "在枚举类型中位置索引值"
					+ Constants2.values()[i].ordinal());
		}
	}
}
