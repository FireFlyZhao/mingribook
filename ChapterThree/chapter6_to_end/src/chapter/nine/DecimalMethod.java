package chapter.nine;

import java.text.DecimalFormat;

public class DecimalMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat myFormat = new DecimalFormat();
		myFormat.setGroupingSize(2);
		String output = myFormat.format(123456.789);
		System.out.println("��������ÿ�������ַ��� " + output);
		myFormat.setGroupingUsed(false);
		String output2 = myFormat.format(123456.789);
		System.out.println("���������ַ��� " + output2);
	}

}
