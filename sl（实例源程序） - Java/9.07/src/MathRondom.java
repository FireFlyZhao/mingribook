public class MathRondom {
	/**
	 * �������ż���ķ���
	 * @param num1 ��ʼ��Χ����
	 * @param num2 ��ֹ��Χ����
	 * @return �漴�ķ�Χ��ż��
	 */
	public static int GetEvenNum(double num1, double num2) {
		// ����num1~num2֮��������
		int s = (int) num1 + (int) (Math.random() * (num2 - num1)); 
		if (s % 2 == 0) { // �ж�������Ƿ�Ϊż��
			return s; // ����
		} else
			// ���������
			return s + 1; // �������1�󷵻�
	}
	
	public static void main(String[] args) {
		// ���ò������������
		System.out.println("����һ��2~32֮���ż����" + GetEvenNum(2, 32));
	}
}
