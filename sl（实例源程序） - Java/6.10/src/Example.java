import java.util.*;

public class Example { // ������
	public static void main(String[] args) { // ������
		int ia[] = new int[] { 1, 8, 9, 4, 5 }; // ����int������ia
		Arrays.sort(ia); // �������������
		int index = Arrays.binarySearch(ia, 4); // ��������ia��Ԫ��4������λ��
		System.out.println("4������λ���ǣ�" + index); // ���������
	}
}
