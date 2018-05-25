package chapter.five;

public class Val_105_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String("We are students");
		String str2 = new String("I like Java");
		String newstr = str.substring(1,3);
		String newstr2 = str2.substring(1,3);
		System.out.println(newstr);
		System.out.println(newstr2);
		if (newstr.equalsIgnoreCase(newstr2)) {
			System.out.println("两个字符相同");
		}else {
			System.out.println("两个字符不相同");
		}
			
	}

}
