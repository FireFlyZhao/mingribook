package chapter.eight;

public class Charac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = Integer.toString(456);
		String str2 = Integer.toBinaryString(456);
		String str3 = Integer.toHexString(456);
		String str4 = Integer.toOctalString(456);
		System.out.println("'456'的十进制表示为：" + str);
		System.out.println("'456'的二进制表示为：" + str2);
		System.out.println("'456'的十六进制表示为：" + str3);
		System.out.println("'456'的八进制表示为：" + str4);
	}

}
