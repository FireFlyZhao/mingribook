public class Matrix { // ������
	public static void main(String[] args) { // ������
		int a[][] = new int[3][4]; // �����ά����
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) { // ѭ�����������е�ÿ��Ԫ��
				System.out.print(a[i][j]); // �������е�Ԫ�����
			}
			System.out.println(); // ����ո�
		}
	}
}
