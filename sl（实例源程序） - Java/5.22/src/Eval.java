public class Eval { // �½���
	public static void main(String[] args) { // ������
		StringBuilder builder = new StringBuilder("a");
		for (int i = 1; i <= 10; i++) {
			builder.append(i);
		}
		System.out.println(builder.toString());
	}
}