package Number;

public class Gess {

	public static void main(String[] args) {
		char word = 'd' , word2 = '@';
		int p = 23088 , p2 = 45213;
		System.out.println("d��unicode���е�˳��λ���ǣ�" + (int) word);
		System.out.println("@��unicode���е�˳��λ���ǣ�" + (int) word2);
		System.out.println("unicode���еĵ�23045λ�ǣ�" + (char) p);
		System.out.println("unicode���еĵ�45213λ�ǣ�" + (char) p2);
	
		char c1 = '\\';
		char c2 = '\u2605';
		char c3 = '\n';
		System.out.println(c1);
		System.out.println(c3);
		System.out.println(c2);
		
		
	}

}
