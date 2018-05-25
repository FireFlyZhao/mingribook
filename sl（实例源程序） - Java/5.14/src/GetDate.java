import java.util.*;

public class GetDate { // 新建类
	public static void main(String[] args) { // 主方法
		Date date = new Date(); // 创建Date对象date
		String hour = String.format("%tH", date); // 将date进行格式化
		String minute = String.format("%tM", date);
		String second = String.format("%tS", date);
		 // 输出的信息
		System.out.println("现在是：" + hour + "时" + minute + "分"
				+ second + "秒");
	}
}
