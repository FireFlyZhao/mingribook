package chapter.nine;

public class MathRondom {
	
	public static int GetEvenNum(double num1, double num2) {
		int s = (int)num1 + (int)(Math.random()*(num2-num1));
		if (s % 2 == 0) {
			return s;
		}else {
			return s + 1;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("����һ��2~32֮���ż����" + GetEvenNum(2, 32));
	}

}
