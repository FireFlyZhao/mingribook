package chapter.four;

public class Var_03 {

	public static void main(String[] args) {
		double sum = 0,a = 1;
		int i = 1;
		while (i <= 20) {
			a = a*(1.0/i);
			sum = sum + a;
			i++;
		}
		System.out.println(sum);
	}

}
