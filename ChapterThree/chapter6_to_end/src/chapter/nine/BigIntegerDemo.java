package chapter.nine;

import java.math.BigInteger;

public class BigIntegerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger bigInstance = new BigInteger("4");
		System.out.println("加法操作：" + bigInstance.add(new BigInteger("2")));
		System.out.println("减法操作：" + bigInstance.subtract(new BigInteger("2")));
		System.out.println("乘法操作：" + bigInstance.multiply(new BigInteger("2")));
		System.out.println("除法操作：" + bigInstance.divide(new BigInteger("2")));
		System.out.println("取商："
				+ bigInstance.divideAndRemainder(new BigInteger("3"))[0]);
		System.out.println("取余数："
				+ bigInstance.divideAndRemainder(new BigInteger("3"))[1]);
		System.out.println("做2次方操作：" + bigInstance.pow(2));
		System.out.println("取相反数操作：" + bigInstance.negate());
	}

}
