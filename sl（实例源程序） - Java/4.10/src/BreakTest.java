public class BreakTest {
	public static void main(String[] args) {
		for (int i = 0; i <= 100; i++) {
			System.out.println(i);
			if (i == 6) {//���i����6������ѭ��
				break;
			}
		}
		System.out.println("---end---");//��ʾ�������
	}
}