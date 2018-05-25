/**
 * ֱ��ѡ�������㷨ʵ��
 * 
 * @author Li Zhong Wei
 */
public class SelectSort {
	public static void main(String[] args) {
		// ����һ�����飬�������Ԫ���������
		int[] array = { 63, 4, 24, 1, 3, 15 };
		// ����ֱ��������Ķ���
		SelectSort sorter = new SelectSort();
		// �����������ķ�������������
		sorter.sort(array);
	}
	
	/**
	 *ֱ��ѡ������
	 * 
	 * @param array
	 *            Ҫ���������
	 */
	public void sort(int[] array) {
		int index;
		for (int i = 1; i < array.length; i++) {
			index = 0;
			for (int j = 1; j <= array.length - i; j++) {
				if (array[j] > array[index]) {
					index = j;
				}
			}
			// ������λ��array.length-i��index(���ֵ)������
			int temp = array[array.length - i];// �ѵ�һ��Ԫ��ֵ���ֵ���ʱ������
			array[array.length - i] = array[index];// �ѵڶ���Ԫ��ֵ���浽��һ��Ԫ�ص�Ԫ��
			array[index] = temp;// ����ʱ����Ҳ���ǵ�һ��Ԫ��ԭֵ���ֵ��ڶ���Ԫ����
		}
		showArray(array);// ���ֱ��ѡ������������ֵ
	}
	
	/**
	 * ��ʾ��������Ԫ��
	 * 
	 * @param array
	 *            Ҫ��ʾ������
	 */
	public void showArray(int[] array) {
		for (int i : array) {// foreach��ʽ��������
			System.out.print(" >" + i);// ���ÿ������Ԫ��ֵ
		}
		System.out.println();
	}
}
