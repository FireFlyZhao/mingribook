import java.util.*;
public class Eval { // ������
	public static void main(String [] args)
	{
       int arr1[]=new int[]{1,2,3,4,5};
       int arr2[] = Arrays.copyOf(arr1, 3);
     // ����Դ�����д��±�0��ʼ��3��Ԫ�ص�Ŀ�����飬���±�0��λ�ÿ�ʼ�洢��
       for(int i=0;i<arr1.length;i++)
           System.out.print(arr1[i]);
		   System.out.println();
       
       for(int j=0;j<arr2.length;j++)
           System.out.print(arr2[j]);
			System.out.println();
	}
}

