public class CharacterCompare {
	public static void main(String args[]) {
		Character char1 = new Character('h');
		Character char2 = new Character('H');
		boolean b = char1.equals(char2);
		System.out.println(char1+"��"+char2+"�Ƿ���ȣ�"+b);
		Character char3 = Character.toLowerCase(char1);
		Character char4 = Character.toLowerCase(char2);
		boolean bb = char3.equals(char4);
		System.out.println(char3+"��"+char4+"�Ƿ���ȣ�"+bb);
	}
}