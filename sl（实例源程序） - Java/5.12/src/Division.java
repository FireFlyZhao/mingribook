public class Division{
	public static void main(String[] args) {
		// �����ַ���
		String str = "192.168.0.1";
		// ����"."���зָ�
		String[] firstArray = str.split("\\.");
		// ����"."�������ηָ�
		String[] secondArray = str.split("\\.", 2);
		// ���strԭֵ
		System.out.println("str��ԭֵΪ��[" + str + "]");
		// ���ȫ���ָ�Ľ��
		System.out.print("ȫ���ָ�Ľ����");
		for (String a : firstArray) {
			System.out.print("[" + a + "]");
		}
		System.out.println();// ����
		// ����ָ����εĽ��
		System.out.print("�ָ����εĽ����");
		for (String a : secondArray) {
			System.out.print("[" + a + "]");
		}
		System.out.println();
	}
}
