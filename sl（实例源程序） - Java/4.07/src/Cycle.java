public class Cycle {
	public static void main(String args[]) {
		int a = 100; // ����int�ͱ���a������ֵ100
		while (a == 60) // ָ������ѭ��������
		{
			System.out.println("ok1"); // while���ѭ����
			a--;
		}
		int b = 100; // ����int�ͱ���b������ֵ100
		do {
			System.out.println("ok2"); // do��while���ѭ����
			b--;
		} while (b == 60); // ָ��ѭ����������
	}
}
