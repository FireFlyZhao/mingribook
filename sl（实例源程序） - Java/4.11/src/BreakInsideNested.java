public class BreakInsideNested {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				if (j == 4) {// ���j����4��ʱ��ͽ����ڲ�ѭ��
					break;
				}
				System.out.println("i=" + i + " j=" + j);
			}
		}
	}
}
