public class General { // �½���
	public static void main(String[] args) { // ������
		String str = String.format("%d", 400 / 2); // �������ʮ������ʾ
		String str2 = String.format("%b", 3 > 5); // ������Բ�����ʽ��ʾ
		String str3 = String.format("%x", 200); // �������ʮ���Ƹ�ʽ��ʾ
		System.out.println("400��һ���ǣ�" + str); // �����ʽ���ַ���
		System.out.println("3>5��ȷ��" + str2);
		System.out.println("200��ʮ���������ǣ�" + str3);
	}
}
