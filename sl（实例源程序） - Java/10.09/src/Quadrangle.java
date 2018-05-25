public class Quadrangle {
	// 实例化保存四边形对象的数组对象
	private Quadrangle[] qtest = new Quadrangle[6];
	private int nextIndex = 0;
	
	public void draw(Quadrangle q) { // 定义draw()方法，参数为四边形对象
		if (nextIndex < qtest.length) {
			qtest[nextIndex] = q;
			System.out.println(nextIndex);
			nextIndex++;
		}
	}
	
	public static void main(String[] args) {
		// 实例化两个四边形对象，用于调用draw()方法
		Quadrangle q = new Quadrangle();
		q.draw(new Square()); // 以正方形对象为参数调用draw()方法
		// 以平行四边形对象为参数调用draw()方法
		q.draw(new Parallelogramgle());
	}
}

class Square extends Quadrangle { // 定义一个正方形类，继承四边形类
	public Square() {
		System.out.println("正方形");
	}
}

// 定义一个平行四边形类，继承四边形类
class Parallelogramgle extends Quadrangle {
	public Parallelogramgle() {
		System.out.println("平行四边形");
	}
}
