public class Tran { // ������
	 // ���巽�����׳��쳣
	static int avg(int number1, int number2) throws MyException {
		if (number1 < 0 || number2 < 0) { // �жϷ����в����Ƿ�����ָ������
			throw new MyException("������ʹ�ø���"); // ������Ϣ
		}
		if (number1 > 100 || number2 > 100) { // �жϷ����в����Ƿ�����ָ������
			throw new MyException("��ֵ̫����"); // ������Ϣ
		}
		return (number1 + number2) / 2; // ��������ƽ��ֵ����
	}
	
	public static void main(String[] args) { // ������
		try { // try����鴦����ܳ����쳣�Ĵ���
			int result = avg(102, 150); // ����avg()����
			System.out.println(result); // ��avg()�����ķ���ֵ���
		} catch (MyException e) {
			System.out.println(e); // ����쳣��Ϣ
		}
	}
}
