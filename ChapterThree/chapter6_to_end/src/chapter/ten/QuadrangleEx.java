package chapter.ten;

public class QuadrangleEx {
	
	private QuadrangleEx[] qtest = new QuadrangleEx[6];
	private int nextIndex = 0;
	public void draw(QuadrangleEx q) {
		if (nextIndex < qtest.length) {
			qtest[nextIndex] = q;
			System.out.println(nextIndex);
			nextIndex++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuadrangleEx q = new QuadrangleEx();
		q.draw(new SquareEx());
		q.draw(new Parallelogramgle());
	}

}

class SquareEx extends QuadrangleEx {
	public SquareEx() {
		System.out.println("Square");
	}
}

class Parallelogramgle extends QuadrangleEx{
	  public Parallelogramgle() {
		  System.out.println("Parallelogramgle");
	  }
}
