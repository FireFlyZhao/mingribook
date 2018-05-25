public class General { // 新建类
	public static void main(String[] args) { // 主方法
		String str = String.format("%d", 400 / 2); // 将结果以十进制显示
		String str2 = String.format("%b", 3 > 5); // 将结果以布尔形式显示
		String str3 = String.format("%x", 200); // 将结果以十进制格式显示
		System.out.println("400的一半是：" + str); // 输出格式化字符串
		System.out.println("3>5正确吗：" + str2);
		System.out.println("200的十六进制数是：" + str3);
	}
}
