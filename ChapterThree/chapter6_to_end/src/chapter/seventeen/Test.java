package chapter.seventeen;

public class Test {
	private Object b;
	
	
	public Object getB() {
		return b;
	}


	public void setB(Object b) {
		this.b = b;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		t.setB(new Boolean(true));
		System.out.println(t.getB());
		t.setB(new Float(12.3));
		Float f = (Float) t.getB();
//		Integer i = (Integer) t.getB();
		System.out.println(f);
	}

}
