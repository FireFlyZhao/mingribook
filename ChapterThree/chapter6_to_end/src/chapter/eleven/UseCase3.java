package chapter.eleven;

public class UseCase3 {
	static class innerClass {
		void f() {
			System.out.println("f()");
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UseCase3.innerClass i = new UseCase3.innerClass();
		i.f();
	}

}
