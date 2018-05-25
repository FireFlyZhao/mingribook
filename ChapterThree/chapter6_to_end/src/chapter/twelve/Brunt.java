package chapter.twelve;

public class Brunt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu = new Student();
		try {
			stu.speak(1500);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("*************");
			System.out.println(e.getMessage());
		}
		System.out.println("*************");
		try {
			int result = count(12315,57876876);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static int count(int m, int n) {
		return m * n;
	}
}
