public class Charac { // ������Charac
	public static void main(String args[]) { // ������
		String str = Integer.toString(456); // ��ȡ���ֵ�ʮ���Ʊ�ʾ
		String str2 = Integer.toBinaryString(456); // ��ȡ���ֵĶ����Ʊ�ʾ
		String str3 = Integer.toHexString(456); // ��ȡ���ֵ�ʮ�����Ʊ�ʾ
		String str4 = Integer.toOctalString(456); // ��ȡ���ֵİ˽��Ʊ�ʾ
		System.out.println("'456'��ʮ���Ʊ�ʾΪ��" + str);
		System.out.println("'456'�Ķ����Ʊ�ʾΪ��" + str2);
		System.out.println("'456'��ʮ�����Ʊ�ʾΪ��" + str3);
		System.out.println("'456'�İ˽��Ʊ�ʾΪ��" + str4);
	}
}
