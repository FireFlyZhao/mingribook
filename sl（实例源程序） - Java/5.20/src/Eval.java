public class Eval { // �½���
	public static void main(String[] args) { // ������
		String str = new String("We are students");
		String str2 = new String("I like Java");
		String newstr = str.substring(1,3);
		String newstr2 = str2.substring(1,3);
		if(newstr.equalsIgnoreCase(newstr2)){
			System.out.println("�����ַ���ͬ");
		}
		else{
			System.out.println("�����ַ�����ͬ");
		}
		}
}
