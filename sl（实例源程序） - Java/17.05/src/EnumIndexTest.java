import static java.lang.System.*;

public class EnumIndexTest {
	enum Constants2 { // 将常量放置在枚举类型中
		Constants_A("我是枚举成员A"), // 定义带参数的枚举类型成员
		Constants_B("我是枚举成员B"), Constants_C("我是枚举成员C"), Constants_D(3);
		private String description;
		private int i = 4;
		
		private Constants2() {
		}
		 // 定义参数为String型的构造方法
		private Constants2(String description) {
			this.description = description;
		}
		
		private Constants2(int i) { // 定义参数为整型的构造方法
			this.i = this.i + i;
		}
		
		public String getDescription() { // 获取description的值
			return description;
		}
		
		public int getI() { // 获取i的值
			return i;
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < Constants2.values().length; i++) {
			out.println(Constants2.values()[i] + "调用getDescription()方法为："
					+ Constants2.values()[i].getDescription());
		}
		out.println(Constants2.valueOf("Constants_D") + "调用getI()方法为："
				+ Constants2.valueOf("Constants_D").getI());
	}
}
