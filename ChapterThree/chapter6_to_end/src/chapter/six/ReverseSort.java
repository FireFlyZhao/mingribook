package chapter.six;

public class ReverseSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {10,20,30,40,50,60};
		ReverseSort sorter = new ReverseSort();
		sorter.sort(array);
	}

	private void sort(int[] array) {
		// TODO Auto-generated method stub
		System.out.println("����ԭ�����ݣ�");
		showArray(array);
		int temp;
		int len = array.length;
		for (int i = 0;i < len/2; i ++) {
			temp = array[i];
			array[i] = array[len - 1 -i ];
			array[len - 1 -i] = temp;
		}
		System.out.println("���鷴ת�����ݣ�");
		showArray(array);
	}

	public void showArray(int[] array) {
		for (int i : array) {
			System.out.print("\t" + i);
		}
		System.out.println();
	}

}
