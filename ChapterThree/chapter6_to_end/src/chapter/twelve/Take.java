package chapter.twelve;

public class Take {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String str = "lili";
			System.out.println(str + "������:");
			int age = Integer.parseInt(str);
			System.out.println(age);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("program over");
	}

}
