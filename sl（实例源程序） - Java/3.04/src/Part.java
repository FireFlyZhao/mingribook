public class Part { // �½���Part
	// ��������PI����ʱ�粻��PI���и�ֵ�������ִ�����ʾ
	static final double PI = 3.14;
	static int age = 23; // ����int�ͱ���age�����и�ֵ
	
	public static void main(String[] args) { // ������
		final int number; // ����int�ͳ���number
		number = 1235; // �Գ������и�ֵ
		age = 22; // �ٴζԱ������и�ֵ
		// number = 1236;
		// //����Ĵ��룬��ΪnumberΪ������ֻ�ܽ���һ�θ�ֵ
		System.out.println("����PI��ֵΪ��" + PI); // ��PI��ֵ���
		System.out.println("��ֵ��number��ֵΪ:" +number);//��number��ֵ���
		System.out.println("int�ͱ���age��ֵΪ��" + age); // ��age��ֵ���
	}
}
