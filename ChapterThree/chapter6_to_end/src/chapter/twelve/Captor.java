package chapter.twelve;

public class Captor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int result = quotient(3, -1);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println("除数不能为0");
		}catch (Exception e) {
			System.out.println("程序发生了其他的异常");
		}
	}
	
	static int quotient(int x, int y) throws MyException{
		if (y < 0) {
			throw new MyException("除数不能是负数");
		}
		return x / y;
	}
}
