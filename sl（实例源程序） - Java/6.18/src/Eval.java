public class Eval { // 创建类
	public static void main(String[] args) {
		int arr[][]=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("数组原有内容：");
		for(int i = 0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println("行列互换后数组内容：");
		for(int i = 0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				System.out.print(arr[j][i]);
			}
			System.out.println();
		}
	}
}
