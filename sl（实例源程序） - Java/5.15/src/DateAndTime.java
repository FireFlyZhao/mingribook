import java.util.*;

public class DateAndTime { // ������
	public static void main(String[] args) { // ������
		Date date = new Date(); // ����Date����date
		String time = String.format("%tc", date); // ��date��ʽ��
		String form = String.format("%tF", date);
		 // ����ʽ���������ʱ�����
		System.out.println("ȫ����ʱ����Ϣ�ǣ�" + time);
		System.out.println("��-��-�ո�ʽ��" + form);
	}
}
