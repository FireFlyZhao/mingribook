import java.util.*;

public class Rakel { // ������
	public static void main(String[] args) { // ������
		// ����String������str
		String str[] = new String[] { "ab", "cd", "ef", "yz" };
		Arrays.sort(str); // �������������
		// ��ָ���ķ�Χ������Ԫ��"cd"������λ��
		int index = Arrays.binarySearch(str, 0, 2, "cd");
		System.out.println("cd������λ���ǣ�" + index); // ���������
	}
}
