import java.util.*;

public class RandomDemo {
	public static void main(String[] args) {
		Random r = new Random(); // ʵ����һ��Random��
		// �������һ������
		System.out.println("�������һ������:" + r.nextInt());
		// �������һ�����ڵ���0С��10������
		System.out.println("�������һ�����ڵ���0С��10��������" + r.nextInt(10));
		// �������һ�������͵�ֵ
		System.out.println("�������һ�������͵�ֵ��" + r.nextBoolean());
		// �������һ��˫�����͵�ֵ
		System.out.println("�������һ��˫�����͵�ֵ��" + r.nextDouble());
		// �������һ�������͵�ֵ
		System.out.println("�������һ�������͵�ֵ��" + r.nextFloat());
		// �������һ�������ܶ�Ϊ��˹�ֲ���˫����ֵ
		System.out.println("�������һ�������ܶ�Ϊ��˹�ֲ���˫����ֵ��"
				+ r.nextGaussian());
	}
}
