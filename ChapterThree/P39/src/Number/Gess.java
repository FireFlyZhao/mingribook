package Number;

public class Gess {

	public static void main(String[] args) {
		char word = 'd' , word2 = '@';
		int p = 23088 , p2 = 45213;
		System.out.println("d在unicode表中的顺序位置是：" + (int) word);
		System.out.println("@在unicode表中的顺序位置是：" + (int) word2);
		System.out.println("unicode表中的第23045位是：" + (char) p);
		System.out.println("unicode表中的第45213位是：" + (char) p2);
	
		char c1 = '\\';
		char c2 = '\u2605';
		char c3 = '\n';
		System.out.println(c1);
		System.out.println(c3);
		System.out.println(c2);
		
		
	}

}
