public class GetTerm { // ��������
	public static void main(String args[]) { // ������
		int x = 20; // ����int�;ֲ�����
		if (x > 30) { // �жϱ���x�Ƿ����30
			System.out.println("a��ֵ����30"); // ���������������Ϣ
		} else if (x > 10) { // �жϱ���x�Ƿ����10
			System.out.println("a��ֵ����10����С��30"); // ���������������Ϣ
		} else if (x > 0) { // �жϱ���x�Ƿ����0
			System.out.println("a��ֵ����0����С��10"); // ���������������Ϣ
		} else { // ������������������ʱ��ִ�е�����
			System.out.println("a��ֵС��0"); // �����Ϣ
		}
	}
}
