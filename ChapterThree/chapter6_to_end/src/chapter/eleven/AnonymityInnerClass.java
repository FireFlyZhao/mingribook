package chapter.eleven;

public class AnonymityInnerClass {

}

interface OutInterfaceEX{
	
}

class OuterClass4{
	public OutInterfaceEX doit(final String s) {
		return new OutInterfaceEX() {
			private int i = 0;
			public int getValue() {
				System.out.println(s);
				return i;
			}
			public void f() {
				System.out.println("f()");
			}
		};
	}
}