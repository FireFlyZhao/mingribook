package chapter.nine;

public class MathRandomChar {
	
	public static char GetRandomChar(char cha1, char cha2) {
		return (char)(cha1 + Math.random()*(cha2 - cha1 + 1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("����Сд�ַ�" + GetRandomChar('a', 'z'));
		System.out.println("�����д�ַ�" + GetRandomChar('A', 'Z'));
		System.out.println("0��9���������ַ�" + GetRandomChar('0', '9'));
	}

}
