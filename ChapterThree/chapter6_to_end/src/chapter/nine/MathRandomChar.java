package chapter.nine;

public class MathRandomChar {
	
	public static char GetRandomChar(char cha1, char cha2) {
		return (char)(cha1 + Math.random()*(cha2 - cha1 + 1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("任意小写字符" + GetRandomChar('a', 'z'));
		System.out.println("任意大写字符" + GetRandomChar('A', 'Z'));
		System.out.println("0到9任意数字字符" + GetRandomChar('0', '9'));
	}

}
