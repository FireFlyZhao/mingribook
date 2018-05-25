import java.text.*;

public class DecimalFormatSimpleDemo {
	// 使用实例化对象时设置格式化模式
	static public void SimgleFormat(String pattern, double value) {
		// 实例化DecimalFormat对象
		DecimalFormat myFormat = new DecimalFormat(pattern); 
		String output = myFormat.format(value); // 将数字进行格式化
		System.out.println(value + " " + pattern + " " + output);
	}
	
	// 使用applyPattern()方法对数字进行格式化
	static public void UseApplyPatternMethodFormat(String pattern, double value) {
		DecimalFormat myFormat=new DecimalFormat();//实例化DecimalFormat对象
		myFormat.applyPattern(pattern); // 调用applyPatten()方法设置格式化模板
		System.out
				.println(value + " " + pattern + " " + myFormat.format(value));
	}
	
	public static void main(String[] args) {
		SimgleFormat("###,###.###", 123456.789);// 调用静态SimgleFormat()方法
		SimgleFormat("00000000.###kg", 123456.789); // 在数字后加上单位
		// 按照格式模板格式化数字，不存在的位以0显示
		SimgleFormat("000000.000", 123.78);
		// 调用静态UseApplyPatternMethodFormat()方法
		UseApplyPatternMethodFormat("#.###%", 0.789); // 将数字转换为百分数形式
		// 将小数点后格式化为两位
		UseApplyPatternMethodFormat("###.##", 123456.789);
		// 将数字转化为千分数形式
		UseApplyPatternMethodFormat("0.00\u2030", 0.789);
	}
}
