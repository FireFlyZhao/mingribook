import java.math.*;

public class BigDecimalDemo {
	static final int location = 10;
	
	/**
	 * 定义加法方法，参数为加数与被加数
	 * 
	 * @param value1
	 *            相加的第一个数
	 * @param value2
	 *            相加的第二个数
	 * @return 两数之和
	 */
	public BigDecimal add(double value1, double value2) {
		// 实例化Decimal对象
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		return b1.add(b2); // 调用加法方法
	}
	
	/**
	 * 定义减法方法，参数为减数与被减数
	 * 
	 * @param value1
	 *            被减数
	 * @param value2
	 *            减数
	 * @return 运算结果
	 */
	public BigDecimal sub(double value1, double value2) {
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		return b1.subtract(b2); // 调用减法方法
	}
	
	/**
	 * 定义乘法方法，参数为乘数与被乘数
	 * 
	 * @param value1
	 *            第一个乘数
	 * @param value2
	 *            第二个乘数
	 * @return
	 */
	public BigDecimal mul(double value1, double value2) {
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		return b1.multiply(b2); // 调用乘法方法
	}
	
	/**
	 * 定义除法方法，参数为除数与被除数
	 * 
	 * @param value1 被除数
	 * @param value2 除数
	 * @return
	 */
	public BigDecimal div(double value1, double value2) {
		return div(value1, value2, location); // 调用自定义除法方法
	}
	
	// 定义除法方法，参数分别为除数与被除数以及商小数点后的位数
	public BigDecimal div(double value1, double value2, int b) {
		if (b < 0) {
			System.out.println("b值必须大于等于0");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		// 调用除法方法，商小数点后保留b位，并将结果进行四舍五入操作
		return b1.divide(b2, b, BigDecimal.ROUND_HALF_UP);
	}
	
	public static void main(String[] args) {
		BigDecimalDemo b = new BigDecimalDemo();
		System.out.println("两个数字相加结果：" + b.add(-7.5, 8.9));
		System.out.println("两个数字相减结果：" + b.sub(-7.5, 8.9));
		System.out.println("两个数字相乘结果：" + b.mul(-7.5, 8.9));
		System.out.println("两个数字相除结果，结果小数后保留10位："+b.div(10, 2));
		System.out.println("两个数字相除，保留小数后5位："+b.div(-7.5,8.9, 5));
	}
}
