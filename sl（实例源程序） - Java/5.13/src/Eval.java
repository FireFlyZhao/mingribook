import java.util.*;

public class Eval { // 新建类
	public static void main(String[] args) { // 主方法
		Date date = new Date(); // 创建Date对象date
		String year = String.format("%tY", date); // 将date进行格式化
		String month = String.format("%tB", date);
		String day = String.format("%td", date);
		System.out.println("今年是：" + year + "年"); // 输出信息
		System.out.println("现在是：" + month);
		System.out.println("今天是：" + day + "号");
	}
}
