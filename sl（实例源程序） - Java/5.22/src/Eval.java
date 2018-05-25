public class Eval { // 新建类
	public static void main(String[] args) { // 主方法
		StringBuilder builder = new StringBuilder("a");
		for (int i = 1; i <= 10; i++) {
			builder.append(i);
		}
		System.out.println(builder.toString());
	}
}