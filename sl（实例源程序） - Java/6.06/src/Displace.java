import java.util.*;

public class Displace { // ������
	public static void main(String[] args) { // ������
		int arr[] = new int[] { 45, 12, 2, 10 }; // ���岢��ʼ��int������arr
		Arrays.fill(arr, 1, 2, 8); // ʹ��fill������������г�ʼ��
		for (int i = 0; i < arr.length; i++) { // ѭ������������Ԫ��
			// �������е�ÿ��Ԫ�����
			System.out.println("��" + i + "��Ԫ���ǣ�" + arr[i]);
		}
	}
}
