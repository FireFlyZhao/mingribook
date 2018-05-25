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
			return ("我是枚举成员A");
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
			return ("我是枚举成员B");
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
			return ("我是枚举成员C");
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
			return ("我是枚举成员D");
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
			System.out.println(AnyEnem.values()[i] + "调用getDescription()方法为："
					+ AnyEnem.values()[i].getDescription());
			System.out.println(AnyEnem.values()[i] + "调用getI()方法为："
					+ AnyEnem.values()[i].getI());
		}
	}
}
