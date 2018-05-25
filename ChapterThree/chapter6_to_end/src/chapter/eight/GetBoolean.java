package chapter.eight;

public class GetBoolean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Boolean b1 = new Boolean(true);
		Boolean b1 = new Boolean("true");
		Boolean b2 = new Boolean("ok");
		System.out.println("b1: " + b1.booleanValue());
		System.out.println("b2: " + b2.toString());
		Boolean b3 = Boolean.valueOf("true");
		System.out.println("b3:" + b3.booleanValue());
		Byte byte1 = Byte.parseByte("123");
		Byte byte2 = Byte.valueOf("123");
		byte byte3 = Byte.parseByte("123");
		byte byte4 = Byte.valueOf("123");
		System.out.println(byte1);
		System.out.println(byte2);
		System.out.println(byte3);
		System.out.println(byte4);
	}

}
