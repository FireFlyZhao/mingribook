package chapter.ten;

public class UseCase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UseCase2 u = new sub();
		u.doSomething();
		u.doAnything();
	}

	public void doSomething() {
		System.out.println("����.doSomething()");
	}
	
	public void doAnything() {
		System.out.println("����.doSomething()");
	}
	
}

class sub extends UseCase2{
	public void doAnything() {
		System.out.println("����.doAnything()");
	}
}