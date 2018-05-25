package chapter.five;

import java.util.Date;

public class Eval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		String year = String.format("%tY", date);
		String month = String.format("%tm", date);
		String day = String.format("%td", date);
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
	}

}
