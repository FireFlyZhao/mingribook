public class GetSwitch { // ������
	public static void main(String args[]) { // ������
		int week = 2; // ����int�ͱ���week
		switch (week) { // ָ��switch���ı��ʽΪ����week
			case 1: // ����case����еĳ���Ϊ1
				System.out.println("Monday"); // �����Ϣ
				break;
			case 2: // ����case����еĳ���Ϊ2
				System.out.println("Tuesday");
				break;
			case 3: // ����case����еĳ���Ϊ3
				System.out.println("Wednesday");
				break;
			default: // default���
				System.out.println("Sorry,I don't Know");
		}
	}
}
