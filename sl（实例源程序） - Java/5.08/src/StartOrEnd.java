public class StartOrEnd { // ������
	public static void main(String args[]) { // ������
		String num1 = "22045612"; // �����ַ���num1
		String num2 = "21304578"; // �����ַ���num2
		boolean b = num1.startsWith("22"); // �ж��ַ���num1�Ƿ���'22'��ͷ
		boolean b2 = num1.endsWith("78"); // �ж��ַ���num1�Ƿ���'78'����
		boolean b3 = num2.startsWith("22"); // �ж��ַ���num2�Ƿ���'22'��ͷ
		boolean b4 = num2.endsWith("78"); // �ж��ַ���num2�Ƿ���'78'����
		System.out.println("�ַ���num1����'22'��ʼ����" + b);
		System.out.println("�ַ���num1����'78'��������" + b2); // �����Ϣ
		System.out.println("�ַ���num2����'22'��ʼ����" + b3);
		System.out.println("�ַ���num2����'78'��������" + b4);
	}
}
