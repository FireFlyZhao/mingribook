public class Trap { // ������
	public static void main(String[] args) { // ������
		int b[][] = new int[][]{{ 1 },{ 2, 3},{ 4, 5, 6 } };// �����ά����
		for (int k = 0; k < b.length; k++) {
			for (int c=0;c<b[k].length; c++){// ѭ��������ά�����е�ÿ��Ԫ��
				System.out.print(b[k][c]); // �������е�Ԫ�����
			}
			System.out.println(); // ����ո�
		}
	}
}
