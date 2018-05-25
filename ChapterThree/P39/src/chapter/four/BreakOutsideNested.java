package chapter.four;

public class BreakOutsideNested {

	public static void main(String[] args) {
		int sum = 0;
		tagwhile:while (true) {
			Loop: for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 6; j++) {
					if (sum > 20)
						break tagwhile;
					if (j == 4)
						break Loop;
					System.out.println("i=" + i + " j=" + j);
					sum++;
					
				}
			}
		System.out.println("---5----");
		}
	}

}
