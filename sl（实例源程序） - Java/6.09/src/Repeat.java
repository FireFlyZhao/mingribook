import java.util.*;

public class Repeat { // ������
	public static void main(String[] args) { // ������
		int arr[] = new int[] { 23, 42, 12, 84, 10 }; // ��������
		int newarr[] = Arrays.copyOfRange(arr, 0, 3); // ��������
		for (int i = 0; i < newarr.length; i++) { // ѭ���������ƺ��������
			System.out.println(newarr[i]); // ���������е�ÿ��Ԫ�����
		}
	}
}
