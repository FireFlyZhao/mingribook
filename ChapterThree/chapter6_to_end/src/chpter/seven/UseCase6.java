package chpter.seven;

public class UseCase6 {

	private float height;
	private float width;

	public UseCase6(float height, float width) {
		super();
		this.height = height;
		this.width = width;
	}

	public float square() {
		return height * width;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UseCase6 u = new UseCase6(3.5f, 4.5f);
		System.out.println(u.square());
	}

}
