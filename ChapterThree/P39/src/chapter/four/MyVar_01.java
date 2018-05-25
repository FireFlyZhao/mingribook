package chapter.four;

public class MyVar_01 {

	public static void main(String[] args) {
		int lineCount = 9;
		for (int i = 1; i <= lineCount; i++) {
			for (int space = 1; space <= lineCount - i; space++) {
				System.out.print("  ");
			}
			for (int star = 1; star <= (i * 2) - 1; star++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
