package chapter.nine;

import java.math.BigInteger;

public class BigIntegerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger bigInstance = new BigInteger("4");
		System.out.println("�ӷ�������" + bigInstance.add(new BigInteger("2")));
		System.out.println("����������" + bigInstance.subtract(new BigInteger("2")));
		System.out.println("�˷�������" + bigInstance.multiply(new BigInteger("2")));
		System.out.println("����������" + bigInstance.divide(new BigInteger("2")));
		System.out.println("ȡ�̣�"
				+ bigInstance.divideAndRemainder(new BigInteger("3"))[0]);
		System.out.println("ȡ������"
				+ bigInstance.divideAndRemainder(new BigInteger("3"))[1]);
		System.out.println("��2�η�������" + bigInstance.pow(2));
		System.out.println("ȡ�෴��������" + bigInstance.negate());
	}

}
