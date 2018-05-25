public class RandomTest{
	/**
	 * 获取2到32之间的6个偶数，并且求这6个偶数的和
	 * 
	 * @param num1
	 *            数字起始范围
	 * @param num2
	 *            数字中止范围（不包括本身）
	 * @return 返回指定范围内随机六个偶数的和
	 */
	public static double EvenNum(double num1, double num2) {
		double sum = 0;// 总和
		int count = 0;// 计数器
		while (true) {
			int tmp = (int) num1 + (int) (Math.random() * (num2 - num1));
			if (tmp != 0 && tmp % 2 == 0) {
				System.out.println("打印2到32之间的偶数(不包括32)" + tmp);
				sum += tmp;
				count++;
			}
			if (count == 6) {// 获取六次偶数后跳出循环
				break;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println("和为：" + EvenNum(2, 32));
	}
}