package chpter.seven;

public class UseCase2 extends UseCase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		UseCase2 u = new UseCase2();
//		UseCase1 u = new UseCase1();
//		UseCase2 u = (UseCase2) new UseCase1();java.lang.ClassCastException
		UseCase1 u = new UseCase2();
		UseCase2 u2 = (UseCase2) u;	//强制转换的用法,new UseCase2,赋值给UseCase1,然后再赋值给UseCase2
//		UseCase3 u = (UseCase3) new UseCase1();java.lang.ClassCastException
		u.setName("123");
		System.out.println(u.getName());
	}

}
