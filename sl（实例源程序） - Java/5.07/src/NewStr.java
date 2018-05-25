public class NewStr { // 创建类
	public static void main(String args[]) { // 主方法
		String str = "address"; // 定义字符串str
		 // 字符串str中的字符"a"替换成"A"后返回的新字符串newstr
		String newstr = str.replace("a", "A");
		System.out.println(newstr); // 将字符串newstr输出
	}
}
