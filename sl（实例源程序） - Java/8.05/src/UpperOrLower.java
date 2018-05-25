public class UpperOrLower { // 创建类UpperOrLower
	public static void main(String args[]) { // 主方法
		Character mychar1 = new Character('A'); // 声明Character对象
		Character mychar2 = new Character('a'); // 声明Character对象
		System.out.println(mychar1 + "是大写字母吗? "
				+ Character.isUpperCase(mychar1));
		System.out.println(mychar2 + "是小写字母吗? "
				+ Character.isLowerCase(mychar2));
	}
}
