package chapter.four;

public class BreakTest {

	public static void main(String[] args) {
		for(int i = 0;i <= 100;i++) {
			System.out.println(i);
			if(i == 6)
				break;
		}
		System.out.println("---end---");
	}

}
