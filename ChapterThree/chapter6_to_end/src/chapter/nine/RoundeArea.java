package chapter.nine;

import java.text.DecimalFormat;

public class RoundeArea {
	
	public static void SimpleFormat(String pattern, double value) {
		DecimalFormat myFormat = new DecimalFormat(pattern);
		String output = myFormat.format(value);
		System.out.println(value + " " + pattern + " " + output);
	}
	
	public static double GetRoundAre(double r) {
		return Math.PI*Math.pow(r, 2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Բ�����Ϊ��");
		SimpleFormat("#.#####", GetRoundAre(2));
	}

}
