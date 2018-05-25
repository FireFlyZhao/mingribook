public class Shoot { // 创建类
	static void pop() throws NegativeArraySizeException {
		// 定义方法并抛出NegativeArraySizeException异常
		int[] arr = new int[-3]; // 创建数组
	}
	public static void main(String[] args) { // 主方法
		try { // try语句处理异常信息
			pop(); // 调用pop()方法
		} catch (NegativeArraySizeException e) {
			System.out.println("pop()方法抛出的异常");// 输出异常信息
		}
	}
}
