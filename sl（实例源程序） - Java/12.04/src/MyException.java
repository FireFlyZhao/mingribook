public class MyException extends Exception {//创建自定义异常，继承Exception类
	public MyException(String ErrorMessagr) { // 构造方法
		super(ErrorMessagr); // 父类构造方法
	}
}
