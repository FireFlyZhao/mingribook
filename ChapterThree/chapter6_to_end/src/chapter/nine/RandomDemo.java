package chapter.nine;

import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		System.out.println("�������һ������:" + r.nextInt());
		System.out.println("�������һ�����ڵ���0С��10��������" + r.nextInt(10));
		System.out.println("�������һ�������͵�ֵ��" + r.nextBoolean());
		System.out.println("�������һ��˫�����͵�ֵ��" + r.nextDouble());
		System.out.println("�������һ�������͵�ֵ��" + r.nextFloat());
		System.out.println("�������һ�������ܶ�Ϊ��˹�ֲ���˫����ֵ��" + r.nextGaussian());
	}

}
