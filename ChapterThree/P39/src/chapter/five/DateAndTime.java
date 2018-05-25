package chapter.five;

import java.util.Date;

public class DateAndTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		String time = String.format("%tc", date);
		String form = String.format("%tF", date);
		System.out.println(time);
		System.out.println(form);
	}

}
