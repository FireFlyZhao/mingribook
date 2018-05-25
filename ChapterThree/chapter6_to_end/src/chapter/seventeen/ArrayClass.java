package chapter.seventeen;

public class ArrayClass<T> {
	private T[] array;
//	private T t1 = new T();
//	private T[] array2 = new T[10];
	
	public T[] getArray() {
		return array;
	}

	public void setArray(T[] array) {
		this.array = array;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayClass<String> a = new ArrayClass<String>();
		String[] array = { "成员1", "成员2", "成员3", "成员4", "成员5" };
		a.setArray(array);
		for (int i = 0; i < a.getArray().length; i++) {
			System.out.println(a.getArray()[i]);
		}
	}

}
