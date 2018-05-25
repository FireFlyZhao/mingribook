/**
 * 反转排序算法实例
 * 
 * @author Li Zhong Wei
 */
public class ReverseSort {
	public static void main(String[] args) {
		// 创建一个数组
		int[] array = { 10, 20, 30, 40, 50, 60 };
		// 创建反转排序类的对象
		ReverseSort sorter = new ReverseSort();
		// 调用排序对象的方法将数组反转
		sorter.sort(array);
	}
	
	/**
	 *直接选择排序法
	 * 
	 * @param array
	 *            要排序的数组
	 */
	public void sort(int[] array) {
		System.out.println("数组原有内容：");
		showArray(array);// 输出排序前的数组值
		int temp;
		int len = array.length;
		for (int i = 0; i < len / 2; i++) {
			temp = array[i];
			array[i] = array[len - 1 - i];
			array[len - 1 - i] = temp;
		}
		System.out.println("数组反转后内容：");
		showArray(array);// 输出排序后的数组值
	}
	
	/**
	 * 显示数组所有元素
	 * 
	 * @param array
	 *            要显示的数组
	 */
	public void showArray(int[] array) {
		for (int i : array) {// foreach格式遍历数组
			System.out.print("\t" + i);// 输出每个数组元素值
		}
		System.out.println();
	}
}
