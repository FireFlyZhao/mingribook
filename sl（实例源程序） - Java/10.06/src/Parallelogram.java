class Quadrangle {
	public static void draw(Quadrangle q) {
		// SomeSentence
	}
}

class Square extends Quadrangle {
	// SomeSentence
}

class Anything {
	// SomeSentence
}

public class Parallelogram extends Quadrangle {
	public static void main(String args[]) {
		Quadrangle q = new Quadrangle(); // ʵ�����������
		// �жϸ�������Ƿ�ΪParallelogram�����һ��ʵ��
		if (q instanceof Parallelogram) {
			Parallelogram p = (Parallelogram) q; // ����ת�Ͳ���
		}
		// �жϸ�������Ƿ�ΪParallelogram�����һ��ʵ��
		if (q instanceof Square) {
			Square s = (Square) q; // ��������ת�Ͳ���
		}
		// ����q����ΪAnything��Ķ���������������Ǵ����
		// System.out.println(q instanceof Anything);
	}
}
