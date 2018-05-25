package chapter.twelve;

public class Shoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			pop();
		} catch (NegativeArraySizeException e) {
			System.out.println("pop()方法抛出的异常");
		}
	}

	static void pop() throws NegativeArraySizeException{
		int[] arr = new int[-3];
	}
}
