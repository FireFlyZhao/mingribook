package chapter.ten;

class V{
	
}

public class OverWriteEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "123";
		String s2 = "123";
		System.out.println(s1.equals(s2));
		V v1 = new V();
		V v2 = new V();
		System.out.println(v1.equals(v2));
		String s3 = new String("123");
		System.out.println(s1.equals(s3));
	}

}
