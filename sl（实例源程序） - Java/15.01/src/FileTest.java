import java.io.*;

public class FileTest { // 创建类FileTest
	public static void main(String[] args) { // 主方法
		File file = new File("word.txt"); // 创建文件对象
		if (file.exists()) { // 如果该文件存在
			file.delete(); // 将文件删除
			System.out.println("文件已删除"); // 输出的提示信息
		} else { // 如果文件不存在
			try { // try语句块捕捉可能出现的异常
				file.createNewFile(); // 创建该文件
				System.out.println("文件已创建"); // 输出的提示信息
			} catch (Exception e) { // catch处理该异常
				e.printStackTrace(); // 输出异常信息
			}
		}
	}
}
