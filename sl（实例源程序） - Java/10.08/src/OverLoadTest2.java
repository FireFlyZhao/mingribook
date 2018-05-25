public class OverLoadTest2 {
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static double add(double a, double b) {
		return a + b;
	}
	
	public static int add(int a) {
		return 1;
	}
	
	public static int add(int a, double b) {
		return 1;
	}
	
	public static int add(double a, int b) {
		return 1;
	}
	
	public static int add(int... a) { // 定义不定长参数方法
		int s = 0;
		for (int i = 0; i < a.length; i++)
			// 根据参数个数做循环操作
			s += a[i]; // 将每个参数累加
		return s; // 将计算结果返回
	}
	
	public static void main(String args[]) {
		System.out.println("调用add(int,int)方法：" + add(1, 2));
		System.out.println("调用add(double,double)方法：" + add(2.1, 3.3));
		System.out.println("调用add(int)方法：" + add(1));
		// 调用不定长参数方法
		System.out.println("调用不定长参数方法：" + add(1,2, 3,4, 5,6, 7, 8, 9));
		System.out.println("调用不定长参数方法：" + add(2,3,4));
	}
}
