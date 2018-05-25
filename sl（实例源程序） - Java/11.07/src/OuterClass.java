public class OuterClass {
	innerClass in = new innerClass(); // 在外部类实例化内部类对象引用
	
	public void ouf() {
		in.inf(); // 在外部类方法中调用内部类方法
	}
	
	class innerClass {
		innerClass() { // 内部类构造方法
		}
		
		public void inf() { // 内部类成员方法
		}
		
		int y = 0; // 定义内部类成员变量
	}
	
	public innerClass doit() { // 外部类方法，返回值为内部类引用
		// y=4; //外部类不可以直接访问内部类成员变量
		in.y = 4;
		return new innerClass(); // 返回内部类引用
	}
	
	public static void main(String args[]) {
		OuterClass out = new OuterClass();
		// 内部类的对象实例化操作必须在外部类或外部类中的非静态方法中实现
		OuterClass.innerClass in = out.doit();
		OuterClass.innerClass in2 = out.new innerClass();
	}
}