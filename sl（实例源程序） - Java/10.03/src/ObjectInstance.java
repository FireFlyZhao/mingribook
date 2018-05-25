public class ObjectInstance {
	public String toString() { // 重写toString()方法
		return "在" + getClass().getName() + "类中重写toString()方法";
	}
	
	public static void main(String[] args) {
		System.out.println(new ObjectInstance()); // 打印本类对象
	}
}
