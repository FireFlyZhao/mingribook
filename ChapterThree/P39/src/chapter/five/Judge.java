package chapter.five;

public class Judge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String regex = "\\w+@+\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
		String str1 = "aaa@";
		String str2 = "aaaaaa";
		String str3 = "1111@111ffyu.dfg.com";
		if (str1.matches(regex)) {
			System.out.println(str1 + "��һ���Ϸ���E-mail��ַ��ʽ");
		}
		if (str2.matches(regex)) {
			System.out.println(str2 + "��һ���Ϸ���E-mail��ַ��ʽ");
		}
		if (str3.matches(regex)) {
			System.out.println(str3 + "��һ���Ϸ���E-mail��ַ��ʽ");
		}
	}

}
