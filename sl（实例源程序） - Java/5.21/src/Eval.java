public class Eval { // 新建类
	public static void main(String[] args) { // 主方法
		String regex = "1[35]\\d{9}";
		String text = "15000000000";
		if (text.matches(regex)) {
			System.out.println(text + "是合法的手机号");
		}
	}
}