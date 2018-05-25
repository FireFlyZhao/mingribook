package chapter.four;

public class BreakInsideNested {

	public static void main(String[] args) {
		for(int i = 0;i < 3;i++) {
			for(int j = 0;j < 6;j++) {
				if(j == 4)
					break;
				System.out.println("i=" + i + " j=" + j);
			}
		}
	}

}
