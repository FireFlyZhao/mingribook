package chapter.eight;

public class UpperOrLower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Character mychar1 = new Character('A');
		Character mychar2 = new Character('a');
		System.out.println(mychar1 + "ÊÇ´óĞ´×ÖÄ¸Âğ?" + Character.isUpperCase(mychar1));
		System.out.println(mychar2 + "ÊÇĞ¡Ğ´×ÖÄ¸Âğ? " + Character.isLowerCase(mychar2));
		Character mychar3 = mychar1.charValue();
	}

}
