public class UpAndLower { // 创建类
	public static void main(String args[]) { // 主方法
		String str = new String("abc DEF"); // 创建的字符串str
		String newstr = str.toLowerCase(); //使用toLowerCase()方法实行小写转换
		String newstr2 = str.toUpperCase();//使用toUpperCase()方法实行大写转换
		System.out.println(newstr);// 将转换后的结果输出
		System.out.println(newstr2);
	}
}
