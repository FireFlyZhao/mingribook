public class Test {
	private Object b; // ����Object���ͳ�Ա����
	
	public Object getB() { // ������ӦgetXXX()����
		return b;
	}
	
	public void setB(Object b) { // ������ӦsetXXX()����
		this.b = b;
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.setB(new Boolean(true)); // ����ת�Ͳ���
		System.out.println(t.getB());
		t.setB(new Float(12.3));
		Float f = (Float) (t.getB()); // ����ת�Ͳ���
		System.out.println(f);
	}
}
