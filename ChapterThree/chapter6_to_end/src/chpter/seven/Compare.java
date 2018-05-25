package chpter.seven;

public class Compare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String c1 = new String("abc");
		String c2 = new String("abc");
//		String c1,c2;
//		c1 = "abc";
//		c2 = "abc";
		String c3 = c1;
		System.out.println("c2==c3的运算结果为：" + (c2 == c3));
		System.out.println("c2.equals(c3)的运算结果为：" + (c2.equals(c3)));
	}

}
