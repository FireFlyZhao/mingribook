public class Test {
	private Object b; // 定义Object类型成员变量
	
	public Object getB() { // 设置相应getXXX()方法
		return b;
	}
	
	public void setB(Object b) { // 设置相应setXXX()方法
		this.b = b;
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.setB(new Boolean(true)); // 向上转型操作
		System.out.println(t.getB());
		t.setB(new Float(12.3));
		Float f = (Float) (t.getB()); // 向下转型操作
		System.out.println(f);
	}
}
