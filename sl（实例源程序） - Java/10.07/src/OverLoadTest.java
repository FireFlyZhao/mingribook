public class OverLoadTest {
	public static int add(int a, int b) { // ����һ������
		return a + b;
	}
	
	// �������һ��������ͬ���ơ��������Ͳ�ͬ�ķ���
	public static double add(double a, double b) {
		return a + b;
	}
	
	public static int add(int a) { // �������һ����������������ͬ�ķ���
		return a;
	}
	
	public static int add(int a, double b) { // ����һ����Ա����
		return 1;
	}
	
	// ���������ǰһ��������������ͬ
	public static int add(double a, int b) {
		return 1;
	}
	
	public static void main(String args[]) {
		System.out.println("����add(int,int)������" + add(1, 2));
		System.out.println("����add(double,double)������" + add(2.1, 3.3));
		System.out.println("����add(int)������" + add(1));
	}
}
