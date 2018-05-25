package chapter.five;

public class Division {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "192.168.0.1";
		String[] firstArray = str.split("\\.");
		String[] secondArray = str.split("\\.",2);
		System.out.println("str的原值为：[" + str + "]");
		System.out.print("全部分割的结果：");
		for (String a : firstArray) {
			System.out.print("[" + a + "]");
		}
		System.out.println();
		System.out.print("分割两次的结果：");
		for (String a : secondArray) {
			System.out.print("[" + a + "]");
		}
		System.out.println();
		String[] thirdArray = str.split("1");
		for (String a : thirdArray) {
			System.out.print("[" + a + "]");
		}
	}

}
