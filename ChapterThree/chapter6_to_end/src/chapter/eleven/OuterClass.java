package chapter.eleven;

public class OuterClass {
	
	innerClass in = new innerClass();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterClass out = new OuterClass();
		OuterClass.innerClass in = out.doit();
		OuterClass.innerClass in2 = out.new innerClass();
	}
	
	public void outf() {
		in.inf();
	}
	
	class innerClass{
		
		int y = 0;
		
		innerClass(){
			
		}
		public void inf() {
			
		}
	}
	
	public innerClass doit() {
		in.y = 4;
		return new innerClass();
	}
}
