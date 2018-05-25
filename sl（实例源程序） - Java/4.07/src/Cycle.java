public class Cycle {
	public static void main(String args[]) {
		int a = 100; // 声明int型变量a并赋初值100
		while (a == 60) // 指定进入循环体条件
		{
			System.out.println("ok1"); // while语句循环体
			a--;
		}
		int b = 100; // 声明int型变量b并赋初值100
		do {
			System.out.println("ok2"); // do…while语句循环体
			b--;
		} while (b == 60); // 指定循环结束条件
	}
}
