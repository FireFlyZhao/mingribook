package chapter.ten;

class Parent{
	Parent(){
		System.out.println("���ø����parent()���췽��");
	}
}

class SubParent extends Parent{
	SubParent(){
		System.out.println("���������Subroutine()���췽��");
		System.out.println("************************");
	}
}


public class Subroutine extends SubParent{
	
	Subroutine(){
		System.out.println("���������Subroutine()���췽��");
	}
	
	public static void main(String[] args) {
		Subroutine s = new Subroutine();
	}
	
}
