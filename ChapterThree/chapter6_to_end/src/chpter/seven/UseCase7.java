package chpter.seven;

public class UseCase7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lenght = args.length;
		if (lenght == 0) {
			System.out.println("�����в���");
		}else {
			for (int i = 1; i <= args.length; i++) {
				System.out.println(i);
			}
		}
	}

}
