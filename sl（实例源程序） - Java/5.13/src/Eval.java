import java.util.*;

public class Eval { // �½���
	public static void main(String[] args) { // ������
		Date date = new Date(); // ����Date����date
		String year = String.format("%tY", date); // ��date���и�ʽ��
		String month = String.format("%tB", date);
		String day = String.format("%td", date);
		System.out.println("�����ǣ�" + year + "��"); // �����Ϣ
		System.out.println("�����ǣ�" + month);
		System.out.println("�����ǣ�" + day + "��");
	}
}
