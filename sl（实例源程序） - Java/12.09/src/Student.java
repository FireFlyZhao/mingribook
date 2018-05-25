public class Student {
   public void speak(int m) throws MyException{
	   if(m > 1000){
		   throw new MyException("参数太大了");
	   }
   }
}