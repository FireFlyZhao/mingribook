import java.util.*;

public class Cope { // ������
	public static void main(String[] args) { // ������
		int arr[] = new int[] { 23, 42, 12, }; // ��������
		int newarr[] = Arrays.copyOf(arr, 5); // ��������arr
		for (int i = 0; i < newarr.length; i++) { // ѭ���������ƺ��������
			System.out.println(newarr[i]); // �����������
		}
	}
}
