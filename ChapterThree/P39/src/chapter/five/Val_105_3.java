package chapter.five;

public class Val_105_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String regex = "1[34578]\\d{9}";
		String text = "13680569905";
		if (text.matches(regex)) {
			System.out.println(text + "是合法的手机号");
		}
		StringBuilder builder = new StringBuilder("a");
		for (int i = 1; i <= 10;i++) {
			builder.append(i);
		}
		System.out.println(builder.toString());
	}

}
