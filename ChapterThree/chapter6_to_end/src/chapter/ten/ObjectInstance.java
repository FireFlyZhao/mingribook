package chapter.ten;

public class ObjectInstance {
	
	public String toString() {
		return "��" + getClass().getName() + "������дtoString()����";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ObjectInstance()); 
	}

}
