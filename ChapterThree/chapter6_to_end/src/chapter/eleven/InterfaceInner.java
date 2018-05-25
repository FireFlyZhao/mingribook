package chapter.eleven;

public class InterfaceInner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterClass2 out = new OuterClass2();
		OutInterface outinter = out.doit();
		outinter.f();
	}

}

interface OutInterface{
	public void f();
}

class OuterClass2{
	private class InnerClass implements OutInterface{
		
		InnerClass(String s){
			System.out.println(s);
		}
		
		@Override
		public void f() {
			// TODO Auto-generated method stub
			System.out.println("访问内部类中的f()方法");
		}
		
	}
	
	public OutInterface doit() {
		return new InnerClass("访问内部类构造方法");
	}
}