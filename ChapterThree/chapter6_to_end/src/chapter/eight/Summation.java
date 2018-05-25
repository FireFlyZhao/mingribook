package chapter.eight;

public class Summation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = new String[] {"89", "12", "10", "18", "35" };
		int sum = 0;
		for (String strF : str) {
			int myint = Integer.parseInt(strF);
			sum = sum + myint;
		}
		System.out.println("数组中的各元素之和是：" + sum); 
	}

}
