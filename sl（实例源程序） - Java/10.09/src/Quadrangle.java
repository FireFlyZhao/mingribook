public class Quadrangle {
	// ʵ���������ı��ζ�����������
	private Quadrangle[] qtest = new Quadrangle[6];
	private int nextIndex = 0;
	
	public void draw(Quadrangle q) { // ����draw()����������Ϊ�ı��ζ���
		if (nextIndex < qtest.length) {
			qtest[nextIndex] = q;
			System.out.println(nextIndex);
			nextIndex++;
		}
	}
	
	public static void main(String[] args) {
		// ʵ���������ı��ζ������ڵ���draw()����
		Quadrangle q = new Quadrangle();
		q.draw(new Square()); // �������ζ���Ϊ��������draw()����
		// ��ƽ���ı��ζ���Ϊ��������draw()����
		q.draw(new Parallelogramgle());
	}
}

class Square extends Quadrangle { // ����һ���������࣬�̳��ı�����
	public Square() {
		System.out.println("������");
	}
}

// ����һ��ƽ���ı����࣬�̳��ı�����
class Parallelogramgle extends Quadrangle {
	public Parallelogramgle() {
		System.out.println("ƽ���ı���");
	}
}
