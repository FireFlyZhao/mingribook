import java.text.*;

public class DecimalMethod {
	public static void main(String[] args) {
		DecimalFormat myFormat = new DecimalFormat();
		myFormat.setGroupingSize(2); // 设置将数字分组为2
		String output = myFormat.format(123456.789);
		System.out.println("将数字以每两个数字分组 " + output);
		myFormat.setGroupingUsed(false); // 设置不允许数字进行分组
		String output2 = myFormat.format(123456.789);
		System.out.println("不允许数字分组 " + output2);
	}
}
