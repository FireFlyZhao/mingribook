package chapter.nine;

import java.text.DecimalFormat;

public class DecimalFormatSimpleDemo {
	
	public static void SimgleFormat(String pattern, double value) {
		DecimalFormat myFormat = new DecimalFormat(pattern);
		String output = myFormat.format(value);
		System.out.println(value + " " + pattern + " " + output);
	}
	
	public static void UseApplyPatterMethodFormat(String pattern,double value) {
		DecimalFormat myFormat = new DecimalFormat();
		myFormat.applyPattern(pattern);
		System.out.println(value + " " + pattern + " " + myFormat.format(value));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimgleFormat("###,###.###",123456.789);
		SimgleFormat("00000000.###kg",123456.789);
		SimgleFormat("000000.000",123.78);
		UseApplyPatterMethodFormat("#.###%",0.789);
		UseApplyPatterMethodFormat("###.##",123456.789);
		UseApplyPatterMethodFormat("0.00\u2030",0.789);
	}

}
