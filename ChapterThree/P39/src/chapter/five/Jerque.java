package chapter.five;

public class Jerque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "";
		long starTime = System.currentTimeMillis();
		for (int i = 0;i < 10000;i++) {
			str =str + i;
		}
		long endTime = System.currentTimeMillis();
		long time = endTime - starTime;
		System.out.println("Sting消耗时间：" + time);
		StringBuilder builder = new StringBuilder("");
		starTime = System.currentTimeMillis();
		for (int i = 0;i < 10000000;i++) {
			builder.append(i);
		}
		endTime = System.currentTimeMillis();
		time = endTime - starTime;
		System.out.println("StringBuilder消耗时间：" + time); 
		StringBuilder bf = new StringBuilder("StringBuilder");
		bf.delete(5,10);
		System.out.println(bf.toString());
	}

}
