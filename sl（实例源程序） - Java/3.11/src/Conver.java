public class Conver { // 创建类
	public static void main(String[] args) {
		// 定义byte型变量mybyte，并把byte型变量允许的最大值赋给mybyte
		byte mybyte = 127;
		int myint = 150; // 定义int型变量myint，并赋值150
		float myfloat = 452.12f; // 定义float型变量myfloat，并赋值
		char mychar = 10; // 定义char型变量mychar，并赋值
		double mydouble = 45.46546; // 定义double型变量，并赋值
		System.out.println("byte型与float型数据进行运算结果为：" + (mybyte + myfloat));
		/* 将运算结果输出 */
		System.out.println("byte型与int型数据进行运算结果为：" + mybyte * myint);
		System.out.println("byte型与char型数据进行运算结果为：" + mybyte / mychar);
		System.out
				.println("double型与char型数据进行运算结果为：" + (mydouble + mychar));
	}
}
