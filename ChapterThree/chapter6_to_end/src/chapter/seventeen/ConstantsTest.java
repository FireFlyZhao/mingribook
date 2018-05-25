package chapter.seventeen;

public class ConstantsTest {
	enum Constants2{
		Constants_A,Constants_B
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstantsTest.doit(Constants.Constants_A);
		ConstantsTest.doit(Constants2.Constants_A);
		ConstantsTest.doit(Constants2.Constants_B);
		ConstantsTest.doit(3);
//		ConstantsTest.doit2(3);
	}
	
	public static void doit(int c) {
		switch (c) {
			case Constants.Constants_A:
				System.out.println("doit() Constants_A");
				break;
			case Constants.Constants_B:	
				System.out.println("doit() Constants_B");
				break;
		}
	}
	
	public static void doit(Constants2 c) {
		switch (c) {
			case Constants_A:
				System.out.println("doit2() Constants_A");
				break;
			case Constants_B:
				System.out.println("doit2() Constants_B");
				break;	
		}
	}
	
}

interface Constants{
	public static final int Constants_A = 1;
	public static final int Constants_B = 12;
}