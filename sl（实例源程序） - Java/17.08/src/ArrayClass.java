public class ArrayClass<T> {
	private T[] array; // ���巺������
	
	public void SetT(T[] array) { // ����SetXXX()����Ϊ��Ա���鸳ֵ
		this.array = array;
	}
	
	public T[] getT() { // ��ȡ��Ա����
		return array;
	}
	
	public static void main(String[] args) {
		ArrayClass<String> a = new ArrayClass<String>();
		String[] array = { "��Ա1", "��Ա2", "��Ա3", "��Ա4", "��Ա5" };
		a.SetT(array); // ����SetT()����
		for (int i = 0; i < a.getT().length; i++) {
			System.out.println(a.getT()[i]); // ����getT()�������������е�ֵ
		}
	}
}
