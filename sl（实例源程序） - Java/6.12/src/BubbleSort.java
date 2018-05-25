public class BubbleSort {
	public static void main(String[] args) {
		// ����һ�����飬�������Ԫ���������
		int[] array = { 63, 4, 24, 1, 3, 15 };
		// ����ð��������Ķ���
		BubbleSort sorter = new BubbleSort();
		// �������򷽷�����������
		sorter.sort(array);
	}
	
	/**
	 *ð������
	 * 
	 * @param array
	 *            Ҫ���������
	 */
	public void sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			// �Ƚ���������Ԫ�أ��ϴ��������ð��
			for (int j = 0; j < array.length - i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];// �ѵ�һ��Ԫ��ֵ���ֵ���ʱ������
					array[j] = array[j + 1];// �ѵڶ���Ԫ��ֵ���浽��һ��Ԫ�ص�Ԫ��
					array[j + 1] = temp;// ����ʱ����Ҳ���ǵ�һ��Ԫ��ԭֵ���ֵ��ڶ���Ԫ����
				}
			}
		}
		showArray(array);// ���ð������������Ԫ��
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
