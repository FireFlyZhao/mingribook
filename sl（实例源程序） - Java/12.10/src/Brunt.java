public class Brunt {
  public static int count(int m,int n){
	  return m * n;
  }
  public static void main(String args[]) throws Exception{
	 try{
		 int result = count(12315,57876876);
		 System.out.println(result);
	 }
	 catch (Exception e) {
		e.printStackTrace();
	}
	
  }
}
