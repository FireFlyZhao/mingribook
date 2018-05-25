import java.util.*;
public class Eval { // 创建类
	public static void main(String [] args)
	{
       int arr1[]=new int[]{1,2,3,4,5};
       int arr2[] = Arrays.copyOf(arr1, 3);
     // 复制源数组中从下标0开始的3个元素到目的数组，从下标0的位置开始存储。
       for(int i=0;i<arr1.length;i++)
           System.out.print(arr1[i]);
		   System.out.println();
       
       for(int j=0;j<arr2.length;j++)
           System.out.print(arr2[j]);
			System.out.println();
	}
}

