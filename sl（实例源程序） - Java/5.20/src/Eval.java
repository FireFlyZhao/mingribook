public class Eval { // 新建类
	public static void main(String[] args) { // 主方法
		String str = new String("We are students");
		String str2 = new String("I like Java");
		String newstr = str.substring(1,3);
		String newstr2 = str2.substring(1,3);
		if(newstr.equalsIgnoreCase(newstr2)){
			System.out.println("两个字符相同");
		}
		else{
			System.out.println("两个字符不相同");
		}
		}
}
