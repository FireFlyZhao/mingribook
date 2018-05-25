public class Getifelse {
	public static void main(String args[]) { // 主方法
		int math = 95; // 声明int型局部变量，并赋给初值95
		int english = 56; // 声明int型局部变量，并赋给初值56
		if (math > 60) { // 使用if语句判断math是否大于60
			System.out.println("数学及格了"); // 条件成立时输出信息
		} else {
			System.out.println("数学没有及格"); // 条件不成立输出的信息
		}
		if (english > 60) { // 判断英语成绩是否大于60
			System.out.println("英语及格了"); // 条件成立输出的信息
		} else {
			System.out.println("英语没有及格"); // 条件不成立输出的信息
		}
	}
}
