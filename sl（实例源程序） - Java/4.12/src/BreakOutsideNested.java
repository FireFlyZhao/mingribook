public class BreakOutsideNested {
	public static void main(String[] args) {
		Loop: for (int i = 0; i < 3; i++) {// ��forѭ��ǰ�ñ�ǩ���
			for (int j = 0; j < 6; j++) {
				if (j == 4) {// ���j����4��ʱ��ͽ������ѭ��
					break Loop;// ����Loop��ǩ��ǵ�ѭ����
				}
				System.out.println("i=" + i + " j=" + j);
			}
		}
	}
}
