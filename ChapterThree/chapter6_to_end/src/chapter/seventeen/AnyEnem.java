package chapter.seventeen;

interface d {
	public String getDescription();
	public int getI();
}

public enum AnyEnem implements d{
	
	Constants_A{

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return ("����ö�ٳ�ԱA");
		}

		@Override
		public int getI() {
			// TODO Auto-generated method stub
			return i;
		}
		
	},
	
	Constants_B{

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return ("����ö�ٳ�ԱB");
		}

		@Override
		public int getI() {
			// TODO Auto-generated method stub
			return i;
		}
	},
	
	Constants_C{

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return ("����ö�ٳ�ԱC");
		}

		@Override
		public int getI() {
			// TODO Auto-generated method stub
			return i;
		}
	},
	
	Constants_D{

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return ("����ö�ٳ�ԱD");
		}

		@Override
		public int getI() {
			// TODO Auto-generated method stub
			return i;
		}
	};
	
	private static int i = 5;
	
	public static void main(String[] args) {
		for (int i = 0; i < AnyEnem.values().length; i++) {
			System.out.println(AnyEnem.values()[i] + "����getDescription()����Ϊ��"
					+ AnyEnem.values()[i].getDescription());
			System.out.println(AnyEnem.values()[i] + "����getI()����Ϊ��"
					+ AnyEnem.values()[i].getI());
		}
	}
}
