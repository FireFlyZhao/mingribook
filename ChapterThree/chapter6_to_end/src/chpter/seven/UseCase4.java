package chpter.seven;
//“Ï≥£
public class UseCase4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UseCase3 u = (UseCase3) new UseCase1();
		u.setName("123");
		System.out.println(u.getName());
		
		
	}

}
//Exception in thread "main" java.lang.ClassCastException: chpter.seven.UseCase1 cannot be cast to chpter.seven.UseCase3
//at chpter.seven.UseCase4.main(UseCase4.java:7)
