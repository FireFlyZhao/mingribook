package chapter.six;

public class Val_126_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]	arr = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("����ԭ�����ݣ�");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("���л������������ݣ�");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[j][i] + "\t");
			}
			System.out.println();
		}
	}

}
