package chapter.seventeen;

public class ShowEnum {
	enum Constants2 {
		Constants_A, Constants_B
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < Constants2.values().length; i++) {
			System.out.println("ö�����ͳ�Ա������" + Constants2.values()[i]);
		}
	}

}
