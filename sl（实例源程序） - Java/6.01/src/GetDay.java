public class GetDay { // ������
	public static void main(String[] args) { // ������
		// ��������ʼ��һά����
		int day[]=new int[]{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for (int i = 0; i < 12; i++) { // ����ѭ������Ϣ���
			System.out.println((i + 1) + "����" + day[i] + "��"); // �������Ϣ
		}
	}
}
