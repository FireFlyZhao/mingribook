public class Shoot { // ������
	static void pop() throws NegativeArraySizeException {
		// ���巽�����׳�NegativeArraySizeException�쳣
		int[] arr = new int[-3]; // ��������
	}
	public static void main(String[] args) { // ������
		try { // try��䴦���쳣��Ϣ
			pop(); // ����pop()����
		} catch (NegativeArraySizeException e) {
			System.out.println("pop()�����׳����쳣");// ����쳣��Ϣ
		}
	}
}
