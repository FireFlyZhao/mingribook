public class Brunt {
  public static void main(String args[]){
	  Student stu = new Student();
	  try {
		stu.speak(1500);
	} catch (MyException e) {
		
		e.printStackTrace();
	}
  }
}