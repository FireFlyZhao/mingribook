import java.util.*;

public class GetDate { // �½���
	public static void main(String[] args) { // ������
		Date date = new Date(); // ����Date����date
		String hour = String.format("%tH", date); // ��date���и�ʽ��
		String minute = String.format("%tM", date);
		String second = String.format("%tS", date);
		 // �������Ϣ
		System.out.println("�����ǣ�" + hour + "ʱ" + minute + "��"
				+ second + "��");
	}
}
