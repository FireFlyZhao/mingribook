public class MathRandomChar {
	// �����ȡ�����ַ�֮�������ַ�
	public static char GetRandomChar(char cha1, char cha2) {
		return (char) (cha1 + Math.random() * (cha2 - cha1 + 1));
	}
	
	public static void main(String[] args) {
		// ��ȡa~z֮�������ַ�
		System.out.println("����Сд�ַ�" + GetRandomChar('a', 'z'));
		// ��ȡA~Z֮�������ַ�
		System.out.println("�����д�ַ�" + GetRandomChar('A', 'Z'));
		// ��ȡ0~9֮�������ַ�
		System.out.println("0��9���������ַ�" + GetRandomChar('0', '9'));
	}
}
