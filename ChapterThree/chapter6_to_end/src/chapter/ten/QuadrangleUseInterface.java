package chapter.ten;

public class QuadrangleUseInterface {
	
	public void doAnyThing() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		drawTest[] d = {
			new SquareUseInterface(), new ParallelogramgleUseInterface()
		};
		for (int i = 0; i < d.length; i++) {
			d[i].draw();
		}
	}

}

interface drawTest{
	public void draw();
}

class ParallelogramgleUseInterface extends QuadrangleUseInterface implements drawTest{
	public void draw() {
		System.out.println("平行四边形.draw()");
	}
	void doAnything() {
		
	}
}

class SquareUseInterface extends QuadrangleUseInterface 
	implements drawTest{
	public void draw() {
		System.out.println("正方形.draw()");
	}
	void doAnything() {
		
	}
}

class AnyThingUseInterface extends QuadrangleUseInterface{
	void doAnything() {
		
	}
}