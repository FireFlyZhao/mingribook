public class GetSum { // ������
	public static void main(String args[]) { // ������
		int x = 1; // ����int�ͱ���x����������ֵ
		int sum = 0; // ����������ڱ�����Ӻ�Ľ��
		while (x <= 10) {
			sum = sum + x; // whileѭ����䵱���������������ʽʱִ��ѭ�������
			x++;
		}
		System.out.println("sum = " + sum); // ������sum���
	}
}
