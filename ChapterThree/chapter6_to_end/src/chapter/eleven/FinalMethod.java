package chapter.eleven;

public class FinalMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sub s = new Sub();
		s.doit();
		Parent p = s;
//		p.doit();
		p.doit2();
		p.doit3();
	}

}

class Parent{
	private final void doit() {
		System.out.println("����.doit()");
	}
	
	final void doit2() {
		System.out.println("����.doit2()");
	}
	
	public void doit3() {
		System.out.println("����.doit3()");
	}
}

class Sub extends Parent{
	public final void doit() {
		System.out.println("����.doit()");
	}
//	final void doit2() {
//		
//	}
	public void doit3() {
		System.out.println("����.doit3()");
	}
}