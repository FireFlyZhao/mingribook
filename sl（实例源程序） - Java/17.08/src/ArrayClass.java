public class ArrayClass<T> {
	private T[] array; // 定义泛型数组
	
	public void SetT(T[] array) { // 设置SetXXX()方法为成员数组赋值
		this.array = array;
	}
	
	public T[] getT() { // 获取成员数组
		return array;
	}
	
	public static void main(String[] args) {
		ArrayClass<String> a = new ArrayClass<String>();
		String[] array = { "成员1", "成员2", "成员3", "成员4", "成员5" };
		a.SetT(array); // 调用SetT()方法
		for (int i = 0; i < a.getT().length; i++) {
			System.out.println(a.getT()[i]); // 调用getT()方法返回数组中的值
		}
	}
}
