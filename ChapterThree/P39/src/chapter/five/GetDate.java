package chapter.five;

import java.util.Date;

public class GetDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		String hour = String.format("%tH", date);
		String minute = String.format("%tM", date);
		String second = String.format("%tS", date);
		System.out.println("�����ǣ�" + hour + "ʱ" + minute + "��"
				+ second + "��");
	}

}
