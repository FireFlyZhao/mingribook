interface drawTest { // ����ӿ�
	public void draw(); // ���巽��
}

// ����ƽ���ı����࣬����̳����ı����࣬��ʵ����drawTest�ӿ�
class ParallelogramgleUseInterface extends QuadrangleUseInterface
		implements drawTest {
	public void draw() { // ���ڸ���ʵ���˽ӿڣ�������Ҫ����draw()����
		System.out.println("ƽ���ı���.draw()");
	}
	
	void doAnyThing() { // ���Ǹ��෽��
		// SomeSentence
	}
}

class SquareUseInterface extends QuadrangleUseInterface implements
		drawTest {
	public void draw() {
		System.out.println("������.draw()");
	}
	
	void doAnyThing() {
		// SomeSentence
	}
}

class AnyThingUseInterface extends QuadrangleUseInterface {
	void doAnyThing() {
		
	}
}

public class QuadrangleUseInterface { // �����ı�����
	public void doAnyTthing() {
		// SomeSentence
	}
	
	public static void main(String[] args) {
		drawTest[] d = { // �ӿ�Ҳ���Խ�������ת�Ͳ���
		new SquareUseInterface(), new ParallelogramgleUseInterface() };
		for (int i = 0; i < d.length; i++) {
			d[i].draw(); // ����draw()����
		}
	}
}
