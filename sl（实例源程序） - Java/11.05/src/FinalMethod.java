class Parents {
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

class Sub extends Parents {
	public final void doit() { // �������ж���һ��doit()����
		System.out.print("����.doit()");
	}
//	final void doit2(){		//final�������ܸ���
//		System.out.println("����.doit2()");
//	}
	public void doit3() {
		System.out.println("����.doit3()");
	}
}

public class FinalMethod {
	public static void main(String[] args) {
		Sub s = new Sub(); // ʵ����
		s.doit(); // ����doit()����
		Parents p = s; // ִ������ת�Ͳ���
		// p.doit(); //���ܵ���private����
		p.doit2();
		p.doit3();
	}
}
