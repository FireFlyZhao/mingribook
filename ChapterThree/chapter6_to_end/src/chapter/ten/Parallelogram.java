package chapter.ten;

class Quadrangle{
	public static void draw(Quadrangle q) {
		
	}
}

class Square extends Quadrangle {
	
}

class Anything {
	
}

public class Parallelogram extends Quadrangle{

	public static void main(String[] args) {
		Quadrangle q = new Quadrangle();
		
		if (q instanceof Parallelogram) {
			Parallelogram p = (Parallelogram) q;
			System.out.println("1." + p);
		}
		
		if (q instanceof  Square) {
			Square s = (Square) q;
			System.out.println("2." + s);
		}
		
		Quadrangle q2 = new Parallelogram();
		if (q2 instanceof Parallelogram) {
			Parallelogram p2 = (Parallelogram) q2;
			System.out.println("3." + p2);
		}
		
//		Parallelogram p3 = (Parallelogram) new Quadrangle();
//		System.out.println("4." + p3);
		
//		if (q instanceof Anything) {
//			
//		}
//		System.out.println(q instanceof Anything);
		
	}
	

	
}
