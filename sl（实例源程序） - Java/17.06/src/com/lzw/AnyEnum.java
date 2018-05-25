package com.lzw;
import static java.lang.System.*;
interface d {
	public String getDescription();
	
	public int getI();
}

public enum AnyEnum implements d {
	Constants_A { // 可以在枚举类型成员内部设置方法
		public String getDescription() {
			return ("我是枚举成员A");
		}
		
		public int getI() {
			return i;
		}
	},
	Constants_B {
		public String getDescription() {
			return ("我是枚举成员B");
		}
		
		public int getI() {
			return i;
		}
	},
	Constants_C {
		public String getDescription() {
			return ("我是枚举成员C");
		}
		
		public int getI() {
			return i;
		}
	},
	Constants_D {
		public String getDescription() {
			return ("我是枚举成员D");
		}
		
		public int getI() {
			return i;
		}
	};
	private static int i = 5;
	
	public static void main(String[] args) {
		for (int i = 0; i < AnyEnum.values().length; i++) {
			out.println(AnyEnum.values()[i] + "调用getDescription()方法为："
					+ AnyEnum.values()[i].getDescription());
			out.println(AnyEnum.values()[i] + "调用getI()方法为："
					+ AnyEnum.values()[i].getI());
		}
	}
}
