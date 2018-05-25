public class Text { 							//创建类
	public static void main(String args[]) { 		//主方法
		String str = "We are students"; 			//定义字符串str
		//将空格在str中的索引位置赋值给变量size
		int size = str.lastIndexOf(" ");
		//将变量size输出
		System.out.println("空格在字符串str中的索引位置是：" + size);
		//将字符串str的长度输出
		System.out.println("字符串str的长度是：" + str.length());
	}
}
