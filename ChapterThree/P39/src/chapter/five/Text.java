package chapter.five;

public class Text {

	public static void main(String[] args) {
		String str = "We are students"; 
		int size = str.lastIndexOf("");
		System.out.println("�ո����ַ���str�е�����λ���ǣ�" + size);
		System.out.println("�ַ���str�ĳ����ǣ�" + str.length());
		System.out.println(str.lastIndexOf("ts"));
	}

}
