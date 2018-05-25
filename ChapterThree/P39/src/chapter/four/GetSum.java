package chapter.four;

public class GetSum {

	public static void main(String[] args) {
		int x = 1;
		int sum = 0;
		while(x <= 10) {
			sum = sum + x;
			x++;
		}
		System.out.println("sum=" + sum);
	}

}
