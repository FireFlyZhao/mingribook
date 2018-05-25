package chapter.eleven;

public class OutClass3 {
	public OutInterface2 doit(final String x) {
		class InnerClass2 implements OutInterface2{
			InnerClass2(String s){
				s = x;
				System.out.println(s);
			}
		}
		return new InnerClass2("doit");
	}
}

interface OutInterface2{
	
}