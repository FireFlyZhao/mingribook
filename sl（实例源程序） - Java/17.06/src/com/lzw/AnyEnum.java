package com.lzw;
import static java.lang.System.*;
interface d {
	public String getDescription();
	
	public int getI();
}

public enum AnyEnum implements d {
	Constants_A { // ������ö�����ͳ�Ա�ڲ����÷���
		public String getDescription() {
			return ("����ö�ٳ�ԱA");
		}
		
		public int getI() {
			return i;
		}
	},
	Constants_B {
		public String getDescription() {
			return ("����ö�ٳ�ԱB");
		}
		
		public int getI() {
			return i;
		}
	},
	Constants_C {
		public String getDescription() {
			return ("����ö�ٳ�ԱC");
		}
		
		public int getI() {
			return i;
		}
	},
	Constants_D {
		public String getDescription() {
			return ("����ö�ٳ�ԱD");
		}
		
		public int getI() {
			return i;
		}
	};
	private static int i = 5;
	
	public static void main(String[] args) {
		for (int i = 0; i < AnyEnum.values().length; i++) {
			out.println(AnyEnum.values()[i] + "����getDescription()����Ϊ��"
					+ AnyEnum.values()[i].getDescription());
			out.println(AnyEnum.values()[i] + "����getI()����Ϊ��"
					+ AnyEnum.values()[i].getI());
		}
	}
}
