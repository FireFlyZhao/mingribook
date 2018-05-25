import java.io.*;

public class FileTest { // 创建类
	public static void main(String[] args) { // 主方法
		File file = new File("word.txt"); // 创建文件对象
		try { // 捕捉异常
			// 创建FileOutputStream对象
			FileOutputStream out = new FileOutputStream(file);
			// 创建byte型数组
			byte buy[] = "我有一只小毛驴，我从来也不骑。".getBytes();
			out.write(buy); // 将数组中信息写入到文件中
			out.close(); // 将流关闭
		} catch (Exception e) { // catch语句处理异常信息
			e.printStackTrace(); // 输出异常信息
		}
		try {
			// 创建FileInputStream类对象
			FileInputStream in = new FileInputStream(file);
			byte byt[] = new byte[1024]; // 创建byte数组
			int len = in.read(byt); // 从文件中读取信息
			// 将文件中信息输出
			System.out.println("文件中的信息是：" + new String(byt, 0, len));
			in.close(); // 关闭流
		} catch (Exception e) {
			e.printStackTrace(); // 输出异常信息
		}
	}
}
