public class Eval { // �½���
	public static void main(String[] args) { // ������
		String regex = "1[35]\\d{9}";
		String text = "15000000000";
		if (text.matches(regex)) {
			System.out.println(text + "�ǺϷ����ֻ���");
		}
	}
}