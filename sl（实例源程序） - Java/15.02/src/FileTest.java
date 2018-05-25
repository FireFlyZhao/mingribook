import java.io.*;

public class FileTest { // 创建类
	public static void main(String[] args) {
		File file = new File("word.txt"); // 创建文件对象
		if (file.exists()) { // 如果文件存在
			String name = file.getName(); // 获取文件名称
			long length = file.length(); // 获取文件长度
			boolean hidden = file.isHidden(); // 判断文件是否是隐藏文件
			System.out.println("文件名称：" + name); // 输出信息
			System.out.println("文件长度是：" + length);
			System.out.println("该文件是隐藏文件吗？" + hidden);
		} else { // 如果文件不存在
			System.out.println("该文件不存在"); // 输出信息
		}
	}
}
