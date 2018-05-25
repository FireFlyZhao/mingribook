package chapter.four;

public class Var_02 {

	public static void main(String[] args) {
		int lineCount = 17;
		
		int maxLineNum = (lineCount + 1) / 2;
		for (int i = 1; i <= maxLineNum; i++) {
			for (int space = 1;space <= maxLineNum - i;space++) {
				System.out.print("  ");
			}
			for (int star = 1;star <= (i*2) - 1;star++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		int declineCount = lineCount - maxLineNum;
		for (int i = 1; i <= declineCount; i++) {
			for (int space = 1;space <= i; space++) {
				System.out.print("  ");
			}
			for (int star = 1;star <= ((declineCount - i + 1)*2 - 1);star++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
	}

}
