package chapter.ten;

public abstract class UseCase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Atest();
	}
	
	abstract void testAbstract();
	
	UseCase1(){
		System.out.println("before testAbstract()");
		testAbstract();
		System.out.println("after testAbstarcat()");
	}
	
}

class Atest extends UseCase1{
	private int i = 1;

	@Override
	void testAbstract() {
		// TODO Auto-generated method stub
		System.out.println("testAbstract()"+i);
	}
	public Atest() {
		System.out.println(i);
	}
	
}
