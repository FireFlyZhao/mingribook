class V { // �Զ�����V
}

public class OverWriteEquals {
	public static void main(String[] args) {
		String s1 = "123"; // ʵ������������������ͬ
		String s2 = "123";
		System.out.println(s1.equals(s2)); // ʹ��equals()��������
		V v1 = new V(); // ʵ��������V�����
		V v2 = new V();
		System.out.println(v1.equals(v2)); // ʹ��equals()�����Ƚ�v1��v2����
	}
}
