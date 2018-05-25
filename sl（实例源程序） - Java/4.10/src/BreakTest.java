public class BreakTest {
	public static void main(String[] args) {
		for (int i = 0; i <= 100; i++) {
			System.out.println(i);
			if (i == 6) {//如果i等于6则跳出循环
				break;
			}
		}
		System.out.println("---end---");//显示程序结束
	}
}