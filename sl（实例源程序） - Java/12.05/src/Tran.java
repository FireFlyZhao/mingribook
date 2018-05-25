public class Tran { // 创建类
	 // 定义方法，抛出异常
	static int avg(int number1, int number2) throws MyException {
		if (number1 < 0 || number2 < 0) { // 判断方法中参数是否满足指定条件
			throw new MyException("不可以使用负数"); // 错误信息
		}
		if (number1 > 100 || number2 > 100) { // 判断方法中参数是否满足指定条件
			throw new MyException("数值太大了"); // 错误信息
		}
		return (number1 + number2) / 2; // 将参数的平均值返回
	}
	
	public static void main(String[] args) { // 主方法
		try { // try代码块处理可能出现异常的代码
			int result = avg(102, 150); // 调用avg()方法
			System.out.println(result); // 将avg()方法的返回值输出
		} catch (MyException e) {
			System.out.println(e); // 输出异常信息
		}
	}
}
