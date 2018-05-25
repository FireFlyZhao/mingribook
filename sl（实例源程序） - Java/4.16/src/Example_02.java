public class Example_02 {	
  public static void main(String args[])
	{			
      double sum = 0,a = 1;
      int i = 1;
      while(i <= 20)
      {
    	  sum = sum+a;
    	  i = i+1;
    	  a = a*(1.0/i);
      }
      System.out.println(sum);
    }
}
