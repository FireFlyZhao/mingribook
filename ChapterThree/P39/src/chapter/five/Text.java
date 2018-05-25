package chapter.five;

public class Text {

	public static void main(String[] args) {
		String str = "We are students"; 
		int size = str.lastIndexOf("");
		System.out.println("空格在字符串str中的索引位置是：" + size);
		System.out.println("字符串str的长度是：" + str.length());
		System.out.println(str.lastIndexOf("ts"));
	}

}
