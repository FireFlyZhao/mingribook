package chapter.six;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {63,4,24,1,3,15};
		BubbleSort sorter = new BubbleSort();
		sorter.sort(arr);
	}

	private void sort(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 1 ; i < arr.length ; i++) {
			for (int j = 0; j< arr.length-i; j++) {
				if (arr[j] > arr[j+1] ) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		showArray(arr);
	}

	private void showArray(int[] arr) {
		// TODO Auto-generated method stub
		for (int i : arr) {
			System.out.print(">" + i);
		}
		System.out.println();
		
	}

}
