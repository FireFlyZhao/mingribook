public class Var_02 {
	public static void main(String args[]) {
		int lineCount = 17;// ����������ж����У��븳ֵ������

		int maxLineNum = (lineCount + 1) / 2;// �������һ��
		for (int i = 1; i <= maxLineNum; i++) {// ѭ����������Խ��Խ��ļ���
			for (int space = 1; space <= maxLineNum - i; space++) {// ����ո�����=���һ��-��ǰ����
				System.out.print("  ");
			}
			for (int star = 1; star <= (i * 2) - 1; star++) {// ����Ǻţ�����=����*2-1
				System.out.print("* ");
			}
			System.out.println();// ����
		}

		int declineCount = lineCount - maxLineNum;// ����ʣ�µļ��У��⼸���Ǻŵ������ǵݼ���
		for (int i = 1; i <= declineCount; i++) {// ѭ����������Խ��Խ�ٵ�����
			for (int space = 1; space <= i; space++) {// ����ո��������ڵ�ǰ������
				System.out.print("  ");
			}
			for (int star = 1; star <= (declineCount - i + 1) * 2 - 1; star++) {// ����Ǻţ��������ڣ�����-��ǰ������*2-1
				System.out.print("* ");
			}
			System.out.println();
		}

	}
}