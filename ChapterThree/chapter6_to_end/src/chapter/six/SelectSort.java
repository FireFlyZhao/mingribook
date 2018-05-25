package chapter.six;

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {63, 4, 24, 1, 3, 15};
		SelectSort sorter = new SelectSort();
		sorter.sort(array);
	}

	private void sort(int[] array) {
		// TODO Auto-generated method stub
		for (int i = 1; i < array.length; i++) {
			int index = 0;
			for (int j = 1; j <= array.length-i; j++) {
				if (array[j] > array[index]) {
					index = j;
				}
			}
			int temp = array[array.length - i];
			array[array.length - i] = array[index];
			array[index] = temp;
		}
		show(array);
	}

	private void show(int[] array) {
		// TODO Auto-generated method stub
		for (int i : array) {
			System.out.print(" >" + i);
		}
		System.out.println();
	}

}
