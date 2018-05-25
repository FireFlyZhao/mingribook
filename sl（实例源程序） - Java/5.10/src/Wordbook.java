public class Wordbook { // 创建类
	public static void main(String args[]) { // 主方法
		String str = new String("b");
		String str2 = new String("a"); // 用于比较的3个字符串
		String str3 = new String("c");
		System.out.println(str + " compareTo " + str2 + ":"
				+ str.compareTo(str2)); // 将str与str2比较的结果输出
		System.out.println(str + " compareTo " + str3 + ":"
				+ str.compareTo(str3)); // 将str与str3比较的结果输出
	}
}
