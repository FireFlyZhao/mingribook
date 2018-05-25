import java.math.*;

public class BigIntegerDemo {
	public static void main(String[] args) {
		BigInteger bigInstance = new BigInteger("4"); // ʵ����һ��������
		// ȡ�ô����ּ�2�Ĳ���
		System.out.println("�ӷ�������" + bigInstance.add(new BigInteger("2")));
		// ȡ�ô����ּ�2�Ĳ���
		System.out.println("����������"
				+ bigInstance.subtract(new BigInteger("2")));
		// ȡ�ô����ֳ���2�Ĳ���
		System.out.println("�˷�������"
				+ bigInstance.multiply(new BigInteger("2")));
		// ȡ�ô����ֳ���2�Ĳ���
		System.out.println("����������"
				+ bigInstance.divide(new BigInteger("2")));
		// ȡ�ô����ֳ���3����
		System.out.println("ȡ�̣�"
				+ bigInstance.divideAndRemainder(new BigInteger("3"))[0]);
		// ȡ�ô����ֳ���3������
		System.out.println("ȡ������"
				+ bigInstance.divideAndRemainder(new BigInteger("3"))[1]);
		// ȡ�ô����ֵ�2�η�
		System.out.println("��2�η�������" + bigInstance.pow(2));
		// ȡ�ô����ֵ��෴��
		System.out.println("ȡ�෴��������" + bigInstance.negate());
	}
}
