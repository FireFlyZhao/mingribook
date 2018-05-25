package chapter.seventeen;

public class EnumS {
	enum Constants2{
		Constants_A("����ö�ٳ�ԱA"),Constants_B("����ö�ٳ�ԱB"),
		Constants_C("����ö�ٳ�ԱC"),Constants_D(3);
		private String description;
		private int i = 4;
		
		private Constants2() {
			
		}
		
		private Constants2(String description) {
			this.description = description;
		}
		
		private Constants2(int i) {
			this.i = this.i + i;
		}
		
		public String getDescription() {
			return description;
		}
		
		public int getI() {
			return i;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < Constants2.values().length; i++) {
			System.out.println(Constants2.values()[i] + "����getDescription()����Ϊ��"
					+ Constants2.values()[i].getDescription());
		}
		System.out.println(Constants2.valueOf("Constants_D") + "����getI()����Ϊ��"
				+ Constants2.valueOf("Constants_D").getI());
	}

}
