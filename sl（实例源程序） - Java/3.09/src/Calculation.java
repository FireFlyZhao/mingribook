public class Calculation { // ������
	public static void main(String[] args) {
		int a = 2; // ����int�ͱ���a
		int b = 5; // ����int�ͱ���b
		// ���������ͱ��������ڱ���Ӧ���߼��������&&����ķ���ֵ
		boolean result = ((a > b) && (a != b));
		// ���������ͱ��������ڱ���Ӧ���߼��������||����ķ���ֵ
		boolean result2 = ((a > b) || (a != b));
		System.out.println(result); // ������result���
		System.out.println(result2); // ������result2���
	}
}
