public class Summation { // ������Summation
	public static void main(String args[]) { // ������
		String str[] = { "89", "12", "10", "18", "35" }; // ����String����
		int sum = 0; // ����int�ͱ���sum
		for (int i = 0; i < str.length; i++) { // ѭ����������
		   int myint=Integer.parseInt(str[i]);//�������е�ÿ��Ԫ�ض�ת��Ϊint��
			sum = sum + myint; // �������еĸ�Ԫ�����
		}
		System.out.println("�����еĸ�Ԫ��֮���ǣ�" + sum); // ������������
	}
}
